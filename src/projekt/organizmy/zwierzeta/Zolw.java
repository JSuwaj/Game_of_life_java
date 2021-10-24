package projekt.organizmy.zwierzeta;

import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Zolw extends Zwierze{
    private static final Color kolor_zolwia = new Color(53, 114, 33);
    private static final int sila_zolwia = 2;
    private static final int inicjatywa_zolwia = 1;
    private static final int zasieg_zolwia = 1;
    private static final String gatunek_zolwia = "zolw";
    public Zolw(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_zolwia, inicjatywa_zolwia, gatunek_zolwia, swiat, kolor_zolwia, zasieg_zolwia);
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
        return new Zolw(x, y, swiat);
    }
    @Override
    public boolean Unik(Organizm atakujacy) {
       if(atakujacy.getSila()<5)
           return true;
       else
           return false;

    }
    @Override
    public void Akcja()
    {
        Random rand = new Random();
        int czy_ruszy=rand.nextInt(4);
        if(czy_ruszy==0) {
            int kierunek = rand.nextInt(4);
            switch (kierunek % 4) {
                case 0:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), zasieg_zolwia, 0))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, zasieg_zolwia, 0);
                    break;
                case 1:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, zasieg_zolwia))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, 0, zasieg_zolwia);
                    break;
                case 2:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1) * zasieg_zolwia, 0))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, (-1) * zasieg_zolwia, 0);
                    break;
                case 3:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1) * zasieg_zolwia))
                        this.Akcja();
                    else
                        swiat.PoruszZwierza(this, 0, (-1) * zasieg_zolwia);
                    break;
            }
        }
    }
}
