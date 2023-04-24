//NOT: Ödevi IntelliJ kullanarak yazdım. Bittikten sonra NetBeans ile de çalıştırdım, sorun çıkmadı.
//Önceden asistanlarla sorun olduğu için ekleme gereği duydum. Kolay gelsin hocam :)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//üst kısımda dosya okuma için gereken importları yaptım.

class Vehicle { //vehicle sınıfı
    private String plaka,model,marka; //vehicle sınıfına özel plaka, model ve marka değişkenleri
    public Vehicle(String plaka, String model, String marka) { //vehicle sınıfıConstructor
        this.plaka = plaka;
        this.model = model;
        this.marka = marka;
    }
    //set get metodları, tostring ve compareto
    public String toString() { return(plaka + model + marka); }
    public int compareTo(Vehicle tasit) {return this.plaka.compareTo(tasit.plaka);}
    public String getPlaka() {return plaka;}
    public void setPlaka(String plaka) {this.plaka = plaka;}
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}
    public String getMarka() {return marka;}
    public void setMarka(String marka) {this.marka = marka;}
}

class Car extends Vehicle { //vehicle sınıfından Car sınıfı oluşuyor
    private int kapi; //car sınıfına özel kapı değişkeni
    public Car(String plaka, String model, String marka, int kapi) { //car sınıfı için yapıcı constructor
        super(plaka, model, marka); //vehicle sınıfından plaka model ve marka değişkenleri kalıtımla alınıyor
        this.kapi = kapi;
    }
    public int getKapi() { return kapi; }
    public void setKapi(int kapi) { this.kapi = kapi; }
    @Override
    public String toString() { //toString metodu Car sınıfına göre yeniden yazıldı. 3 farklı çıktı vermesi lazım araba çeşidine göre
        if (this.kapi == 2) //kapı sayısı 2 ise spor araba
            return(getPlaka() + " " + "plakalı" + " " + getModel() + " model" + " " + getMarka() +" marka" + " spor araba");
        else if (this.kapi == 5) //5 ise SWagon araba
            return(getPlaka() + " " + "plakalı" + " " + getModel() + " model" + " " + getMarka() +" marka" + " SWagon araba");
        else //başka seçenek olmadığı için else kısmına da normal araba
            return(getPlaka() + " " + "plakalı" + " " + getModel() + " model" + " " + getMarka() +" marka" + " normal araba");
    }
}

class Truck extends Vehicle { //vehicle sınıfından truck sınıfı oluşuyor
    private int yuk_kapasitesi; //truck sınıfına özel yük kapasitesi değişkeni
    public Truck(String plaka, String model, String marka, int yuk_kapasitesi) { //truck sınıfı için yapıcı constructor
        super(plaka,model,marka); //car sınıfında olduğu gibi vehicle sınıfından plaka, model, marka alınıyor
        this.yuk_kapasitesi = yuk_kapasitesi;
    }
    @Override
    public String toString() { //tostring truck sınıfına göre yeniden yazılıyor
        return(getPlaka() + " " + "plakalı" + " " + getModel() + " model" + " " + getMarka() +" marka " + yuk_kapasitesi + " yük kapasiteli kamyon");}
    private int getYuk_kapasitesi() {return yuk_kapasitesi;}
    private void setYuk_kapasitesi(int yuk_kapasitesi) {this.yuk_kapasitesi = yuk_kapasitesi;}
}

class Node { //çift bağlı listeyi oluşturmak için node sınıfını yazdım
    Vehicle tasit; //vehicle tipinde taşıt değişkeni
    Node sonraki, onceki; //metotlarda kullanılacak nodelar birbirine önceki ve sonraki nodelar aracılığı ile bağlanacak

    static Node getNode(Vehicle tasit_bilgisi) { //vehicle türüyle kullanılacak taşıtın bilgilerini alıyor
        Node newNode = new Node();               //yeni bir node yaratıyor
        newNode.tasit = tasit_bilgisi;           //o node'un taşıtına parametre olarak alınan taşıtın değerini atıyor
        newNode.onceki = newNode.sonraki = null; //listeye daha bağlanmadığı için öncesi ve sonrası null
        return newNode;
    }

