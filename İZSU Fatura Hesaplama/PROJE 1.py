sayac_tip1 = sayac_tip2 = sayac_tip3 = sayac_tip4 = sayac_tip5 = 0
tip1_su_tuketimi = tip2_su_tuketimi = tip3_su_tuketimi = tip4_su_tuketimi = tip5_su_tuketimi = 0
konut1 = konut2 = konut3 = 0
konut1_su_tuketimi = konut2_su_tuketimi = konut3_su_tuketimi = 0
tar_hay_50_ton = 0
fazla_tuketim = 0
indirimli_hane_sayisi = 0
indirimli_insan_sayisi=0
indirim_sayaci=0
su_tuketim_indirimi = False
resmi_daire_rekor_abone=0
resmi_daire_rekor_kullanım=-1
konut_disi_rekor_abone=0
konut_disi_rekor_kullanim=-1
konut_disi_rekor_fatura=0
konut_disi_rekor_tip=0
izsu_toplam=0
ilce_belediye_toplam=0
buyuksehir_belediye_toplam=0
devlet_toplam=0
tip1_ucret=tip2_ucret=tip3_ucret=tip4_ucret=tip5_ucret=0
gun_carpimi=1
KONUT_KAD1_1=2.89          # _1 KISMI SU TÜKETİM BİRİM ÜCRETİNİ VE
KONUT_KAD1_2=1.44          # _2 KISMI DA ATIK SU BİRİ ÜCRETİNİ BELİRTMEKTEDİR.
KONUT_KAD2_1=3.13
KONUT_KAD2_2=1.56
KONUT_KAD3_1=6.43
KONUT_KAD3_2=3.22
ISYERI_1=7.38
ISYERI_2=3.68
RESMI_DAIRE_1=4.34
RESMI_DAIRE_2=2.16
ORGANIZE_SANAYI_1=5.00
ORGANIZE_SANAYI_2=2.50
ITHS_KAD1_1=1.45           # ITHS=İLÇE TARIMSAL VE HAYVAN SULAMA
ITHS_KAD1_2=0.72
ITHS_KAD2_1=2.89
ITHS_KAD2_2=1.44
ITHS_KAD3_1=6.43
ITHS_KAD3_2=3.22

CTV_CARPAN=0.39
ATIK_TOPLAMA_CARPAN=13.00
ATIK_BERTARAF_CARPAN=2.54
KDV_CARPAN=0.08

abone_dongu = "E"

