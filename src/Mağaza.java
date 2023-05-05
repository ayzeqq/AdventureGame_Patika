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
            zirhAl(c1, c2, c3);
        }
    }

    public void silahAl(Karakter karakter){
        System.out.println("Hangisi? Tabanca(1), Kılıç(2), Tüfek(3)");
        int al = input.nextInt();
        if(al==1){
            karakter.etki=karakter.hasar+2;
        }
        else if(al==2){
            karakter.etki=karakter.hasar+3;
        }
        else if(al==3){
            karakter.etki=karakter.hasar+7;
        }
        else{
            System.out.println("Silah satın alınmadı!");
        }
    }

    public void zirhAl(Canavar c1, Canavar c2, Canavar c3){
        System.out.println("Hangi zırh? Hafif(1), Orta(2), Ağır(3)");
        int al = input.nextInt();
        if(al==1){
            c1.etki=c1.hasar-1;
            c2.etki=c2.hasar-1;
            c3.etki=c3.hasar-1;
            System.out.println("C1: " + c1.etki + ", C2: " + c2.etki + ", C3: " + c3.etki);            
        }
        else if(al==2){
            c1.etki=c1.hasar-3;
            c2.etki=c2.hasar-3;
            c3.etki=c3.hasar-3;
            System.out.println("C1: " + c1.etki + ", C2: " + c2.etki + ", C3: " + c3.etki);
        }
        else if(al==3){
            c1.etki=0;
            c2.etki=0;
            c3.etki=c3.hasar-5;
            System.out.println("C1: " + c1.etki + ", C2: " + c2.etki + ", C3: " + c3.etki);
        }
        else{
            System.out.println("Zırh satın alınmadı!");
        }
    }
}
