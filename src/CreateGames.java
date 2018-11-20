import java.sql.*;

public class CreateGames implements Runnable {
    int begin;
    int end;
    int jornada;


    public CreateGames(int begin, int end, int jornada) {
        this.begin = begin;
        this.end = end;
        this.jornada = jornada;
        // getCreatedGames();

    }

    public int checkWinner(Game game) {
        int winner;
        System.out.println("//////////////////////////////////////////////////////////////////");
        System.out.println("Juego: #" + game.idGame + " de la jornada : #" + game.idJornada + " ------- " + game.getName(game.idTeamUnderdog) + " vs " + game.getName(game.idTeamFavorite));
        System.out.println("Equipo: " + game.getName(game.idTeamFavorite) + " tiene " + game.mean + " puntos en contra y es el favorito");
        System.out.println("Resultado:La probabilidad de que suceda dicho evento es de: %" + game.probEvent);
        if (game.probEvent > 50) {
            System.out.println("Conclusion:I think you should go with " + game.getName(game.idTeamFavorite) + " because i think the difference of " + game.mean + " is going to be fullfilled");
            winner = game.idTeamFavorite;
        } else if (game.probEvent < 50) {
            System.out.println("Conclusion:I think you should go with " + game.getName(game.idTeamUnderdog) + " because i dont think the difference of " + game.mean + " is going to be fullfilled");
            winner = game.idTeamUnderdog;
        } else {
            System.out.println("I would go with the favorite team :" + game.getName(game.idTeamFavorite) + " because there is a 50/50 chance. Better to go safe");
            winner = game.idTeamFavorite;
        }
        System.out.println("//////////////////////////////////////////////////////////////////");
        System.out.println(" ");


        return winner;

    }


    public int[] getGamesJornada(int idJornada) {
        int i = 1;
        int id[] = new int[15];
        // System.out.println(idJornada);

        Connection conn = null;
        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/NFL", "root", "");


            String query = "SELECT * FROM Game g WHERE g.idJornada=" + idJornada;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id[i] = rs.getInt(1);
                i++;

            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;

    }


    @Override
    public void run() {
        Game games[] = new Game[15];
        int id[];
        id = getGamesJornada(jornada);
        if (id[1] == 0) {
            System.out.println("No info found about that week");
        } else
            for (int i = begin; i < end; i++) {//i cambia valores a id
                System.out.println(id[i]);
                games[i] = new Game(id[i]);
                games[i] = new Game(i);



            }


    }
}


