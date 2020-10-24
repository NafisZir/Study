package primitiveLine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrLine {
    // Поле класса
    private double coordinateX = 0.0;
    private double coordinateY = 0.0;
    private double size = 0.0;



    public PrLine(double coordinateX, double coordinateY, double size) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.size = size;
    }

    public PrLine( int q) {
        Random random = new Random();
        this.coordinateX = (random.nextDouble()*500.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
    }

    public PrLine() {}

    public double getCoordinateX() { return coordinateX; }

    public void setCoordinateX(double coordinateX) { this.coordinateX = coordinateX; }

    public double getCoordinateY() { return coordinateY; }

    public void setCoordinateY(double coordinateY) { this.coordinateY = coordinateY; }

    public double getSize() { return size; }

    public void setSize(double size) { this.size = size; }

    public void show(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(coordinateX, coordinateY, 2, size);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillRect(coordinateX, coordinateY, 4, size);
    }

    public void move(double arrLine[], byte jL, double addX, double addY, GraphicsContext gc){
        for (int k = 0; k < jL; k++) {
            x = (arrLine[k] + addX);
            arrLine[k] = x;
            y = (arrLine[++k] + addY);
            arrLine[k] = y;
            s = arrLine[++k];
            show(gc);
    }
}
