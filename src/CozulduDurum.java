import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CozulduDurum implements SikayetDurumu {
    @Override
    public void durumGuncelle(Sikayet sikayet) {
        System.out.println("Şikayet durumu: Çözüldü");
    }

    public static class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Apartman Yönetimi");
            primaryStage.setScene(new Scene(root, 400, 300));
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}