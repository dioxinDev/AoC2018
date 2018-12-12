package mobi.reid.AoC2018.helper;

public class ChronalNode {

    int x;
    int y;
    public int areaCovered;
    boolean infiniteBounds;
    public String name;

    public ChronalNode(String name, int x, int y){
        this.x = x;
        this.y = y;
        this.name = name;

    }

    public int getDistance(int x, int y) {
        return Math.abs(this.x-x)+Math.abs(this.y-y);
    }

    public void incrementArea() {
        areaCovered++;
    }
}