    static Node plakaya_gore_ekle(Node head, Node yeni_tasit) { //plakaya göre taşıt ekleme metodu, büyükten küçüğe doğru ekliyor
        Node simdiki_tasit; //eklenecek taşıt
        Node ilk_tasit; //listenin başındaki taşıt
        if (head == null) { //liste boşsa yeni taşıt listenin ilk elemanı yani headi oluyor
            head = yeni_tasit;
            ilk_tasit = head; //head yani yeni taşıt değerini ilk taşıt değişkenine atıyorum
        }
        else if (head.tasit.getPlaka().compareTo(yeni_tasit.tasit.getPlaka()) < 0) { //listenin başındaki taşıtın plakasının değeri, yeni taşıtın plakasının değerinden
            yeni_tasit.sonraki = head;                                               //alfabetik olarak düşük ise
            yeni_tasit.sonraki.onceki = yeni_tasit;
            head = yeni_tasit;
        } else {
            simdiki_tasit = head;
            while (simdiki_tasit.sonraki != null && simdiki_tasit.sonraki.tasit.getPlaka().compareTo(yeni_tasit.tasit.getPlaka()) > 0) //yeni gelen plaka değeri en baştaki değerden ya da sonraki gelenlerden düşük ise
                simdiki_tasit = simdiki_tasit.sonraki;                                                                                 //büyük olana kadar ya da sonraki konumunda bir taşıt bulunmayana kadar
            yeni_tasit.sonraki = simdiki_tasit.sonraki;                                                                                //while döngüsü dönmeye devam ediyor.
            if (simdiki_tasit.sonraki != null)
                yeni_tasit.sonraki.onceki = yeni_tasit;
            simdiki_tasit.sonraki = yeni_tasit;
            yeni_tasit.onceki = simdiki_tasit;
        }
        return head;
    }

    static Node tasit_sil(Node head, String silinecek_plaka) { //Listenin başındaki taşıtı ve silinecek taşıtın plaka değerini parametre olarak alan silme metotu
        Node simdiki;
        simdiki = head;
        if (simdiki.tasit.getPlaka() == silinecek_plaka) { //simdiki değer head değerinden başlıyor ve eşitse o değer siliniyor
            head = simdiki.sonraki;
        }
        while (simdiki.tasit.getPlaka().compareTo(silinecek_plaka) > 0) //şimdiki taşıtın plakası silinecek plakaya eşit değilse
            simdiki = simdiki.sonraki;                                  //şimdi bakılan diğer bir ileri alınıyor ve eşit bir değer bulunana kadar devam ediyor
        simdiki.onceki.sonraki = simdiki.sonraki;                       //bulunduğu and şimdiki değerin sonraki bağlı olduğu bağlantı öncesinde bulunan değerin sonraki gösterdiği değer oluyor
        simdiki.sonraki.onceki = simdiki.onceki;                        //çift bağlı liste olduğu için sonraki değerinin önce gösterdiği konumun da değişmesi lazım
        return head;
    }

    static void listeyi_yazdir(Node head) { //listeye taşıtları eklerken büyükten küçüğe eklemiştim
        while (head.sonraki != null) { //o yüzden listenin sonuna gidiyorum plakanın en küçük olduğu değere
            head = head.sonraki;
        }
        while (head != null) { //en son değeri yazdırıp head değerini bir geri çekiyorum en başa gelene kadar
            System.out.println(head.tasit);
            head = head.onceki;
        }
    }

