package primitiveLine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrLine {
    // Поле класса
    private double coordinateX;
    private double coordinateY;
    private double size ;



    public PrLine(double coordinateX, double coordinateY, double size) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.size = size;
    }

    public PrLine() {
        Random random = new Random();
        this.coordinateX = (random.nextDouble()*500.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
    }

    public void show(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(coordinateX, coordinateY, 2, size);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(coordinateX - 1, coordinateY, 4, size + 3);
    }

    public void move(double addX, double addY, GraphicsContext gc){
        this.coordinateX += addX;
        this.coordinateY += addY;
        show(gc);
    }
}
