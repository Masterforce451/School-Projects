import java.util.Random;
import java.lang.Math;

public class EightQueens {
    int h;
    int yerDegistirme;
    int restartSayisi;
    Random random = new Random();
    public int[] hillClimbing() {
        yerDegistirme = 0;
        restartSayisi = 0;
        int[] bestSuccessor = satrancTahtasiOlustur();
        h = hHesapla(bestSuccessor);
        int hOnceki = h;

        while (true) {
            if (h == 0) {
                return bestSuccessor;
            }
            else {
                int[][] successors = generateSuccessors(bestSuccessor);
                bestSuccessor = selectBestNode(successors, bestSuccessor, h);
                if (h == hOnceki) {
                    restartSayisi++;
                    bestSuccessor = satrancTahtasiOlustur();
                    h = hHesapla(bestSuccessor);
                }
                hOnceki = h;
            }
        }
    }
    
    public int[] satrancTahtasiOlustur() {
        int[] satrancTahtasi = new int[8];
        for (int i=0; i<satrancTahtasi.length; i++) {
            satrancTahtasi[i] = random.nextInt(8);
        }
        return satrancTahtasi;
    }

    public int hHesapla(int[] satrancTahtasi) {
        int h = 0;
        for (int i=0; i<satrancTahtasi.length; i++) {
            for (int j=i+1; j<satrancTahtasi.length; j++) {
                if ((satrancTahtasi[i] == satrancTahtasi[j]) || (Math.abs(i-j) == Math.abs(satrancTahtasi[i]-satrancTahtasi[j]))) {
                    h++;
                }
            }
        }
        return h;
    }

    public int[][] generateSuccessors(int[] satrancTahtasi) {
        int[][] hamleTahtasi = new int[8][8];
        int[] satrancTahtasiKomsu;

        for (int i=0; i<satrancTahtasi.length; i++) {
            satrancTahtasiKomsu = satrancTahtasi.clone();
            for (int j=0; j<8; j++) {
                satrancTahtasiKomsu[i] = j;
                hamleTahtasi[i][j] = hHesapla(satrancTahtasiKomsu);
            }
        }
        return hamleTahtasi;
    }

    public int[] selectBestNode(int[][] successors, int[] satrancTahtasi, int hSimdiki) {
        int[] successor = satrancTahtasi.clone();
        int hMinimum = hSimdiki;
        for (int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                if (successors[i][j] < hMinimum) {
                    successor = satrancTahtasi.clone();
                    hMinimum = successors[i][j];
                    successor[i] = j;
                }
            }
        }
        yerDegistirme++;
        h = hMinimum;
        return successor;
    }

    public void tahtaYazdir(int[] tahta,int iterasyon) {
        System.out.print("Çözüm" + " ".repeat(3 - Integer.toString(iterasyon).length())+ iterasyon + ": ");
        for(int i=0;i<tahta.length;i++) {
            System.out.print(tahta[i] + " ");
        }
    }
    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        double totalTime=0;
        int[] yer_degistirme_sayisi = new int[15];
        int yer_degistirme_toplam = 0;
        int[] random_restart_sayisi = new int[15];
        int random_restart_toplam = 0;
        double[] totalTime_sayisi = new double[15];
        double sure_toplam = 0;
        for(int i=0;i<15;i++) {
            long startTime = System.nanoTime();
            eightQueens.tahtaYazdir(eightQueens.hillClimbing(),i);
            System.out.println();
            long endTime = System.nanoTime();
            totalTime = ((endTime - startTime)/Math.pow(10,9));
            yer_degistirme_sayisi[i] = eightQueens.yerDegistirme;
            yer_degistirme_toplam += eightQueens.yerDegistirme;
            random_restart_sayisi[i] = eightQueens.restartSayisi;
            random_restart_toplam += eightQueens.restartSayisi;
            totalTime_sayisi[i] = totalTime;
            sure_toplam += totalTime;
        }

        int ortalama_yer_degistirme = yer_degistirme_toplam / 15;
        int ortalama_restart = random_restart_toplam / 15;
        double ortalama_sure = sure_toplam / 15;

        System.out.println();
        System.out.println("Döngü no    Yer değiştirme  Random restart  Çalışma süresi");
        for(int i=0;i<15;i++) {
            System.out.print(i + " ".repeat(12-Integer.toString(i).length()));
            System.out.print(yer_degistirme_sayisi[i]);
            System.out.print(" ".repeat(16-Integer.toString(yer_degistirme_sayisi[i]).length()));
            System.out.print(random_restart_sayisi[i]);
            System.out.print(" ".repeat(16-Integer.toString(random_restart_sayisi[i]).length()));
            System.out.println(String.format("%.7f",totalTime_sayisi[i]) + " sn");
        }
        System.out.print("Ortalamalar:");
        System.out.print(ortalama_yer_degistirme + " ".repeat(16-Integer.toString(ortalama_yer_degistirme).length()));
        System.out.print(ortalama_restart + " ".repeat(16-Integer.toString(ortalama_restart).length()));
        System.out.println(String.format("%.7f",ortalama_sure) + " sn");

    }
}