while abone_dongu == "E" or abone_dongu == "e":
    abone_no = int(input("Abone numaranızı giriniz:"))
    abone_tipi = int(input("Abone tipi kodunuzu giriniz:"))
    while abone_tipi not in [1, 2, 3, 4, 5]:
        print("Hatalı abone tipi kodu girdiniz.")
        abone_tipi = int(input("Abone tipi kodunuzu tekrar giriniz:"))
    if abone_tipi == 1:
        abone_tip_adi = "Konut"
        sayac_tip1 += 1
        hane_sayisi = int(input("Hane sayısını giriniz:"))
        while hane_sayisi < 1:
            print("Hane sayısını hatalı girdiniz.Lütfen tekrar giriniz:")
            hane_sayisi = int(input("Hane sayısı giriniz:"))
        if hane_sayisi == 1:
            indirimli_hane = input("Hanede şehit,gazi,sporcu ya da engelli var mı?(Y/y/Ş/ş/G/g/S/s/E/e):")
            while indirimli_hane not in ['Y', 'y', 'Ş', 'ş', 'G', 'g', 'S', 's', 'E', 'e']:
                print("Hatalı veri girişi.Lütfen tekrar giriniz.")
                indirimli_hane = input("Hanede şehit,gazi,sporcu ya da engelli var mı?(Y/y/Ş/ş/G/g/S/s/E/e):")
            if indirimli_hane in ['Ş','ş','G','g','S','s','E','e']:
                indirimli_hane_sayisi += 1
                su_tuketim_indirimi = True
        elif hane_sayisi > 1:
            se_ga_spor_sayisi = int(input("Hanelerdeki toplam şehit,gazi veya sporcu sayısı:"))
            while se_ga_spor_sayisi < 0 or se_ga_spor_sayisi > hane_sayisi:
                print("Girdiğiniz sayı 0 ile hane sayısı arasında olmalıdır.Lütfen tekrar giriniz.")
                se_ga_spor_sayisi = int(input("Hanelerdeki toplam şehit,gazi veya sporcu sayısı:"))
            engelli_sayisi = int(input("Hanelerdeki toplam engelli sayısını giriniz:"))
            while engelli_sayisi < 0 or engelli_sayisi > hane_sayisi:
                print("Girdiğiniz sayı 0 ile hane sayısı arasında olmalıdır.")
                engelli_sayisi = int(input("Hanelerdeki toplam engelli sayısını tekrar giriniz:"))
            indirimli_insan_sayisi=se_ga_spor_sayisi + engelli_sayisi
            indirim_sayaci+=indirimli_insan_sayisi
            while indirimli_insan_sayisi > hane_sayisi:
                print("Hanelerdeki toplam şehit,gazi,sporcu ve engelli sayısı;hane sayısından büyük olamaz.")
                print("Lütfen belirtilen değerleri tekrar giriniz.")
                se_ga_spor_sayisi = int(input("Hanelerdeki toplam şehit,gazi veya sporcu sayısı:"))
                while se_ga_spor_sayisi < 0 or se_ga_spor_sayisi > hane_sayisi:
                    print("Girdiğiniz sayı 0 ile hane sayısı arasında olmalıdır.Lütfen tekrar giriniz.")
                    se_ga_spor_sayisi = int(input("Hanelerdeki toplam şehit,gazi veya sporcu sayısı:"))
                engelli_sayisi = int(input("Hanelerdeki toplam engelli sayısını giriniz:"))
                while engelli_sayisi < 0 or engelli_sayisi > hane_sayisi:
                    print("Girdiğiniz sayı 0 ile hane sayısı arasında olmalıdır.")
                    engelli_sayisi = int(input("Hanelerdeki toplam engelli sayısını tekrar giriniz:"))
                indirimli_insan_sayisi=se_ga_spor_sayisi + engelli_sayisi
                indirim_sayaci+=indirimli_insan_sayisi

            onceki_sayac_degeri = int(input("Önceki sayaç değerini giriniz:"))
            while onceki_sayac_degeri < 0:
                print("Hatalı veri girdiniz.Lütfen tekrar giriniz.")
                onceki_sayac_degeri = int(input("Önceki sayaç değerini giriniz:"))
            simdiki_sayac_degeri = int(input("Şimdiki sayaç değerini giriniz:"))
            while not (simdiki_sayac_degeri == onceki_sayac_degeri or simdiki_sayac_degeri > onceki_sayac_degeri):
                print("Şimdiki sayaç değerini yanlış girdiniz.Lütfen tekrar giriniz.")
                simdiki_sayac_degeri = int(input("Şimdiki sayaç değerini giriniz:"))

            su_tuketimi = simdiki_sayac_degeri - onceki_sayac_degeri
            hane_basi_su_tuketimi = su_tuketimi / hane_sayisi
            tip1_su_tuketimi+=su_tuketimi

            gecen_gun_sayisi = int(input("Önceki ve şimdiki sayaç okuma tarihleri arasındaki gün sayısını giriniz:"))
            while gecen_gun_sayisi < 1:
                print("Hatalı veri girişii.")
                gecen_gun_sayisi = int(input("Önceki ve şimdiki sayaç okuma tarihleri arasındaki gün sayısını tekrar giriniz:"))
            if gecen_gun_sayisi !=30:
                gun_carpimi=gecen_gun_sayisi / 30

            if hane_basi_su_tuketimi > 20 * gun_carpimi:
                konut3 +=1
                konut3_su_tuketimi += su_tuketimi
                su_tuketim_ucreti = (13 * KONUT_KAD1_1) + (7 * KONUT_KAD2_1) + KONUT_KAD3_1 * (su_tuketimi - 20)
                atik_su_ucreti = (13 * KONUT_KAD1_2) + (7 * KONUT_KAD2_2) + KONUT_KAD3_2 * (su_tuketimi - 20)
            elif 13 * gun_carpimi < hane_basi_su_tuketimi <= 20 * gun_carpimi:
                konut2 +=1
                konut2_su_tuketimi += su_tuketimi
                su_tuketim_ucreti = (13 * KONUT_KAD1_1) + KONUT_KAD2_1 * (su_tuketimi - 13)
                atik_su_ucreti = (13 * KONUT_KAD1_2) + KONUT_KAD2_2 * (su_tuketimi - 13)
            else:
                konut1 += 1
                konut1_su_tuketimi += su_tuketimi
                su_tuketim_ucreti = su_tuketimi * KONUT_KAD1_1
                atik_su_ucreti = su_tuketimi * KONUT_KAD1_2
            if hane_basi_su_tuketimi > 100:
                fazla_tuketim += hane_sayisi
            elif hane_basi_su_tuketimi <= 100 and su_tuketim_ucreti / hane_sayisi > 500:
                fazla_tuketim += hane_sayisi
            if hane_basi_su_tuketimi <= 20 * gun_carpimi and engelli_sayisi > 0:
                su_tuketim_ucreti-=(su_tuketim_ucreti / hane_sayisi) * engelli_sayisi * 0.5
                atik_su_ucreti-=(atik_su_ucreti / hane_sayisi) * engelli_sayisi * 0.5
            if se_ga_spor_sayisi >0:
                su_tuketim_ucreti-=(su_tuketim_ucreti / hane_sayisi) * se_ga_spor_sayisi * 0.5
                atik_su_ucreti-=(su_tuketim_ucreti / hane_sayisi) * se_ga_spor_sayisi * 0.5
    if abone_tipi == 1 and hane_sayisi == 1:
        onceki_sayac_degeri = int(input("Önceki sayaç değerini giriniz:"))
        while onceki_sayac_degeri < 0:
            print("Hatalı veri girdiniz.Lütfen tekrar giriniz.")
            onceki_sayac_degeri = int(input("Önceki sayaç değerini giriniz:"))
        simdiki_sayac_degeri = int(input("Şimdiki sayaç değerini giriniz:"))
        while not (simdiki_sayac_degeri == onceki_sayac_degeri or simdiki_sayac_degeri > onceki_sayac_degeri):
            print("Şimdiki sayaç değerini yanlış girdiniz.Lütfen tekrar giriniz.")
            simdiki_sayac_degeri = int(input("Şimdiki sayaç değerini giriniz:"))

        gecen_gun_sayisi = int(input("Önceki ve şimdiki sayaç okuma tarihleri arasındaki gün sayısını giriniz:"))
        while gecen_gun_sayisi < 1:
            print("Hatalı veri girişii.")
            gecen_gun_sayisi = int(input("Önceki ve şimdiki sayaç okuma tarihleri arasındaki gün sayısını tekrar giriniz:"))
        if gecen_gun_sayisi != 30:
            gun_carpimi = gecen_gun_sayisi / 30

        su_tuketimi = simdiki_sayac_degeri - onceki_sayac_degeri
        tip1_su_tuketimi += su_tuketimi

        if su_tuketimi > 20 * gun_carpimi:
            konut3 += 1
            konut3_su_tuketimi += su_tuketimi
            su_tuketim_ucreti = (13 * KONUT_KAD1_1) + (7 * KONUT_KAD2_1) + KONUT_KAD3_1 * (su_tuketimi - 20)
            atik_su_ucreti = (13 * KONUT_KAD1_2) + (7 * KONUT_KAD2_2) + KONUT_KAD3_2 * (su_tuketimi - 20)
            if su_tuketim_indirimi == True:
                su_tuketim_ucreti *= 0.5
                atik_su_ucreti *= 0.5
        elif 13 * gun_carpimi < su_tuketimi <= 20 * gun_carpimi:
            konut2 += 1
            konut2_su_tuketimi += su_tuketimi
            su_tuketim_ucreti = (13 * KONUT_KAD1_1) + KONUT_KAD2_1 * (su_tuketimi - 13)
            atik_su_ucreti = (13 * KONUT_KAD1_2) + KONUT_KAD2_2 * (su_tuketimi - 13)
            if su_tuketim_indirimi == True:
                su_tuketim_ucreti *= 0.5
                atik_su_ucreti *= 0.5
        else:
            konut1 += 1
            konut1_su_tuketimi += su_tuketimi
            su_tuketim_ucreti = su_tuketimi * KONUT_KAD1_1
            atik_su_ucreti = su_tuketimi * KONUT_KAD1_2
            if su_tuketim_indirimi == True:
                su_tuketim_ucreti *= 0.5
                atik_su_ucreti *= 0.5
        if su_tuketimi > 100:
            fazla_tuketim += 1
        elif su_tuketimi <= 100 and su_tuketim_ucreti > 500:
            fazla_tuketim += 1
    if abone_tipi in [2, 3, 4, 5]:
        onceki_sayac_degeri = int(input("Önceki sayaç değerini giriniz:"))
        while onceki_sayac_degeri < 0:
            print("Hatalı veri girdiniz.Lütfen tekrar giriniz.")
            onceki_sayac_degeri = int(input("Önceki sayaç değerini giriniz:"))
        simdiki_sayac_degeri = int(input("Şimdiki sayaç değerini giriniz:"))
        while not (simdiki_sayac_degeri == onceki_sayac_degeri or simdiki_sayac_degeri > onceki_sayac_degeri):
            print("Şimdiki sayaç değerini yanlış girdiniz.Lütfen tekrar giriniz.")
            simdiki_sayac_degeri = int(input("Şimdiki sayaç değerini giriniz:"))
        gecen_gun_sayisi = int(input("Önceki ve şimdiki sayaç okuma tarihleri arasındaki gün sayısını giriniz:"))
        while gecen_gun_sayisi < 1:
            print("Hatalı veri girişi.")
            gecen_gun_sayisi = int(input("Önceki ve şimdiki sayaç okuma tarihleri arasındaki gün sayısını tekrar giriniz:"))

        su_tuketimi = simdiki_sayac_degeri - onceki_sayac_degeri

        if abone_tipi == 2:
            abone_tip_adi = "İşyeri"
            sayac_tip2 += 1
            tip2_su_tuketimi += su_tuketimi
            hane_sayisi = 1
            su_tuketim_ucreti = ISYERI_1 * su_tuketimi
            atik_su_ucreti = ISYERI_2 * su_tuketimi
            if su_tuketimi > 100:
                fazla_tuketim += 1
            elif su_tuketimi <= 100 and su_tuketim_ucreti > 500:
                fazla_tuketim += 1
            if su_tuketimi > konut_disi_rekor_kullanim:
                konut_disi_rekor_kullanim=su_tuketimi
                konut_disi_rekor_abone=abone_no
                konut_disi_rekor_tip=abone_tip_adi
        elif abone_tipi == 3:
            abone_tip_adi = "Resmi Daire"
            sayac_tip3 += 1
            tip3_su_tuketimi += su_tuketimi
            hane_sayisi = 1
            su_tuketim_ucreti = RESMI_DAIRE_1 * su_tuketimi
            atik_su_ucreti = RESMI_DAIRE_2 * su_tuketimi
            if su_tuketimi > 100:
                fazla_tuketim += 1
            elif su_tuketimi <= 100 and su_tuketim_ucreti > 500:
                fazla_tuketim += 1
            if su_tuketimi > resmi_daire_rekor_kullanım:
                resmi_daire_rekor_kullanım=su_tuketimi
                resmi_daire_rekor_abone=abone_no
            if su_tuketimi > konut_disi_rekor_kullanim:
                konut_disi_rekor_kullanim=su_tuketimi
                konut_disi_rekor_abone=abone_no
                konut_disi_rekor_tip=abone_tip_adi
        elif abone_tipi == 4:
            abone_tip_adi = "Organize Sanayi"
            sayac_tip4 += 1
            tip4_su_tuketimi += su_tuketimi
            hane_sayisi = 1
            su_tuketim_ucreti = ORGANIZE_SANAYI_1 * su_tuketimi
            atik_su_ucreti = ORGANIZE_SANAYI_2 * su_tuketimi
            if su_tuketimi > 100:
                fazla_tuketim += 1
            elif su_tuketimi <= 100 and su_tuketim_ucreti > 500:
                fazla_tuketim += 1
            if su_tuketimi > konut_disi_rekor_kullanim:
                konut_disi_rekor_kullanim=su_tuketimi
                konut_disi_rekor_abone=abone_no
                konut_disi_rekor_tip=abone_tip_adi
        elif abone_tipi == 5:
            abone_tip_adi = "İlçe Tarımsal ve Hayvan Sulama"
            sayac_tip5 += 1
            tip5_su_tuketimi += su_tuketimi
            hane_sayisi = 1
            if gecen_gun_sayisi != 30:
                gun_carpimi = gecen_gun_sayisi / 30
            if su_tuketimi > 20 * gun_carpimi:
                su_tuketim_ucreti = (13 * ITHS_KAD1_1) + (7 * ITHS_KAD2_1) + ITHS_KAD3_1 * (su_tuketimi - 20)
                atik_su_ucreti = (13 * ITHS_KAD1_2) + (7 * ITHS_KAD2_2) + ITHS_KAD3_2 * (su_tuketimi - 20)
            elif 13 * gun_carpimi < su_tuketimi <= 20 * gun_carpimi:
                su_tuketim_ucreti = (13 * ITHS_KAD1_1) + ITHS_KAD2_1 * (su_tuketimi - 13)
                atik_su_ucreti = (13 * ITHS_KAD1_2) + ITHS_KAD2_2 * (su_tuketimi - 13)
            else:
                su_tuketim_ucreti = su_tuketimi * ITHS_KAD1_1
                atik_su_ucreti = su_tuketimi * ITHS_KAD1_2
            if su_tuketimi > 50:
                tar_hay_50_ton += 1
            if su_tuketimi >100:
                fazla_tuketim += 1
            elif su_tuketimi <= 100 and su_tuketim_ucreti >500:
                fazla_tuketim+=1
            if su_tuketimi > konut_disi_rekor_kullanim:
                konut_disi_rekor_kullanim=su_tuketimi
                konut_disi_rekor_abone=abone_no
                konut_disi_rekor_tip=abone_tip_adi

    ctv_vergisi = su_tuketimi * CTV_CARPAN * gun_carpimi
    kati_atik_toplama_ucreti = ATIK_TOPLAMA_CARPAN * hane_sayisi * gun_carpimi
    kati_atik_bertaraf_ucreti = ATIK_BERTARAF_CARPAN * hane_sayisi * gun_carpimi
    izsu_payi=su_tuketim_ucreti + atik_su_ucreti
    kdv_oncesi_fatura_degeri = izsu_payi + kati_atik_toplama_ucreti + kati_atik_bertaraf_ucreti
    kdv_degeri =kdv_oncesi_fatura_degeri * KDV_CARPAN
    kdv_sonrası_fatura_degeri = kdv_oncesi_fatura_degeri + kdv_degeri + ctv_vergisi
    ilce_belediye_payi=kati_atik_toplama_ucreti + ctv_vergisi

    izsu_toplam+=izsu_payi
    ilce_belediye_toplam+=ilce_belediye_payi
    buyuksehir_belediye_toplam+=kati_atik_bertaraf_ucreti
    devlet_toplam+=kdv_degeri

    if abone_tipi !=1:
        konut_disi_rekor_fatura=kdv_sonrası_fatura_degeri
    if abone_tipi==1:
        tip1_ucret+=kdv_sonrası_fatura_degeri
    elif abone_tipi==2:
        tip2_ucret+=kdv_sonrası_fatura_degeri
    elif abone_tipi==3:
        tip3_ucret+=kdv_sonrası_fatura_degeri
    elif abone_tipi==4:
        tip4_ucret+=kdv_sonrası_fatura_degeri
    elif abone_tipi==5:
        tip5_ucret+=kdv_sonrası_fatura_degeri

    print("Abone numarası:", abone_no)
    print("Abone tipi:", abone_tip_adi)
    print("Dönemlik su tüketim miktari:",format(su_tuketimi,'.2f'))
    print("Dönemlik su tüketim ücreti:",format(su_tuketim_ucreti,'.2f'))
    print("Dönemlik atık su ücreti:",format(atik_su_ucreti,'.2f'))
    print("Toplam su tüketim ve atık su ücreti:",format(su_tuketim_ucreti + atik_su_ucreti,'.2f'))
    print("Dönemlik ÇTV tutarı:",format(ctv_vergisi,'.2f'))
    print("Dönemlik katı atık toplama ücreti:",format(kati_atik_toplama_ucreti,'.2f'))
    print("Dönemlik katı atık bertaraf ücreti:",format(kati_atik_bertaraf_ucreti,'.2f'))
    print("Dönemlik fatura tutarı:",format(kdv_sonrası_fatura_degeri,'.2f'))
    print("Dönemlik devlete aktarılacak KDV tutarı:",format(kdv_degeri,'.2f'))
    print("Dönemlik ilçe belediyesine aktarılacak tutar:",format(ilce_belediye_payi,'.2f'))
    print("Dönemlik büyükşehir belediyesine aktarılacak tutar:",format(kati_atik_bertaraf_ucreti,'.2f'))
    print("Dönemlik İZSU payı",format(izsu_payi,'.2f'))

    abone_dongu = input("Daha başka abone var mı?(e/E/h/H)")

