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
        gc.setFill(Color.RED);
        gc.fillRect(coordinateX, coordinateY, size, size);
        gc.rotate(90);
    }
}
