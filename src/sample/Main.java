package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();

        primaryStage.setTitle("Laba");
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);

        primaryStage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if( keyEvent.getCode() == KeyCode.RIGHT)
                    controller.moveToContainer(35.0,35.0);
                if (keyEvent.getCode() == KeyCode.LEFT)
                    controller.moveToContainer(-35.0,-35.0);
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
