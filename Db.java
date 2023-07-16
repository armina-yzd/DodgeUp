import java.sql.*;
import java.util.ArrayList;

public class Db {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sys";
    static final String USER = "root";
    static final String PASS = "a13811383";

    public static ArrayList<Player> GetPlayer() {
        ArrayList<Player> players = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from player");
            while (resultSet.next()) {
                int playerid = resultSet.getInt(1);
                int State = resultSet.getInt(2);
                boolean state = false;
                if (State == 1) {
                    state = true;
                }
                int count = resultSet.getInt(3);
                Player player = new Player(playerid, state, count);
                players.add(player);
            }
            int t1, t2;
            boolean t3;
            for (int i = 0; i < players.size(); i++) {
                for (int j = 1; j < players.size() - i; j++) {
                    if (players.get(j).getCount() > players.get(j - 1).getCount()) {
                        t1 = players.get(j).getCount();
                        t2 = players.get(j).getPlayerid();
                        t3 = players.get(j).isState();
                        players.get(j).setCount(players.get(j - 1).getCount());
                        players.get(j).setPlayerid(players.get(j - 1).getPlayerid());
                        players.get(j).setState(players.get(j - 1).isState());
                        players.get(j - 1).setCount(t1);
                        players.get(j - 1).setPlayerid(t2);
                        players.get(j - 1).setState(t3);

                    }

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public static void AddPlayer(int Playerid, int State, int Count) {

        try {
           String sql = "insert into player (playerid, state, count)"
                    + "values('" + Playerid + "','" + State + "','" + Count + "')";
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void UpdatePlayer(int count, int num) {
        try {
            String sql = "update player set count='" + count + "' where (playerid = '" + num + "')";
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
