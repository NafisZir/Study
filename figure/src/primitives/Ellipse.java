package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Ellipse extends PrCircle{
    private double radius2;

    public Ellipse(double x, double y, double r1, double r2){
        this.coordinateX = x;
        this.coordinateY = y;
        this.radius = r1;
        this.radius2 = r2;
    }

    public Ellipse(){
        Random random = new Random();
        this.coordinateX = (random.nextDouble()*1000.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.radius = random.nextDouble()*50.0;
        this.radius2 = random.nextDouble()*50.0;
    }

    public void rotate(){
        double s = this.radius;
        this.radius = this.radius2;
        this.radius2 = s;
    }

    @Override
    public void show(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillOval(this.coordinateX- this.radius, this.coordinateY - this.radius, this.radius*2, this.radius2*2);
    }

    @Override
    public void delete(GraphicsContext gc){
        gc.setFill(Color.grayRgb(244));
        gc.fillOval(this.coordinateX- (this.radius + 1), this.coordinateY - (this.radius + 1), this.radius*2 + 2, this.radius2*2 + 2);
    }
}
