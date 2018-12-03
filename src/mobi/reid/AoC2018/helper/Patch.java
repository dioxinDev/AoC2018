package mobi.reid.AoC2018.helper;

public class Patch {

    public int xOffSet;
    public int yOffSet;
    public int xSpan;
    public int ySpan;

    public Patch(int xo, int yo, int xf, int yf) {
        this.xOffSet = xo;
        this.yOffSet = yo;
        this.xSpan = xf;
        this.ySpan = yf;
    }


}
