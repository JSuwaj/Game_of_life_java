package projekt.organizmy.rosliny;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
public class BarszczSosnowskiego extends Roslina{
    private static final Color kolor_barszczu = new Color(210, 203, 126);
    private static final int sila_barszczu = 10;
    private static final String gatunek_barszczu= "barszcz";
    public BarszczSosnowskiego(int polozenie_x, int polozenie_y,  Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_barszczu,  gatunek_barszczu, swiat, kolor_barszczu);
    }
    @Override
    public void Akcja()
    {
        //funkcja sprawdza czy w jego sasiedztwie stoi jakies zwierze i jezeli stoi to je zabija
        Organizm temp = swiat.CoTuStoi(this.getPolozenie_x() + 1, this.getPolozenie_y());
        if (temp!=null)
        {
            if (temp.getInicjatywa() != 0 && !temp.getGatunek().equals("cyberowca"))
            {
                temp.setZywy(false);
                swiat.Usmierc(temp);
            }
        }
        temp = swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + 1);
        if (temp != null)
        {
            if (temp.getInicjatywa() != 0 && !temp.getGatunek().equals("cyberowca"))
            {
                temp.setZywy(false);
                swiat.Usmierc(temp);
            }
        }
        temp = swiat.CoTuStoi(this.getPolozenie_x() - 1, this.getPolozenie_y());
        if (temp != null)
        {
            if (temp.getInicjatywa() != 0 && !temp.getGatunek().equals("cyberowca"))
            {
                temp.setZywy(false);
                swiat.Usmierc(temp);
            }
        }
        temp = swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() - 1);
        if (temp != null)
        {
            if (temp.getInicjatywa() != 0 && !temp.getGatunek().equals("cyberowca"))
            {
                temp.setZywy(false);
                swiat.Usmierc(temp);
            }
        }
        RozprzestrzenSie();
    }
    @Override
    public void Kolizja(Organizm inny_organizm) {
        if(inny_organizm.getGatunek().equals("cyberowca"))
        {
            int temp_x = this.getPolozenie_x();
            int temp_y = this.getPolozenie_y();
            this.setZywy(false);
            swiat.Usmierc(this);
            inny_organizm.setPolozenie_x(temp_x);
            inny_organizm.setPolozenie_y(temp_y);
        }
        else {
            if (inny_organizm.getInicjatywa() != 0 ) {
                inny_organizm.setZywy(false);
                swiat.Usmierc(inny_organizm);
            }
        }
    }
    @Override
    public Organizm KopiujOrganizm(int x, int y)
    {
        return new BarszczSosnowskiego(x, y, swiat);
    }
}
