package DB;

import models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

public class UserDAO {
    private static UserModel user;

    private static HashMap<String, UserModel> users = new HashMap<String, UserModel>();

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
                String token = UUID.randomUUID().toString();

                user.setToken(token);

                users.put(token, user);
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

    public static void logout(String token){
        users.remove(token);
    }

    public static Boolean checkUserLogin(String token){
        return users.containsKey(token);
    }

    public static UserModel getUser(){
        return user;
    }
}
