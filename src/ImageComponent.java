import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;



public class ImageComponent extends JComponent {

    private static final long serialVersionUID = 1L;
    private Image background;
    int jornada;
    Image logosfavorite[] = new Image[15];
    Image logosunderdog[] = new Image[15];
    String meanStr[] = new String[15];

    int winners[] = new int[15];
    int[] favorite = new int[15];
    int[] underdog = new int[15];
    String[] probability=new String [15];


    public ImageComponent(int idjornada) {//obtener objetos con el file de cada equipo para convertirlo a imagen;
        this.jornada = idjornada;
        obtainFiles(jornada);

    }


    public void obtainFiles(int jornada) {
        Game arraygames[];


        double[] meanInt = new double[15];
        double[] probDouble = new double[15];
        Team teams[];

        CreateTeams createTeams1 = new CreateTeams(1, 32);
        Thread t1 = new Thread(createTeams1);
        CreateObjectGames co = new CreateObjectGames(jornada);//entra 3 veces
        Thread t2 = new Thread(co);
        t1.start();
        t2.start();
        teams = createTeams1.team;//aqui es donde se crean, no en thread
        File filesFavorite[] = new File[15];
        File filesUnderdog[] = new File[15];
        try{
            t2.join();
        }catch (InterruptedException e){

        }


        arraygames = co.games;
        this.winners = co.idwinners;


        for (int i = 1; i < arraygames.length; i++) {
            this.favorite[i] = arraygames[i].idTeamFavorite;
            this.underdog[i] = arraygames[i].idTeamUnderdog;
            probDouble[i]=arraygames[i].probEvent;
            this.probability[i]=Double.toString(probDouble[i]);


            meanInt[i] = arraygames[i].mean * -1;
            this.meanStr[i] = Double.toString(meanInt[i]);


            for (int j = 1; j < teams.length; j++) {
                if (favorite[i] == teams[j].idTeam) {
                    filesFavorite[i] = teams[j].logo;

                    try {
                        logosfavorite[i] = ImageIO.read(filesFavorite[i]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                if (underdog[i] == teams[j].idTeam) {
                    filesUnderdog[i] = teams[j].logo;
                    try {
                        logosunderdog[i] = ImageIO.read(filesUnderdog[i]);
                    } catch (IOException e) {
                        System.out.println("Could not find files, because there is no existing game");
                    }


                }


            }


        }




        try {

            File image2 = new File("template.png");
            background = ImageIO.read(image2);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, 1284, 950, this);
        int xa = 650;
        int ya = 10;
        int xb = 200;
        int yb = 10;
        int xc = 790;
        int yc = 30;
        g.setColor(Color.WHITE);
        g.drawString("Probability that Favorite event occurs",840,10);

        for (int i = 1; i < logosfavorite.length; i++) {

            g.drawImage(logosfavorite[i], xa, ya, 58, 39, this);

            ya += 68;

        }
        for (int i = 1; i < logosunderdog.length; i++) {

            g.drawImage(logosunderdog[i], xb, yb, 58, 39, this);

            yb += 68;

        }



        for (int i = 1; i < meanStr.length; i++) {

            g.drawString(meanStr[i], xc, yc);
            yc += 69;

        }


        int ys = 36;

        for (int i = 1; i < winners.length; i++) {
            for (int j = 1; j < favorite.length; j++) {

                if (winners[i] == favorite[j]) {
                    g.drawString("X", 540, ys);

                    ys += 68;

                }else if (winners[i]==underdog[j]){
                    g.drawString("X", 403, ys);

                    ys += 68;
                }

            }


        }

        int yo=30;
        for (int i = 1; i < probability.length; i++) {
            g.drawString("%"+probability[i],840,yo);
            yo+=69;

            }


        }

    }
