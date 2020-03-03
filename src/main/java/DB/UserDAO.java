package DB;

import models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private static UserModel user;
    public static Boolean login(String username, String password) throws Exception {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            String query = "SELECT * FROM users WHERE username = ? and password = ?";
            connection = Database.getConnection();
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if(rs.next()){
                user = new UserModel();
                user.setName(rs.getString("name"));
                user.setId(rs.getInt("id"));
                return true;
            }

            return false;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            rs.close();
            connection.close();
        }
        return false;
    }

    public static UserModel getUser(){
        return user;
    }
}
