import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeritabaniBaglantisi {
    private static VeritabaniBaglantisi instance;
    private Connection connection;
    private final String url = "jdbc:mysql://127.0.0.1:3306/apartman_yonetim";
    private final String username = "root";
    private final String password = "Bilmiyorum.12"; // Burada kendi şifrenizi girin.

    private VeritabaniBaglantisi() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Veritabanına başarıyla bağlandı.");
        } catch (SQLException ex) {
            System.out.println("Veritabanı bağlantısı başarısız: " + ex.getMessage());
        }
    }

    public static VeritabaniBaglantisi getInstance() {
        if (instance == null) {
            instance = new VeritabaniBaglantisi();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
