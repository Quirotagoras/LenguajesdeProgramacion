import javax.swing.*;

class ImageFrame extends JFrame {

int jornada;

    public ImageFrame(int jornada){
        this.jornada=jornada;

        setTitle("Jornada" + jornada);
        setSize(1284, 964);
        ImageComponent component = new ImageComponent(jornada);
        add(component);

    }

}