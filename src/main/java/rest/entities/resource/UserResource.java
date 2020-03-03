package rest.entities.resource;

import rest.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserResource {
    public ArrayList<User> select() throws Exception {
        ArrayList<User> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            String query = "SELECT * FROM USERS";
            System.out.println("UserDAO.select\n" + query);
            connection = DataSource.getConnection();
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(loadDataFromResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            rs.close();
            connection.close();
        }
        return list;
    }

    private User loadDataFromResultSet(ResultSet rs) throws Exception {
        User user = new User(rs.getInt("ID"));
        user.setName(rs.getString("NAME"));
        user.setUsername(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));
        return user;
    }
}