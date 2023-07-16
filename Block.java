import processing.core.PApplet;

public abstract class Block implements Interface {

    private float x;
    private float yPos;
    float yDir;
    private int c1, c2, c3;

    private boolean state;

    public Block(float x, float ypos, float ydir, int c1, int c2, int c3) {
        yPos = ypos;
        this.x = x;
        yDir = ydir;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        state = true;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void setx(float x) {
        this.x = x;
    }

    public void setcolor(int c1, int c2, int c3) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void setyDir(float yDir) {
        this.yDir = yDir;
    }

    public boolean isState() {
        return state;
    }

    public static PApplet a = Main.processing;

    @Override
    public void ShowObject() {
        a.fill(c1, c2, c3);
        a.noStroke();

        a.rect(x, yPos, 40, 50);

    }

    public boolean check(float n) {
        if (yPos > 490 && yPos < 500) {
            if (x < n + 20 && x > n - 55) {
                return true;
            }
        } else if (yPos > 500) {
            if (x < n + 8 && x > n - 8) {
                return true;
            }
        }
        return false;
    }
}
