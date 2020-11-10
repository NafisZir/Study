package primitives;

public class ListElement {
    private TFigure figure;
    private ListElement nextElement;

    public ListElement(TFigure figure, ListElement element){
        this.figure = figure;
        this.nextElement = element;
    }

    public ListElement(){}

    public void setNextElement(ListElement nextElement) {
        this.nextElement = nextElement;
    }

    public TFigure getFigure() {
        return figure;
    }

    public ListElement getNextElement() {
        return nextElement;
    }
}
