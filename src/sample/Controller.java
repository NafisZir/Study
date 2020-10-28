package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primitives.*;

public class Controller {
    @FXML
    private ComboBox comboBoxDelete;

    @FXML
    private ComboBox comboBoxCreate;

    @FXML
    private ComboBox comboBoxMove;

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

    // Переменная считает количество кругов
    private byte iC = 0;
    // Массив для сохранения объектов
    private PrCircle[] arrCircle = new PrCircle[20];
    private byte jC = 0;
    // Переменная для того, чтобы удалять содержимое массива arrCircle, после нажатия кнопки "Удалить"
    private byte dC = 0;

    private byte iS = 0;
    private PrSquare[] arrSquare = new PrSquare[20];
    private byte jS = 0;
    private byte dS = 0;

    private byte iL = 0;
    private PrLine[] arrLine = new PrLine[20];
    private byte jL = 0;
    private byte dL = 0;

    private byte iR = 0;
    private PrRing[] arrRing = new PrRing[20];
    private byte jR = 0;
    private byte dR = 0;

    private byte iF = 0;
    private Flower[] arrFlower = new Flower[10];
    private byte jF = 0;
    private byte dF = 0;
    // Метод создает элементы в comboBoxCreate

    @FXML
    public void initialize() {
        comboBoxCreate.getItems().removeAll(comboBoxCreate.getItems());
        comboBoxCreate.getItems().addAll("Круг", "Отрезок", "Квадрат", "Кольцо", "Цветок");
        comboBoxCreate.getSelectionModel().select("Выберите примитив");
        comboBoxDelete.getItems().removeAll(comboBoxDelete.getItems());
        comboBoxDelete.getItems().addAll("Круг", "Отрезок", "Квадрат", "Кольцо", "Цветок");
        comboBoxMove.getItems().removeAll(comboBoxMove.getItems());
        comboBoxMove.getItems().addAll("Круг", "Отрезок", "Квадрат", "Кольцо", "Цветок");
    }

    // Метод обработки кнопки "Создать"
    @FXML
    public void buttonCreate() {
        if (comboBoxCreate.getValue().equals("Круг"))
            createCircle();
        if (comboBoxCreate.getValue().equals("Квадрат"))
            createRect();
        if (comboBoxCreate.getValue().equals("Отрезок"))
            createLine();
        if (comboBoxCreate.getValue().equals("Кольцо"))
            createRing();
        if (comboBoxCreate.getValue().equals("Цветок"))
            createFlower();
    }

    // Метод обработки кнопки "Создать р."
    public void buttonCreateRandom(){
        if (comboBoxCreate.getValue().equals("Круг"))
            createCircleRandom();
        if (comboBoxCreate.getValue().equals("Квадрат"))
            createRectRandom();
        if (comboBoxCreate.getValue().equals("Отрезок"))
            createLineRandom();
        if (comboBoxCreate.getValue().equals("Кольцо"))
            createRingRandom();
        if (comboBoxCreate.getValue().equals("Цветок"))
            createFlowerRandom();
    }

    // Метод обработки кнопки "Создать т."
    public void buttonCreatePoint(){
        if (comboBoxCreate.getValue().equals("Круг"))
            createCirclePoint();
        if (comboBoxCreate.getValue().equals("Квадрат"))
            createRectPoint();
        if (comboBoxCreate.getValue().equals("Отрезок"))
            createLinePoint();
        if (comboBoxCreate.getValue().equals("Кольцо"))
            createRingPoint();
        if (comboBoxCreate.getValue().equals("Цветок"))
            createFlowerPoint();
    }

    // Метод обработки кнопки "Удалить"
    public void buttonDelete() {
        if (comboBoxDelete.getValue().equals("Круг")) {
            dC = 1;
            deleteCircle();
        }
        if (comboBoxDelete.getValue().equals("Квадрат")) {
            dS = 1;
            deleteRect();
        }
        if (comboBoxDelete.getValue().equals("Отрезок")) {
            dL = 1;
            deleteLine();
        }
        if (comboBoxDelete.getValue().equals("Кольцо")) {
            dR = 1;
            deleteRing();
        }
        if (comboBoxDelete.getValue().equals("Цветок")) {
            dF = 1;
            deleteFlower();
        }
    }


