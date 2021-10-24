package projekt;
import projekt.swiat.Okno;
public class Komentator {
    Okno okno;
    public Komentator(Okno okno){this.okno=okno;}
    public void KomunikatZabil(String gatunek_zabijajacy, String gatunek_umierajacy)
    {
        okno.DodajKomentarz(gatunek_zabijajacy+" zabija "+gatunek_umierajacy+"<br/>");
    }
    public void KomunikatUrodzil(String gatunek)
    {
        okno.DodajKomentarz("powstal nowy "+gatunek+"<br/>");
    }
    public void KomunikatUnik(String gatunek)
    {
        okno.DodajKomentarz(gatunek+" wykonuje unik<br/>");
    }
    public void Komunikat(String komunikat)
    {
        okno.DodajKomentarz(komunikat+" <br/>");
    }
}
