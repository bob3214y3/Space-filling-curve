import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import processing.core.PApplet;

public class ProcessingShowcase extends PApplet{

    public static void main(String[] args){

        List<PApplet> sketches = new ArrayList<>();
        sketches.add(new HilbertCurve());
        sketches.add(new TriangleCurve());
        //add sketch classes here!


        //this is optional, but causes the sketches to appear in random order
        //copy this to where the index is reset to randomize whenever you loop
        Collections.shuffle(sketches);

        int currentSketchIndex = 0;

        while(true){

            //using a broad exception to just skip over any sketches that have problems
            try {
                PApplet sketch = sketches.get(currentSketchIndex);
                String[] processingArgs = {""};
                PApplet.runSketch(processingArgs, sketch);

                // this is useful after we've looped
                sketch.getSurface().resumeThread();

                //how long do you want each sketch to display for
                //60 seconds
                Thread.sleep(3*1000);

                // prevent sketches from continuing to run while they're hidden
                sketch.getSurface().pauseThread();;

                //hide the sketch
                sketch.getSurface().setVisible(false);
            }
            catch (Exception e) {
                System.err.println("There was a problem running a sketch!");
                e.printStackTrace();
                System.err.println("Skipping to the next sketch.");
            }

            // move to the next sketch, loop back to the first after finishing
            currentSketchIndex++;
            if(currentSketchIndex >= sketches.size()){
                currentSketchIndex = 0;
            }

            //go back to the top of the while(true) loop
        }
    }
}