package projekt.swiat;
import javax.swing.*;
import java.awt.*;
public class Plansza extends JPanel{
    private final int szerokosc;
    private final int wysokosc;
    private final int x;
    private final int y;
    static public int wielkosc_komorki = 30;
    static public int margines = 10;
    boolean czy_gra_zaczeta;
    private final Swiat swiat;
    public Plansza(Swiat swiat,int x,int y)
    {
        this.x=x;
        this.y=y;
        this.swiat=swiat;
        this.szerokosc= margines+wielkosc_komorki*x;
        this.wysokosc=margines+wielkosc_komorki*y;
        this.czy_gra_zaczeta=false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        swiat.RysujSwiat(g, wielkosc_komorki, margines);
        if(!czy_gra_zaczeta)
        {
            for(int i=0;i<wysokosc;i++)
                for(int j=0;j<szerokosc;j++)
                {
                    g.setColor(Color.WHITE);
                    g.fillRect(margines + i * wielkosc_komorki+1,margines + j * wielkosc_komorki+1,wielkosc_komorki-1, wielkosc_komorki-1);
                }
        }
    }
    public int getWidth(){
        return szerokosc;
    }

    public int getHeight() {
        return wysokosc;
    }

    public void setCzy_gra_zaczeta(boolean czy_gra_zaczeta)
    {
        this.czy_gra_zaczeta=czy_gra_zaczeta;
    }

}
