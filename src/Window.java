import javax.swing.*;

public class Window implements Runnable{


    public static void Window(){
        ImageIcon image = new ImageIcon("week10.png");
        JLabel label = new JLabel("Hello World", JLabel.CENTER);
        label.setAlignmentX(0);
        label.setAlignmentY(0);

        JFrame window = new JFrame("Frame");
        window.setVisible(true);
        window.setSize(500,500);
        window.add(label);

    }



    @Override
    public void run() {
        Window();
    }
}
