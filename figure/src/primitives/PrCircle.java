package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PrCircle extends TFigure{
    protected double radius;


    public PrCircle() {
        Random random = new Random();
        this.coordinateX = (random.nextDouble()*1000.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.radius = (random.nextDouble()*50.0);
    }

    @Override
    public void show(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillOval(this.coordinateX- this.radius, this.coordinateY - this.radius, this.radius*2, this.radius*2);
    }

    @Override
    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillOval(this.coordinateX- (this.radius + 1), this.coordinateY - (this.radius + 1), this.radius*2 + 2, this.radius*2 + 2);
    }

    public void move(double addX, double addY, GraphicsContext gc){
        this.coordinateX += addX;
        this.coordinateY += addY;
        show(gc);
    }
}
