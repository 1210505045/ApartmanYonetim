import java.sql.*;
import java.util.Scanner;

public class KullaniciArama {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/apartman_yonetim";
        String username = "root";
        String password = "Bilmiyorum.12";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Arama Türü Seçin: \n1 - İsimle Arama \n2 - Daire No ile Arama");
        int secim = scanner.nextInt();
        scanner.nextLine(); // Dummy read

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "";
            if (secim == 1) {
                System.out.print("Aranacak İsmi Girin: ");
                String arananIsim = scanner.nextLine();
                query = "SELECT * FROM kullanıcılar WHERE ad LIKE ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, "%" + arananIsim + "%");
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("kullanici_id") +
                                    ", Ad: " + rs.getString("ad") +
                                    ", Soyad: " + rs.getString("soyad") +
                                    ", Daire No: " + rs.getString("daire_no"));
                        }
                    }
                }
            } else if (secim == 2) {
                System.out.print("Daire No'yu Girin: ");
                String daireNo = scanner.nextLine();
                query = "SELECT * FROM kullanıcılar WHERE daire_no = ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, daireNo);
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("kullanici_id") +
                                    ", Ad: " + rs.getString("ad") +
                                    ", Soyad: " + rs.getString("soyad") +
                                    ", Daire No: " + rs.getString("daire_no"));
                        }
                    }
                }
            } else {
                System.out.println("Geçersiz seçim!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
