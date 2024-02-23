package com.mycompany.project;

import processing.core.PApplet;

public class Main {
               

    
    public static void main(String[] args) {
        
        PApplet sketch = new fillCurve1();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs,sketch);   
        
    }
}
