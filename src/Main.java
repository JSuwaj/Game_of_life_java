
import java.awt.*;


import projekt.swiat.Okno;
import projekt.swiat.Swiat;


public class Main extends Canvas{
    public static void main(String[] args) {
        Main m=new Main();
        Swiat swiat= new Swiat(20,20);
        Okno okno = new Okno(20,20,swiat);
        okno.setVisible(true);
        int a;

    }
}
