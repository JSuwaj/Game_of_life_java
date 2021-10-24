package projekt.organizmy.zwierzeta;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
public class Wilk extends Zwierze{
    private static final Color kolor_wilka = new Color(101, 101, 101);
    private static final int sila_wilka = 9;
    private static final int inicjatywa_wilka = 5;
    private static final int zasieg_wilka = 1;
    private static final String gatunek_wilka = "wilk";
    public Wilk(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_wilka, inicjatywa_wilka, gatunek_wilka, swiat, kolor_wilka, zasieg_wilka);
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
        return new Wilk(x, y, swiat);
    }
}
