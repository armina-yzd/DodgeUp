public class Player {
    private int playerid;
    private boolean state;
    private int count;

    public Player(int playerid, boolean state, int count) {
        this.playerid = playerid;
        this.state = state;
        this.count = count;

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

    public void setState(boolean state) {
        this.state = state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }
}
