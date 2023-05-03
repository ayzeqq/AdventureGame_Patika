import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Karakter Samuray = new Karakter (1,5,21,15);
        Karakter Okçu = new Karakter (2,7,18,20);
        Karakter Şovalye = new Karakter (3,8,24,5);
        Karakter Gamer = new Karakter(0, 0, 0, 0);

        Canavar Zombi = new Canavar (1,3,10,4);
        Canavar Vampir = new Canavar (2,4,14,7);
        Canavar Ayı = new Canavar (3,7,20,12);
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
        
        System.out.println("Karakter seçiniz: \nSamuray (1) \nOkçu (2) \nŞovalye (3)");
        Scanner input = new Scanner(System.in);
        int seçKar = input.nextInt();
        if(seçKar==1) Gamer=Samuray;
        if(seçKar==2) Gamer=Okçu;
        if(seçKar==3) Gamer=Şovalye;
        System.out.println(Gamer.ID);
        while(Gamer.saglik>0){
            System.out.println("Gidilecek yer: Mağara 1, Orman 2, Nehir 3, Güvenli Ev 4, Mağaza 5");
            int seçMek = input.nextInt();
            if(seçMek==1) Savaş=Mağara;
            if(seçMek==2) Savaş=Orman;
            if(seçMek==3) Savaş=Nehir;
            //en son 4.seçenek eklendi ve güvenli ev entegresine devam edilecek...
            if(seçMek==4){
                Gamer.saglikTamamla();
            }
            Savaş.savasGanimet(Gamer);
            if(seçMek==1) Mağara.eşya=Savaş.eşya;
            if(seçMek==2) Orman.eşya=Savaş.eşya;
            if(seçMek==3) Nehir.eşya=Savaş.eşya;
            if(isKazandi(Mağara, Orman, Nehir)){
                System.out.println("Kazandınız!");
                break;
            }
        }
        System.out.println("Kaybettiniz!");
        

        //System.out.println("Oyuncu sağlık son durumu: " + Gamer.saglik);
        
    }

    static boolean isKazandi(Mekan Mağara, Mekan Orman, Mekan Nehir) {
        if(Mağara.eşya==true && Orman.eşya==true && Nehir.eşya==true){
            return true;
        }
        return false;
    }
}
