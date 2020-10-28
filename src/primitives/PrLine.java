package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrLine {
    // Поле класса
    Point p;
    private double size ;

    public PrLine(double x, double y, double size) {
        this.p = new Point(x, y);
        this.size = size;
    }

    public PrLine() {
        Random random = new Random();
        double x, y;
        x = (random.nextDouble()*500.0);
        y = (random.nextDouble()*500.0);
        this.p = new Point(x, y);
        this.size = (random.nextDouble()*100.0);
    }

    public PrLine( Point p, double s){
        this.p = p;
        this.size = s;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void show(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(p.getCoordinateX(), p.getCoordinateY(), 2, size);
    }

    public void show2(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(p.getCoordinateX(), p.getCoordinateY(), size, 2);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(p.getCoordinateX() - 1, p.getCoordinateY(), 4, size + 3);
    }

    public void delete2(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(p.getCoordinateX() - 1, p.getCoordinateY(), size + 3, 4);
    }

    public void move(double addX, double addY, GraphicsContext gc){
        p.setCoordinateX(addX);
        p.setCoordinateY(addY);
        show(gc);
    }

    public void move2(double addX, double addY, GraphicsContext gc){
        p.setCoordinateX(addX);
        p.setCoordinateY(addY);
        show2(gc);
    }
}
