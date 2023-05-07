import java.util.Random;

public class Mekan {
    String name;
    Canavar canavar;
    boolean eşya;
    Karakter karakter;
    
    Mekan(String name, Canavar canavar, boolean eşya){
        this.canavar=canavar;
        this.name=name;
        this.eşya=eşya;
    }
    
    public int canavarSayisi(){
        Random rand = new Random();
        int sayi = rand.nextInt(3)+1;
        return sayi;
    }
    public void savasGanimet(Karakter karakter, int i){
        System.out.println(" ");
        System.out.println(i+". düşman");
        System.out.println("---------");
        System.out.println("Oyuncu sağlığı:" + karakter.saglik + " / Canavar sağlığı:" + canavar.saglik);
        int temp=canavar.saglik;
        Random rand = new Random();
        int sayi = rand.nextInt(2);
        if(sayi==0){
            while(canavar.saglik>=0 && karakter.saglik>=0){
                canavar.saglik-=karakter.etki;
                if(canavar.saglik<=0 || karakter.saglik<=0) {
                    System.out.println("Canavar sağlığı:" + canavar.saglik + " / Oyuncu sağlığı:" + karakter.saglik);
                    break;
                }
                karakter.saglik-=canavar.etki;
                System.out.println("Canavar sağlığı:" + canavar.saglik + " / Oyuncu sağlığı:" + karakter.saglik);

            }
        }
        if(sayi==1){
            while(canavar.saglik>=0 && karakter.saglik>=0){
                karakter.saglik-=canavar.etki;
                if(canavar.saglik<=0 || karakter.saglik<=0) {
                    System.out.println("Oyuncu sağlığı:" + karakter.saglik + " / Canavar sağlığı:" + canavar.saglik);
                    break;
                }
                canavar.saglik-=karakter.etki;
                System.out.println("Oyuncu sağlığı:" + karakter.saglik + " / Canavar sağlığı:" + canavar.saglik);
            }
        }
        
        System.out.println("Oyuncu sağlığı:" + karakter.saglik + " / Canavar sağlığı:" + canavar.saglik);
        System.out.println("---------");
        canavar.saglik=temp;
    }

    public void yılanEşyaÇarkı(Karakter karakter, Canavar c1, Canavar c2, Canavar c3, Canavar c4, Mekan mekan){
        Random rand = new Random();
        int çark = rand.nextInt(100)+1;
        if(çark>0 && çark<=45){ // hiçbir şey
            System.out.println("Hiçbir şey kazanamadınız. :(");
        }
        if(çark>45 && çark<=60){ // silah
            int slh = rand.nextInt(100)+1;
            if(slh>0 && slh<=20){ // tüfek
                karakter.etki=karakter.hasar+7;
                System.out.println("Tüfek kazandınız. :)");
            }
            if(slh>20 && slh<=50){ // kılıç
                karakter.etki=karakter.hasar+3;
                System.out.println("Kılıç kazandınız. :)");

            }
            if(slh>50 && slh<=100){ // tabanca
                karakter.etki=karakter.hasar+2;
                System.out.println("Tabanca kazandınız. :)");

            }
            mekan.eşya=true;
            
        }
        if(çark>60 && çark<=75){ // zırh
            int zrh = rand.nextInt(100)+1;
            if(zrh>0 && zrh<=20){ // ağır
                c1.etki=0;
                c2.etki=0;
                c3.etki=c3.hasar-5;
                if(c4.hasar-5>=0){
                    c4.etki=c4.hasar-5;
                }
                else{
                    c4.etki=0;
                }
                System.out.println("Ağır zırh kazandınız. :)");
            }
            if(zrh>20 && zrh<=50){ // orta
                c1.etki=c1.hasar-3;
                c2.etki=c2.hasar-3;
                c3.etki=c3.hasar-3;
                c4.etki=c4.hasar-3;
                System.out.println("Orta zırh kazandınız. :)");
            }
            if(zrh>50 && zrh<=100){ // hafif
                c1.etki=c1.hasar-1;
                c2.etki=c2.hasar-1;
                c3.etki=c3.hasar-1;
                c4.etki=c4.hasar-1;
                System.out.println("Hafif zırh kazandınız. :)");
            }
            mekan.eşya=true;
        }
        if(çark>75 && çark<=100){ // para
            int pr = rand.nextInt(100)+1;
            if(pr>0 && pr<=20){ // 10 para
                karakter.para=karakter.para+10;
                System.out.println("10 para kazandınız. :)");
            }
            if(pr>20 && pr<=50){ // 5 para
                karakter.para=karakter.para+5;
                System.out.println("5 para kazandınız. :)");
            }
            if(pr>50 && pr<=100){ // 1 para
                karakter.para=karakter.para+1;
                System.out.println("1 para kazandınız. :)");
            }
            mekan.eşya=true;
        }
    }
}
