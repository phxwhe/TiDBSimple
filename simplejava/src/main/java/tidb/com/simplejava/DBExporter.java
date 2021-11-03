package tidb.com.simplejava;

import java.io.*;
import java.sql.*;

public class DBExporter {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://tidb.dec11076.e93d9e16.us-west-2.prod.aws.tidbcloud.com:4000/bikeshare";
        String username = "root";
        String password = "pingcap1";

        String csvFilePath = "bikedata-export.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM trips";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            // write header line containing column names
            fileWriter.write("id, rideable_type,lastname,username,shirtsize");

            while (result.next()) {
                //String id= Integer.toString(result.getInt("id"));
                Integer id= result.getInt("id");
                String rideable_type= result.getString("rideable_type");
                String member_casual= result.getString("member_casual");

                String line = String.format("%d,%s,%s",
                        id, rideable_type,member_casual);

                fileWriter.newLine();
                fileWriter.write(line);
            }

            statement.close();
            fileWriter.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }

    }
}
