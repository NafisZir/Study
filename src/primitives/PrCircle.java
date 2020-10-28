package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrCircle {
    // Поле класса
    Point p;
    private double radius;

    // Конструктор 1, если пользователь ввел значения
    public PrCircle(double x, double y, double radius) {
        this.p = new Point(x, y);
        this.radius = radius;
    }

    // Конструктор 2
    public PrCircle() {
        Random random = new Random();
        double x, y;
        x = (random.nextDouble()*1000.0);
        y = (random.nextDouble()*500.0);
        this.p = new Point(x, y);
        this.radius = (random.nextDouble()*50.0);
    }

    public PrCircle( Point p, double s){
        this.p = p;
        this.radius = s;
    }

    // метод создает круг на холсте
    public void show(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillOval(p.getCoordinateX() - this.radius, p.getCoordinateY() - this.radius, this.radius*2, this.radius*2);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillOval(p.getCoordinateX()- (this.radius + 1), p.getCoordinateY() - (this.radius + 1), this.radius*2 + 2, this.radius*2 + 2);
    }

    // Метод перемещает круг
    public void move(double x, double y, GraphicsContext gc){
        p.setCoordinateX(x);
        p.setCoordinateY(y);
        show(gc);
    }
}
