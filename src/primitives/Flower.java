package primitives;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Flower {
    PrSquare square = new PrSquare(1);
    PrRing ringUp = new PrRing(1);
    PrRing ringDown = new PrRing(1);
    PrRing ringRight = new PrRing(1);
    PrRing ringLeft = new PrRing(1);
    PrLine lineUp = new PrLine(1);
    PrLine lineDown = new PrLine(1);
    PrLine lineRight = new PrLine(1);
    PrLine lineLeft = new PrLine(1);

    public Flower(double x, double y, double s){
        setCoordinate(x, y, s);
    }

    public Flower(){
        Random random = new Random();
        double x, y, s;
        x = (300 + random.nextDouble()*500.0);
        y = (300 + random.nextDouble()*500.0);
        s = (random.nextDouble()*40.0);
        setCoordinate(x, y, s);
    }

    public void setCoordinate(double x, double y, double s){
        PrSquare sq = new PrSquare(x,y,s);
        square = sq;
        lineUp.p.setCoordinateX(x + s/2);
        lineUp.p.setCoordinateY(y + s);
        lineUp.setSize(s);

        lineDown.p.setCoordinateX(x + s/2);
        lineDown.p.setCoordinateY(y - s);
        lineDown.setSize(s);

        lineRight.p.setCoordinateY(y + s/2);
        lineRight.p.setCoordinateX(x + s);
        lineRight.setSize(s);

        lineLeft.p.setCoordinateY(y + s/2);
        lineLeft.p.setCoordinateX(x - s);
        lineLeft.setSize(s);

        ringUp.c1.p.setCoordinateX(x + s/2);
        ringUp.c2.p.setCoordinateX(x + s/2);
        ringUp.c1.p.setCoordinateY(y - s);
        ringUp.c2.p.setCoordinateY(y - s);
        ringUp.c1.setRadius(s/2);
        ringUp.c2.setRadius(s/5);

        ringDown.c1.p.setCoordinateX(x + s/2);
        ringDown.c2.p.setCoordinateX(x + s/2);
        ringDown.c1.p.setCoordinateY(y + 2*s);
        ringDown.c2.p.setCoordinateY(y + 2*s);
        ringDown.c1.setRadius(s/2);
        ringDown.c2.setRadius(s/5);

        ringRight.c1.p.setCoordinateX(x + 2*s);
        ringRight.c2.p.setCoordinateX(x + 2*s);
        ringRight.c1.p.setCoordinateY(y + s/2);
        ringRight.c2.p.setCoordinateY(y + s/2);
        ringRight.c1.setRadius(s/2);
        ringRight.c2.setRadius(s/5);

        ringLeft.c1.p.setCoordinateX(x - s);
        ringLeft.c2.p.setCoordinateX(x - s);
        ringLeft.c1.p.setCoordinateY(y + s/2);
        ringLeft.c2.p.setCoordinateY(y + s/2);
        ringLeft.c1.setRadius(s/2);
        ringLeft.c2.setRadius(s/5);
    }

    public void show(GraphicsContext gc){
        square.show(gc);
        lineRight.show2(gc);
        lineLeft.show2(gc);
        lineUp.show(gc);
        lineDown.show(gc);
        ringUp.showR(gc);
        ringDown.showR(gc);
        ringRight.showR(gc);
        ringLeft.showR(gc);
    }

    public void delete(GraphicsContext gc){
        square.delete(gc);

        lineUp.delete(gc);
        lineDown.delete(gc);
        lineRight.delete2(gc);
        lineLeft.delete2(gc);

        ringUp.delete(gc);
        ringDown.delete(gc);
        ringRight.delete(gc);
        ringLeft.delete(gc);
    }

    public void move(double x, double y, GraphicsContext gc){
        square.move(x, y, gc);

        lineUp.move(x, y, gc);
        lineDown.move(x, y, gc);
        lineRight.move2(x, y, gc);
        lineLeft.move2(x, y, gc);

        ringUp.moveToR(x, y, gc);
        ringDown.moveToR(x, y, gc);
        ringRight.moveToR(x, y, gc);
        ringLeft.moveToR(x, y, gc);
    }
}
