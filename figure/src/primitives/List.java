package primitives;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class List {
    private final int QUANTITY_FIGURES = 6;
    private final int NUMBER_IN_GROUP = 25;
    private double addX, addY;
    private int value;
    TFigure figure;
    ListElement element = null;
    ListElement elementTemp;
    ListElement head;

    public List (int r){
        Random random = new Random();

        for (int i = 0; i < NUMBER_IN_GROUP; i++) {
            value = random.nextInt(QUANTITY_FIGURES) + 1;
            figure = addFigure(value);

            elementTemp = this.element;
            this.element = new ListElement(figure, elementTemp);
        }

        head = element;
    }

    public List (){
        elementTemp = this.element;
        this.element = new ListElement();
    }

    private TFigure addFigure (int value){
        switch (value) {
            case (1):
                figure = new PrCircle();
                break;
            case (2):
                figure = new PrSquare();
                break;
            case (3):
                figure = new PrLine();
                break;
            case (4):
                figure = new Ellipse();
                break;
            case (5):
                figure = new Rectangle();
                break;
            case (6):
                figure = new Rhombus();
                break;
        }

        return figure;
    }

    private void iterator(String work, GraphicsContext gc){
        element = head;
        switch (work){
            case ("show"):
                do  {
                    figure = element.getFigure();
                    figure.show(gc);
                    this.element = element.getNextElement();
                } while (element.getNextElement() != null);
                break;
            case ("move"):
                do  {
                    figure = element.getFigure();
                    figure.move(addX, addY, gc);
                    this.element = element.getNextElement();
                } while (element.getNextElement() != null);
                break;
            case ("delete"):
                do  {
                    figure = element.getFigure();
                    figure.delete(gc);
                    this.element = element.getNextElement();
                } while (element.getNextElement() != null);
                break;
        }
        element = head;
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

    public void deleteList(GraphicsContext gc){
        deleteAll(gc);
        element = head;
        while (true){
            if(element.getNextElement() == null) {
                element = null;
                break;
            }
            elementTemp = element;
            element = element.getNextElement();
            elementTemp.setNextElement(null);
        }
    }

    public void addFigureRandom(){
        Random random = new Random();
        value = random.nextInt(QUANTITY_FIGURES) + 1;
        figure = addFigure(value);
        elementTemp = element;
        this.element = new ListElement(figure, elementTemp);
        head = element;
    }
}
