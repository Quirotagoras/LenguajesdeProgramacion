public class CreateObjectGames  implements Runnable{
    int idJornada;
    int idwinners[] = new int[15];
    Game games[] = new Game[15];





    public CreateObjectGames(int idJornada) {
        this.idJornada = idJornada;


    }


    public void getCreateObjectGames() {
        CreateGames cg = new CreateGames(1,15,idJornada);
        Thread t1 = new Thread(cg);
        t1.start();
        int ids[]=cg.getGamesJornada(idJornada);
        for (int i = 1 ;i < ids.length; i++) {
            games[i]= new Game(ids[i]);
            idwinners[i]=cg.checkWinner(games[i]);
        }

    }



    @Override
    public void run() {
        getCreateObjectGames();
    }
}
