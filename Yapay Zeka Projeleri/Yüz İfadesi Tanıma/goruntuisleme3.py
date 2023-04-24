import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, BatchNormalization, Activation, MaxPooling2D, Dropout, Flatten, Dense
from tensorflow.keras.optimizers import Adam
from sklearn.model_selection import train_test_split
import cv2
import keras_tuner as kt
from tensorflow.math import confusion_matrix
import visualkeras

def cnn_model(hyperparameters):
    model = Sequential()

    model.add(Conv2D(32, (3,3), strides=(1,1), padding='same', activation='relu', input_shape=(48,48,1)))
    model.add(BatchNormalization())
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(0.5))

    model.add(Conv2D(64, (3,3), strides=(1,1), padding='same', activation='relu'))
    model.add(BatchNormalization())
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(hyperparameters.Choice('dropout_2', values=[0.25, 0.5])))

    model.add(Conv2D(128, (3,3), strides=(1,1), padding='same', activation='relu'))
    model.add(BatchNormalization())
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(0.25))

    model.add(Conv2D(256, (3,3), strides=(1,1), padding='same', activation='relu'))
    model.add(BatchNormalization())
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(0.25))

    model.add(Conv2D(hyperparameters.Choice('filters_5', values=[128, 256, 512]), (3,3), padding='same', activation='relu'))
    model.add(BatchNormalization())
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(0.25))

    model.add(Flatten())

    model.add(Dense(128))
    model.add(BatchNormalization())
    model.add(Activation('relu'))
    model.add(Dropout(0.25))

    model.add(Dense(256))
    model.add(BatchNormalization())
    model.add(Activation('relu'))
    model.add(Dropout(0.25))

    model.add(Dense(7, activation='softmax'))
    
    model.compile(optimizer=Adam(learning_rate=hyperparameters.Choice('learning_rate', values=[0.001, 0.01])), loss='sparse_categorical_crossentropy', metrics=['accuracy'])
       
    return model

veri_seti = pd.read_csv('fer2013.csv')
piksel_degerleri = pd.DataFrame(veri_seti.pixels.str.split(" ").tolist(), dtype=int)
resimler = piksel_degerleri.values.astype(float)
resimler = resimler.reshape(resimler.shape[0], 48, 48, 1)
resimler = resimler.astype('float32')
etiketler = veri_seti.emotion

X_train, X_test, y_train, y_test = train_test_split(resimler, etiketler, test_size=0.15, random_state=42, stratify=etiketler)
X_train, X_valid, y_train, y_valid = train_test_split(X_train, y_train, test_size=0.15, random_state=41)

hyperparameter_opt = kt.BayesianOptimization(cnn_model, objective='val_accuracy', max_trials=6)
hyperparameter_opt.search(X_train,y_train,epochs=8,validation_data=(X_test,y_test))
hyperparameters = hyperparameter_opt.get_best_hyperparameters(num_trials=1)[0]
model = cnn_model(hyperparameters)
model.fit(np.array(X_train), np.array(y_train), batch_size=32, epochs=20, verbose=1, validation_data=(np.array(X_valid), np.array(y_valid)), shuffle=True)

duygular =       {0:"Kizgin",  1:"Igrenmis",2:"Korkmus",   3:"Mutlu",   4:"Uzgun",   5:"Saskin",     6:"Notr"}
duygu_renkleri = {0:(0,0,255), 1:(0,0,0),   2:(0,255,255), 3:(0,255,0), 4:(100,0,0), 5:(75,255,255), 6:(255,255,255)}