abone_toplam = sayac_tip1 + sayac_tip2 + sayac_tip3 + sayac_tip4 + sayac_tip5
konut_toplam = konut1 + konut2 + konut3
tip1_yuzde = format((sayac_tip1 / abone_toplam) * 100, '.2f')
tip2_yuzde = format((sayac_tip2 / abone_toplam) * 100, '.2f')
tip3_yuzde = format((sayac_tip3 / abone_toplam) * 100, '.2f')
tip4_yuzde = format((sayac_tip4 / abone_toplam) * 100, '.2f')
tip5_yuzde = format((sayac_tip5 / abone_toplam) * 100, '.2f')

toplam_su_tuketimi=tip1_su_tuketimi + tip2_su_tuketimi + tip3_su_tuketimi + tip4_su_tuketimi + tip5_su_tuketimi
toplam_ucret=tip1_ucret + tip2_ucret + tip3_ucret + tip4_ucret + tip5_ucret
indirimli_insan_yuzde=(indirim_sayaci + indirimli_hane_sayisi) / hane_sayisi * 100

tip1_ort_tuketim = (tip1_su_tuketimi / sayac_tip1) / gun_carpimi
tip2_ort_tuketim = (tip2_su_tuketimi / sayac_tip2) / gun_carpimi
tip3_ort_tuketim = (tip3_su_tuketimi / sayac_tip3) / gun_carpimi
tip4_ort_tuketim = (tip4_su_tuketimi / sayac_tip4) / gun_carpimi
tip5_ort_tuketim = (tip5_su_tuketimi / sayac_tip5) / gun_carpimi

