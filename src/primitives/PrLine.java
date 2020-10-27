package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrLine {
    // Поле класса
    Point p = new Point();
    private double size ;

    public PrLine(double coordinateX, double coordinateY, double size) {
        p.setCoordinateX(coordinateX);
        p.setCoordinateY(coordinateY);
        this.size = size;
    }

    public PrLine() {
        Random random = new Random();
        p.setCoordinateX(random.nextDouble()*500.0);
        p.setCoordinateY(random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
    }

    public PrLine(int q){ }

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
