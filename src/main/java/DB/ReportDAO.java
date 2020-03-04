package DB;

import models.UserModel;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAO {

    public static JSONArray getReportData() throws Exception {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            String query = "select * from products p\n" +
                    "join product_categories on p.id = product_categories.product_id\n" +
                    "join categories on categories.id = product_categories.category_id";
            connection = Database.getConnection();
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();

            JSONArray result = convertToJSON(rs);
            System.out.println(result);
            return result;

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            rs.close();
            connection.close();
        }

        return new JSONArray();
    }

    public static JSONArray convertToJSON(ResultSet resultSet)
            throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_columns = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_columns; i++) {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
            }
            jsonArray.put(obj);
        }
        return jsonArray;
    }
}
