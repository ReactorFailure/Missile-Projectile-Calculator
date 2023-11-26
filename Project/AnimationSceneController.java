package Project;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;

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
        System.out.println(physics.getAngleOfLaunch());
    }
}
