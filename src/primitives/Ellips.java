package primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellips extends PrCircle{


    @Override
    public void show(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillOval(this.coordinateX- this.radius, this.coordinateY - this.radius, this.radius*2, this.radius*2);
    }

}
