package projekt.swiat;

public class Punkt {
    private int x;
    private int y;
    Punkt(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
