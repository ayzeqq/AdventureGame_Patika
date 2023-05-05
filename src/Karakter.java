public class Karakter extends Canlilar{

    Karakter(int ID, int hasar, int saglik, int para, String name, int etki) {
        super(ID, hasar, saglik, para, name, etki);
        //TODO Auto-generated constructor stub
    }

    public void saglikTamamla() {
        if(ID==1) saglik=21;
        if(ID==2) saglik=18;
        if(ID==3) saglik=24;
    }
    
}
