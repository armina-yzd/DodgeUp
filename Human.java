import processing.core.PApplet;

public abstract class Human implements Interface {

    private float x;
    public static PApplet a = Main.processing;

    @Override
    public void ShowObject() {
        x = a.mouseX;

        a.fill(4, 168, 186);
        a.noStroke();
        a.ellipse(x, 550, 40, 40);
        a.rect(x - 8, 560, 16, 35);

        a.fill(0, 130, 150);
        a.circle(x - 4, 620, 7);
        a.circle(x + 4, 620, 7);

        a.fill(0);
        a.circle(x + 8, 540, 9);
        a.circle(x - 8, 540, 9);

        a.stroke(4, 168, 186);

        a.line(x + 4, 590, x + 4, 620);
        a.line(x - 4, 590, x - 4, 620);
        a.line(x, 560, x - 15, 580);
        a.line(x, 560, x + 15, 580);

    }

    public float getX() {
        return x;
    }
}
