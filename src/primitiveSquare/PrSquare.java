package primitiveSquare;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrSquare {
    // Поле класса
    private double coordinateX;
    private double coordinateY;
    private double size;

    Random random = new Random();

    public PrSquare(double coordinateX, double coordinateY, double size) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.size = size;
    }

    public PrSquare() {
        this.coordinateX = (random.nextDouble()*500.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
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
