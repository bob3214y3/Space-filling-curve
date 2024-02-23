package com.mycompany.project;

/*
* Hilbert Curve Animation V1
* Author: 1. Phi Dinh Van Toan
*         2. Nguyen Khac Hoang
*         3. Nguyen Truong Duy
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

import javafx.stage.WindowEvent;
import processing.core.PApplet;
import processing.core.PVector;

import static com.mycompany.project.App.stage;
public class HilbertCurve extends PApplet{
    int level =2; // number of Iteration
    int N = (int) pow(2,level); // size of the background (for drawing)
    int total = N*N; // total line of drawing
    PVector[] path = new PVector[(int)(pow(2,12)*pow(2,10))];

    public void settings(){
        size(512,512); // set the size of the image
        smooth();
    }
    public void setup(){
        noStroke();
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Hilbert(i);
            float len = width/(float)N ;
            path[i].mult(len);
            path[i].add(len/2,len/2);
        }
        surface.setTitle("Hilbert Curve!"); // name of the window
//        surface.setLocation(100, 100);
        surface.setAlwaysOnTop(true);
//        surface.getNative();
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
        counter =0; // restart the counter


        N = (int)pow(2,level);
        total =  N*N;
        for (int i = 0; i < total; i++) {
            path[i] = Hilbert(i);
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
        if (key == ENTER){
            this.getSurface().pauseThread();
            this.getSurface().setVisible(false);
        }
    }
    
    
    // this one run when a keyboard is pressed

    /* in here we consider all the plane is just a grid
     * for example
     *   in the 1st level is 2*2
     *   in the 2nd level is 4*4
     * `...
     * Input: index of the node
     * */
    
    
    public PVector Hilbert (int i){

        PVector[] point = {
                new PVector(0,0),
                new PVector(0,1),
                new PVector(1,1),
                new PVector(1,0)
        };
        int index = i &3; // get the quadrant
        PVector v = point[index];

        for (int j = 1; j < level; j++) {
            int len = (int)pow(2,j);
            i = i >>>2;
            index = i & 3;
            if (index == 0 ){ // roltate left
                float temp = v.x;
                v.x = v.y;
                v.y = temp;
            }
            else if (index == 1){
                v.y += len;
            }
            else if (index == 2){
                v.x +=len;
                v.y +=len;
            }
            else{ // roltate right
                float temp = len - 1 - v.x; // len now =
                v.x = 2* len-1-v.y  ;
                v.y = temp;
            }
        }
        return v;
    }

  /*  public static void main(String[] args) {
        String[] name = new String[] {"HilbertCurve"};
        PApplet.main(name);
    } */
}
