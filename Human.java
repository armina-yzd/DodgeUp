import processing.core.PApplet;
public abstract class Human implements  Interface{

    private float x;
    public static  PApplet a=Main.processing;

    @Override
    public void ShowObject() {
        x=a.mouseX;
        a.ellipse(x, 510, 40, 40);
        a.fill(0);
        a.circle(x+8,510,9);
        a.circle(x-8,510,9);
        a.stroke(0,76,153);
        a.line(x,590,x,530);
        a.line(x,590,x+10,620);
        a.line(x,590,x-10,620);
        a.line(x,530,x-15,570);
        a.line(x,530,x+15,570);
    }

    public float getX() {
        return x;
    }
}
