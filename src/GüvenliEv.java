public class GüvenliEv {
    Karakter karakter;
    int saglik;

    GüvenliEv(Karakter karakter){
        this.karakter=karakter;
    }
    public void saglikTamamla(){
        if(karakter.ID==1) saglik=21;
        if(karakter.ID==2) saglik=18;
        if(karakter.ID==3) saglik=24;
    }
}
