import javafx.scene.control.Label;

public class General {
    private static General instance;

    public static void exit(){
        System.exit(0);
    }
    public static void setVersion(Label version){
        version.setText(version.getText()+Config.VERSION);
    }

    public static General getInstance(){
        if(instance == null){
            instance = new General();
        }
        return instance;
    }
}
