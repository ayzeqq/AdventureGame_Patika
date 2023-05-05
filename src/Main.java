import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Satın alma düzenlemesi yapılacak...
        // Gereksiz eklenen kodları incele ve çıkar...
        
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
        Silahlar Tabanca = new Silahlar (1,2,25);
        Silahlar Kılıç = new Silahlar (2,3,35);
        Silahlar Tüfek = new Silahlar (3,7,45);
        
        Zirhlar Hafif = new Zirhlar (1,1,15);
        Zirhlar Orta = new Zirhlar (2,3,25);
        Zirhlar Ağır = new Zirhlar (3,5,40);
        Mekan Mağara = new Mekan ("Mağara", Zombi, false);
        Mekan Orman = new Mekan ("Orman", Vampir, false);
        Mekan Nehir = new Mekan ("Nehir", Ayı, false);
        Mekan Savaş = new Mekan ("Savaş", Zombi, false);

        Mağaza mağaza = new Mağaza();
        
        System.out.println("Karakter seçiniz: Samuray (1), Okçu (2), Şovalye (3)");
        Scanner input = new Scanner(System.in);
        int seçKar = input.nextInt();
        if(seçKar==1) Gamer=Samuray;
        if(seçKar==2) Gamer=Okçu;
        if(seçKar==3) Gamer=Şovalye;
        System.out.println(Gamer.ID);
        while(Gamer.saglik>0){
            System.out.println("Gidilecek yer: Mağara 1, Orman 2, Nehir 3, Güvenli Ev 4, Mağaza 5");
            int seçMek = input.nextInt();
            if(seçMek==1) {
                Savaş=Mağara;
                int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Zombi çıktı, savaşmak için (1), kaçmak için (2).");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    Savaş.savasGanimet(Gamer, i);
                }
                if(Gamer.saglik>0){
                    Mağara.eşya=true;
                    System.out.println("Eşya kazanıldı!");
                }
                
                if(isKazandi(Mağara, Orman, Nehir)){
                    System.out.println("Kazandınız!");
                    break;
                }
            }
            else if(seçMek==2) {
                Savaş=Orman;
                int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Vampir çıktı, savaşmak için (1), kaçmak için (2).");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    Savaş.savasGanimet(Gamer, i);
                }
                if(Gamer.saglik>0){
                    Orman.eşya=true;
                    System.out.println("Eşya kazanıldı!");
                }
                if(isKazandi(Mağara, Orman, Nehir)){
                    System.out.println("Kazandınız!");
                    break;
                }
            }
            else if(seçMek==3) {
                Savaş=Nehir;
                int sayi = Savaş.canavarSayisi();
                System.out.println(sayi + " adet Ayı çıktı, savaşmak için (1), kaçmak için (2).");
                int savKaç=input.nextInt();
                if(savKaç==2) {
                    continue;
                }
                for(int i=1;i<=sayi;i++){
                    Savaş.savasGanimet(Gamer, i);
                }
                if(Gamer.saglik>0){
                    Nehir.eşya=true;
                    System.out.println("Eşya kazanıldı!");
                }
                if(isKazandi(Mağara, Orman, Nehir)){
                    System.out.println("Kazandınız!");
                    break;
                }
            }
            else if(seçMek==4){
                Gamer.saglikTamamla();
            }
            else if(seçMek==5){
                System.out.println("Hangisini satın almak istersin? Silah (1) / Zırh (2)");
                int al = input.nextInt();
                mağaza.alisveris(Gamer, al, Zombi, Vampir, Ayı);
            }
            else {
                System.out.println("Geçerli bir seçenek giriniz!");
            }
            
        }
        if(Gamer.saglik<=0) System.out.println("Kaybettiniz!");
                
    }

    static boolean isKazandi(Mekan Mağara, Mekan Orman, Mekan Nehir) {
        if(Mağara.eşya==true && Orman.eşya==true && Nehir.eşya==true){
            return true;
        }
        return false;
    }
}
