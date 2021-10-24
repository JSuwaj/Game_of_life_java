package projekt.swiat;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;

import projekt.organizmy.Organizm;
import projekt.organizmy.zwierzeta.Owca;
import projekt.organizmy.zwierzeta.Wilk;
import projekt.organizmy.zwierzeta.Zolw;
import projekt.organizmy.zwierzeta.Antylopa;
import projekt.organizmy.zwierzeta.Lis;
import projekt.organizmy.zwierzeta.CyberOwca;
import projekt.organizmy.zwierzeta.Czlowiek;
import projekt.organizmy.rosliny.Trawa;
import projekt.organizmy.rosliny.Mlecz;
import projekt.organizmy.rosliny.WilczeJagody;
import projekt.organizmy.rosliny.Guarana;
import projekt.organizmy.rosliny.BarszczSosnowskiego;
import projekt.Komentator;



import java.awt.*;


public class Swiat {
    private LinkedList<Organizm> v_organizmy = new LinkedList<>();
    private LinkedList<Organizm> nowe_organizmy = new LinkedList<>();
    private Czlowiek czlowiek;
    private String[][] mapa;
    private Komentator komentator;
    private int wysokosc;
    private int szerokosc;
    private final int ilosc_startowa_owiec=4;
    private final int ilosc_startowa_wilkow=4;
    private final int ilosc_startowa_zolwi=4;
    private final int ilosc_startowa_antylop=4;
    private final int ilosc_startowa_lisow=4;
    private final int ilosc_startowa_trawy=3;
    private final int ilosc_startowa_mlecza=2;
    private final int ilosc_startowa_jagod=3;
    private final int ilosc_startowa_guarany=3;
    private final int ilosc_startowa_barszczu=3;
    private final int ilosc_startowa_cyberowiec=2;
    public Swiat(int wysokosc,int szerokosc)
    {
        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;

        mapa=new String[wysokosc][szerokosc];
        InicjujSwiat();
    }
    public void setWysokosc(int wysokosc)
    {
        this.wysokosc=wysokosc;
    }
    public void setSzerokosc(int szerokosc)
    {
        this.szerokosc=szerokosc;
    }
    public void InicjujSwiat()
    {
        //funkcja ustawia na mapie organizmy
        v_organizmy.clear();
        for(int i=0;i<wysokosc;i++)
            for(int j=0;j<szerokosc;j++)
            {
                mapa[i][j]="nic";
            }
        czlowiek=new Czlowiek(wysokosc/2,szerokosc/2,this);
            mapa[czlowiek.getPolozenie_x()][czlowiek.getPolozenie_y()]="czlowiek";
        for(int i=0;i<ilosc_startowa_owiec;i++)
        {
            DodajPoczatkowyOrganizm("owca");
        }
        for(int i=0;i<ilosc_startowa_wilkow;i++)
        {
            DodajPoczatkowyOrganizm("wilk");
        }
        for(int i=0;i<ilosc_startowa_zolwi;i++)
        {
            DodajPoczatkowyOrganizm("zolw");
        }
        for(int i=0;i<ilosc_startowa_antylop;i++)
        {
            DodajPoczatkowyOrganizm("antylopa");
        }
        for(int i=0;i<ilosc_startowa_lisow;i++)
        {
            DodajPoczatkowyOrganizm("lis");
        }
        for(int i=0;i<ilosc_startowa_trawy;i++)
        {
            DodajPoczatkowyOrganizm("trawa");
        }
        for(int i=0;i<ilosc_startowa_mlecza;i++)
        {
            DodajPoczatkowyOrganizm("mlecz");
        }
        for(int i=0;i<ilosc_startowa_jagod;i++)
        {
            DodajPoczatkowyOrganizm("jagody");
        }
        for(int i=0;i<ilosc_startowa_guarany;i++)
        {
            DodajPoczatkowyOrganizm("guarana");
        }
        for(int i=0;i<ilosc_startowa_barszczu;i++)
        {
            DodajPoczatkowyOrganizm("barszcz");
        }
        for(int i=0;i<ilosc_startowa_cyberowiec;i++)
        {
            DodajPoczatkowyOrganizm("cyberowca");
        }
    }

