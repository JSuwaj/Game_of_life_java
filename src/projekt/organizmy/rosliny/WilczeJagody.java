package projekt.organizmy.rosliny;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
public class WilczeJagody extends Roslina{
    private static final Color kolor_jagod = new Color(0, 0, 0);
    private static final int sila_jagod = 99;
    private static final String gatunek_jagod = "jagody";
    public WilczeJagody(int polozenie_x, int polozenie_y,  Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_jagod,  gatunek_jagod, swiat, kolor_jagod);
    }
    @Override
    public void Kolizja(Organizm inny_organizm) {
        if (inny_organizm.getInicjatywa() != 0)
        {
            inny_organizm.setZywy(false);
            swiat.Usmierc(inny_organizm);
        }
    }
    @Override
    public Organizm KopiujOrganizm(int x, int y)
    {
        return new WilczeJagody(x, y, swiat);
    }
}
