package com.mycompany.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javafx.application.Application;
import static javafx.application.Application.launch;
import processing.core.PApplet;
import processing.javafx.*;

public class Main {

    
    public static void main(String[] args) {

       /* List<PApplet> sketches = new ArrayList<>();
        sketches.add(new fillCurve1());
        sketches.add(new fillCurve1zoom());
        
        PApplet sketch = sketches.get(0);
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch); */
        PApplet.main(fillCurve1.class);
    }
}
