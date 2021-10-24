package projekt.organizmy.zwierzeta;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Lis extends Zwierze{
    private static final Color kolor_lisa = new Color(255, 106, 0);
    private static final int sila_lisa = 3;
    private static final int inicjatywa_lisa = 7;
    private static final int zasieg_lisa = 1;
    private static final String gatunek_lisa = "lis";
    public Lis(int polozenie_x, int polozenie_y, Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_lisa, inicjatywa_lisa, gatunek_lisa, swiat, kolor_lisa, zasieg_lisa);
    }
    @Override
    public void Akcja()
    {
        Random rand = new Random();
        int kierunek = rand.nextInt(4);
        switch (kierunek % 4)
        {
            case 0:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), zasieg_lisa, 0))
                    this.Akcja();
			    else
                    if (swiat.CoTuStoi(this.getPolozenie_x() + zasieg_lisa, this.getPolozenie_y())!=null)
                    {
                        if (swiat.CoTuStoi(this.getPolozenie_x() + zasieg_lisa, this.getPolozenie_y()).getSila() > this.getSila())
                        {
                            if (this.SprawdzMiejscaDookola())
                            this.Akcja();
                        }
                            else
                        swiat.PoruszZwierza(this, zasieg_lisa, 0);
                    }
				else
                    swiat.PoruszZwierza(this, zasieg_lisa, 0);
                break;
            case 1:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, zasieg_lisa))
                    this.Akcja();
                else
                    if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + zasieg_lisa)!=null)
                    {
                        if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + zasieg_lisa).getSila() > this.getSila())
                        {
                            if (this.SprawdzMiejscaDookola())
                            this.Akcja();
                        }
                            else
                        swiat.PoruszZwierza(this, 0, zasieg_lisa);
                    }
                    else
                        swiat.PoruszZwierza(this, 0, zasieg_lisa);
                break;
            case 2:

                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1) * zasieg_lisa, 0))
                    this.Akcja();
                else
                    if (swiat.CoTuStoi(this.getPolozenie_x() + (-1) * zasieg_lisa, this.getPolozenie_y())!=null)
                    {
                        if (swiat.CoTuStoi(this.getPolozenie_x() + (-1) * zasieg_lisa, this.getPolozenie_y()).getSila() > this.getSila())
                        {
                            if (this.SprawdzMiejscaDookola())
                            this.Akcja();
                        }
                            else
                        swiat.PoruszZwierza(this, (-1) * zasieg_lisa, 0);
                    }
                    else
                        swiat.PoruszZwierza(this, (-1) * zasieg_lisa, 0);
				break;
            case 3:
                if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1) * zasieg_lisa))
                    this.Akcja();
                else
                    if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + (-1) * zasieg_lisa)!=null)
                    {
                        if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + (-1) * zasieg_lisa).getSila() > this.getSila())
                        {
                            if (this.SprawdzMiejscaDookola())
                            this.Akcja();
                        }
                            else
                        swiat.PoruszZwierza(this, 0, (-1) * zasieg_lisa);
                    }
                    else
                        swiat.PoruszZwierza(this, 0, (-1) * zasieg_lisa);
                    break;
                }
    }
    private boolean SprawdzMiejscaDookola()
    {
        //funkcja sprawdza czy jest miejsce dookola lisa ktore istnieje i na ktorym mie stoi organizm od niego silniejszy
        //jest ona po to aby funkcja akcja nie wchodzila w nieskonczona petle
        if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), zasieg_lisa, 0))
        {
            if (swiat.CoTuStoi(this.getPolozenie_x() + zasieg_lisa, this.getPolozenie_y()) == null)
            return true;
		else
            if (swiat.CoTuStoi(this.getPolozenie_x() + zasieg_lisa, this.getPolozenie_y()).getSila()<this.getSila())
            return true;
        }
        if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, zasieg_lisa))
        {
            if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + zasieg_lisa) == null)
            return true;
		else
            if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + zasieg_lisa).getSila() < this.getSila())
            return true;
        }
        if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1) * zasieg_lisa, 0))
        {
            if (swiat.CoTuStoi(this.getPolozenie_x() + (-1) * zasieg_lisa, this.getPolozenie_y()) == null)
            return true;
		else
            if (swiat.CoTuStoi(this.getPolozenie_x() + (-1) * zasieg_lisa, this.getPolozenie_y()).getSila() < this.getSila())
            return true;
        }
        if (swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1) * zasieg_lisa))
        {
            if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + (-1) * zasieg_lisa) == null)
            return true;
		else
            if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() + (-1) * zasieg_lisa).getSila() < this.getSila())
            return true;
        }
        return false;
    }
    @Override
    public Organizm KopiujOrganizm(int x,int y)
    {
        return new Lis(x, y, swiat);
    }
}
