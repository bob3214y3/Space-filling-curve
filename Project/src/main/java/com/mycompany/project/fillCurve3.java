package com.mycompany.project;

import processing.core.PApplet;
import java.util.Stack;

public class fillCurve3 extends PApplet {

    float x, y;
    float angle;
    int depth = 4;
    int total = (int) pow(4,depth);
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
        colorMode(HSB,360,255,255);

        surface.setTitle("Gosper Curve!"); // name of the window
//        surface.setLocation(100, 100);
        surface.setAlwaysOnTop(true);
    }
    float counter = 0;
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
       counter ++;
       if(counter >= totalSteps)counter =0;
    }

    public void keyPressed() {
        if (key == '+') {
            frameRate(frameRate += 10); // increase the frame rate when the "+" key is pressed
        }
        if (key == '-') {
            frameRate(frameRate -= 10); // decrease the frame rate when the "-" key is pressed
        }
       
        if (key == ENTER){
            this.getSurface().pauseThread();
            this.getSurface().setVisible(false);
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
          float hue = map (counter, 0 , totalSteps,0,360);
          stroke(hue,255,255);
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
