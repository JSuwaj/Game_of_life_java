package projekt.organizmy.rosliny;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
public class Guarana extends Roslina{
    private static final Color kolor_guarany = new Color(163, 0, 13);
    private static final int sila_guarany = 0;
    private static final String gatunek_guarany = "guarana";
    public Guarana(int polozenie_x, int polozenie_y,  Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_guarany,  gatunek_guarany, swiat, kolor_guarany);
    }
    @Override
    public void Kolizja(Organizm inny_organizm) {
        if (this.getSila() <= inny_organizm.getSila())
        {
            int temp_x = this.getPolozenie_x();
            int temp_y = this.getPolozenie_y();
            inny_organizm.setSila(inny_organizm.getSila() + 3);
            this.setZywy(false);
            swiat.Usmierc(this);
            inny_organizm.setPolozenie_x(temp_x);
            inny_organizm.setPolozenie_y(temp_y);
        }
        else
        {
            inny_organizm.setZywy(false);
            swiat.Usmierc(inny_organizm);
        }
    }
    @Override
    public Organizm KopiujOrganizm(int x, int y)
    {
        return new Guarana(x, y, swiat);
    }
}
