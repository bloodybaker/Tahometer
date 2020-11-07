import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Data extends Config {
    private boolean connected;
    public boolean isConnected(){
        return connected;
    }
    private Connection connection = null;
    public Data(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(HOST, USER, PASS);
            connected = true;

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public boolean login(String login, String pass){
        try {
            PreparedStatement select = connection.prepareStatement("SELECT pass FROM " + TABLE_NAME_USERS + " WHERE login = ?");
            select.setString(1,login);
            ResultSet resultSet = select.executeQuery();
            String temp = "";
            while (resultSet.next()){
                temp = resultSet.getString(1);
            }
            if(temp.equals(pass)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
