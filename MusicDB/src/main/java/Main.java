import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/TimBuchalka/MusicDB/src/main/resources/database/music.db");
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM artists ORDER BY name");
            while (results.next()) {
                System.out.printf("%s%n", results.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
