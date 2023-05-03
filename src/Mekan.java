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
    
    public void canavarSayisi(){
        Random rand = new Random();
        int sayi = rand.nextInt(3)+1;
        System.out.println("canavar sayısı " + sayi);
    }

    public void savasGanimet(Karakter karakter){
        System.out.println("Oyuncu sağlığı:" + karakter.saglik + "Canavar sağlığı:" + canavar.saglik);
        while(canavar.saglik>=0 && karakter.saglik>=0){
            canavar.saglik-=karakter.hasar;
            karakter.saglik-=canavar.hasar;
        }
        System.out.println("Oyuncu sağlığı:" + karakter.saglik + "Canavar sağlığı:" + canavar.saglik);
        if(karakter.saglik>0){
            this.eşya=true;
            System.out.println("Eşya kazanıldı.");
        }
    }

    /*public void esyaKazan(){
        if(bütün canavarlar öldürüldü){
            this.eşya=true;
        } 
    }*/
}
