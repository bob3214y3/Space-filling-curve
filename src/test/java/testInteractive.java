import processing.core.*;

public class testInteractive extends PApplet {

    int fillVal = 100;


    public void draw() {
        fill(fillVal);
        rect(25, 25, 50, 50);
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP) {
                fillVal = fillVal+5 ;
            } else if (keyCode == DOWN) {
                fillVal = 0;
            }
        } else {
            fillVal = 126;
        }
    }

    public static void main(String[] args) {
        String[] Appletargs = new String[] {"testInteractive"};
        PApplet.main(Appletargs);
    }
}
