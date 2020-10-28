package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrSquare {
    // Поле класса
    private double size;
    Point p;

    public PrSquare(double x, double y, double size) {
        this.p = new Point(x, y);
        this.size = size;
    }

    public PrSquare( Point p, double s){
        this.p = p;
        this.size = s;
    }

    public PrSquare() {
        Random random = new Random();
        double x = (random.nextDouble()*500.0);
        double y = (random.nextDouble()*500.0);
        this.p = new Point(x, y);
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
        this.p.setCoordinateX(x);
        this.p.setCoordinateY(y);
        show(gc);
    }
}
