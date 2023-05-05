import java.util.Scanner;

public class Mağaza {
    Karakter karakter;
    Silahlar silah;
    Zirhlar zirh;
    Canavar canavar;

    Mağaza() {
        
    }
    
    Scanner input = new Scanner(System.in);
    
    public void alisveris(Karakter karakter, int al, Canavar c1, Canavar c2, Canavar c3){
        if(al==1){
            silahAl(karakter);
        }
        if(al==2){
            zirhAl(karakter, c1, c2, c3);
        }
    }

    public void silahAl(Karakter karakter){
        System.out.println("Hangisi? Tabanca(1)[25 P], Kılıç(2)[35 P], Tüfek(3)[45 P]");
        System.out.println("Cüzdan: " + karakter.para);
        int al = input.nextInt();
        if(al==1 && karakter.para>=25){
            karakter.etki=karakter.hasar+2;
            karakter.para-=25;
        }
        else if(al==2 && karakter.para>=35){
            karakter.etki=karakter.hasar+3;
            karakter.para-=35;
        }
        else if(al==3 && karakter.para>=45){
            karakter.etki=karakter.hasar+7;
            karakter.para-=45;
        }
        else{
            System.out.println("Silah satın alınmadı!");
        }
    }

    public void zirhAl(Karakter karakter, Canavar c1, Canavar c2, Canavar c3){
        System.out.println("Hangi zırh? Hafif(1)[15 P], Orta(2)[25 P], Ağır(3)[40 P]");
        System.out.println("Cüzdan: " + karakter.para);
        int al = input.nextInt();
        if(al==1 && karakter.para>=15){
            c1.etki=c1.hasar-1;
            c2.etki=c2.hasar-1;
            c3.etki=c3.hasar-1;
            System.out.println("C1: " + c1.etki + ", C2: " + c2.etki + ", C3: " + c3.etki);
            karakter.para-=15;
        }
        else if(al==2 && karakter.para>=25){
            c1.etki=c1.hasar-3;
            c2.etki=c2.hasar-3;
            c3.etki=c3.hasar-3;
            System.out.println("C1: " + c1.etki + ", C2: " + c2.etki + ", C3: " + c3.etki);
            karakter.para-=25;
        }
        else if(al==3 && karakter.para>=40){
            c1.etki=0;
            c2.etki=0;
            c3.etki=c3.hasar-5;
            System.out.println("C1: " + c1.etki + ", C2: " + c2.etki + ", C3: " + c3.etki);
            karakter.para-=40;
        }
        else{
            System.out.println("Zırh satın alınmadı!");
        }
    }
}
