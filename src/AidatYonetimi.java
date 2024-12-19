import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AidatYonetimi {

    private Connection connection;

    public AidatYonetimi() {
        this.connection = VeritabaniBaglantisi.getInstance().getConnection();
    }

    // Aidat Ekle
    public void aidatEkle(int kullaniciId, double tutar, String odemeTarihi, String durum) {
        String query = "INSERT INTO Aidatlar (kullanici_id, tutar, odeme_tarihi, durum) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, kullaniciId);
            stmt.setDouble(2, tutar);
            stmt.setString(3, odemeTarihi);
            stmt.setString(4, durum);
            stmt.executeUpdate();
            System.out.println("Aidat başarıyla eklendi.");
        } catch (SQLException e) {
            System.out.println("Aidat eklenirken hata: " + e.getMessage());
        }
    }

    // Aidatları Listele
    public void aidatlariListele() {
        String query = "SELECT * FROM Aidatlar";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Aidat ID: " + rs.getInt("aidat_id") +
                        ", Kullanıcı ID: " + rs.getInt("kullanici_id") +
                        ", Tutar: " + rs.getDouble("tutar") +
                        ", Tarih: " + rs.getDate("odeme_tarihi") +
                        ", Durum: " + rs.getString("durum"));
            }
        } catch (SQLException e) {
            System.out.println("Aidatları listelerken hata: " + e.getMessage());
        }
    }
}
