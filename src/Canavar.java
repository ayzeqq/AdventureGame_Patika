import java.util.Random;

public class Canavar extends Canlilar{

    Canavar(int ID, int hasar, int saglik, int para, String name, int etki) {
        super(ID, hasar, saglik, para, name, etki);
        //TODO Auto-generated constructor stub
    }

    static int hasarÜret(){
        Random rand = new Random();
        int hsr = rand.nextInt(4)+3;
        return hsr;
    }

    static int eşyaDüş() {
        return 54;
    }
    
}
