package primitives;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Flower {
    // Создаю обьекты более простых примитивов
    PrSquare square;
    PrRing ringUp;
    PrRing ringDown;
    PrRing ringRight;
    PrRing ringLeft;
    PrLine lineUp;
    PrLine lineDown;
    PrLine lineRight;
    PrLine lineLeft;

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

    public Flower(Point p, double s){
        this.square = new PrSquare(p, s);

        this.lineUp = new PrLine(p.getCoordinateX() + s/2, p.getCoordinateY() + s, s);
        this.lineDown = new PrLine(p.getCoordinateX() + s/2, p.getCoordinateY() - s, s);
        this.lineRight = new PrLine(p.getCoordinateY() + s/2, p.getCoordinateX() + s, s);
        this.lineLeft = new PrLine(p.getCoordinateY() + s/2, p.getCoordinateX() - s, s);

        this.ringUp = new PrRing(s/2, s/5, p.getCoordinateX() + s/2, p.getCoordinateY() - s);
        this.ringDown = new PrRing(s/2, s/5, p.getCoordinateX() + s/2, p.getCoordinateY() + 2*s);
        this.ringRight = new PrRing(s/2, s/5, p.getCoordinateX() + 2*s, p.getCoordinateY() + s/2);
        this.ringLeft = new PrRing(s/2, s/5, p.getCoordinateX() - s, p.getCoordinateY() + s/2);
    }

    public void setCoordinate(double x, double y, double s){
        this.square = new PrSquare(x, y, s);

        this.lineUp = new PrLine(x + s/2, y + s, s);
        this.lineDown = new PrLine(x + s/2, y - s, s);
        this.lineRight = new PrLine(x + s, y + s/2, s);
        this.lineLeft = new PrLine(x - s, y + s/2, s);

        this.ringUp = new PrRing(s/2, s/5, x + s/2, y - s);
        this.ringDown = new PrRing(s/2, s/5, x + s/2, y + 2*s);
        this.ringRight = new PrRing(s/2, s/5, x + 2*s, y + s/2);
        this.ringLeft = new PrRing(s/2, s/5, x - s, y + s/2);
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