    private void DodajPoczatkowyOrganizm(String gatunek)
    {
        //funkcja dodaje organizm podczas inicjacji swiata
        Organizm organizm=null;
        Random x = new Random();
        int org_x = x.nextInt(wysokosc);
        Random y = new Random();
        int org_y = y.nextInt(szerokosc);
        while(!mapa[org_x][org_y].equals("nic"))
        {
            org_x = x.nextInt(wysokosc);
            org_y = y.nextInt(szerokosc);
        }
        if(gatunek.equals("owca"))
        {
            organizm = new Owca(org_x,org_y,this);
        }
        if(gatunek.equals("wilk"))
        {
            organizm = new Wilk(org_x,org_y,this);
        }
        if(gatunek.equals("zolw"))
        {
            organizm = new Zolw(org_x,org_y,this);
        }
        if(gatunek.equals("antylopa"))
        {
            organizm = new Antylopa(org_x,org_y,this);
        }
        if(gatunek.equals("lis"))
        {
            organizm = new Lis(org_x,org_y,this);
        }
        if(gatunek.equals("trawa"))
        {
            organizm = new Trawa(org_x,org_y,this);
        }
        if(gatunek.equals("mlecz"))
        {
            organizm = new Mlecz(org_x,org_y,this);
        }
        if(gatunek.equals("jagody"))
        {
            organizm = new WilczeJagody(org_x,org_y,this);
        }
        if(gatunek.equals("guarana"))
        {
            organizm = new Guarana(org_x,org_y,this);
        }
        if(gatunek.equals("barszcz"))
        {
            organizm = new BarszczSosnowskiego(org_x,org_y,this);
        }
        if(gatunek.equals("cyberowca"))
        {
            organizm = new CyberOwca(org_x,org_y,this);
        }
        if (organizm != null) {
            mapa[org_x][org_y]=organizm.getGatunek();
            v_organizmy.add(organizm);
        }

    }

    public Punkt ZnajdzWolneMiejsce(int x,int y)
    {
        //funkcja szuka najblizszego wolnego miejsca na mapie a jezeli takiego nie ma zwraca punkt poza mapa
        int temp_x = x;
        int temp_y = y;
        int  kolo = 1;
        while (!mapa[temp_x][temp_y].equals("nic"))
        {
            for (int i = x-kolo; i < x+kolo;  i++)
            {
                for (int j =y-kolo; j < y + kolo; j++)
                {
                    if (i >= 0 && j >= 0 && i < wysokosc && j < szerokosc)
                    {
                        if (mapa[i][j].equals("nic"))
                        {
                            temp_x = i;
                            temp_y = j;
                            i= x + kolo;
                            j = y + kolo;
                        }
                    }
                }
            }
            kolo++;
            if (kolo >= wysokosc && kolo >= szerokosc)
            {
                temp_x = -1;
                temp_y = -1;
                break;
            }
        }
        return new Punkt(temp_x,temp_y);
    }
    public Punkt ZnajdzBarszcz(int x,int y)
    {
        //funkcja szuka najblizszego barszczu na mapie a jezeli takiego nie ma zwraca punkt poza mapa
        int temp_x = x;
        int temp_y = y;
        int gwiazda=1;
        while (gwiazda<wysokosc+szerokosc)
        {
            temp_x=x;
            temp_y=y-gwiazda;
            for(int i=0;i<=gwiazda;i++)
            {
                if (temp_x >= 0 && temp_y >= 0 && temp_x < wysokosc && temp_y < szerokosc)
                {
                    if (mapa[temp_x][temp_y].equals("barszcz"))
                    {
                        return new Punkt(temp_x,temp_y);
                    }
                }
                temp_x--;
                temp_y++;
            }
            temp_x=x;
            temp_y=y-gwiazda;
            for(int i=0;i<=gwiazda;i++)
            {
                if (temp_x >= 0 && temp_y >= 0 && temp_x < wysokosc && temp_y < szerokosc)
                {
                    if (mapa[temp_x][temp_y].equals("barszcz"))
                    {
                        return new Punkt(temp_x,temp_y);
                    }
                }
                temp_x++;
                temp_y++;
            }
            temp_x=x;
            temp_y=y+gwiazda;
            for(int i=0;i<=gwiazda;i++)
            {
                if (temp_x >= 0 && temp_y >= 0 && temp_x < wysokosc && temp_y < szerokosc)
                {
                    if (mapa[temp_x][temp_y].equals("barszcz"))
                    {
                        return new Punkt(temp_x,temp_y);
                    }
                }
                temp_x++;
                temp_y--;
            }
            temp_x=x;
            temp_y=y+gwiazda;
            for(int i=0;i<=gwiazda;i++)
            {
                if (temp_x >= 0 && temp_y >= 0 && temp_x < wysokosc && temp_y < szerokosc)
                {
                    if (mapa[temp_x][temp_y].equals("barszcz"))
                    {
                        return new Punkt(temp_x,temp_y);
                    }
                }
                temp_x--;
                temp_y--;
            }
            gwiazda++;
        }
        return new Punkt(-1,-1);
    }

