package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primitives.*;

import java.util.Random;

public class Controller {
    public final int NUMBER_FROM_TASK = 35;
    public final int QUANTITY_FIGURES = 6 - 1;

    @FXML
    private ComboBox comboBoxDelete;

    @FXML
    private ComboBox comboBoxCreate;

    @FXML
    private ComboBox comboBoxMove;

    @FXML
    private ComboBox comboBoxRotate;

    @FXML
    private TextField layoutMoveX;

    @FXML
    private TextField layoutMoveY;

    @FXML
    private TextField layoutCraeteX;

    @FXML
    private TextField layoutCraeteY;

    @FXML
    private TextField sizeField;

    @FXML
    private TextField sizeField2;

    @FXML
    private Label dialog;

    @FXML
    private Canvas c;

    TFigure[] container = new TFigure[100];
    // для передвижения по массиву
    private byte j = 0;

    // Метод создает элементы в comboBoxCreate
    @FXML
    public void initialize() {
        comboBoxCreate.getItems().removeAll(comboBoxCreate.getItems());
        comboBoxCreate.getItems().addAll("Все", "Круг", "Отрезок", "Квадрат", "Эллипс", "Прямоугольник", "Ромб");
        comboBoxCreate.getSelectionModel().select("Выберите примитив");
        comboBoxDelete.getItems().removeAll(comboBoxDelete.getItems());
        comboBoxDelete.getItems().addAll("Все", "Круг", "Отрезок", "Квадрат", "Эллипс", "Прямоугольник", "Ромб");
        comboBoxMove.getItems().removeAll(comboBoxMove.getItems());
        comboBoxMove.getItems().addAll("Все", "Круг", "Отрезок", "Квадрат", "Эллипс", "Прямоугольник", "Ромб");
        comboBoxRotate.getItems().removeAll(comboBoxRotate.getItems());
        comboBoxRotate.getItems().addAll("Эллипс");
    }


    // Метод обработки кнопки "Занести в контейнер"
    public void buttonCreate() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size1 = sizeField.getText();
        String size2 = sizeField2.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s1 = Double.parseDouble(size1);
        double s2 = 0;
        try {
            s2 = Double.parseDouble(size2);
        }catch (Exception ex) {
            System.out.println("");
        }

