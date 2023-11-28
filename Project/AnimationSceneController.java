package Project;

import java.io.IOException;

import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationSceneController {
    Physics physics;

    @FXML
    private QuadCurve path;

    @FXML
    private ImageView rocket_Iv;

    @FXML
    private Line x_Axis;

    @FXML
    private Line y_Axis;

    public void setPhysics(Physics physics) {
        this.physics = physics;
    }

    public void animation() {
        path.setStartY(y_Axis.getEndY() - physics.heightOfLaunch);
        path.setEndX(physics.calcDistance() + x_Axis.getStartX());

        path.setControlX(((path.getEndX() + path.getStartX()) / 2));
        path.setControlY(physics.calcMaxHeight() / 2);

        x_Axis.setEndX(path.getEndX());

        PathTransition transition = new PathTransition(Duration.seconds(physics.calcTime()), path);
        transition.setNode(rocket_Iv);
        transition.setCycleCount(1);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.play();

        transition.setOnFinished(e -> {
            try {
                returnMain(transition);
            } catch (IOException e1) {
                System.out.println("Big probemo");
            }
        });
    }

    public void returnMain(PathTransition pt) throws IOException {
        Stage stage = (Stage) pt.getNode().getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();

        // Retrieve the controller after loading
        GUIController controller = loader.getController();
        controller.onReturn(physics);

        stage.setScene(new Scene(root));
        stage.setTitle("Animation running");
        stage.setResizable(false);
        stage.show();
    }
}
