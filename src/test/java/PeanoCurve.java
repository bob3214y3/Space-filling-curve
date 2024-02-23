import processing.core.PApplet;
import processing.core.PVector;

public class PeanoCurve extends PApplet {
    int level =3;
    int N = (int) pow(3,level);
    int total = N*N;
    PVector[] path = new PVector[total];
    public void settings(){
        size(512,512);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Peano(i);
            float len = width/N ;
            path[i].mult(len);
            path[i].add(len/2,len/2);
        }
    }
    float counter = 0;
    public void draw(){
        background(0);
        stroke(255);
        noFill();
            beginShape();
        for (int i = 0; i < counter; i++) {
            vertex(path[i].x,path[i].y);
        }
         endShape();

        for (int i = 0; i < counter; i++) {
            text(i,path[i].x,path[i].y);
        }
//        for (int j = 1; j < counter; j++) {
////            float hue = map (j, 0 , path.length,0,360);
////            stroke(hue,255,255);
//            line(path[j].x,path[j].y,path[j-1].x,path[j-1].y);
//        }
        counter = (float) (counter + 0.1);
        if (counter >= path.length){
            counter =0;
        }
    }
    public PVector Peano(int i) {
        PVector[] point = {
                new PVector(0, 0),
                new PVector(0, 1),
                new PVector(0, 2),
                new PVector(1, 2),
                new PVector(1, 1),
                new PVector(1, 0),
                new PVector(2, 0),
                new PVector(2, 1),
                new PVector(2,2)
        };
        int mod = i%9;

        PVector v = point[mod];
        for (int j = 1; j < level; j++) {
        /*    switch (mod){
                case 0:
                    break;
                case 1:
                    v.x = 2 - v.x;
                    v.y += nona * 3;
                    break;
                case 2:
                    v.y += nona *3;
                    break;
                case 3:
                    v.x = 2 - v.x + nona *3;
                    break;
                case 4:
                    v.x += nona*3;
                    break;
                case 5:
                    v.x

            }*/
            int nona = (int) (i/(pow(3,j+1)));
            if(nona/3 ==1){
                if(nona %2 ==1){
                    v.y = pow(3,j+1) - v.y-1- (nona%3)*3;

                }
                else{
                    v.y = pow(3,j+1)-1- v.y - (nona%3)*3 ;
                    v.x = 2 - v.x;
                }
            }
            else {
                if(nona %2 ==1){
                v.x = 2 - v.x;}
                    v.y += (nona%3) * (3);
            }

            v.x += (nona/3) *3;
        }
        return v;
    }
    public static void main(String[] args){
        String[] name = new String[] {"PeanoCurve"};
        PApplet.main(name);
    }
}
