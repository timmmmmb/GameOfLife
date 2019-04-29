package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import world.World;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) {
        double width = 400,height = 400;
        World w = new World(width,height);
        Button nextDay = new Button("Next Day");
        nextDay.setOnAction(ActionEvent -> w.nextDay());
        AnchorPane root = new AnchorPane(nextDay);
        Scene scene = new Scene(root,width,height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
