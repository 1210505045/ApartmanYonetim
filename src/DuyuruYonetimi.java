import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DuyuruYonetimi implements Subject {

    private Connection connection;
    private List<Observer> observers;

    public DuyuruYonetimi() {
        this.connection = VeritabaniBaglantisi.getInstance().getConnection();
        this.observers = new ArrayList<>();
    }

    // Observer Metodları
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String mesaj) {
        for (Observer observer : observers) {
            observer.update(mesaj);
        }
    }

    // Duyuru Ekle
    public void duyuruEkle(String baslik, String icerik) {
        String query = "INSERT INTO Duyurular (baslik, icerik) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, baslik);
            stmt.setString(2, icerik);
            stmt.executeUpdate();
            System.out.println("Duyuru başarıyla eklendi.");
            // Gözlemcilere bildirim gönder
            notifyObservers("Yeni Duyuru: " + baslik + " - " + icerik);
        } catch (SQLException e) {
            System.out.println("Duyuru eklenirken hata: " + e.getMessage());
        }
    }

    // Duyuruları Listele
    public void duyurulariListele() {
        String query = "SELECT * FROM Duyurular";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Duyuru ID: " + rs.getInt("duyuru_id") +
                        ", Başlık: " + rs.getString("baslik") +
                        ", İçerik: " + rs.getString("icerik") +
                        ", Yayım Tarihi: " + rs.getTimestamp("yayim_tarihi"));
            }
        } catch (SQLException e) {
            System.out.println("Duyurular listelenirken hata: " + e.getMessage());
        }
    }

    // Duyuru Güncelle
    public void duyuruGuncelle(int duyuruId, String yeniBaslik, String yeniIcerik) {
        String query = "UPDATE Duyurular SET baslik = ?, icerik = ? WHERE duyuru_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, yeniBaslik);
            stmt.setString(2, yeniIcerik);
            stmt.setInt(3, duyuruId);
            stmt.executeUpdate();
            System.out.println("Duyuru başarıyla güncellendi.");
        } catch (SQLException e) {
            System.out.println("Duyuru güncellenirken hata: " + e.getMessage());
        }
    }

    // Duyuru Sil
    public void duyuruSil(int duyuruId) {
        String query = "DELETE FROM Duyurular WHERE duyuru_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, duyuruId);
            stmt.executeUpdate();
            System.out.println("Duyuru başarıyla silindi.");
        } catch (SQLException e) {
            System.out.println("Duyuru silinirken hata: " + e.getMessage());
        }
    }

    public static class LoginController {

        @FXML
        private TextField usernameField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private void handleLogin() {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if ("admin".equals(username) && "1234".equals(password)) {
                System.out.println("Giriş başarılı!");
                // Burada ana ekrana geçiş yapılabilir.
            } else {
                System.out.println("Hatalı kullanıcı adı veya şifre!");
            }
        }
    }
}