    static void tersten_yazdir(Node head) { //liste zaten plakaya göre büyükten küçüğe sıralandığı için while döngüsü ile head null olana kadar yazdırıyorum
        while (head != null) {
            System.out.println(head.tasit);
            head = head.sonraki;
        }
    }
}
public class final_odev {
    public static void main(String args[]) {
        Node head = null; // null değerinde bir head değeri yaratıyorum
        try { // dosya okuma olduğu için try catch içine alınması lazım
            File dosya = new File("C:\\Users\\Gökay\\Desktop\\veriler.txt"); //verilet.txt dosyasını dosya adlı yeni bir file'a atıyorum
            FileReader okuyucu = new FileReader(dosya);//file reader kullanarak dosyayı ona atıyorum
            BufferedReader buffered_okuyucu = new BufferedReader(okuyucu); //buffered reader kullanıp satır satır okuma işlemi yapılacak
            String satir; //okunacak her satır için string türünde satır değişkeni oluşturuyorum
            System.out.println("Araçların dosyadan okunmuş hali:");
            while ((satir = buffered_okuyucu.readLine()) != null) { //döngü dosyada boş satır bulana kadar dönecek
                String[] dizi = satir.split(" "); //Dosyadaki bir satırdaki her değer split metotuyla aralarında " " bulunursa ayrılıp bir diziye atanıyor
                String plaka,model,marka;
                String kapi_sayisi,yuk;
                String tasit_turu = null;
                int yuk_kapasitesi = 0;

                plaka = dizi[1]; //dosyada okunan 2. değer plaka değeri olduğu için onu plakaya atıyorum
                model = dizi[2]; //dosyada okunan 3. değer plaka değeri olduğu için onu modele atıyorum
                marka = dizi[3]; //dosyada okunan 4. değer plaka değeri olduğu için onu marka atıyorum

                if (dizi[0].contains("car")) { //1. değer taşıt türü ve contains metotuyla içindeki değerin "car" içerip içermediğine bakıyoum. İçeriyor ise araba türü için işlemler yapılacak
                    kapi_sayisi = dizi[4]; //satırdaki 5. değer araba olduğu için kapı sayısını içeriyor
                    int kapi = Integer.parseInt(kapi_sayisi); //kapı sayısı string olduğu parseInt ile onu int tipine döndürüp kapi değişkenine atıyorum
                    Car araba = new Car(plaka,model,marka,kapi); //yeni bir araba oluşturuyorum
                    Node new_node = Node.getNode(araba); //araba çift bağlı listeye ekleneceği için node türü olan bir değişkene atanıyor
                    head = Node.plakaya_gore_ekle(head,new_node); //plakaya göre ekleneceği için head değerini ve yeni arabayı parametre olarak alan listeye ekleme metotu

                    if (kapi == 2) //araba 2 kapılıysa spor araba
                        tasit_turu = "spor araba";
                    else if (kapi == 5) //5 kapılıysa SWagon araba
                        tasit_turu = "SWagon araba";
                    else //ikisi de değilse başka seçenek olmadığı için standart araba
                        tasit_turu = "standart araba";
                } else { //if araba olup olmadığını kontrol etti, olmadığı için taşıtımız kamyon oldu ve buraya geçildi
                    yuk = dizi[4]; //5. değer kamyon için yük kağasitesi
                    yuk_kapasitesi = Integer.parseInt(yuk); //yine string olduğu için parseInt ile int'e çeviriyor
                    Truck kamyon = new Truck(plaka,model,marka,yuk_kapasitesi); //yeni bir kamyon oluşturuyorum
                    Node new_node = Node.getNode(kamyon); //yeni bir node ve içinde truck nesnesi
                    head = Node.plakaya_gore_ekle(head,new_node); //üstteki gibi plakaya göre eklendi
                }
                System.out.print(plaka + " " + "plakalı" + " " + model + " model" + " " + marka +" marka"); //Bu kısım listenin daha plakaya göre sıralanamdan önce yazıldığı yer
                if (tasit_turu != null)
                    System.out.print(" "+ tasit_turu);
                else
                    System.out.print(" " + yuk_kapasitesi + " yük kapasiteli kamyon");
                System.out.print("\n");
            }
            okuyucu.close(); //dosyayla işimiz bittiği için okuyucuyu kaptıyorum
            System.out.print("\n");
            System.out.println("Araçların plakaya göre sıralanmış hali:"); //plakaya göre yazdırılacak yere geçiyorum
            Node.listeyi_yazdir(head); //listeyi yazdırıyorum
        } catch (IOException x) {x.printStackTrace();}

        try { //burası ekleme çıkarma işlemlerinin yapılma ve yapıldıktan sonra listenin yazdırıldığı yer
            File dosya = new File("C:\\Users\\Gökay\\Desktop\\islemler.txt"); //bu sefer islemler.txt alınacak
            FileReader okuyucu = new FileReader(dosya); //bu kısım üstteki kısmın aynısı
            BufferedReader y_okuyucu = new BufferedReader(okuyucu);
            String line;
            while ((line = y_okuyucu.readLine()) != null) {
                String islemli_dizi[] = line.split(" ");
                String islem;
                String plaka,model,marka;
                String S_kapi,yuk;
                String tasit_turu = null;

                islem = islemli_dizi[0]; //bu sefer islem adında bir değişkenimiz var, ekle ya da sil değerini alacak

                if (islemli_dizi[0].contains("ekle")) { //ekle ise bu kısım
                    plaka = islemli_dizi[2]; //yine üstteki verilet.txt de yaptığımızın aynısı
                    model = islemli_dizi[3];
                    marka = islemli_dizi[4];
                    if (islemli_dizi[1].contains("car")) {
                        S_kapi = islemli_dizi[5];
                        int kapi = Integer.parseInt(S_kapi);
                        Car araba = new Car(plaka,model,marka,kapi);
                        Node new_node = Node.getNode(araba);
                        head = Node.plakaya_gore_ekle(head,new_node);

                        if (kapi == 2)
                            tasit_turu = "spor araba";
                        else if (kapi == 5)
                            tasit_turu = "Swagon araba";
                        else
                            tasit_turu = "standart araba";
                    } else {
                        yuk = islemli_dizi[5];
                        int yuk_kapasitesi = Integer.parseInt(yuk);
                        Truck kamyon = new Truck(plaka,model,marka,yuk_kapasitesi);
                        Node new_node = Node.getNode(kamyon);
                        head = Node.plakaya_gore_ekle(head,new_node);
                    }
                } else if (islemli_dizi[0].contains("sil")) { //fark buarada, silme işlemi gerçekleşecek ise
                    plaka = islemli_dizi[1]; //1. değer işlem türü idi, 2. değer ise sil işleminde kullanılacak plaka
                    head = Node.tasit_sil(head,plaka); //eklemede olduğu gibi head değerini ve plakayı alıp işlem yapılıyor
                }
            }
            okuyucu.close();

            System.out.print("\n");
            System.out.println("Ekleme/çıkarma işlemlerinden sonra araçların sıralanmış hali:");
            Node.listeyi_yazdir(head); //ekleme çıkarma sonrası liste yazdırılıyor
            System.out.print("\n");

            System.out.println("Listenin tersten sıralanmış hali:");
            Node.tersten_yazdir(head); //liste tersten yazdırılacağı için bu sefer tersten yazdır metotu çağırılıyor
        } catch (IOException x) {x.printStackTrace();}
    }
}