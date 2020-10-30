package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Rhombus extends PrSquare{

    public Rhombus(double coordinateX, double coordinateY, double size) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.size = size;
    }

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
        gc.fillRect(coordinateX, coordinateY, size, size);

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
        gc.fillRect(coordinateX - 1, coordinateY - 1, size + 2, size + 2);

        gc.restore();
    }
}