def dosyadan_tani():
    fotograf_tekrarla = True
    while (fotograf_tekrarla == True):
        print("fotoğrafın adını giriniz:")
        fotograf = input()
        frame = cv2.imread(fotograf)
        siyahBeyazFrame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        boyutlu_yuz = cv2.resize(siyahBeyazFrame, (48,48))
        facec = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
        yuzler = facec.detectMultiScale(siyahBeyazFrame, 1.1, 5, 0, [20,20])
        for (x, y, w, h) in yuzler:
            yuz = siyahBeyazFrame[y:y+h, x:x+w]
            boyutlu_yuz = cv2.resize(yuz, (48,48))
            duygu = model.predict(boyutlu_yuz.reshape(1,48,48,1))
            duygu_index = np.argmax(duygu)
            cv2.rectangle(frame,(x,y),(x+w,y+h),duygu_renkleri[duygu_index],2)
            cv2.putText(frame, duygular[duygu_index], (x+4, y+20+h//800), cv2.FONT_HERSHEY_SIMPLEX, w/300, duygu_renkleri[duygu_index])
        while (True):
            cv2.imshow('Fotograf', frame)
            if cv2.waitKey(1) == 27:
                cv2.destroyWindow("Fotograf")
                break
        print("Başka bir fotoğraf girmek istiyor musunuz?[y][n]")
        cevap = input("Cevabınız:")
        if (cevap == 'n'):
            fotograf_tekrarla = False
        if (cevap == 'y'):
            continue
    
def kameradan_tani():
    camera = cv2.VideoCapture(0, cv2.CAP_DSHOW)
    while (True):
        _, frame = camera.read()
        siyahBeyazFrame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        boyutlu_yuz = cv2.resize(siyahBeyazFrame, (48,48))
        facec = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
        yuzler = facec.detectMultiScale(siyahBeyazFrame, 1.1, 5, 0, [20,20])
        for (x, y, w, h) in yuzler:
            yuz = siyahBeyazFrame[y:y+h, x:x+w] 
            boyutlu_yuz = cv2.resize(yuz, (48,48))
            duygu = model.predict(boyutlu_yuz.reshape(1,48,48,1))
            duygu_index = np.argmax(duygu)
            cv2.rectangle(frame,(x,y),(x+w,y+h),duygu_renkleri[duygu_index],2)
            cv2.putText(frame, duygular[duygu_index], (x+4, y+h+20), cv2.FONT_HERSHEY_SIMPLEX, w/300, duygu_renkleri[duygu_index])
        cv2.imshow('Kamera', frame)
        if cv2.waitKey(1) == 27:
            cv2.destroyWindow("Kamera")
            camera.release()
            break

print("Seçilen fotoğrafın yüz ifadesini belirlemek için [a] tuşuna basınız.")
print("Kameradan eş zamanlı yüz ifadesi belirlemek için [b] tuşuna basınız.")
print("Program başladıktan sonra herhangi bir anda kapatmak için [ESC] tuşuna basınız.")
cevap = input("Cevabınız:") #Spider 5.1'den kaynaklanan hata ile input() çalışmayabilmektedir. 5.3 ile bu problem çözülmüştür.
kamerayi_ac = ''
fotograf_ac = ''
while (cevap not in ('a','b')): 
        print("Geçersiz seçenek. Lütfen tekrar deneyiniz.")
        print("Seçilen fotoğrafın yüz ifadesini belirlemek için [a] tuşuna basınız.")
        print("Kameradan eş zamanlı yüz ifadesi belirlemek için [b] tuşuna basınız.")
        cevap = input("Cevabınız:")

while (True):
    if (cevap == 'a' or fotograf_ac == 'y'): #Fotoğraf inputu
        dosyadan_tani()
        print("Kamerayı açmak istiyor musunuz?[y][n]")
        kamerayi_ac = input("Cevabınız:")
        cevap = ''
    elif (cevap == 'b' or kamerayi_ac == 'y'): #Kamera inputu
        kameradan_tani()
        print("Fotoğraftan ifade belirlemek istiyor musunuz?[y][n]")
        fotograf_ac = input("Cevabınız:")
        cevap = ''
        kamerayi_ac = ''
    else:
        print("CNN modelini, hata matrisini ve matrisin grafiğini görmek için [y] tuşuna basınız.")
        print("Tekrar fotoğraf işlemek için [a] tuşuna, kamerayı tekar açmak için [b] tuşuna basınız.")
        cevap = input("Cevabınız:")
        while (cevap not in ('a','b','y')):
            print("Geçersiz seçenek. Lütfen tekrar deneyiniz.")
            print("CNN modelini, hata matrisini ve matrisin grafiğini görmek için [y] tuşuna basınız.")
            print("Tekrar fotoğraf işlemek için [a] tuşuna, kamerayı tekar açmak için [b] tuşuna basınız.")
            cevap = input("Cevabınız:")
        if (cevap == 'y'):
            break

visualkeras.layered_view(model, to_file='model_ciktisi.png').show()

cv2.destroyAllWindows()
y_test_pred = model.predict(X_test)
print("\n\n", y_test, end="\n\n\n")
print(y_test_pred)
matrix = confusion_matrix(y_test, np.argmax(y_test_pred, axis=1))
print("Hata matrisi:\n", matrix)


def plot_confusion_matrix(cm, target_names, title='Confusion matrix'):   
    cmap = plt.get_cmap('Oranges')

    plt.figure(figsize=(8, 6))
    plt.imshow(cm, interpolation='nearest', cmap=cmap)
    plt.title(title)
    plt.colorbar()

    tick_marks = np.arange(len(target_names))
    plt.xticks(tick_marks, target_names, rotation=45)
    plt.yticks(tick_marks, target_names)

    plt.tight_layout()
    plt.ylim(len(target_names)-0.5, -0.5)
    plt.ylabel('Gerçek sınıf')
    plt.xlabel('Tahmin sınıfı')
    plt.savefig(title + '.png', dpi=500, bbox_inches = 'tight')
    plt.show()
    

target_names = ("Kızgın", "İğrenmiş", "Korkmuş", "Mutlu", "Üzgün", "Şaşkın", "Nötr")
plot_confusion_matrix(matrix, target_names)

model.summary()