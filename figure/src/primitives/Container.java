package primitives;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.Random;

public class Container {
    private final int QUANTITY_FIGURES = 6;
    private final int NUMBER_IN_GROUP = 25;
    private final float INCREASE_PERCENT = 1.1f;
    private int maxSize;
    private int maxIndex;
    private double addX, addY;
    private int value;
    TFigure figure;
    TFigure[] arrContainer;

    public Container (int r){
        Random random = new Random();

        arrContainer = new TFigure[NUMBER_IN_GROUP + 10];
        maxSize = arrContainer.length;

        for (int i = 0; i < NUMBER_IN_GROUP; i++) {
            value = random.nextInt(QUANTITY_FIGURES) + 1;
            addFigure(value);
        }

        maxIndex = NUMBER_IN_GROUP;
    }

    public Container (){
        arrContainer = new TFigure[NUMBER_IN_GROUP + 10];
        maxSize = arrContainer.length;
    }

    private void addFigure( int value){
        if(maxIndex == maxSize) {
            increaseSize();
        }
        if (value == 1) {
            figure = new PrCircle();
            arrContainer[maxIndex++] = figure;
        }
        if (value == 2) {
            figure = new PrSquare();
            arrContainer[maxIndex++] = figure;
        }
        if (value == 3) {
            figure = new PrLine();
            arrContainer[maxIndex++] = figure;
        }
        if (value == 4) {
            figure = new Ellipse();
            arrContainer[maxIndex++] = figure;
        }
        if (value == 5) {
            figure = new Rectangle();
            arrContainer[maxIndex++] = figure;
        }
        if (value == 6) {
            figure = new Rhombus();
            arrContainer[maxIndex++] = figure;
        }
    }

    private void iterator(String work, GraphicsContext gc){
        if (work.equals("show")){
            for (int i = 0; i < maxIndex; i++) {
                figure = arrContainer[i];
                figure.show(gc);
            }
        }
        if (work.equals("move")){
            for (int i = 0; i < maxIndex; i++) {
                figure = arrContainer[i];
                figure.move(addX, addY, gc);
            }
        }
        if (work.equals("delete")){
            for (int i = 0; i < maxIndex; i++) {
                figure = arrContainer[i];
                figure.delete(gc);
            }
        }
    }

    public void showAll(GraphicsContext gc){
        iterator("show", gc);
    }

    public void moveAll(double addX, double addY, GraphicsContext gc){
        this.addX = addX;
        this.addY = addY;
        deleteAll(gc);
        iterator("move", gc);
    }

    public void deleteAll(GraphicsContext gc){
        iterator("delete", gc);
    }

    public void deleteContainer(GraphicsContext gc){
        deleteAll(gc);
        for (int i = 0; i < maxIndex; i++) {
            arrContainer[i] = null;
        }
        maxIndex = 0;
    }

    public void addFigureRandom(){
        Random random = new Random();
        value = random.nextInt(QUANTITY_FIGURES) + 1;
        addFigure(value);
    }

    private void increaseSize(){
        int newSize = (int) (maxSize*INCREASE_PERCENT);
        this.arrContainer = Arrays.copyOf(arrContainer, newSize);
        maxSize = newSize;
    }
}
