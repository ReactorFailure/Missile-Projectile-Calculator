package Project;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
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

    public void animation(ActionEvent ae) {
        // Path path = new Path();
        // path.getElements().add(new MoveTo(50, 500));
        // path.getElements().add(new QuadCurveTo(300, 150, 550, 500));
        path.setEndX(physics.calcDistance() + path.getStartX());
        path.setControlX(((path.getEndX() - path.getStartX()) / 2));
        path.setControlY(physics.calcMaxHeight() * 2);


        System.out.println(physics.calcDistance());
        System.out.println(path.getStartX());
        System.out.println(path.getEndX());
        System.out.println(path.getEndX() - path.getStartX());

        PathTransition transition = new PathTransition(Duration.seconds(1), path);
        transition.setNode(rocket_Iv);
        transition.setCycleCount(1);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.play();
    }
}
