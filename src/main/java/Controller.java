import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label identif;
    @FXML
    private Separator item1;
    @FXML
    private Label item3;
    @FXML
    private ImageView item2;
    @FXML
    private Label item4;
    @FXML
    private Label item5;
    @FXML
    private TextField login;
    @FXML
    private Slider slider;
    @FXML
    private PasswordField pass;
    @FXML
    private Button close;
    @FXML
    private Button loginButton;
    @FXML
    private Label version;
    @FXML
    void closeApp(MouseEvent event) {
        General.exit();
    }

    @FXML
    void checkFields(ActionEvent event) {
        String log = login.getText();
        String pas = pass.getText();
        if(!log.isEmpty()){
            if(!pas.isEmpty()){
                if(data.login(log, pas)){
                    System.out.println("Goood");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }catch (Exception e){
                        General.exit();
                    }

                }else {
                    System.out.println("BAAD");
                }
            }
        }
    }



    private Data data = null;
    @FXML
    void initialize() {

        data = new Data();
        if(data.isConnected()){
            General.setVersion(version);
            int value = (int)Math.round(Math.random()*100);
            identif.setText(identif.getText() + " " + value);
            slider.valueProperty().addListener(new ChangeListener<Number>() {

                @Override
                public void changed(
                        ObservableValue<? extends Number> observableValue,
                        Number oldValue,
                        Number newValue) {
                    if(newValue.intValue() > value-5 & newValue.intValue() < value+5){
                        loginButton.setDisable(false);
                    }else {
                        loginButton.setDisable(true);
                    }
                }
            });
        }else{
            System.exit(0);
        }
        //hideall();
    }

    private void hideall(){
        identif.setVisible(false);
        pass.setVisible(false);
        login.setVisible(false);
        loginButton.setVisible(false);
        version.setVisible(false);
        close.setVisible(false);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);
        item5.setVisible(false);
        slider.setVisible(false);
    }

}
