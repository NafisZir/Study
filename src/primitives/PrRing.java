package primitives;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class PrRing {
    PrCircle c1;
    PrCircle c2;

    public PrRing(double r1, double r2, double x, double y){
        this.c1 = new PrCircle(x, y, r1);
        this.c2 = new PrCircle(x, y, r2);
    }

    public PrRing(){
        Random random = new Random();
        double x = random.nextDouble()*500.0;
        double y = random.nextDouble()*500.0;
        double r1 = 50 + random.nextDouble()*100.0;
        double r2 = random.nextDouble()*50.0;
        this.c1 = new PrCircle(x, y, r1);
        this.c2 = new PrCircle(x, y, r2);
    }

    public PrRing(Point p, double r1, double r2){
        this.c1 = new PrCircle(p, r1);
        this.c2 = new PrCircle(p, r2);
    }

    public void showR(GraphicsContext gc){
        c1.show(gc);
        c2.delete(gc);
    }

    public void delete(GraphicsContext  gc){

    }

    public void moveToR(double x, double y, GraphicsContext gc){
        c1.delete(gc);
        c1.move(x, y, gc);
        c2.move(x, y, gc);
        c2.delete(gc);
    }
}
