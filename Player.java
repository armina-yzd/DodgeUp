import processing.core.PApplet;

public class Player {
    private int playerid;
    private boolean state;
    private int count;

    public Player(int playerid,boolean state,int count){
        this.playerid=playerid;
        this.state=state;
        this.count=count;

    }

    public int getCount() {
        return count;
    }

    public int getPlayerid() {
        return playerid;
    }

    public boolean isState() {
        return state;
    }
}
