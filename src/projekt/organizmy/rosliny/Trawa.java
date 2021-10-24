package projekt.organizmy.rosliny;

import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;

public class Trawa extends Roslina{
    private static final Color kolor_trawy = new Color(128, 255, 0);
    private static final int sila_trawy = 0;
    private static final String gatunek_trawy = "trawa";
    public Trawa(int polozenie_x, int polozenie_y,  Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_trawy,  gatunek_trawy, swiat, kolor_trawy);
    }
    @Override
    public Organizm KopiujOrganizm(int x, int y)
    {
        return new Trawa(x, y, swiat);
    }
}
