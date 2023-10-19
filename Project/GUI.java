package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Zeyu Huang
 */
public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label lb_Message = new Label("Please enter values to launch the missile:");
        Label lb_Angle = new Label("Angle of launch:");
        Label lb_Height = new Label("Height of launch:");
        Label lb_Velocity = new Label("Initial velocity:");
        Label lb_Distance = new Label("Distance to target:");

        TextField tf_Angle = new TextField();
        TextField tf_Height = new TextField();
        TextField tf_Velocity = new TextField();
        TextField tf_Distance = new TextField();

        Button btn_Launch = new Button("Launch");
        Button btn_Clear = new Button("Clear");

        // GUI
        HBox hb_Angle = new HBox(10, lb_Angle, tf_Angle);
        HBox hb_Height = new HBox(10, lb_Height, tf_Height);
        HBox hb_Velocity = new HBox(10, lb_Velocity, tf_Velocity);
        HBox hb_Distance = new HBox(10, lb_Distance, tf_Distance);
        HBox hb_Buttons = new HBox(50, btn_Launch, btn_Clear);
        hb_Buttons.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, lb_Message, hb_Angle, hb_Height, hb_Velocity, hb_Distance, hb_Buttons);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Missile Launch Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
