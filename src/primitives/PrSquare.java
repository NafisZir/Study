package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrSquare {
    // Поле класса
    private double coordinateX;
    private double coordinateY;
    private double size;

    public PrSquare(double coordinateX, double coordinateY, double size) {
        Point p = new Point();
        p.setCoordinateX(coordinateX);
        p.setCoordinateY(coordinateY);
        this.size = size;
        this.coordinateX = p.getCoordinateX();
        this.coordinateY = p.getCoordinateY();
    }

    public PrSquare( Point p, double s){
        Point point = p;
        this.coordinateX = p.getCoordinateX();
        this.coordinateY = p.getCoordinateY();
        this.size = s;
    }

    public PrSquare() {
        Random random = new Random();
        Point p = new Point();
        p.setCoordinateX(random.nextDouble()*500.0);
        p.setCoordinateY(random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
        this.coordinateX = p.getCoordinateX();
        this.coordinateY = p.getCoordinateY();
    }

    public PrSquare(int q){ }

    public void setSize(double size) {
        this.size = size;
    }

    public void show(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(coordinateX, coordinateY, size, size);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(coordinateX - 1, coordinateY - 1, size + 2, size + 2);
    }

    public void move(double x, double y, GraphicsContext gc){
        this.coordinateX += x;
        this.coordinateY += y;
        show(gc);
    }
}
