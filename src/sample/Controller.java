package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primitives.Container;

public class Controller{
    @FXML
    private TextField layoutMoveX;

    @FXML
    private TextField layoutMoveY;

    @FXML
    public Label dialog;

    @FXML
    private Canvas c;

    Container container;

    public void createEmptyContainer(){
        container = new Container();
        dialog.setText("Пустой контейнер создан");
    }

    public void createContainer(){
        container = new Container(1);
        dialog.setText("Контейнер создан и заполнен");
    }

    public void createOneFigure(){
        container.addFigureRandom();
        dialog.setText("Случайная фигура в контейнере");
    }

    public void showFigures(){
        GraphicsContext gc = c.getGraphicsContext2D();
        container.showAll(gc);
    }

    public void moveFigures(){
        GraphicsContext gc = c.getGraphicsContext2D();
        double x = Double.parseDouble(layoutMoveX.getText());
        double y = Double.parseDouble(layoutMoveY.getText());
        container.moveAll(x, y, gc);
    }

    public void deleteFigures(){
        GraphicsContext gc = c.getGraphicsContext2D();
        container.deleteAll(gc);
        dialog.setText("Все фигуры стерты");
    }

    public void deleteContainer(){
        GraphicsContext gc = c.getGraphicsContext2D();
        container.deleteContainer(gc);
        container = null;
        dialog.setText("Контейнер уничтожен");
    }
}