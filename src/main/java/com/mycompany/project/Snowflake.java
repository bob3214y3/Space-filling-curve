package com.mycompany.project;

import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Snowflake extends PApplet {
    class Segment {
        PVector a;
        PVector b;

        Segment(PVector a_, PVector b_) {
            a = a_.copy();
            b = b_.copy();
        }

        Segment[] create() {
            Segment[] parts = new Segment[4];
            PVector another = PVector.sub(b, a);
            another.div(3);

            PVector a1 = PVector.add(a, another); // part 0
            parts[0] = new Segment(a, a1);
            PVector b1 = PVector.sub(b, another); // part 3
            parts[3] = new Segment(b1, b);
            another.rotate(-PI / 3);
            PVector c1 = PVector.add( a1,another);
            parts[1] = new Segment(a1, c1); // part 1
            parts[2] = new Segment(c1, b1); // part 2
            return parts;
        }

        public void show() {
            stroke(255);
            line(a.x, a.y, b.x, b.y); // create a line
        }
    }

    ArrayList<Segment> segments;

    public void addAll(Segment[] array, ArrayList<Segment> listofsegment) {
        for (Segment s : array) {
            listofsegment.add(s); // for each segment s in an array, add parts to the ArrayList
        }
    }

    public void settings() {
        size(700, 950);
    }

    public void setup() {
        segments = new ArrayList<>();
        PVector a = new PVector(100, 400);
        PVector b = new PVector(600, 400);

        float edge = PVector.dist(a,b);        // create vector c for an equi. rectangle
        float height = edge * (sqrt(3)/2);
        PVector c = new PVector(350,400+height);

        Segment segment1 = new Segment(a, b);
        Segment segment2 = new Segment(b, c);
        Segment segment3 = new Segment(c, a);
        segments.add(segment1);
        segments.add(segment2);
        segments.add(segment3);
        Segment beginning = new Segment(a,b);
        segments.add(beginning);
    }

    public void mousePressed() {
        ArrayList<Segment> nextLevel = new ArrayList<Segment>(); //create a new arraylist
        for(Segment s : segments) {
            Segment[] parts = s.create();
            addAll(parts, nextLevel);
        }
        segments = nextLevel;
    }

    public void draw() {
        background(0);
        stroke(255);
        for (Segment s : segments) {
            s.show();
        }
    }
    public static void main(String[] args) {
        String[] name = new String[] {"Snowflake"};
        PApplet.main(name);
}
    }
 
/*import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import processing.core.PApplet;
import static processing.core.PApplet.sqrt;
import static processing.core.PConstants.FX2D;
import static processing.core.PConstants.PI;
import processing.core.PFont;
import processing.core.PVector;
import processing.core.PSurface;
import processing.javafx.PSurfaceFX;

public class fillCurve1 extends PApplet {

   

    @Override
    protected PSurface initSurface() {
        g = createPrimaryGraphics();
        PSurface genericSurface = g.createSurface();
        PSurfaceFX fxSurface = (PSurfaceFX) genericSurface;

        fxSurface.sketch = this;

        App.surface = fxSurface;     
        PrimarySnowflakeController.surface = fxSurface;
        
        
            //new Thread(() -> Application.launch(App.class)).start();
     
        new Thread(new Runnable() {
        public void run() {
            Application.launch(App.class);
        }
    }).start();

    while (fxSurface.stage == null) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
    }

       /* while (fxSurface.stage == null) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
        } 
       
        this.surface = fxSurface;
        Canvas canvas = (Canvas) surface.getNative();
        
        return surface;
    
    } 
    class Segment {
        PVector a;
        PVector b;

        Segment(PVector a_, PVector b_) {
            a = a_.copy();
            b = b_.copy();
        }

        Segment[] create() {
            Segment[] parts = new Segment[4];
            PVector another = PVector.sub(b, a);
            another.div(3);

            PVector a1 = PVector.add(a, another); // part 0
            parts[0] = new Segment(a, a1);
            PVector b1 = PVector.sub(b, another); // part 3
            parts[3] = new Segment(b1, b);
            another.rotate(-PI / 3);
            PVector c1 = PVector.add( a1,another);
            parts[1] = new Segment(a1, c1); // part 1
            parts[2] = new Segment(c1, b1); // part 2
            return parts;
        }

        public void show() {
            stroke(255);
            line(a.x, a.y, b.x, b.y); // create a line
        }
    }

    ArrayList<Segment> segments;

    public void addAll(Segment[] array, ArrayList<Segment> listofsegment) {
        for (Segment s : array) {
            listofsegment.add(s); // for each segment s in an array, add parts to the ArrayList
        }
    }

    public void settings() {
        size(700, 950,FX2D);
    }

    public void setup() {
        PrimarySnowflakeController.p = this;
        segments = new ArrayList<>();
        PVector a = new PVector(100, 400);
        PVector b = new PVector(600, 400);

        float edge = PVector.dist(a,b);        // create vector c for an equi. rectangle
        float height = edge * (sqrt(3)/2);
        PVector c = new PVector(350,400+height);

        Segment segment1 = new Segment(a, b);
        Segment segment2 = new Segment(b, c);
        Segment segment3 = new Segment(c, a);
        segments.add(segment1);
        segments.add(segment2);
        segments.add(segment3);
        Segment beginning = new Segment(a,b);
        segments.add(beginning);
    }

    public void mousePressed() {
        ArrayList<Segment> nextLevel = new ArrayList<Segment>(); //create a new arraylist
        for(Segment s : segments) {
            Segment[] parts = s.create();
            addAll(parts, nextLevel);
        }
        segments = nextLevel;
    }

    public void draw() {
        background(0);
        stroke(255);
        for (Segment s : segments) {
            s.show();
        }
    }
} */