    // Метод обработки кнопки "Переместить"
    public void buttonMove() {
        if (comboBoxMove.getValue().equals("Круг"))
            moveToCircle();
        if (comboBoxMove.getValue().equals("Квадрат"))
            moveToRect();
        if (comboBoxMove.getValue().equals("Отрезок"))
            moveToLine();
        if (comboBoxMove.getValue().equals("Кольцо"))
            moveToRing();
        if (comboBoxMove.getValue().equals("Цветок"))
            moveToFlower();
    }


    // ...
    // Следующие методы только
    // по работе с кругом
    // ...


    // Создаем круг
    public void createCircle() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double r = Double.parseDouble(radius);

        PrCircle circle = new PrCircle(x, y, r);
        // Объект для создания примитива на холсте
        GraphicsContext gc = c.getGraphicsContext2D();
        circle.show(gc);
        arrCircle[jC] = circle;
        ++jC;
        ++iC;
        dialog.setText("Круг №" + iC + " создан!");
    }

    // Создаем круг с рандомными значениями
    public void createCircleRandom() {
        PrCircle circle = new PrCircle();
        GraphicsContext gc = c.getGraphicsContext2D();
        circle.show(gc);
        arrCircle[jC] = circle;
        ++jC;

        ++iC;
        dialog.setText("Круг №" + iC + " создан!");
    }

    public void createCirclePoint(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double r = Double.parseDouble(radius);
        GraphicsContext gc = c.getGraphicsContext2D();

        Point p = new Point(x, y);
        PrCircle circle = new PrCircle(p, r);

        circle.show(gc);

        arrCircle[jC] = circle;
        ++jC;
    }
    // Функция по перемещению круга
    public void moveToCircle() {
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteCircle();
        PrCircle circle;
        for (int k = 0; k < jC; k++) {
            circle = arrCircle[k];
            circle.move(addX, addY, gc);
        }
    }

    // Метод удаляет круг
    public void deleteCircle() {
        PrCircle circle;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jC; k++) {
            circle = arrCircle[k];
            circle.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dC == 1) {
            for (int k = 0; k < jC; k++) {
                arrCircle[k] = null;
            }
            jC = 0;
            dC = 0;
        }
    }


    // ...
    // Следующие методы только
    // по рабооте с квадратом
    // ...


    public void createRect() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(size);

        PrSquare square = new PrSquare(x, y, s);
        GraphicsContext gc = c.getGraphicsContext2D();
        square.show(gc);
        arrSquare[jS] = square;
        ++jS;

        ++iS;
        dialog.setText("Квадрат №" + iS + " создан!");
    }

    public void createRectRandom() {
        PrSquare square = new PrSquare();
        GraphicsContext gc = c.getGraphicsContext2D();
        square.show(gc);
        arrSquare[jS] = square;
        ++jS;

        ++iS;
        dialog.setText("Квадрат №" + iS + " создан!");
    }

    public void createRectPoint(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(radius);
        GraphicsContext gc = c.getGraphicsContext2D();

        Point p = new Point(x, y);
        PrSquare square = new PrSquare(p, s);

        square.show(gc);

        arrSquare[jS] = square;
        ++jS;
    }

    public void moveToRect() {
        PrSquare square;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteRect();
        for (int k = 0; k < jS; k++) {
            square = arrSquare[k];
            square.move(addX, addY, gc);
        }
    }

    public void deleteRect() {
        PrSquare square;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jS; k++) {
            square = arrSquare[k];
            square.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dS == 1) {
            for (int k = 0; k < jS; k++) {
                arrSquare[k] = null;
            }
            jS = 0;
            dS = 0;
        }
    }


    //...
    // Следующие методы только
    // по рабооте с линией
    //...


    public void createLineRandom() {
        PrLine line = new PrLine();
        GraphicsContext gc = c.getGraphicsContext2D();
        line.show(gc);
        arrLine[jL] = line;
        ++jL;

        ++iL;
        dialog.setText("Отрезок №" + iL + " создан!");
    }

    public void createLine() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(size);

        PrLine line = new PrLine(x, y, s);
        GraphicsContext gc = c.getGraphicsContext2D();
        line.show(gc);
        arrLine[jL] = line;
        ++jL;

        ++iL;
        dialog.setText("Отрезок №" + iL + " создан!");
    }

    public void createLinePoint(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(radius);
        GraphicsContext gc = c.getGraphicsContext2D();

        Point p = new Point(x, y);
        PrLine line = new PrLine(p, s);

        line.show(gc);

        arrLine[jL] = line;
        ++jL;
    }

    public void moveToLine() {
        PrLine line;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteLine();
        for (int k = 0; k < jL; k++) {
            line = arrLine[k];
            line.move(addX, addY, gc);
        }
    }

    public void deleteLine() {
        PrLine line;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jL; k++) {
            line = arrLine[k];
            line.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dL == 1) {
            for (int k = 0; k < jL; k++) {
                arrLine[k] = null;
            }
            dL = 0;
            jL = 0;
        }
    }


