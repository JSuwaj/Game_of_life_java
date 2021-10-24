package projekt.organizmy.zwierzeta;

import java.util.Random;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;
import java.awt.*;
public class Zwierze extends Organizm{
    private int zasieg_ruchu;
    public Zwierze(int polozenie_x, int polozenie_y, int sila, int inicjatywa, String gatunek,Swiat swiat,Color kolor,int zasieg_ruchu) {
        super(polozenie_x, polozenie_y, sila, inicjatywa, gatunek,swiat,kolor);
        this.zasieg_ruchu=zasieg_ruchu;
    }
    public int getzasieg_ruchu() {
        return zasieg_ruchu;
    }

    public void setzasieg_ruchu(int zasieg_ruchu) {
        this.zasieg_ruchu = zasieg_ruchu;
    }
    @Override
    public void Akcja() {
        Random rand = new Random();
        int kierunek = rand.nextInt(4);
        switch (kierunek % 4)
        {
            case 0:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), zasieg_ruchu, 0))
                    this.Akcja();
                else
                    swiat.PoruszZwierza(this, zasieg_ruchu, 0);
                break;
            case 1:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, zasieg_ruchu))
                    this.Akcja();
                else
                    swiat.PoruszZwierza(this, 0,  zasieg_ruchu);
                break;
            case 2:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1)*zasieg_ruchu, 0))
                    this.Akcja();
                else
                    swiat.PoruszZwierza(this, (-1)*zasieg_ruchu, 0);
                break;
            case 3:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1)*zasieg_ruchu))
                    this.Akcja();
		        else
                    swiat.PoruszZwierza(this, 0 , (-1) * zasieg_ruchu);
                break;
        }
    }
    @Override
    public void Kolizja(Organizm inny_organizm) {
        if (inny_organizm.getGatunek().equals(this.getGatunek()))
        {
            Rozmnazanie(inny_organizm.getPolozenie_x(), inny_organizm.getPolozenie_y());
        }
        else
        {
            if (this.getSila() <= inny_organizm.getSila())
            {
                int temp_x = this.getPolozenie_x();
                int temp_y = this.getPolozenie_y();
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

    }

    @Override
    public boolean Unik(Organizm atakujacy) {
        return false;
    }

    @Override
    public  Organizm KopiujOrganizm(int x, int y)
    {
        return null;
    }
    public void Rozmnazanie(int x, int y)
    {
        Organizm nowy_zwierzak;
        nowy_zwierzak=this.KopiujOrganizm(x, y);
        swiat.DodajUrodzonyOrganizm(nowy_zwierzak, x, y);
    }
}
