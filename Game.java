import java.sql.*;

public class Game {

    int idGame;
    int idJornada;
    int idTeamFavorite;
    int idTeamUnderdog;
    double mean;
    double x;
    double sd;
    double probEvent;


    public Game(int idGame) {

        this.idGame = idGame;
        this.idJornada=getJornada(idGame);
        this.idTeamFavorite=getidTeamFavorite(idGame);
        this.idTeamUnderdog=getIdTeamUnderdog(idGame);
        this.mean=getMean(idGame);
        this.x=getX(idGame);
        this.sd=getSd(idGame);

        CumulativeProbability cp = new CumulativeProbability(mean,sd,x);
        this.probEvent=cp.getProb()*100;



    }

//SQL para obtener datos del juego


    public int getIdTeamUnderdog(int idGame){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");

            stmt = conn.createStatement();
            String sql = "Select * FROM Game WHERE idGame=" + idGame;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                id = rs.getInt(3);
            }


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return id;
    }
    public int getidTeamFavorite(int idGame){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");

            stmt = conn.createStatement();
            String sql = "Select * FROM Game WHERE idGame=" + idGame;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                id = rs.getInt(4);
            }


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return id;
    }
    public double getSd(int idGame){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        double sd = 0;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");

            stmt = conn.createStatement();
            String sql = "Select * FROM Game WHERE idGame=" + idGame;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                sd = rs.getDouble(7);
            }


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return sd;

    }
    public double getX(int idGame){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        double x = 0;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");

            stmt = conn.createStatement();
            String sql = "Select * FROM Game WHERE idGame=" + idGame;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                x = rs.getDouble(5);
            }


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return x;

    }
    public double getMean(int idGame){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        double mean = 0;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");

            stmt = conn.createStatement();
            String sql = "Select * FROM Game WHERE idGame=" + idGame;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mean = rs.getDouble(6);
            }


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return mean;

    }
    public String getName(int idTeam) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
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
    public int getJornada(int idGame){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        int id = 0;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");

            stmt = conn.createStatement();
            String sql = "Select * FROM Game g, Jornada j  WHERE g.idGame=" + idGame +" AND g.idJornada=j.idJornada";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                id = rs.getInt(2);
            }


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return id;

    }



}



