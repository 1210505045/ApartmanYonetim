import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SikayetYonetimi {

    private Connection connection;

    public SikayetYonetimi() {
        this.connection = VeritabaniBaglantisi.getInstance().getConnection();
    }

    // Şikayet/Talep Ekle
    public void sikayetEkle(int kullaniciId, String konu, String icerik) {
        String query = "INSERT INTO Sikayetler_Talepler (kullanici_id, konu, icerik) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, kullaniciId);
            stmt.setString(2, konu);
            stmt.setString(3, icerik);
            stmt.executeUpdate();
            System.out.println("Şikayet/Talep başarıyla eklendi.");
        } catch (SQLException e) {
            System.out.println("Şikayet eklenirken hata: " + e.getMessage());
        }
    }

    // Şikayet/Talep Listele
    public void sikayetleriListele() {
        String query = "SELECT * FROM Sikayetler_Talepler";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Şikayet ID: " + rs.getInt("sikayet_id") +
                        ", Kullanıcı ID: " + rs.getInt("kullanici_id") +
                        ", Konu: " + rs.getString("konu") +
                        ", İçerik: " + rs.getString("icerik") +
                        ", Durum: " + rs.getString("durum") +
                        ", Tarih: " + rs.getTimestamp("olusturma_tarihi"));
            }
        } catch (SQLException e) {
            System.out.println("Şikayetler listelenirken hata: " + e.getMessage());
        }
    }

    // Şikayet/Talep Durumu Güncelle
    public void sikayetDurumGuncelle(int sikayetId, String yeniDurum) {
        String query = "UPDATE Sikayetler_Talepler SET durum = ? WHERE sikayet_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, yeniDurum);
            stmt.setInt(2, sikayetId);
            stmt.executeUpdate();
            System.out.println("Şikayet durumu başarıyla güncellendi.");
        } catch (SQLException e) {
            System.out.println("Şikayet durumu güncellenirken hata: " + e.getMessage());
        }
    }
}
