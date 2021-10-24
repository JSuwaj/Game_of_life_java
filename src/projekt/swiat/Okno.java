package projekt.swiat;
import javax.swing.*;
import java.awt.event.*;
import projekt.Komentator;
public class Okno extends JFrame implements KeyListener, MouseListener {

    private Plansza plansza;
    private int x, y;
    private Swiat swiat;
    Komentator komentator;
    String komentarz;
    JLabel komentarze;
    JButton zapisz;
    JButton wczytaj;
    JButton start;
    JButton kolejna_tura;
    public Okno(int x, int y, Swiat world) {
        this.x = x;
        this.y = y;
        this.swiat = world;
        this.komentarz="<html>komentarze</html>";
        komentator=new Komentator(this);
        addKeyListener(this);
        addMouseListener(this);
        plansza = new Plansza(swiat,x,y);
        komentarze=new JLabel(komentarz);
        ZrobGuziki();
        add(plansza);
        swiat.setKomentator(this.komentator);
        setSize(plansza.getWidth() + 240, plansza.getHeight() + 80);
        setTitle("Jakub Suwaj 179927");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        requestFocus();
    }

    private void ZrobGuziki(){
        //funkcja ustawia guziki w menu gry
        zapisz=new JButton("Zapisz gre");
        zapisz.setBounds(plansza.getWidth()+50,200,140,30);
        zapisz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                swiat.ZapiszSwiat();
                komentarz+="</html>";
                komentarze.setText(komentarz);
                repaint();
                komentarz="<html>komentarze<br/>";
                requestFocus();
            }
        });
        wczytaj=new JButton("Wczytaj gre");
        wczytaj.setBounds(plansza.getWidth()+50,250,140,30);
        wczytaj.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                swiat.WczytajSwiat();
                komentarz+="</html>";
                komentarze.setText(komentarz);
                repaint();
                komentarz="<html>komentarze<br/>";
                requestFocus();
            }
        });
        start=new JButton("Nowa gra");
        start.setBounds(plansza.getWidth()+50,100,140,30);
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                plansza.setCzy_gra_zaczeta(true);
                swiat.InicjujSwiat();
                repaint();
                requestFocus();
            }
        });
        kolejna_tura=new JButton("Kolejna tura");
        kolejna_tura.setBounds(plansza.getWidth()+50,150,140,30);
        kolejna_tura.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                swiat.NacisnietyGuzik(null);
                komentarz+="</html>";
                komentarze.setText(komentarz);
                repaint();
                komentarz="<html>komentarze<br/>";
                requestFocus();
            }
        });
        komentarze.setBounds(plansza.getWidth()+50,300, 150,400);
        komentarze.setVerticalAlignment(SwingConstants.TOP);
        add(zapisz);
        add(wczytaj);
        add(start);
        add(kolejna_tura);
        add(komentarze);
    }
    public void DodajKomentarz(String tekst) {
    komentarz+=tekst;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        swiat.NacisnietyGuzik(e);
        komentarz+="</html>";
        komentarze.setText(komentarz);
        repaint();
        komentarz="<html>komentarze<br/>";
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
