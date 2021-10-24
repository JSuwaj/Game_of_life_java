package projekt.organizmy.zwierzeta;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Czlowiek extends Zwierze{
    private static final Color kolor_czlowieka = new Color(189, 158, 139);
    private static final int sila_czlowieka = 5;
    private static final int inicjatywa_czlowieka = 4;
    private static final int zasieg_czlowieka = 1;
    private static final String gatunek_czlowieka = "czlowiek";
    private int czas_od_uzycia_umiejetnosci;
    private char kierunek;
    public Czlowiek(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_czlowieka, inicjatywa_czlowieka, gatunek_czlowieka, swiat, kolor_czlowieka, zasieg_czlowieka);
        setCzas_od_uzycia_umiejetnosci(11);
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
        return new Czlowiek(x, y, swiat);
    }

    public void setKierunek(char kierunek) {
        this.kierunek = kierunek;
    }

    public int getCzas_od_uzycia_umiejetnosci() {
        return czas_od_uzycia_umiejetnosci;
    }

    public void setCzas_od_uzycia_umiejetnosci(int czas_od_uzycia_umiejetnosci) {
        this.czas_od_uzycia_umiejetnosci = czas_od_uzycia_umiejetnosci;
    }
    public void Akcja()
    {
        //na podstawie czasu od uzycia umiejetnosci funkcja zmienia zasieg czlowieka
        if (czas_od_uzycia_umiejetnosci == 1 || czas_od_uzycia_umiejetnosci == 2 || czas_od_uzycia_umiejetnosci == 3)
            this.setzasieg_ruchu(2);
        if (czas_od_uzycia_umiejetnosci == 4 || czas_od_uzycia_umiejetnosci == 5)
        {
            Random rand = new Random();
            int temp = rand.nextInt(2);
            if(temp==1)
                this.setzasieg_ruchu(2);
		else
            this.setzasieg_ruchu(1);
        }
        if (czas_od_uzycia_umiejetnosci >= 6)
            this.setzasieg_ruchu(1);
        switch (this.kierunek)
        {
            case 'd':
                if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), this.getzasieg_ruchu(), 0))
                swiat.PoruszZwierza(this, this.getzasieg_ruchu(), 0);
                break;
            case 's':
                if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, this.getzasieg_ruchu()))
                swiat.PoruszZwierza(this, 0, this.getzasieg_ruchu());
                break;
            case 'a':
                if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1) * this.getzasieg_ruchu(), 0))
                swiat.PoruszZwierza(this, (-1) * this.getzasieg_ruchu(), 0);
                break;
            case 'w':
                if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1) * this.getzasieg_ruchu()))
                swiat.PoruszZwierza(this, 0, (-1) * this.getzasieg_ruchu());
                break;
            case 'e':
                this.UmiejetnoscSpecjalna();
                break;
        }
        setCzas_od_uzycia_umiejetnosci(czas_od_uzycia_umiejetnosci+1);
    }

    private void UmiejetnoscSpecjalna() {
        if(czas_od_uzycia_umiejetnosci>10)
            this.setCzas_od_uzycia_umiejetnosci(0);
    }
}
