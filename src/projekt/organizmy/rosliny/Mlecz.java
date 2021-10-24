package projekt.organizmy.rosliny;
import projekt.organizmy.Organizm;
import projekt.swiat.Swiat;

import java.awt.*;
public class Mlecz extends Roslina{
    private static final Color kolor_mlecza = new Color(247, 255, 0);
    private static final int sila_mlecza = 0;
    private static final String gatunek_mlecza = "mlecz";
    public Mlecz(int polozenie_x, int polozenie_y,  Swiat swiat) {
        super(polozenie_x, polozenie_y, sila_mlecza,  gatunek_mlecza, swiat, kolor_mlecza);
    }
    @Override
    public void Akcja()
    {
        RozprzestrzenSie();
        RozprzestrzenSie();
        RozprzestrzenSie();
    }
    @Override
    public Organizm KopiujOrganizm(int x, int y)
    {
        return new Mlecz(x, y, swiat);
    }
}