    public void RysujSwiat(Graphics g,int wielkosc_kwadratu,int margines)
    {
        for(int i=0;i<wysokosc;i++)
            for(int j=0;j<szerokosc;j++)
            {
                if(!mapa[i][j].equals("nic"))
                {
                    this.CoTuStoi(i,j).RysujOrganizm(g,wielkosc_kwadratu,margines);
                }
                else
                {
                    g.setColor(Color.WHITE);
                    g.fillRect(margines + i * wielkosc_kwadratu+1,margines + j * wielkosc_kwadratu+1,wielkosc_kwadratu-1, wielkosc_kwadratu-1);
                }
            }
    }
    private void WykonajTure()
    {
        for(int i=7;i>=0;i--)
        {
            if(i==czlowiek.getInicjatywa() && czlowiek.getZywy())
                czlowiek.Akcja();
            for (Organizm organizm : v_organizmy) {
                {
                    if(organizm.getInicjatywa()==i && organizm.getZywy())
                        organizm.Akcja();
                }
            }

        }
        if(czlowiek.getZywy())
            czlowiek.DodajRok();
        for (Organizm organizm : v_organizmy) {
            organizm.DodajRok();
        }
        this.AktualizujOrganizmy();
        this.UsunUmarleOrganizmy();
    }
    public void NacisnietyGuzik(KeyEvent event) {
        //funkcja ustawia kierunek ruchu czlowieka w przypadku nacisniecia klawisza e uzywa jego umiejetnosci
        if(event!=null) {
            int key = event.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    czlowiek.setKierunek('w');
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    czlowiek.setKierunek('d');
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    czlowiek.setKierunek('s');
                    break;

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    czlowiek.setKierunek('a');
                    break;
                case KeyEvent.VK_E:
                    czlowiek.setKierunek('e');
                    break;
            }
        }
        else
            czlowiek.setKierunek('x');
        this.WykonajTure();
    }
    public void DodajUrodzonyOrganizm(Organizm nowy_organizm, int x, int y)
    {
        //funkcja dodaje organizmy do vectora nowo urodzonych organizmow
        Punkt punkt;
        punkt = this.ZnajdzWolneMiejsce(x, y);
        if(punkt.getX()!=-1 && punkt.getY()!=-1) {
            nowy_organizm.setPolozenie_x(punkt.getX());
            nowy_organizm.setPolozenie_y(punkt.getY());
            nowe_organizmy.add(nowy_organizm);
        }
    }
    private void UsunUmarleOrganizmy() {
        //funkcja na koniec tury usuwa obumarle organizmy
        for(int i = 0; i < v_organizmy.size(); ++i)
        {
            if(!v_organizmy.get(i).getZywy())
            {
                v_organizmy.remove(i);
                --i;
            }
        }
    }
    public void AktualizujOrganizmy()
    {
        //funkcja dodaje nowo urodzone organizmy do swiata gry
        //w przypadku gdy jeden nowo urodzony organizm zajal pole kolejnego ten kolejny nie zostaje dodany
        int i = 0;
        for (Organizm organizm : nowe_organizmy)
        {
            if (mapa[organizm.getPolozenie_x()][organizm.getPolozenie_y()].equals("nic"))
            {
                mapa[organizm.getPolozenie_x()][organizm.getPolozenie_y()] = organizm.getGatunek();
                v_organizmy.add(organizm);
                nowe_organizmy.set(i, null);
                komentator.KomunikatUrodzil(organizm.getGatunek());
            }
            i++;
        }
        nowe_organizmy.clear();
    }
    public void PoruszZwierza(Organizm chodzacy_organizm, int dx, int dy)
    {
        //funkcja wykonuje ruch zwierzecia i wywoluje metody takie jak kolizja czy unik
        int docelowe_x=chodzacy_organizm.getPolozenie_x()+dx;
        int docelowe_y=chodzacy_organizm.getPolozenie_y()+dy;
        if(!this.mapa[docelowe_x][docelowe_y].equals("nic"))
        {

            if(CoTuStoi(docelowe_x, docelowe_y).getZywy()) {
                if (CoTuStoi(docelowe_x, docelowe_y).getGatunek().equals(chodzacy_organizm.getGatunek()))
                {
                    CoTuStoi(docelowe_x, docelowe_y).Kolizja(chodzacy_organizm);
                }
                else
                {
                    String temp_gatunek=CoTuStoi(docelowe_x, docelowe_y).getGatunek();
                    if(!CoTuStoi(docelowe_x, docelowe_y).Unik(chodzacy_organizm))
                    {
                        CoTuStoi(docelowe_x, docelowe_y).Kolizja(chodzacy_organizm);
                        if (chodzacy_organizm.getPolozenie_x() == docelowe_x && chodzacy_organizm.getPolozenie_y() == docelowe_y) {
                            komentator.KomunikatZabil(chodzacy_organizm.getGatunek(),temp_gatunek);
                            mapa[docelowe_x][docelowe_y] = chodzacy_organizm.getGatunek();
                            mapa[docelowe_x - dx][docelowe_y - dy] = "nic";
                        }
                        else
                            komentator.KomunikatZabil(temp_gatunek,chodzacy_organizm.getGatunek());
                    }
                    else
                    {
                        komentator.KomunikatUnik(temp_gatunek);
                    }
                }
            }
        }
        else
        {
            mapa[chodzacy_organizm.getPolozenie_x()][chodzacy_organizm.getPolozenie_y()]="nic";
            chodzacy_organizm.setPolozenie_x(docelowe_x);
            chodzacy_organizm.setPolozenie_y(docelowe_y);
            mapa[docelowe_x][docelowe_y]=chodzacy_organizm.getGatunek();
        }
    }
    public void ZapiszSwiat() {
        String path = "saves.txt" ;
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.println(this.wysokosc);
            writer.println(this.szerokosc);
            writer.println(czlowiek.getCzas_od_uzycia_umiejetnosci());
            writer.println(czlowiek.getZywy());
            czlowiek.ZapiszOrganizm(writer);
            for (Organizm organizm : v_organizmy) {
                organizm.ZapiszOrganizm(writer);
            }
            komentator.Komunikat("Zapisanno swiat");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void WczytajSwiat()
    {
        String sciezka = "saves.txt";
        try {
            int temp,temp_sila,temp_x,temp_y,temp_ile_zyje;
            String temp_gatunek;
            File plik = new File(sciezka);
            Scanner reader = new Scanner(plik);
            String linia = reader.nextLine();
            temp = Integer.parseInt(linia);
            this.setWysokosc(temp);
            linia = reader.nextLine();
            temp = Integer.parseInt(linia);
            this.setSzerokosc(temp);
            linia = reader.nextLine();
            temp = Integer.parseInt(linia);
            czlowiek.setCzas_od_uzycia_umiejetnosci(temp);
            linia = reader.nextLine();
            if(linia.equals("true"))
                czlowiek.setZywy(true);
            else
                czlowiek.setZywy(false);
            linia = reader.nextLine();
            linia = reader.nextLine();
            temp_x = Integer.parseInt(linia);
            czlowiek.setPolozenie_x(temp_x);
            linia = reader.nextLine();
            temp_y = Integer.parseInt(linia);
            czlowiek.setPolozenie_y(temp_y);
            linia = reader.nextLine();
            temp_sila = Integer.parseInt(linia);
            czlowiek.setSila(temp_sila);
            linia = reader.nextLine();
            temp_ile_zyje = Integer.parseInt(linia);
            czlowiek.setIle_zyje(temp_ile_zyje);
            for(int i=0;i<wysokosc;i++)
                for(int j=0;j<szerokosc;j++)
                    mapa[i][j]="nic";
            mapa[czlowiek.getPolozenie_x()][czlowiek.getPolozenie_y()]=czlowiek.getGatunek();
            v_organizmy.clear();
            while (reader.hasNextLine()) {
                linia = reader.nextLine();
                temp_gatunek=linia;
                linia = reader.nextLine();
                temp_x = Integer.parseInt(linia);
                linia = reader.nextLine();
                temp_y = Integer.parseInt(linia);
                linia = reader.nextLine();
                temp_sila = Integer.parseInt(linia);
                linia = reader.nextLine();
                temp_ile_zyje = Integer.parseInt(linia);
                DodajWczytanyOrganizm(temp_gatunek,temp_x,temp_y,temp_sila,temp_ile_zyje);
            }
            komentator.Komunikat("Wczytano swiat");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private void DodajWczytanyOrganizm(String gatunek,int x,int y,int sila,int ile_zyje)
    {
        //funkcja dodaje wczytany z pliku organizm do swiata gry
        Organizm organizm=null;
        if(gatunek.equals("owca"))
        {
            organizm = new Owca(x,y,this);
        }
        if(gatunek.equals("wilk"))
        {
            organizm = new Wilk(x,y,this);
        }
        if(gatunek.equals("zolw"))
        {
            organizm = new Zolw(x,y,this);
        }
        if(gatunek.equals("antylopa"))
        {
            organizm = new Antylopa(x,y,this);
        }
        if(gatunek.equals("lis"))
        {
            organizm = new Lis(x,y,this);
        }
        if(gatunek.equals("trawa"))
        {
            organizm = new Trawa(x,y,this);
        }
        if(gatunek.equals("mlecz"))
        {
            organizm = new Mlecz(x,y,this);
        }
        if(gatunek.equals("jagody"))
        {
            organizm = new WilczeJagody(x,y,this);
        }
        if(gatunek.equals("guarana"))
        {
            organizm = new Guarana(x,y,this);
        }
        if(gatunek.equals("barszcz"))
        {
            organizm = new BarszczSosnowskiego(x,y,this);
        }
        if(gatunek.equals("cyberowca"))
        {
            organizm = new CyberOwca(x,y,this);
        }
        if (organizm != null) {
            organizm.setSila(sila);
            organizm.setIle_zyje(ile_zyje);
            mapa[x][y]=organizm.getGatunek();
            v_organizmy.add(organizm);
        }
    }
    public boolean CzyMiejsceIstnieje(int x, int y, int dx, int dy)
    {
        //funkcja sprawdza czy miejsce nie wykracza poza mape
        if (x + dx < wysokosc && y + dy < szerokosc && x + dx>=0 && y + dy>=0)
            return true;
        else
            return false;
    }
    public Organizm CoTuStoi(int x, int y)
    {
        //funkcja szuka organizmy stojacego na danym miejscu na mapie
        for (Organizm organizm : v_organizmy) {
            if(organizm.getPolozenie_x()==x && organizm.getPolozenie_y()==y)
                return organizm;
        }
        if(czlowiek.getPolozenie_x()==x && czlowiek.getPolozenie_y()==y)
            if(czlowiek.getZywy())
                return czlowiek;
        return null;
    }

    public void Usmierc(Organizm niezywy_organizm) {
        mapa[niezywy_organizm.getPolozenie_x()][niezywy_organizm.getPolozenie_y()] = "nic";
    }

    public void setKomentator(Komentator komentator) {
        this.komentator = komentator;
    }
}