konut1_yuzde = format((konut1 / konut_toplam) * 100, '.2f')
konut2_yuzde = format((konut2 / konut_toplam) * 100, '.2f')
konut3_yuzde = format((konut3 / konut_toplam) * 100, '.2f')

konut1_ort_tuketim = format((konut1_su_tuketimi / konut1) / gun_carpimi,'.2f')
konut2_ort_tuketim = format((konut2_su_tuketimi / konut2) / gun_carpimi,'.2f')
konut3_ort_tuketim = format((konut3_su_tuketimi / konut3) / gun_carpimi,'.2f')
tar_hay_50_ton_yuzde = format((tar_hay_50_ton / sayac_tip5) * 100, '.2f')

print("Konut abone sayısı:", sayac_tip1, ",tüm aboneler içinde yüzdesi %", tip1_yuzde ,"ve aylık ortalama su tüketim miktarları", tip1_ort_tuketim)
print("İşyeri abone sayısı:", sayac_tip2, ",tüm aboneler içindeki yüzdesi %", tip2_yuzde ,"ve aylık ortalama su tüketim miktarları", tip2_ort_tuketim)
print("Resmi daire abone sayısı:", sayac_tip3, ",tüm aboneler içindeki yüzdesi %", tip3_yuzde ,"ve aylık ortalama su tüketim miktarları", tip3_ort_tuketim)
print("Organize Sanayi abone sayısı:", sayac_tip4, ",tüm aboneler içindeki yüzdesi %", tip4_yuzde ,"ve aylık ortalama su tüketim miktarları", tip4_ort_tuketim)
print("İlçe Tarımsal ve Hayvan Sulama sayısı:", sayac_tip5, ",tüm aboneler içindeki yüzdesi %", tip5_yuzde ,"ve aylık ortalama su tüketim miktarları", tip5_ort_tuketim)
print("")
print("1. kademe konut tipi abone sayısı:", konut1, "konut tipi aboneler içindeki yüzdesi %", konut1_yuzde,"ve aylık ortalama su tüketim miktarları:", konut1_ort_tuketim)
print("2. kademe konut tipi abone sayısı:", konut2, "konut tipi aboneler içindeki yüzdesi %", konut2_yuzde,"ve aylık ortalama su tüketim miktarları:", konut2_ort_tuketim)
print("3. kademe konut tipi abone sayısı:", konut3, "konut tipi aboneler içindeki yüzdesi %", konut3_yuzde,"ve aylık ortalama su tüketim miktarları:", konut3_ort_tuketim)
print("")
print("Aylık su tüketim miktarı 50 tondan fazla olan ilçe tarımsal ve hayvan sulama tipi abonelerin sayısı:",tar_hay_50_ton, "ve ilçe tarımsal ve hayvan sulama tipi aboneler içindeki yüzdesi %",tar_hay_50_ton_yuzde)
print("Aylık su tüketim miktarı 100 tondan yüksek veya aylık su tüketim ücreti 500 TL’den yüksek olan abonelerin (hanelerin) sayısı:",fazla_tuketim)
print("Şehit, gazi veya devlet sporcusu olan ve engelli olan konut tipi abonelerin (hanelerin) sayısı:",indirim_sayaci + indirimli_hane_sayisi,"ve konut tipi aboneler (haneler) içindeki yüzdeleri %",format(indirimli_insan_yuzde,'.2f'))
print("Aylık su tüketim miktarı en yüksek olan resmi daire tipi abonenin abone no’su:",resmi_daire_rekor_abone,"ve aylık su tüketim miktarı:",format(resmi_daire_rekor_kullanım,'.2f'))
print("Aylık su tüketim ücreti en yüksek olan konut tipi dışındaki abonenin abone no’su:", konut_disi_rekor_abone,",abone tipi adı:", konut_disi_rekor_tip,",aylık su tüketim miktarı", format(konut_disi_rekor_kullanim, '.2f'), "ve ödediği aylık su tüketim ücreti:", format(konut_disi_rekor_fatura, '.2f'))
print("")
print("Konut tipi abonelerin aylık toplam su tüketim miktarları:",format(tip1_su_tuketimi / gun_carpimi,'.2f'),"ve Bornova'daki aylık toplam su tüketim miktarı içindeki yüzdesi:%",format((tip1_su_tuketimi / toplam_su_tuketimi)*100,'.2f'))
print("İşyeri tipi abonelerin aylık toplam su tüketim miktarları:",format(tip2_su_tuketimi / gun_carpimi,'.2f'),"ve Bornova'daki aylık toplam su tüketim miktarı içindeki yüzdesi:%",format((tip2_su_tuketimi / toplam_su_tuketimi)*100,'.2f'))
print("Resmi daire tipi abonelerin aylık toplam su tüketim miktarları:",format(tip3_su_tuketimi / gun_carpimi,'.2f'),"ve Bornova'daki aylık toplam su tüketim miktarı içindeki yüzdesi:%",format((tip3_su_tuketimi / toplam_su_tuketimi)*100,'.2f'))
print("Organize Sanayi tipi abonelerin aylık toplam su tüketim miktarları:",format(tip4_su_tuketimi / gun_carpimi,'.2f'),"ve Bornova'daki aylık toplam su tüketim miktarı içindeki yüzdesi:%",format((tip4_su_tuketimi / toplam_su_tuketimi)*100,'.2f'))
print("İlçe Tarımsal ve Hayvan Sulama tipi abonelerin aylık toplam su tüketim miktarları:",format(tip5_su_tuketimi / gun_carpimi,'.2f'),"ve Bornova'daki aylık toplam su tüketim miktarı içindeki yüzdesi:%",format((tip5_su_tuketimi / toplam_su_tuketimi)*100,'.2f'))
print("Bornova'nın aylık toplam su tüketim miktarı:",format(toplam_su_tuketimi / gun_carpimi,'.2f'))
print("")
print("Konut tipi abonelerden elde edilen aylık toplam su tüketim ücreti:",format(tip1_ucret / gun_carpimi,'.2f'))
print("İşyeri tipi abonelerden elde edilen aylık toplam su tüketim ücreti:",format(tip2_ucret / gun_carpimi,'.2f'))
print("Resmi daire tipi abonelerden elde edilen aylık toplam su tüketim ücreti:",format(tip3_ucret / gun_carpimi,'.2f'))
print("Organize Sanayi tipi abonelerden elde edilen aylık toplam su tüketim ücreti:",format(tip4_ucret / gun_carpimi,'.2f'))
print("İlçe Tarımsal ve Hayvan Sulama tipi abonelerden elde edilen aylık toplam su tüketim ücreti:",format(tip5_ucret / gun_carpimi,'.2f'))
print("Abonelerden elde edilen aylık toplam su tüketim ücreti:",format(toplam_ucret,'.2f'))
print("Aşağıda toplam fatura ücretlerinden kurumlara ayrılan paylar verilmiştir:")
print("İZSU:",format(izsu_toplam,'.2f'))
print("İlçe belediyesi:",format(ilce_belediye_toplam,'.2f'))
print("Büyükşehir belediyesi:",format(buyuksehir_belediye_toplam,'.2f'))
print("Devlet:",format(devlet_toplam,'.2f'))