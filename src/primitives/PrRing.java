package primitives;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class PrRing {
    PrCircle c1 = new PrCircle(1);
    PrCircle c2 = new PrCircle(1);

    public PrRing(double r1, double r2, double x, double y){
        c1.p.setCoordinateX(x);
        c1.p.setCoordinateY(y);
        c2.p.setCoordinateX(x);
        c2.p.setCoordinateY(y);
        c1.setRadius(r1);
        c2.setRadius(r2);
    }

    public PrRing(){
        Random random = new Random();
        double x = random.nextDouble()*500.0;
        double y = random.nextDouble()*500.0;
        double r1 = 50 + random.nextDouble()*100.0;
        double r2 = random.nextDouble()*50.0;
        c1.p.setCoordinateX(x);
        c1.p.setCoordinateY(y);
        c2.p.setCoordinateX(x);
        c2.p.setCoordinateY(y);
        c1.setRadius(r1);
        c2.setRadius(r2);
    }

    public void showR(GraphicsContext gc){
        c1.show(gc);
        c2.delete(gc);
    }

    public void delete(GraphicsContext  gc){
        c1.delete(gc);
    }

    public void moveToR(double x, double y, GraphicsContext gc){
        c1.move(x,y,gc);
        c2.move(x,y,gc);
        c2.delete(gc);
    }
}
