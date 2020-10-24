package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primitiveCircle.PrCircle;
import primitiveLine.PrLine;
import primitiveSquare.PrSquare;

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
    private Label dialog;

    @FXML
    private Canvas c;

    // Переменная считает количество кругов
    private byte iC = 0;
    // Переменная-индекс для массива arrCircle
    private byte jC = 0;
    // Массив для сохранения координат и радиуса всех созданных кругов
    private double[] arrCircle = new double[100];
    // Переменная для того, чтобы удалять содержимое массива arrCircle, после нажатия кнопки "Удалить"
    private byte dC = 0;

    private byte iR = 0;
    private byte jR = 0;
    private double[] arrRect = new double[100];
    private byte dR = 0;

    private byte iL = 0;
    private byte jL = 0;
    private double[] arrLine = new double[100];
    private byte dL = 0;

    // Метод создает элементы в comboBoxCreate

    @FXML
    public void initialize() {
        comboBoxCreate.getItems().removeAll(comboBoxCreate.getItems());
        comboBoxCreate.getItems().addAll("Круг", "Отрезок", "Квадрат");
        comboBoxCreate.getSelectionModel().select("Выберите примитив");
        comboBoxDelete.getItems().removeAll(comboBoxDelete.getItems());
        comboBoxDelete.getItems().addAll("Круг", "Отрезок", "Квадрат");
        comboBoxMove.getItems().removeAll(comboBoxMove.getItems());
        comboBoxMove.getItems().addAll("Круг", "Отрезок", "Квадрат");
    }

    // Метод обработки кнопки "Создать"
    @FXML
    public void buttonCreate(){
        if(comboBoxCreate.getValue().equals("Круг"))
            mainCircleCreateFunction();
        if(comboBoxCreate.getValue().equals("Квадрат"))
            mainSquareCreateFunction();
        if(comboBoxCreate.getValue().equals("Отрезок"))
            mainLineCreateFunction();
    }


    // Метод обработки кнопки "Удалить"
    public void buttonDelete(){
        if(comboBoxDelete.getValue().equals("Круг")) {
            dC = 1;
            deleteCircle();
        }
        if(comboBoxDelete.getValue().equals("Квадрат")) {
            dR = 1;
            deleteRect();
        }
        if(comboBoxDelete.getValue().equals("Отрезок")) {
            dL = 1;
            deleteLine();
        }
    }


    // Метод обработки кнопки "Переместить"
    public void buttonMove(){
        if(comboBoxMove.getValue().equals("Круг"))
            moveToCircle();
        if(comboBoxMove.getValue().equals("Квадрат"))
            moveToRect();
        if(comboBoxMove.getValue().equals("Отрезок"))
            moveToLine();
    }


    // ...
    // Следующие методы только
    // по работе с кругом
    // ...

    // Здесь вся работа по созданию круга
    public void mainCircleCreateFunction() {
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String radius = sizeField.getText();

        // Если поля пустые, то значения получаются рандомными
        if (coordinateX.equals("") && coordinateY.equals("") && radius.equals(""))
            createCircleEmpty();
        else {
            try {
                double x = Double.parseDouble(coordinateX);
                double y = Double.parseDouble(coordinateY);
                double r = Double.parseDouble(radius);
                // Добавляем координаты и радиус в массив
                arrCircle[jC] = x;
                ++jC;
                arrCircle[jC] = y;
                ++jC;
                arrCircle[jC] = r;
                ++jC;

                createCircle(x, y, r);
            } catch (Exception e) {
                dialog.setText("Некорректный ввод!");
            }
        }
    }

    // Создаем круг
    public void createCircle(double x, double y, double r){
        PrCircle circle = new PrCircle(x,y,r);
        // Объект для создания примитива на холсте
        GraphicsContext gc = c.getGraphicsContext2D();
        circle.show(gc);
        ++iC;
        dialog.setText("Круг №" + iC + " создан!");
    }

    // Создаем круг с рандомными значениями
    public void createCircleEmpty(){
        PrCircle circle = new PrCircle(1);
        GraphicsContext gc = c.getGraphicsContext2D();
        circle.show(gc);
        arrCircle[jC] = circle.getCoordinateX();
        ++jC;
        arrCircle[jC] = circle.getCoordinateY();
        ++jC;
        arrCircle[jC] = circle.getRadius();
        ++jC;

        ++iC;
        dialog.setText("Круг №" + iC + " создан!");
    }

    // Функция по перемещению круга
    public void moveToCircle(){
        double x, y, r;
        PrCircle circle = new PrCircle();
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteCircle();
        for (int k = 0; k < jC; k++) {
            x = (arrCircle[k] + addX);
            arrCircle[k] = x;
            y = (arrCircle[++k] + addY);
            arrCircle[k] = y;
            r = arrCircle[++k];

            circle.move(x, y, r, gc);
        }
    }

    // Метод удаляет круг
    public void deleteCircle(){
        PrCircle circle = new PrCircle();
        for (int k = 0; k < jC; k++) {
            circle.setCoordinateX(arrCircle[k]);
            circle.setCoordinateY(arrCircle[++k]);
            circle.setRadius(arrCircle[++k]+1);
            GraphicsContext gc = c.getGraphicsContext2D();
            circle.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if(dC == 1){
            for (int k = 0; k < jC; k++) {
                arrCircle[k] = 0;
            }
            dC = 0;
        }
    }


    // ...
    // Следующие методы только
    // по рабооте с квадратом
    // ...


    public void mainSquareCreateFunction(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();

        // Если поля пустые, то значения получаются рандомными
        if (coordinateX.equals("") && coordinateY.equals("") && size.equals(""))
            createRectEmpty();
        else {
            try {
                double x = Double.parseDouble(coordinateX);
                double y = Double.parseDouble(coordinateY);
                double s = Double.parseDouble(size);
                // Добавляем координаты и радиус в массив
                arrRect[jR] = x;
                ++jR;
                arrRect[jR] = y;
                ++jR;
                arrRect[jR] = s;
                ++jR;

                createRect(x, y, s);
            } catch (Exception e) {
                dialog.setText("Некорректный ввод!");
            }
        }
    }

    public void createRect(double x, double y, double s){
        PrSquare square = new PrSquare(x,y,s);
        GraphicsContext gc = c.getGraphicsContext2D();
        square.show(gc);
        ++iR;
        dialog.setText("Квадрат №" + iR + " создан!");
    }

    public void createRectEmpty(){
        PrSquare square = new PrSquare(1);
        GraphicsContext gc = c.getGraphicsContext2D();
        square.show(gc);

        arrRect[jR] = square.getCoordinateX();
        ++jR;
        arrRect[jR] = square.getCoordinateY();
        ++jR;
        arrRect[jR] = square.getSize();
        ++jR;

        ++iR;
        dialog.setText("Квадрат №" + iR + " создан!");
    }

    public void moveToRect(){
        double x, y, s;
        PrSquare square = new PrSquare();
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteRect();
        for (int k = 0; k < jR; k++) {
            x = (arrRect[k] + addX);
            arrRect[k] = x;
            y = (arrRect[++k] + addY);
            arrRect[k] = y;
            s = arrRect[++k];
            square.move(x, y, s, gc);
        }
    }

    public void deleteRect(){
        PrSquare square = new PrSquare();
        for (int k = 0; k < jR; k++) {
            square.setCoordinateX(arrRect[k] + -1);
            square.setCoordinateY(arrRect[++k] + -1);
            square.setSize(arrRect[++k] + 2);
            GraphicsContext gc = c.getGraphicsContext2D();
            square.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if(dR == 1){
            for (int k = 0; k < jR; k++) {
                arrRect[k] = 0;
            }
            dR = 0;
        }
    }


    //...
    // Следующие методы только
    // по рабооте с линией
    //...

    public void mainLineCreateFunction(){
        String coordinateX = layoutCraeteX.getText();
        String coordinateY = layoutCraeteY.getText();
        String size = sizeField.getText();

        // Если поля пустые, то значения получаются рандомными
        if (coordinateX.equals("") && coordinateY.equals("") && size.equals(""))
            createLineEmpty();
        else {
            try {
                double x = Double.parseDouble(coordinateX);
                double y = Double.parseDouble(coordinateY);
                double s = Double.parseDouble(size);
                // Добавляем координаты и радиус в массив
                arrLine[jL] = x;
                ++jL;
                arrLine[jL] = y;
                ++jL;
                arrLine[jL] = s;
                ++jL;

                createLine(x, y, s);
            } catch (Exception e) {
                dialog.setText("Некорректный ввод!");
            }
        }
    }

    public void createLineEmpty(){
        PrLine line = new PrLine(1);
        GraphicsContext gc = c.getGraphicsContext2D();
        gc.save();
        line.show(gc);

        arrLine[jL] = line.getCoordinateX();
        ++jL;
        arrLine[jL] = line.getCoordinateY();
        ++jL;
        arrLine[jL] = line.getSize();
        ++jL;

        ++iL;
        dialog.setText("Отрезок №" + iL + " создан!");
    }

    public void createLine(double x, double y, double s){
        PrLine line = new PrLine(x,y,s);
        GraphicsContext gc = c.getGraphicsContext2D();
        line.show(gc);

        ++iL;
        dialog.setText("Отрезок №" + iL + " создан!");
    }

    public void moveToLine(){
        double x, y, s;
        PrLine line = new PrLine();
        GraphicsContext gc = c.getGraphicsContext2D();
        String coordinateX = layoutMoveX.getText();
        String coordinateY = layoutMoveY.getText();
        double addX = Double.parseDouble(coordinateX);
        double addY = Double.parseDouble(coordinateY);
        deleteLine();

        line.move(arrLine, jL, addX, addY, gc);

        }
    }

    public void deleteLine(){
        PrLine line = new PrLine();
        for (int k = 0; k < jL; k++) {
            line.setCoordinateX(arrLine[k] - 1);
            line.setCoordinateY(arrLine[++k]);
            line.setSize(arrLine[++k] + 3);
            GraphicsContext gc = c.getGraphicsContext2D();
            line.delete(gc);
        }
        // Если была нажата кнопка "Удалить" то очищаем массив
        if(dL == 1){
            for (int k = 0; k < jL; k++) {
                arrLine[k] = 0;
            }
            dL = 0;
        }
    }
}
