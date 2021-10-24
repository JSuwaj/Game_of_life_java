package projekt.organizmy.rosliny;
import java.util.Random;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;
import java.awt.*;
public class Roslina extends Organizm{
    private static final double prawdopodobienstwo_rozpylenia=0.1;
    private static final int inicjatywa_rosliny=0;
    public Roslina(int polozenie_x, int polozenie_y, int sila, String gatunek, Swiat swiat, Color kolor) {
        super(polozenie_x, polozenie_y, sila, inicjatywa_rosliny, gatunek, swiat, kolor);
    }

    @Override
    public void Akcja() {
        RozprzestrzenSie();
    }

    @Override
    public void Kolizja(Organizm inny_organizm) {
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

    @Override
    public boolean Unik(Organizm atakujacy) {
        return false;
    }

    @Override
    public Organizm KopiujOrganizm(int x, int y) {
        return null;
    }
    public void RozprzestrzenSie()
    {
        //funkcja rozprzestrzenia rosline z pewnym prawdopodobienstwem po sprawdzeniu czy nie stoi na wylosowanym polu inny organizm
        Random rand = new Random();
        int liczba = rand.nextInt(100);
        if (liczba % 100 < 100 * prawdopodobienstwo_rozpylenia)
        {
            int kierunek =rand.nextInt(4);
            switch (kierunek % 4)
            {
                case 0:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 1, 0))
                    this.RozprzestrzenSie();
			else
                    if(swiat.CoTuStoi(this.getPolozenie_x()+1, this.getPolozenie_y())==null)
                {
                    Organizm nowa_roslina;
                    nowa_roslina = this.KopiujOrganizm(this.getPolozenie_x() + 1, this.getPolozenie_y());
                    swiat.DodajUrodzonyOrganizm(nowa_roslina, this.getPolozenie_x() + 1, this.getPolozenie_y());
                }
                break;
                case 1:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, 1))
                    this.RozprzestrzenSie();
			else
                    if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y()+1) == null)
                {
                    Organizm nowa_roslina;
                    nowa_roslina = this.KopiujOrganizm(this.getPolozenie_x(), this.getPolozenie_y() + 1);
                    swiat.DodajUrodzonyOrganizm(nowa_roslina, this.getPolozenie_x(), this.getPolozenie_y() + 1);
                }
                break;
                case 2:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), (-1), 0))
                    this.RozprzestrzenSie();
			else
                    if (swiat.CoTuStoi(this.getPolozenie_x() - 1, this.getPolozenie_y()) == null)
                {
                    Organizm nowa_roslina;
                    nowa_roslina = this.KopiujOrganizm(this.getPolozenie_x() - 1, this.getPolozenie_y());
                    swiat.DodajUrodzonyOrganizm(nowa_roslina, this.getPolozenie_x() - 1, this.getPolozenie_y());
                }
                break;
                case 3:
                    if (!swiat.CzyMiejsceIstnieje(this.getPolozenie_x(), this.getPolozenie_y(), 0, (-1)))
                    this.RozprzestrzenSie();
			else
                    if (swiat.CoTuStoi(this.getPolozenie_x(), this.getPolozenie_y() - 1) == null)
                {
                    Organizm nowa_roslina;
                    nowa_roslina = this.KopiujOrganizm(this.getPolozenie_x(), this.getPolozenie_y() - 1);
                    swiat.DodajUrodzonyOrganizm(nowa_roslina, this.getPolozenie_x(), this.getPolozenie_y() - 1);
                }
                break;
            }
        }

    }
}
