package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primitives.Ellipse;
import primitives.PrCircle;
import primitives.PrLine;
import primitives.PrSquare;

public class Controller {
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

    // Переменная считает количество кругов
    private byte iC = 0;
    // Массив для сохранения объектов
    private PrCircle[] arrCircle = new PrCircle[20];
    private byte jC = 0;
    // Переменная для того, чтобы удалять содержимое массива arrCircle, после нажатия кнопки "Удалить"
    private byte dC = 0;

    private byte iR = 0;
    private PrSquare[] arrSquare = new PrSquare[20];
    private byte jS = 0;
    private byte dR = 0;

    private byte iL = 0;
    private PrLine[] arrLine = new PrLine[20];
    private byte jL = 0;
    private byte dL = 0;

    private byte iE = 0;
    private Ellipse[] arrEllipse = new Ellipse[20];
    private byte jE = 0;
    private byte dE = 0;

    // Метод создает элементы в comboBoxCreate

    @FXML
    public void initialize() {
        comboBoxCreate.getItems().removeAll(comboBoxCreate.getItems());
        comboBoxCreate.getItems().addAll("Круг", "Отрезок", "Квадрат", "Эллипс", "Прямоугольник", "Ромб");
        comboBoxCreate.getSelectionModel().select("Выберите примитив");
        comboBoxDelete.getItems().removeAll(comboBoxDelete.getItems());
        comboBoxDelete.getItems().addAll("Круг", "Отрезок", "Квадрат", "Эллипс", "Прямоугольник", "Ромб");
        comboBoxMove.getItems().removeAll(comboBoxMove.getItems());
        comboBoxMove.getItems().addAll("Круг", "Отрезок", "Квадрат", "Эллипс", "Прямоугольник", "Ромб");
        comboBoxRotate.getItems().removeAll(comboBoxRotate.getItems());
        comboBoxRotate.getItems().addAll("Эллипс");
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
        if (comboBoxCreate.getValue().equals("Эллипс"))
            createEllipse();
    }

    public void buttonCreateRandom() {
        if (comboBoxCreate.getValue().equals("Круг"))
            createCircleEmpty();
        if (comboBoxCreate.getValue().equals("Квадрат"))
            createRectEmpty();
        if (comboBoxCreate.getValue().equals("Отрезок"))
            createLineEmpty();
        if (comboBoxCreate.getValue().equals("Эллипс"))
            createEllipseEmpty();
    }

    // Метод обработки кнопки "Удалить"
    public void buttonDelete() {
        if (comboBoxDelete.getValue().equals("Круг")) {
            dC = 1;
            deleteCircle();
        }
        if (comboBoxDelete.getValue().equals("Квадрат")) {
            dR = 1;
            deleteRect();
        }
        if (comboBoxDelete.getValue().equals("Отрезок")) {
            dL = 1;
            deleteLine();
        }
        if (comboBoxDelete.getValue().equals("Эллипс")) {
            dE = 1;
            deleteEllipse();
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
        if (comboBoxMove.getValue().equals("Эллипс"))
            moveToEllipse();
    }

    // Метод обработки кнопки "Вращать"
    public void buttonRotate(){
        if (comboBoxRotate.getValue().equals("Эллипс"))
            rotateEllipse();
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
    public void createCircleEmpty() {
        PrCircle circle = new PrCircle();
        GraphicsContext gc = c.getGraphicsContext2D();
        circle.show(gc);
        arrCircle[jC] = circle;
        ++jC;

        ++iC;
        dialog.setText("Круг №" + iC + " создан!");
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
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(radius);

        PrSquare square = new PrSquare(x, y, s);
        GraphicsContext gc = c.getGraphicsContext2D();
        square.show(gc);
        arrSquare[jS] = square;
        ++jS;

        ++iR;
        dialog.setText("Квадрат №" + iR + " создан!");
    }

    public void createRectEmpty() {
        PrSquare square = new PrSquare();
        GraphicsContext gc = c.getGraphicsContext2D();
        square.show(gc);
        arrSquare[jS] = square;
        ++jS;

        ++iR;
        dialog.setText("Квадрат №" + iR + " создан!");
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
        if (dR == 1) {
            for (int k = 0; k < jS; k++) {
                arrSquare[k] = null;
            }
            jS = 0;
            dR = 0;
        }
    }


    //...
    // Следующие методы только
    // по рабооте с линией
    //...


    public void createLineEmpty() {
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
        String radius = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(radius);

        PrLine line = new PrLine(x, y, s);
        GraphicsContext gc = c.getGraphicsContext2D();
        line.show(gc);
        arrLine[jL] = line;
        ++jL;

        ++iL;
        dialog.setText("Отрезок №" + iL + " создан!");
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


    //...
    // Следующие методы только
    // по рабооте с эллипсом
    //...


    public void createEllipseEmpty() {
        Ellipse ellipse = new Ellipse();
        GraphicsContext gc = c.getGraphicsContext2D();
        ellipse.show(gc);
        arrEllipse[jE] = ellipse;
        ++jE;

        ++iE;
        dialog.setText("Эллипс №" + iE + " создан!");
    }

    public void createEllipse() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size1 = sizeField.getText();
        String size2 = sizeField2.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s1 = Double.parseDouble(size1);
        double s2 = Double.parseDouble(size2);

        Ellipse ellipse = new Ellipse(x, y, s1, s2);
        GraphicsContext gc = c.getGraphicsContext2D();
        ellipse.show(gc);
        arrEllipse[jE] = ellipse;
        ++jE;

        ++iE;
        dialog.setText("Эллипс №" + iE + " создан!");
    }

    public void moveToEllipse() {
        Ellipse ellipse;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteEllipse();
        for (int k = 0; k < jE; k++) {
            ellipse = arrEllipse[k];
            ellipse.move(addX, addY, gc);
        }
    }

    public void deleteEllipse() {
        Ellipse ellipse;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jE; k++) {
            ellipse = arrEllipse[k];
            ellipse.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dE == 1) {
            for (int k = 0; k < jE; k++) {
                arrEllipse[k] = null;
            }
            dE = 0;
            jE = 0;
        }
    }

    public void rotateEllipse() {
        Ellipse ellipse;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jE; k++) {
            ellipse = arrEllipse[k];
            ellipse.delete(gc);
            ellipse.rotate();
            ellipse.show(gc);
        }
    }
}