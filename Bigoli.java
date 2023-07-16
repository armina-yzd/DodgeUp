import processing.core.PApplet;

import java.util.Random;

public abstract class Bigoli implements Interface {
    private float x;
    private float yPos;

    private boolean state;

    public Bigoli(float x, float ypos) {
        yPos = ypos;
        this.x = x;
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

    public boolean isState() {
        return state;
    }

    public float getyPos() {
        return yPos;
    }

    public static PApplet a = Main.processing;

    @Override
    public void ShowObject() {
        a.fill(new Random().nextInt(1, 250), new Random().nextInt(1, 250), new Random().nextInt(1, 250));
        a.noStroke();
        a.circle(x, yPos, 20);

    }

    public boolean check(float n) {
        if (yPos > 505 && yPos < 600) {
            if (x < n + 15 && x > n - 15) {
                return true;
            }
        }
        return false;

    }

}
