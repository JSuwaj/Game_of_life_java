package projekt.organizmy.zwierzeta;

import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;
import projekt.swiat.Punkt;

import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierze{
    private static final Color kolor_antylopy = new Color(130, 89, 51);
    private static final int sila_antylopy = 4;
    private static final int inicjatywa_antylopy = 4;
    private static final int zasieg_antylopy = 2;
    private static final String gatunek_antylopy = "antylopa";
    public Antylopa(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_antylopy, inicjatywa_antylopy, gatunek_antylopy, swiat, kolor_antylopy, zasieg_antylopy);
    }
    @Override
    public boolean Unik(Organizm atakujacy)
    {
        Random rand = new Random();
        int liczba = rand.nextInt(2);
        if (liczba == 1)
        {
            Punkt punkt;
            punkt = swiat.ZnajdzWolneMiejsce(this.getPolozenie_x(), this.getPolozenie_y());
            if (punkt.getX() - 1 == this.getPolozenie_x() || punkt.getX() + 1 == this.getPolozenie_x() || punkt.getX() == this.getPolozenie_x())
            if (punkt.getY() - 1 == this.getPolozenie_y() || punkt.getY() + 1 == this.getPolozenie_y() || punkt.getY()  == this.getPolozenie_y())
            if (punkt.getX() >= 0 && punkt.getY() >= 0)
            {
                int temp_x = this.getPolozenie_x();
                int temp_y = this.getPolozenie_y();
                swiat.PoruszZwierza(this, punkt.getX()-this.getPolozenie_x(), punkt.getY() - this.getPolozenie_y());
                swiat.PoruszZwierza(atakujacy, temp_x-atakujacy.getPolozenie_x(), temp_y-atakujacy.getPolozenie_y());
                return true;
            }
        }
        return false;
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
        return new Antylopa(x, y, swiat);
    }
}