        if (comboBoxCreate.getValue().equals("Круг"))
            createCircle(x, y, s1);
        if (comboBoxCreate.getValue().equals("Квадрат"))
            createRect(x, y, s1);
        if (comboBoxCreate.getValue().equals("Отрезок"))
            createLine(x, y ,s1);
        if (comboBoxCreate.getValue().equals("Эллипс"))
            createEllipse(x, y , s1, s2);
        if (comboBoxCreate.getValue().equals("Прямоугольник"))
            createRectangle(x, y, s1, s2);
        if (comboBoxCreate.getValue().equals("Ромб"))
            createRhombus(x, y ,s1);
    }


    // метод обработки кнопки "Занести в контейнер рандомно"
    public void buttonCreateRandom() {
        if (comboBoxCreate.getValue().equals("Круг"))
            createCircleEmpty();
        if (comboBoxCreate.getValue().equals("Квадрат"))
            createRectEmpty();
        if (comboBoxCreate.getValue().equals("Отрезок"))
            createLineEmpty();
        if (comboBoxCreate.getValue().equals("Эллипс"))
            createEllipseEmpty();
        if (comboBoxCreate.getValue().equals("Прямоугольник"))
            createRectangleEmpty();
        if (comboBoxCreate.getValue().equals("Ромб"))
            createRhombusEmpty();
    }


    // Метод обработки кнопки "Заполнить рандомно"
    public void buttonContainerRandom(){
        Random random = new Random();
        int value;
        for (int i = 0; i < NUMBER_FROM_TASK; i++) {
            value = random.nextInt(QUANTITY_FIGURES) + 1;
            if(value == 1)
                createCircleEmpty();
            if(value == 2)
                createRectEmpty();
            if(value == 3)
                createLineEmpty();
            if(value == 4)
                createEllipseEmpty();
            if(value == 5)
                createRectangleEmpty();
            if(value == 6)
                createRhombusEmpty();
        }
    }


    // Обработка кнопки "Показать"
    public void buttonShow(){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();
        for(int i = 0; i < j; ++i){
            figure = container[i];
            figure.show(gc);
        }
    }


    // Метод обработки кнопки "Удалить"
    public void buttonDelete() {
        if (comboBoxDelete.getValue().equals("Все"))
            deleteContainer();
        if (comboBoxDelete.getValue().equals("Круг"))
            deleteCircle();
        if (comboBoxDelete.getValue().equals("Квадрат"))
            deleteSquare();
        if (comboBoxDelete.getValue().equals("Отрезок"))
            deleteLine();
    }


    // Метод обработки кнопки "Переместить"
    public void buttonMove() {
    String coordinateX = layoutMoveX.getText();
    String coordinateY = layoutMoveY.getText();
    double addX = Double.parseDouble(coordinateX);
    double addY = Double.parseDouble(coordinateY);

    if (comboBoxMove.getValue().equals("Все"))
        moveToContainer(addX, addY);
    if (comboBoxMove.getValue().equals("Круг"))
        moveToCircle(addX, addY);
    if (comboBoxMove.getValue().equals("Квадрат"))
        moveToSquare(addX, addY);
    if (comboBoxMove.getValue().equals("Отрезок"))
        moveToLine(addX, addY);
    }


    // Метод обработки кнопки "Переместить в базовую точку"
    public void buttonMoveBasePoint(){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);

        if (comboBoxMove.getValue().equals("Все")) {
            moveToBaseAll(x, y);
        }

        if (comboBoxMove.getValue().equals("Круг")){
            moveToBaseCircle(x, y);
        }

        if (comboBoxMove.getValue().equals("Квадрат")){
            moveToBaseSquare(x, y);
        }

        if (comboBoxMove.getValue().equals("Отрезок")){
            moveToBaseLine(x, y);
        }
    }


    // Метод обработки кнопки "Вращать"
    public void buttonRotate() {
        if (comboBoxRotate.getValue().equals("Эллипс"))
            rotateEllipse();
    }



    // Создаем фигуры с заданными значениями
    public void createCircle(double x, double y, double s) {
        TFigure circle = new PrCircle(x, y, s);
        container[j] = circle;
        ++j;
    }
    public void createRect(double x, double y, double s) {
        TFigure square = new PrSquare(x, y, s);
        container[j] = square;
        ++j;
    }
    public void createLine(double x, double y, double s) {
        TFigure line = new PrLine(x, y, s);
        container[j] = line;
        ++j;
    }
    public void createEllipse(double x, double y, double s1, double s2) {
        TFigure ellipse = new Ellipse(x, y, s1, s2);
        container[j] = ellipse;
        ++j;
    }
    public void createRectangle(double x, double y, double s1, double s2) {
        TFigure rectangle = new Rectangle(x, y, s1, s2);
        container[j] = rectangle;
        ++j;
    }
    public void createRhombus(double x, double y, double s) {
        TFigure rhombus = new Rhombus(x, y, s);
        container[j] = rhombus;
        ++j;
    }


    // Создаем фигуры с рандомными значениями
    public void createCircleEmpty() {
        TFigure circle = new PrCircle();
        container[j] = circle;
        ++j;
    }
    public void createRectEmpty() {
        TFigure square = new PrSquare();
        container[j] = square;
        ++j;
    }
    public void createLineEmpty() {
        TFigure line = new PrLine();
        container[j] = line;
        ++j;
    }
    public void createEllipseEmpty() {
        TFigure ellipse = new Ellipse();
        container[j] = ellipse;
        ++j;
    }
    public void createRhombusEmpty() {
        TFigure rhombus = new Rhombus();
        container[j] = rhombus;
        ++j;
    }
    public void createRectangleEmpty() {
        TFigure rectangle = new Rectangle();
        container[j] = rectangle;
        ++j;
    }


    // Уничтожение содержимого контейнера
    public  void deleteContainer(){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
            container[i] = null;
        }
        j = 0;
    }


    // Вращение эллипса
    public void rotateEllipse(){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int i = 0; i < j; i++) {
            figure = container[i];
            if(figure instanceof Ellipse)
                ((Ellipse) figure).rotate(gc);

            for(int k = 0; k < j; ++k){
                figure = container[k];
                figure.show(gc);
            }
        }
    }


    // Перемещение фигур
    public void moveToContainer(double addX, double addY){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }
        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.move(addX, addY, gc);
        }
    }
    public void moveToCircle(double x, double y){
        GraphicsContext gc = c.getGraphicsContext2D();
        TFigure figure;

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrCircle)
                figure.move(x, y, gc);
        }
    }
    public void moveToSquare(double x, double y){
        GraphicsContext gc = c.getGraphicsContext2D();
        TFigure figure;

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrSquare)
                figure.move(x, y, gc);
        }
    }
    public void moveToLine(double x, double y){
        GraphicsContext gc = c.getGraphicsContext2D();
        TFigure figure;

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrLine)
                figure.move(x, y, gc);
        }
    }


    // Удаление отдельных фигур
    public void deleteCircle(){
        GraphicsContext gc = c.getGraphicsContext2D();
        TFigure figure;

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrCircle)
                figure.delete(gc);
        }
    }
    public void deleteSquare(){
        GraphicsContext gc = c.getGraphicsContext2D();
        TFigure figure;

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrSquare)
                figure.delete(gc);
        }
    }
    public void deleteLine(){
        GraphicsContext gc = c.getGraphicsContext2D();
        TFigure figure;

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrLine)
                figure.delete(gc);
        }
    }


    // Перемещение в базовую точку
    public void moveToBaseAll( double x, double y){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.basePoint(x, y, gc);
        }
    }
    public void moveToBaseCircle( double x, double y){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrCircle)
                figure.basePoint(x, y, gc);
        }
    }
    public void moveToBaseSquare( double x, double y){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrSquare)
                figure.basePoint(x, y, gc);
        }
    }
    public void moveToBaseLine( double x, double y){
        TFigure figure;
        GraphicsContext gc = c.getGraphicsContext2D();

        for (int i = 0; i < j; i++) {
            figure = container[i];
            figure.delete(gc);
        }

        for (int i = 0; i < j; i++) {
            figure = container[i];

            if(figure instanceof PrLine)
                figure.basePoint(x, y, gc);
        }
    }
}