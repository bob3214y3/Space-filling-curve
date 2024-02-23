/*
 * Hilbert Curve Animation V1
 * Author: 1. Phi Dinh Van Toan
 *         2. Nguyen Khac Hoang
 *         3. Duy :v Quen ten r
 * Day created: 16.12.2022
 * Last update: 20.01.2023
 * Description: Create Hilbert Curve(space filling) using iteration method
 *
 * Function: press
 *   1. "ArrowUp" to increase the level of Iteration
 *   2. "ArrowDown" to decrease the level of Iteration
 *   3. "ArrowRight" to increase the level of Iteration
 *   4. "ArrowLeft" to decrease the speed of the animation
 * */

import processing.core.PApplet;
import processing.core.PVector;

;

public class TriangleCurve extends PApplet{
    int level =1 ;
    int N = (int)pow(2,level);
    int total =  3 * (int)pow(4,level-1);
    PVector[] path = new PVector[3 * (int)pow(4,10)];


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
            float len = 2*(width /N) ; // fix later - value now: 128
            path[i].mult(len);
            path[i].add(0,0);
        }
    }

    float counter = 0; // this one is to change the position(stage :V)(iteration) of the animation
    float speed = 0.5F; // this one is to change the speed of the animation
    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(2);
        for (int j = 1; j <  counter; j++) {
            /*
             * Set the color of the image
             * the j change from 0 to 360 directly proportional to 0-> path.lenth
             * or (j/(path.length))*361-1
             * */
            float hue = map (j, 0 , total,0,360);
            stroke(hue,255,255); // set the color for the line
            line(path[j].x,path[j].y,path[j-1].x,path[j-1].y); // draw
        }
        counter+= speed; // using this one to increase speed of the animation
        if (counter >= total){
            counter = 0;
        } // reset the counter (animation) when the picture is finish
        String shown_speed = String.format("%.2f",(speed));
        text("Speed:" + shown_speed,0,60);
        text("Level: "+ level,0,40);

    }
    /*
     * recalculate all the value of the curve
     */
    public void reInitialize(){
        counter =0;
        N = (int)pow(2,level);
        total =  3 * (int)pow(4,level-1);
        for (int i = 0; i < total; i++) {
            path[i] = Tri(i);
            float len = 2*((float)width /N) ;
            path[i].mult(len);
            path[i].add(0,0);
    }
    }

    public void keyPressed(){
        if (key == CODED){

            if (keyCode == UP){
                if(level <= 8){
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
                new PVector(0.5F,0.5F),
                new PVector(1,0)
        };
        int newIndexMod = i %3;
        i = i /3;
        PVector v = point[newIndexMod];

        for (int j = 1; j < level; j++) {
            int len = (int)pow(2,j-1); // now = 1,2

            int newIndexDiv = i & 3;
            if (newIndexDiv == 0) {
                float temp = v.x;
                v.x = v.y;
                v.y = temp;
            }
            else if (newIndexDiv ==1) {
                v.y += len;
            }

            else if (newIndexDiv ==2 ) {
                v.x +=len;
                v.y +=len;
            }
            else {
                float temp = len - v.x; // len now = 1 , 2
                v.x = 2* len-v.y  ;
                v.y = temp;

            }
            i = i >>>2;
        }
        return v;
    }

    public static void main(String[] args) {
        String[] name = new String[] {"TriangleCurve"};
        PApplet.main(name);
    }
}
