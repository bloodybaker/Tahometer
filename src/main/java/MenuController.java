import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    private Label version;

    @FXML
    private Button hideButton;

    @FXML
    void closeApp(MouseEvent event) {
        General.exit();
    }

    @FXML
    void hideToTray(ActionEvent event) {

    }

    @FXML
    void initialize() {
        General.setVersion(version);
    }
}
