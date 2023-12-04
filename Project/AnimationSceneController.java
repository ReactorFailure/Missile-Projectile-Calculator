package Project;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Zeyu Huang
 */
public class AnimationSceneController {
    Physics physics;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private QuadCurve path;

    @FXML
    private ImageView rocket_Iv;

    @FXML
    private Line x_Axis;

    @FXML
    private Line y_Axis;

    /**
     * This method imports the physic object from another class. It stores that
     * object in the parameter physics of this class
     * 
     * @param physics The physic object
     * @return Does not return anything
     */
    public void setPhysics(Physics physics) {
        this.physics = physics;
    }

    /**
     * This method is used to play the animation of the rocket. It calls the
     * returnMain() method once the animation finishes
     * 
     * @return Does no return anything
     */
    public void animation() {
        path.setStartY(y_Axis.getEndY() - physics.getHeightOfLaunch());
        path.setEndX(physics.calcDistance() + y_Axis.getLayoutX());

        path.setControlX(((path.getEndX() + path.getStartX()) / 2));
        path.setControlY(y_Axis.getEndY() - physics.calcMaxHeight());

        if (path.getEndX() > 500) {
            x_Axis.setEndX(path.getEndX());
            backgroundImage.setFitWidth(path.getEndX() + 100);
        }

        PathTransition transition = new PathTransition(Duration.seconds(physics.calcTime()), path);
        transition.setNode(rocket_Iv);
        transition.setCycleCount(1);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.play();
        SoundEffects.rocketlaunch();

        transition.setOnFinished(e -> {
            SoundEffects.explosion();
            Image image = new Image("Project//img//explison.png");
            backgroundImage.setImage(image);

            FadeTransition ft = new FadeTransition(Duration.seconds(2));
            ft.setNode(backgroundImage);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setAutoReverse(true);
            ft.setCycleCount(2);

            ft.play();

            ft.setOnFinished(e2 -> {
            try {
                returnMain(transition);
            } catch (IOException e1) {
                System.out.println("Big probemo");
            }

            });
        });
    }

    /**
     * This mathod changes the stage to the main stage. It is called after the
     * animation has finished
     * 
     * @param pt Pathtransiton of the rocket
     * @throws IOException When there is any IO errors
     * @return Does not return anything
     */
    private void returnMain(PathTransition pt) throws IOException {
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