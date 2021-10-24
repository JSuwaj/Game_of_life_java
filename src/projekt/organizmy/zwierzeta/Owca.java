package projekt.organizmy.zwierzeta;

import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;

public class Owca extends Zwierze {
    private static final Color kolor_owcy = new Color(187, 187, 187);
    private static final int sila_owcy = 4;
    private static final int inicjatywa_owcy = 4;
    private static final int zasieg_owcy = 1;
    private static final String gatunek_owcy = "owca";
    public Owca(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_owcy, inicjatywa_owcy, gatunek_owcy, swiat, kolor_owcy, zasieg_owcy);
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
       return new Owca(x, y, swiat);
    }

}
