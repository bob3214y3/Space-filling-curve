import processing.core.PApplet;
import processing.core.PVector;

public class ZCurve extends PApplet{
    int level =1;
    int N = (int)pow(2,level);
    //    int total =  14;
    int total =  4 * (int)pow(4,level-1);

    PVector[] path = new PVector[ 4 * (int)pow(4,9)];


    public void settings(){
        int size = 512;
        size(size,size);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Tri(i);
            float len = ((float)width /N) ; // fix later - value now: 128
            path[i].mult(len);
           path[i].add(len/2,len/2);
        }
    }

    float counter = 0 ;
    float speed = 0.5F;
    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(2);
        for (int j = 1; j < counter; j++) {
            float hue = map (j, 0 , total,0,360);
            stroke(hue,255,255);
            line(path[j].x,path[j].y,path[j-1].x,path[j-1].y);
        } // this is drawing part :V
        strokeWeight(4);
        counter+= speed; // this is for change the speed of the animation - the higher the more speed
        if (counter >= total){
            counter = 0;
        }
        String shown_speed = String.format("%.2f",(speed));
        text("Speed:" + shown_speed,0,60);
        text("Level: "+ level,0,40);

    } // dont touch it until you done the algo :))))))))
    /*
     * recalculate all the value of the line
     * */
    public void reInitialize(){
        counter =0; // restart the counter


        N = (int)pow(2,level);
        total =  N*N;
        for (int i = 0; i < total; i++) {
            path[i] = Tri(i);
            float len = (width /(float)N) ;
            path[i].mult(len);
            path[i].add(len/2,len/2);
        }
    }
    public void keyPressed(){
        if (key == CODED){

            if (keyCode == UP){
                if(level <= 9){
                    level++;
                    reInitialize();
                }
            }
            if (keyCode == DOWN){
                if (level >1){
                    level --;
                    reInitialize();
                }
            }
            if (keyCode == LEFT){
                speed = (float) (speed * 0.9);
            }
            if (keyCode == RIGHT){
                speed = (float) (speed * 1.1);
            }

        }
    }// this one run when a keyboard is pressed

    /* in here we consider all the plane is just a grid
     * for example
     *   in the 1st level is 2*2
     *   in the 2nd level is 4*4
     * `...
     * Input: index of the node
     * */
    public PVector Tri(int i){
        PVector[] point = {
                new PVector(0,0),
                new PVector(1,0),
                new PVector(0,1),
                new PVector(1,1)
        };
        int index = i &3;
        PVector v = point[index];

        for (int j = 1; j < level; j++) {
            int len = (int)pow(2,j);
            i = i >>>2;
            index = i & 3;
            if (index == 0 ){

            }
            else if (index == 1){
                v.x += len;
            }
            else if (index == 2){
                v.y += len;

            }
            else {
                v.x +=len;
                v.y +=len;

            }
        }
        return v;
    }

    public static void main(String[] args) {
        String[] name = new String[] {"ZCurve"};
        PApplet.main(name);
    }
}
