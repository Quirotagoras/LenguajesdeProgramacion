import java.sql.*;
import java.io.File;


public class Team {
    int idTeam;
    String name;
    String city;
    File logo;


    public Team(int idTeam, String name, String city,File logo ) {
        this.idTeam = idTeam;
        this.name = name;
        this.city = city;
        this.logo=logo;
    }



    public String getCity(int idTeam) {
        //SQL//
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String name = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            // System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");
            //System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "Select * FROM Team WHERE idTeam=" + idTeam;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                name = rs.getString(3);
            }


            //System.out.println("Executed Query");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println(rs);
        return name;
    }

    public String getName(int idTeam) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String name = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");


            //STEP 3: Open a connection
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");
            //System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "Select * FROM Team WHERE idTeam=" + idTeam;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                name = rs.getString(2);
            }

            //System.out.println("Executed Query");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        // System.out.println(rs);
        return name;
    }


}