// ...
// Следующие методы только
// по работе с кольцом
// ...


    public void createRingRandom() {
        PrRing ring = new PrRing();
        GraphicsContext gc = c.getGraphicsContext2D();
        ring.showR(gc);
        arrRing[jR] = ring;
        ++jR;

        ++iR;
        dialog.setText("Кольцо №" + iR + " создан!");
    }

    public void createRing() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();
        String size2 = sizeField2.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s1 = Double.parseDouble(size);
        double s2 = Double.parseDouble(size2);

        PrRing ring = new PrRing(s1, s2, x, y);
        GraphicsContext gc = c.getGraphicsContext2D();
        ring.showR(gc);
        arrRing[jR] = ring;
        ++jR;

        ++iR;
        dialog.setText("Кольцо №" + iR + " создан!");
    }

    public void createRingPoint(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();
        String size2 = sizeField2.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double r1 = Double.parseDouble(size);
        double r2 = Double.parseDouble(size2);

        Point p1 = new Point(x, y);
        Point p2 = new Point(x, y);
        PrRing ring = new PrRing(p1, p2, r1, r2);
        GraphicsContext gc = c.getGraphicsContext2D();

        ring.showR(gc);
        arrRing[jR] = ring;
        ++jR;
    }

    public void moveToRing() {
        PrRing ring;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteRing();
        for (int k = 0; k < jR; k++) {
            ring = arrRing[k];
            ring.moveToR(addX, addY, gc);
        }
    }

    public void deleteRing() {
        PrRing ring;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jR; k++) {
            ring = arrRing[k];
            ring.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dR == 1) {
            for (int k = 0; k < jR; k++) {
                arrRing[k] = null;
            }
            dR = 0;
            jR = 0;
        }
    }


// ...
// Следующие методы только
// по работе с цветком
// ...


    public void createFlowerRandom() {
        Flower flower = new Flower();
        GraphicsContext gc = c.getGraphicsContext2D();
        flower.show(gc);
        arrFlower[jF] = flower;
        ++jF;

        ++iF;
        dialog.setText("Цветок №" + iF + " создан!");
    }

    public void createFlower() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(size);

        Flower flower = new Flower(x, y, s);
        GraphicsContext gc = c.getGraphicsContext2D();
        flower.show(gc);
        arrFlower[jF] = flower;
        ++jF;

        ++iF;
        dialog.setText("Цветок №" + iF + " создан!");
    }

    public void createFlowerPoint(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(radius);

        Point p = new Point(x, y);
        Flower flower = new Flower(p, s);
        GraphicsContext gc = c.getGraphicsContext2D();
        flower.show(gc);

        arrFlower[jF] = flower;
        ++jF;
    }

    public void moveToFlower() {
        Flower flower;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteFlower();
        for (int k = 0; k < jF; k++) {
            flower = arrFlower[k];
            flower.move(addX, addY, gc);
        }
    }

    public void deleteFlower() {
        Flower flower;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jF; k++) {
            flower = arrFlower[k];
            flower.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dF == 1) {
            for (int k = 0; k < jF; k++) {
                arrFlower[k] = null;
            }
            dF = 0;
            jF = 0;
        }
    }
}