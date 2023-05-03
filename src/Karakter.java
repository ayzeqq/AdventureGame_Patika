public class Karakter extends Canlilar{

    //Karakter karakter;

    Karakter(int ID, int hasar, int saglik, int para) {
        super(ID, hasar, saglik, para);
        //TODO Auto-generated constructor stub
    }

    public void saglikTamamla() {
        if(ID==1) saglik=21;
        if(ID==2) saglik=18;
        if(ID==3) saglik=24;
    }
    
}
