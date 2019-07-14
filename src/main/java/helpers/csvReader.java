package helpers;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class csvReader {

    public Map<String,String> getData(String csvFileName)
    {
        HashMap<String,String> data = new HashMap<String, String>();
     try
    {
        Class.forName("org.relique.jdbc.csv.CsvDriver");

        Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\sgupta58\\IdeaProjects\\testclient\\src\\test\\resources\\testData");

        // create a Statement object to execute the query with
        Statement stmt = conn.createStatement();

        String query = "Select * from " + csvFileName;
        ResultSet results = stmt.executeQuery(query);

        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next()) {
            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                data.put(columnName, results.getString(i));
            }
        }
        results.close();
        stmt.close();
    }
    catch(Exception e)
    {
        System.out.println("Exception occured" + e);
        e.printStackTrace();
    }
     System.out.println("dta is" + data);
     return data;
    }
}
