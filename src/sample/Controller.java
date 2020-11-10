package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primitives.List;

public class Controller{
    @FXML
    private TextField layoutMoveX;

    @FXML
    private TextField layoutMoveY;

    @FXML
    public Label dialog;

    @FXML
    private Canvas c;

    List list;

    public void createEmptyContainer(){
        list = new List();
        dialog.setText("Пустой контейнер создан");
    }

    public void createContainer(){
        list = new List(1);
        dialog.setText("Контейнер создан и заполнен");
    }

    public void createOneFigure(){
        list.addFigureRandom();
        dialog.setText("Случайная фигура в контейнере");
    }

    public void showFigures(){
        GraphicsContext gc = c.getGraphicsContext2D();
        list.showAll(gc);
    }

    public void moveFigures(){
        GraphicsContext gc = c.getGraphicsContext2D();
        double x = Double.parseDouble(layoutMoveX.getText());
        double y = Double.parseDouble(layoutMoveY.getText());
        list.moveAll(x, y, gc);
    }

    public void deleteFigures(){
        GraphicsContext gc = c.getGraphicsContext2D();
        list.deleteAll(gc);
        dialog.setText("Все фигуры стерты");
    }

    public void deleteContainer(){
        GraphicsContext gc = c.getGraphicsContext2D();
        list.deleteList(gc);
        list = null;
        dialog.setText("Контейнер уничтожен");
    }
}