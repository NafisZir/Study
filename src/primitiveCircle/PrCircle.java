package primitiveCircle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrCircle {
    // Поле класса
    private double coordinateX = 0.0;
    private double coordinateY = 0.0;
    private double radius = 0.0;

    Random random = new Random();

    // Конструктор 1, если пользователь ввел значения
    public PrCircle(double coordinateX, double coordinateY, double radius) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.radius = radius;
    }

    // Конструктор 2, если пользователь оставил ВСЕ поля пустыми
    public PrCircle(int q) {
        this.coordinateX = (random.nextDouble()*1000.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.radius = (random.nextDouble()*50.0);
    }
    public PrCircle(){ }

    // Геттеры и Сеттеры
    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCoordinateX() { return coordinateX; }

    public double getCoordinateY() { return coordinateY; }

    public double getRadius() { return radius; }

    // метод создает круг на холсте
    public void show(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillOval(this.coordinateX- this.radius, this.coordinateY - this.radius, this.radius*2, this.radius*2);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillOval(this.coordinateX- this.radius, this.coordinateY - this.radius, this.radius*2, this.radius*2);
    }

    // Метод перемещает круг
    public void move( double x, double y, double r, GraphicsContext gc){
        this.coordinateX = x;
        this.coordinateY = y;
        this.radius = r;
        show(gc);
    }
}
