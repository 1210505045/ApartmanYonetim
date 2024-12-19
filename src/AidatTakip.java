import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AidatTakip {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/apartman_yonetim";
        String username = "root";
        String password = "Bilmiyorum.12";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM aidatlar WHERE durum = 'Ödenmedi'";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                System.out.println("Ödenmeyen Aidatlar:");
                while (rs.next()) {
                    System.out.println("Aidat ID: " + rs.getInt("aidat_id") +
                            ", Kullanıcı ID: " + rs.getInt("kullanici_id") +
                            ", Tutar: " + rs.getDouble("tutar") +
                            ", Tarih: " + rs.getDate("tarih") +
                            ", Durum: " + rs.getString("durum"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
