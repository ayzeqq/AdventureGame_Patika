public abstract class Canlilar {
    
    int ID;
    int hasar;
    int saglik;
    int para;
    String name;
    int etki;
    //static Silahlar silah;

    Canlilar(int ID, int hasar, int saglik, int para, String name, int etki){
        this.ID=ID;
        this.hasar=hasar;
        this.saglik=saglik;
        this.para=para;
        this.name=name;
        this.etki=etki;
        //this.silah=silah;
    }
}
