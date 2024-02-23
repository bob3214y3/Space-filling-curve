import processing.core.PApplet;
import processing.core.PFont;

public class SierpinskiTri extends PApplet {
    final int length =700;
    int max = 2;
    public void settings() {
        size(800, 800);
    }
    public void setup() {
        noStroke();
        noLoop();
    }
    float counter =0;
    public void draw(){
        counter =0;
        background(0);
        divide((float)width/2-(float)length/2,(float)width/2+length*(sqrt(3)/4),length,1,max);
        fill(255);
        text("level: " +max ,0,40);
    }
    @Override
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP && max < 8) {
                max ++;
                redraw();
            } else if (keyCode == DOWN && max > 1) {
                max --;
                redraw();
            }
        }
    }

    // this thing work, don't touch it :)))
    //create a loop of creating a triangle
    public void divide(float x, float y , float length,int level , int max){
        if(level >= max ){
            tri(x,y,length);
        }else{ // create smaller triangle
            divide(x,y,length/2,level+1,max);// at the left vertex
            divide(x+length/4,y-length*(sqrt(3)/4),length/2,level+1,max);// at the right vertex
            divide(x+length/2,y,length/2,level+1,max);//start at the top vertex
        }
    }

    public void tri(float x, float y, float length){
        map(counter,0,pow(3,max),0,360);
        fill(counter,255,255);
        triangle(x,y,x+length,y,x+length/2, (y-length*(float)(Math.sqrt(3)/2)));
        counter+= 0.1F;
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SierpinskiTri" };
        PApplet.main(appletArgs);
    }
}