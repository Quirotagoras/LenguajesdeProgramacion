import com.sun.tools.javah.Gen;

import java.io.File;

public class CreateTeams implements Runnable {
    int begin;
    int end;

    Team team[] = new Team[33];


    public CreateTeams(int begin, int end){
        this.begin=begin;
        this.end=end;

    }

    public File[] fillFiles(){
        File files[] = new File[33];
        files[1]  = new File("falcons.png");
        files[2]  = new File("redskins.png");
        files[3]  = new File("cowboys.png");
        files[4]  = new File("eagles.png");
        files[5]  = new File("giants.png");
        files[6]  = new File("ravens.png");
        files[7]  = new File("bengals.png");
        files[8]  = new File("browns.png");
        files[9]  = new File("steelers.png");
        files[10]  = new File("bills.png");
        files[11]  = new File("dolphins.png");
        files[12]  = new File("patriots.png");
        files[13]  = new File("jets.png");
        files[14]  = new File("texans.png");
        files[15]  = new File("colts.png");
        files[16]  = new File("jaguars.png");
        files[17]  = new File("titans.png");
        files[18]  = new File("broncos.png");
        files[19]  = new File("kansas.png");
        files[20]  = new File("chargers.png");
        files[21]  = new File("raiders.png");
        files[22]  = new File("bears.png");
        files[23]  = new File("lions.png");
        files[24]  = new File("packers.png");
        files[25]  = new File("vikings.png");
        files[26]  = new File("panthers.png");
        files[27]  = new File("saints.png");
        files[28]  = new File("buchaneers.png");
        files[29]  = new File("cardinals.png");
        files[30]  = new File("rams.png");
        files[31]  = new File("seahawks.png");
        files[32]  = new File("49ers.png");

        return files;
    }

    public void GenerateTeams(){

        for (int i = begin; i <= end; i++) {//crear los 32 equipos
            String name[] = new String[33];
            String city[] = new String[33];
            File files[]= fillFiles();
            team[i] = new Team(i, name[i], city[i],files[i]);
            String nombre = team[i].getName(i);
            String ciudad = team[i].getCity(i);
            System.out.println("IdTeam: " + i + " Team : " + nombre + " Ciudad: " + ciudad+"File "+ files[i]);

        }

    }

    @Override
    public void run() {
        GenerateTeams();

    }
}

