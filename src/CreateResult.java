import javax.swing.JFrame;


public class CreateResult implements Runnable {
    int jornada;



    public CreateResult(int jornada){
        this.jornada=jornada;




    }

    public void run(){
        ImageFrame frame = new ImageFrame(jornada);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}





