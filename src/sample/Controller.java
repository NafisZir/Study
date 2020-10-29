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

    private byte iRE = 0;
    private Rectangle[] arrRectangle = new Rectangle[20];
    private byte jRE = 0;
    private byte dRE = 0;

    private byte iRH = 0;
    private Rhombus[] arrRhombus = new Rhombus[20];
    private byte jRH = 0;
    private byte dRH = 0;

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
        if (comboBoxCreate.getValue().equals("Прямоугольник"))
            createRectangle();
        if (comboBoxCreate.getValue().equals("Ромб"))
            createRhombus();
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
        if (comboBoxCreate.getValue().equals("Прямоугольник"))
            createRectangleEmpty();
        if (comboBoxCreate.getValue().equals("Ромб"))
            createRhombusEmpty();
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
        if (comboBoxDelete.getValue().equals("Прямоугольник")) {
            dRE = 1;
            deleteRectangle();
        }
        if (comboBoxDelete.getValue().equals("Ромб")) {
            dRH = 1;
            deleteRhombus();
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
        if (comboBoxMove.getValue().equals("Прямоугольник"))
            moveToRectangle();
        if (comboBoxMove.getValue().equals("Ромб"))
            moveToRhombus();
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


    // ...
    // Следующие методы только
    // по работе с прямоугольником
    // ...


    public void createRectangle() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size1 = sizeField.getText();
        String size2 = sizeField2.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s1 = Double.parseDouble(size1);
        double s2 = Double.parseDouble(size2);

        Rectangle rect = new Rectangle(x, y, s1, s2);
        GraphicsContext gc = c.getGraphicsContext2D();
        rect.show(gc);
        arrRectangle[jRE] = rect;
        ++jRE;

        ++iRE;
        dialog.setText("Прямоугольник №" + iRE + " создан!");
    }

    public void createRectangleEmpty() {
        Rectangle rect = new Rectangle();
        GraphicsContext gc = c.getGraphicsContext2D();
        rect.show(gc);
        arrRectangle[jRE] = rect;
        ++jRE;

        ++iRE;
        dialog.setText("Прямоугольник №" + iRE + " создан!");
    }

    public void moveToRectangle() {
        Rectangle rect;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteRectangle();
        for (int k = 0; k < jRE; k++) {
            rect = arrRectangle[k];
            rect.move(addX, addY, gc);
        }
    }

    public void deleteRectangle() {
        Rectangle rect;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jRE; k++) {
            rect = arrRectangle[k];
            rect.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dRE == 1) {
            for (int k = 0; k < jRE; k++) {
                arrRectangle[k] = null;
            }
            dRE = 0;
            jRE = 0;
        }
    }


    // ...
    // Следующие методы только
    // по работе с ромбом
    // ...


    public void createRhombus() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size1 = sizeField.getText();
        double x = Double.parseDouble(coordinateX);
        double y = Double.parseDouble(coordinateY);
        double s = Double.parseDouble(size1);

        Rhombus rhombus = new Rhombus(x, y ,s);
        GraphicsContext gc = c.getGraphicsContext2D();
        rhombus.show(gc);
        arrRhombus[jRH] = rhombus;
        ++jRH;

        ++iRH;
        dialog.setText("Ромб №" + iRH + " создан!");
    }

    public void createRhombusEmpty() {
        Rhombus rhombus = new Rhombus();
        GraphicsContext gc = c.getGraphicsContext2D();
        rhombus.show(gc);
        arrRhombus[jRH] = rhombus;
        ++jRH;

        ++iRH;
        dialog.setText("Ромб №" + iRH + " создан!");
    }

    public void moveToRhombus() {
        Rhombus rhombus;
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteRhombus();
        for (int k = 0; k < jRH; k++) {
            rhombus = arrRhombus[k];
            rhombus.move(addX, addY, gc);
        }
    }

    public void deleteRhombus() {
        Rhombus rhombus;
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int k = 0; k < jRH; k++) {
            rhombus = arrRhombus[k];
            rhombus.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if (dRH == 1) {
            for (int k = 0; k < jRH; k++) {
                arrRhombus[k] = null;
            }
            dRH = 0;
            jRH = 0;
        }
    }
}