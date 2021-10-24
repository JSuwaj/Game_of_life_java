package projekt.organizmy.zwierzeta;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;
import projekt.swiat.Punkt;
import java.awt.*;
import java.util.Random;

public class CyberOwca extends Zwierze{
    private static final Color kolor_cyberowcy = new Color(0, 255, 248);
    private static final int sila_cyberowcy = 11;
    private static final int inicjatywa_cyberowcy = 4;
    private static final int zasieg_cyberowcy = 1;
    private static final String gatunek_cyberowcy = "cyberowca";
    public CyberOwca(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_cyberowcy, inicjatywa_cyberowcy, gatunek_cyberowcy, swiat, kolor_cyberowcy, zasieg_cyberowcy);
    }
    @Override
    public void Akcja()
    {
        //jezeli barszcz na mapie istnieje to cyberowca kieruje sie poziomo a potem pionowo
        Punkt miejsce_docelowe=swiat.ZnajdzBarszcz(this.getPolozenie_x(),this.getPolozenie_y());
        if(miejsce_docelowe.getX()==-1 && miejsce_docelowe.getY()==-1)
        {
            Random rand = new Random();
            int kierunek = rand.nextInt(4);
            switch (kierunek % 4)
            {
                case 0:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), zasieg_cyberowcy, 0))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, zasieg_cyberowcy, 0);
                    break;
                case 1:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, zasieg_cyberowcy))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, 0,  zasieg_cyberowcy);
                    break;
                case 2:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1)*zasieg_cyberowcy, 0))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, (-1)*zasieg_cyberowcy, 0);
                    break;
                case 3:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1)*zasieg_cyberowcy))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, 0 , (-1) * zasieg_cyberowcy);
                    break;
            }
        }
        else {
            if (miejsce_docelowe.getX() > this.getPolozenie_x()) {
                swiat.PoruszZwierza(this, zasieg_cyberowcy, 0);
            } else if (miejsce_docelowe.getX() < this.getPolozenie_x()) {
                swiat.PoruszZwierza(this, (-1) * zasieg_cyberowcy, 0);
            } else {
                if (miejsce_docelowe.getX() == this.getPolozenie_x()) {
                    if (miejsce_docelowe.getY() > this.getPolozenie_y()) {
                        swiat.PoruszZwierza(this, 0, zasieg_cyberowcy);
                    } else if (miejsce_docelowe.getY() < this.getPolozenie_y()) {
                        swiat.PoruszZwierza(this, 0, (-1) * zasieg_cyberowcy);
                    }
                }
            }
        }
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
        return new CyberOwca(x, y, swiat);
    }
}
