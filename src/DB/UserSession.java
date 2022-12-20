package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author JoeAlpha
 */

public class UserSession {
    public static boolean isLogin(String email, String password, JFrame frame){
        try {
            Connection conn = DBConnection.setConnection();
            String mySqlQuery = "SELECT * FROM tbl_users WHERE email=? AND password =? ";
            PreparedStatement preparedStatement = conn.prepareStatement(mySqlQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                UserCredentials.status    = resultSet.getString("status");
                UserCredentials.firstname = resultSet.getString("firstname");
                UserCredentials.lastname  = resultSet.getString("lastname");
                UserCredentials.phone     = resultSet.getString("phone");
                UserCredentials.gender    = resultSet.getString("gender");
                UserCredentials.email     = resultSet.getString("email");
                
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
