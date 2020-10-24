package primitiveSquare;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrSquare {
    // Поле класса
    private double coordinateX = 0.0;
    private double coordinateY = 0.0;
    private double size = 0.0;

    Random random = new Random();

    public PrSquare(double coordinateX, double coordinateY, double size) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.size = size;
    }

    public PrSquare(int q) {
        this.coordinateX = (random.nextDouble()*500.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
    }

    public PrSquare(){}

    public void setCoordinateX(double coordinateX) { this.coordinateX = coordinateX; }

    public void setCoordinateY(double coordinateY) { this.coordinateY = coordinateY; }

    public void setSize(double size) { this.size = size; }

    public double getCoordinateX() { return coordinateX; }

    public double getCoordinateY() { return coordinateY; }

    public double getSize() { return size; }

    public void show(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(coordinateX, coordinateY, size, size);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(coordinateX, coordinateY, size, size);
    }

    public void move(double x, double y, double s, GraphicsContext gc){
        this.coordinateX = x;
        this.coordinateY = y;
        this.size = s;
        show(gc);
    }
}
