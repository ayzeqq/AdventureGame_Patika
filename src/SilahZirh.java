public abstract class SilahZirh {
    int ID;
    int hasar;
    int para;
    
    public SilahZirh (int ID, int hasar, int para){
        this.ID=ID;
        this.hasar=hasar;
        this.para=para;
    }

    public void test(){
        System.out.println(2*ID);
    }
}
