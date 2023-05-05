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
}
