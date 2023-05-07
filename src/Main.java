import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // ---- Terimler ingilizceye çevrilecek...

        // ++++ Hasar ve etki de randomlanacak!!
        // ++++ Para-eşya vs düşme ihtimalini düzenle...
        // ++++ Satın alma düzenlemesi yapılacak...
        // ++++ Gereksiz eklenen kodları incele ve çıkar...
        // ++++ Mağaza kısmı eklenecek...
        // ++++ Kazansa da "kaybetti" yazısı ilaveten çıkıyor...
        // ++++ Her turda eşya kazanmamalı, o turdaki tüm canavarlar ölünce almalı...
        
        Karakter Samuray = new Karakter (1,5,21,15, "Samuray", 5);
        Karakter Okçu = new Karakter (2,7,18,20, "Okçu", 7);
        Karakter Şovalye = new Karakter (3,8,24,5, "Şovalye", 8);
        Karakter Gamer = new Karakter(0, 0, 0, 0, "Gamer", 0);
        
        Canavar Zombi = new Canavar (1,3,10,4, "Zombi", 3);
        Canavar Vampir = new Canavar (2,4,14,7, "Vampir", 4);
        Canavar Ayı = new Canavar (3,7,20,12, "Ayı", 7);
        
        Canavar Yılan = new Canavar (4, Canavar.hasarÜret(), 12, 0, "Yılan", 6); 
        
        
        
        /*Silahlar Tabanca = new Silahlar (1,2,25);
        Silahlar Kılıç = new Silahlar (2,3,35);
        Silahlar Tüfek = new Silahlar (3,7,45);
        
        
        Zirhlar Hafif = new Zirhlar (1,1,15);
        Zirhlar Orta = new Zirhlar (2,3,25);
        Zirhlar Ağır = new Zirhlar (3,5,40);*/
        
        Mekan Mağara = new Mekan ("Mağara", Zombi, false);
        Mekan Orman = new Mekan ("Orman", Vampir, false);
        Mekan Nehir = new Mekan ("Nehir", Ayı, false);
        Mekan Maden = new Mekan ("Maden", Yılan, false);
        Mekan Savaş = new Mekan ("Savaş", Zombi, false);

        Mağaza mağaza = new Mağaza();
        
        System.out.println("Karakter seçiniz:");
        System.out.println("-----------------");
        System.out.println("Samuray (1), Okçu (2), Şovalye (3)");
        Scanner input = new Scanner(System.in);
        int seçKar = input.nextInt();
        if(seçKar==1) Gamer=Samuray;
        if(seçKar==2) Gamer=Okçu;
        if(seçKar==3) Gamer=Şovalye;

        while(Gamer.saglik>0){
            System.out.println("Gitmek istediğiniz yeri seçiniz:");
            System.out.println("--------------------------------");
            System.out.println("Mağara (1), Orman (2), Nehir (3), Maden (4), Mağaza (5), Güvenli Ev (6)");
            int seçMek = input.nextInt();
            if(seçMek==1) {
                Savaş=Mağara;
                if(Mağara.eşya){
                    System.out.println("=========");
                    System.out.println("Daha önce bu bölümden eşya kazanıldı.");
                    System.out.println("Diğer bölümleri tamamlayınız.");
                    System.out.println("=========");
                    continue;
                }
                int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Zombi çıktı, savaşmak için (1), kaçmak için (2)");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    if(Gamer.saglik>0){
                        Savaş.savasGanimet(Gamer, i, Zombi);
                    }
                    else{
                        break;
                    }
                    if(Gamer.saglik>0) {
                        Gamer.para+=4;
                        System.out.println("4 para kazandınız.");
                        System.out.println("Toplam para: " + Gamer.para);
                        System.out.println("=========");
                    }
                }
                if(Gamer.saglik>0){
                    Mağara.eşya=true;
                    System.out.println("Eşya kazanıldı.");
                }
                
                if(isKazandi(Mağara, Orman, Nehir, Maden)){
                    break;
                }
            }
            else if(seçMek==2) {
                Savaş=Orman;
                if(Orman.eşya){
                    System.out.println("=========");
                    System.out.println("Daha önce bu bölümden eşya kazanıldı.");
                    System.out.println("Diğer bölümleri tamamlayınız.");
                    System.out.println("=========");
                    continue;
                }
                int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Vampir çıktı, savaşmak için (1), kaçmak için (2)");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    if(Gamer.saglik>0){
                        Savaş.savasGanimet(Gamer, i, Vampir);
                    }
                    else{
                        break;
                    }
                    if(Gamer.saglik>0) {
                        Gamer.para+=7;
                        System.out.println("7 para kazandınız.");
                        System.out.println("Toplam para: " + Gamer.para);
                        System.out.println("=========");
                    }
                }
                if(Gamer.saglik>0){
                    Orman.eşya=true;
                    System.out.println("Eşya kazanıldı.");
                }
                if(isKazandi(Mağara, Orman, Nehir, Maden)){
                    break;
                }
            }
            else if(seçMek==3) {
                Savaş=Nehir;
                if(Nehir.eşya){
                    System.out.println("=========");
                    System.out.println("Daha önce bu bölümden eşya kazanıldı.");
                    System.out.println("Diğer bölümleri tamamlayınız.");
                    System.out.println("=========");
                    continue;
                }
                int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Ayı çıktı, savaşmak için (1), kaçmak için (2)");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    if(Gamer.saglik>0){
                        Savaş.savasGanimet(Gamer, i, Ayı);
                    }
                    else{
                        break;
                    }
                    if(Gamer.saglik>0) {
                        Gamer.para+=12;
                        System.out.println("12 para kazandınız.");
                        System.out.println("Toplam para: " + Gamer.para);
                        System.out.println("=========");
                    }
                }
                if(Gamer.saglik>0){
                    Nehir.eşya=true;
                    System.out.println("Eşya kazanıldı.");
                    System.out.println(" ");
                }
                if(isKazandi(Mağara, Orman, Nehir, Maden)){
                    break;
                }
            }
            else if(seçMek==4){ 
                Savaş=Maden;
                if(Savaş.eşya){
                    System.out.println("=========");
                    System.out.println("Daha önce bu bölümden eşya kazanıldı.");
                    System.out.println("Diğer bölümleri tamamlayınız.");
                    System.out.println("=========");
                    continue;
                }
                Random rand = new Random();
                int sayi = rand.nextInt(5)+1;
                //int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Yılan çıktı, savaşmak için (1), kaçmak için (2)");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    if(Gamer.saglik>0){
                        Savaş.savasGanimet(Gamer, i, Yılan);
                    }
                    else{
                        break;
                    }
                    if(Gamer.saglik>0) {
                        Savaş.yılanEşyaÇarkı(Gamer, Zombi, Vampir, Ayı, Yılan, Savaş);
                        System.out.println("Toplam para: " + Gamer.para);
                        System.out.println("=========");
                    }
                }
                if(Gamer.saglik>0){
                    Maden.eşya=true;
                    //System.out.println("Eşya kazanıldı!");
                    //System.out.println(" ");
                }
                if(isKazandi(Mağara, Orman, Nehir, Maden)){
                    break;
                }
            }
            else if(seçMek==5){
                System.out.println("Hangisini satın almak istersin? Silah (1) / Zırh (2)");
                int al = input.nextInt();
                mağaza.alisveris(Gamer, al, Zombi, Vampir, Ayı, Yılan);
                System.out.println("Kalan para: " + Gamer.para);
            }
            else if(seçMek==6){
                Gamer.saglikTamamla();
                System.out.println("Sağlık yenilendi. Son sağlık durumu: " + Gamer.saglik);
            }
            else {
                System.out.println("Geçerli bir seçenek giriniz:");
            }
        }

        if(Gamer.saglik<=0) {
            System.out.println("============");
            System.out.println(":( :( OYUNU KAYBETTİNİZ. :( :(");
            System.out.println("============");
            System.out.println("SON DURUM:");
            System.out.println("Oyuncu sağlık durumu: " + Gamer.saglik);
            System.out.println("Oyuncu para durumu: " + Gamer.para);
        }
        else {
            System.out.println("============");
            System.out.println("---### OYUNU KAZANDINIZ. ###---");
            System.out.println("============");
            System.out.println("SON DURUM:");
            System.out.println("Oyuncu sağlık durumu: " + Gamer.saglik);
            System.out.println("Oyuncu para durumu: " + Gamer.para);
        }
    }

    static boolean isKazandi(Mekan Mağara, Mekan Orman, Mekan Nehir, Mekan Maden) {
        if(Mağara.eşya==true && Orman.eşya==true && Nehir.eşya==true && Maden.eşya==true){
            return true;
        }
        return false;
    }

    public void sonDurum() {

    }
}
