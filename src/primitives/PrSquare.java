package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrSquare {
    // Поле класса
    Point p = new Point();
    private double size;

    public PrSquare(double coordinateX, double coordinateY, double size) {
        p.setCoordinateX(coordinateX);
        p.setCoordinateY(coordinateY);
        this.size = size;
    }

    public PrSquare() {
        Random random = new Random();
        p.setCoordinateX(random.nextDouble()*500.0);
        p.setCoordinateY(random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
    }

    public PrSquare(int q){ }

    public void setSize(double size) {
        this.size = size;
    }

    public void show(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(p.getCoordinateX(), p.getCoordinateY(), size, size);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(p.getCoordinateX() - 1, p.getCoordinateY() - 1, size + 2, size + 2);
    }

    public void move(double x, double y, GraphicsContext gc){
        p.setCoordinateX(x);
        p.setCoordinateY(y);
        show(gc);
    }
}
