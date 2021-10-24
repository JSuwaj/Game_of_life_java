package projekt.organizmy;
import projekt.swiat.Swiat;
import java.awt.*;
import java.io.PrintWriter;
public abstract class Organizm {
    private int polozenie_x;
    private int polozenie_y;
    private int sila;
    private final int inicjatywa;
    private final String gatunek;
    private int ile_zyje;
    private boolean zywy;
    protected final Swiat swiat;
    private final Color kolor;
    public Organizm(int polozenie_x,int polozenie_y,int sila,int inicjatywa,String gatunek,Swiat swiat,Color kolor    )
    {
        this.polozenie_x=polozenie_x;
        this.polozenie_y=polozenie_y;
        this.sila=sila;
        this.inicjatywa=inicjatywa;
        this.gatunek=gatunek;
        this.zywy=true;
        this.ile_zyje=0;
        this.swiat=swiat;
        this.kolor=kolor;
    }
    public int getPolozenie_x()
    {
        return this.polozenie_x;
    }
    public int getPolozenie_y()
    {
        return this.polozenie_y;
    }
    public int getSila()
    {
        return this.sila;
    }
    public int getInicjatywa()
    {
        return this.inicjatywa;
    }
    public String getGatunek()
    {
        return this.gatunek;
    }
    public boolean getZywy()
    {
        return this.zywy;
    }
    public void setPolozenie_x(int x)
    {
        this.polozenie_x=x;
    }
    public void setPolozenie_y(int y)
    {
        this.polozenie_y=y;
    }
    public void setIle_zyje(int ile_zyje)
    {
        this.ile_zyje=ile_zyje;
    }
    public void setSila(int sila)
    {
        this.sila=sila;
    }
    public void DodajRok()
    {
        this.ile_zyje++;
    }
    public void setZywy(boolean zywy)
    {
        this.zywy=zywy;
    }
    public abstract void Akcja();
    public abstract void Kolizja(Organizm inny_organizm);
    public abstract boolean Unik(Organizm atakujacy);
    public abstract Organizm KopiujOrganizm(int x, int y);
    public void RysujOrganizm(Graphics g, int wielkosc_kwadratu, int margines) {
        if(!getZywy())
            return;
        int x = margines + polozenie_x * wielkosc_kwadratu;
        int y = margines + polozenie_y * wielkosc_kwadratu;
            g.setColor(kolor);
            g.fillRect(x+1,y+1,wielkosc_kwadratu-1, wielkosc_kwadratu-1);
    }
    public void ZapiszOrganizm(PrintWriter writer)
    {
        writer.println(this.gatunek);
        writer.println(this.polozenie_x);
        writer.println(this.polozenie_y);
        writer.println(this.sila);
        writer.println(ile_zyje);
    }
}
