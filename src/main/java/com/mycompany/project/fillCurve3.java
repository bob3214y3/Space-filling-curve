package com.mycompany.project;

import processing.core.PApplet;
import java.util.Stack;

public class fillCurve3 extends PApplet {

    float x, y;
    float angle;
    int depth = 4;
    int totalSteps;
    int currentStep;
    
    int frameRate = 200; // set the initial frame rate

    public void settings() {
        size(600, 600);
        smooth();
        
        
    }

    public void setup() {
        //noStroke();
        //colorMode(HSB,360,255,255);
        background(0);
        angle = radians(60);
        x = width - 150;
        y = height + 150;
        translate(x - 300, y - 300);
        String curveString = applyRules("A", depth);
        totalSteps = curveString.length();
        currentStep = 0;
        frameRate(frameRate); // set the frame rate
    }

    public void draw() {
       
        if (currentStep < totalSteps) {
            //stroke(255);
            //strokeWeight(2);
            String curveString = applyRules("A", depth);
            drawString(curveString.charAt(currentStep));
            currentStep++;
        } else {
            
            currentStep = 0;
            background(0);
            translate(x - 300, y - 300); // reset the origin to the center of the frame
            x = width - 150;
            y = height + 150;
        }
    }

    public void keyPressed() {
        if (key == '+') {
            frameRate(frameRate += 10); // increase the frame rate when the "+" key is pressed
        }
        if (key == '-') {
            frameRate(frameRate -= 10); // decrease the frame rate when the "-" key is pressed
        }
    }

    public String applyRules(String s, int depth) {
        if (depth == 0) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                result += "A-B--B+A++AA+B-";
            } else if (c == 'B') {
                result += "+A-BB--B-A++A+B";
            } else {
                result += c;
            }
        }
        return applyRules(result, depth - 1);
    }

    public void drawString(char c) {
        Stack<Turtle> stack = new Stack<Turtle>();
          stroke(179, 217, 255);
          strokeWeight(2);
          
        float len = pow(3, depth - 2);
        if (c == 'A' || c == 'B') {
            line(x - width / 2, y - height / 2, x - width / 2 + len * cos(angle), y - height / 2 + len * sin(angle));
            x += len * cos(angle);
            y += len * sin(angle);
        } else if (c == '+') {
            angle += radians(60);
        } else if (c == '-') {
            angle -= radians(60);
        } else if (c == '|') {
            angle += radians(180);
        } else if (c == '[') {
            stack.push(new Turtle(x, y, angle));
        } else if (c == ']') {
            Turtle previous = stack.pop();
            x = previous.x;
            y = previous.y;
            angle = previous.angle;
        }
    }

    class Turtle {

        float x, y;
        float angle;

        Turtle(float x, float y, float angle) {
            this.x = x;
            this.y = y;
            this.angle = angle;
        }
    }
}

/*import processing.core.PApplet;
import processing.core.PVector;

public class fillCurve3 extends PApplet{
    int level =6;
    int N = (int)pow(2,level);
    //    int total =  14;
    int total =  4 * (int)pow(4,level-1);

    PVector[] path = new PVector[total];


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
            float len = (width /N) ; // fix later - value now: 128
            path[i].mult(len);
           path[i].add(len/2,len/2);
        }
    }

    float counter = 0 ;
    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(2);
//        beginShape();
        for (int j = 1; j < counter; j++) {
            float hue = map (j, 0 , path.length,0,360);
            stroke(hue,255,255);
            line(path[j].x,path[j].y,path[j-1].x,path[j-1].y);
        } // this is drawing part :V
        strokeWeight(4);
//        for (int j = 1; j < counter; j++) {
//            point(path[j].x,path[j].y);
////            text((int)path[j-1].x, (float) (path[j-1].x), (float) (path[j-1].y));
////            text((int)path[j-1].y, (float) (path[j-1].x+10), (float) (path[j-1].y+10));
////            text((int)j-1, (float) (path[j-1].x), (float) (path[j-1].y));
//        }
//        endShape();
        counter+= 1; // this is for change the speed of the animation - the higher the more speed
        if (counter >= path.length){
            counter = 0;
        }
        text("Level: "+ level,0,40);

    } // dont touch it until you done the algo :))))))))


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
            else if (index == 3){
                v.x +=len;
                v.y +=len;

            }
        }
        return v;
    }
/*
    public static void main(String[] args) {
        String[] name = new String[] {"fillCurve3"};
        PApplet.main(name);
    } */
