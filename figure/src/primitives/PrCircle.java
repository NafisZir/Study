package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrCircle extends TFigure{
    // Поле класса
    protected double radius;

    // Конструктор 1, если пользователь ввел значения
    public PrCircle(double coordinateX, double coordinateY, double radius) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.radius = radius;
    }

    // Конструктор 2, если пользователь оставил ВСЕ поля пустыми
    public PrCircle() {
        Random random = new Random();
        this.coordinateX = (random.nextDouble()*1000.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.radius = (random.nextDouble()*50.0);
    }

    // метод создает круг на холсте
    @Override
    public void show(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillOval(this.coordinateX- this.radius, this.coordinateY - this.radius, this.radius*2, this.radius*2);
    }

    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillOval(this.coordinateX- (this.radius + 1), this.coordinateY - (this.radius + 1), this.radius*2 + 2, this.radius*2 + 2);
    }

    // Метод перемещает круг
    @Override
    public void move(double x, double y, GraphicsContext gc){
        this.coordinateX += x;
        this.coordinateY += y;
        show(gc);
    }
}
