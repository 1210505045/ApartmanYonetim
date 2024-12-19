import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SikayetArama {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/apartman_yonetim";
        String username = "root";
        String password = "Bilmiyorum.12";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Şikayet Arama Türü: \n1 - Başlığa Göre Arama \n2 - Duruma Göre Arama");
        int secim = scanner.nextInt();
        scanner.nextLine(); // Dummy read

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "";
            if (secim == 1) {
                System.out.print("Başlık Girin: ");
                String baslik = scanner.nextLine();
                query = "SELECT * FROM sikayetler_talepler WHERE baslik LIKE ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, "%" + baslik + "%");
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            System.out.println("Şikayet ID: " + rs.getInt("sikayet_id") +
                                    ", Başlık: " + rs.getString("baslik") +
                                    ", İçerik: " + rs.getString("icerik") +
                                    ", Tarih: " + rs.getDate("tarih"));
                        }
                    }
                }
            } else if (secim == 2) {
                System.out.print("Durum Girin (Yeni/Çözüldü): ");
                String durum = scanner.nextLine();
                query = "SELECT * FROM sikayetler_talepler WHERE durum = ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, durum);
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            System.out.println("Şikayet ID: " + rs.getInt("sikayet_id") +
                                    ", Başlık: " + rs.getString("baslik") +
                                    ", İçerik: " + rs.getString("icerik") +
                                    ", Tarih: " + rs.getDate("tarih") +
                                    ", Durum: " + rs.getString("durum"));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
