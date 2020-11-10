package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Rhombus extends PrSquare{
    private double g = Math.toRadians(60);
    private double p = 11;

    public Rhombus() {
        Random random = new Random();
        this.coordinateX = (random.nextDouble()*500.0);
        this.coordinateY = (random.nextDouble()*500.0);
        this.size = (random.nextDouble()*100.0);
    }

    @Override
    public void show(GraphicsContext gc){
        double rotationCenterX = (this.coordinateX + this.size) / 2;
        double rotationCenterY = (this.coordinateY + this.size) / 2;

        gc.save();

        gc.translate(rotationCenterX, rotationCenterY);
        gc.rotate(45);
        gc.translate(-rotationCenterX, -rotationCenterY);
        gc.setFill(Color.RED);
        gc.fillRect(coordinateX*Math.cos(g), coordinateY*Math.cos(g), size, size);

        gc.restore();
    }

    @Override
    public void delete(GraphicsContext gc){
        double rotationCenterX = (this.coordinateX + this.size) / 2;
        double rotationCenterY = (this.coordinateY + this.size) / 2;

        gc.save();

        gc.translate(rotationCenterX, rotationCenterY);
        gc.rotate(45);
        gc.translate(-rotationCenterX, -rotationCenterY);
        gc.setFill(Color.grayRgb(244));
        gc.fillRect((coordinateX - 1)*Math.cos(g), (coordinateY- 1)*Math.cos(g), size + 2, size + 2);

        gc.restore();
    }

    public void move(double addX, double addY, GraphicsContext gc){
        if(addX > 0) {
            this.coordinateX += (addX + p);
            this.coordinateY += (addY + p);
            show(gc);
        }
        else{
            this.coordinateX += (addX - p);
            this.coordinateY += (addY - p);
            show(gc);
        }
    }
}
