package primitives;

import javafx.scene.canvas.GraphicsContext;

public abstract class TFigure {
    protected double coordinateX;
    protected double coordinateY;

    public TFigure() {}

    public abstract void show(GraphicsContext gc);

    public abstract void delete(GraphicsContext gc);

    public abstract void move(double addX, double addY, GraphicsContext gc);
}
