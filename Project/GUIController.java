package Project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GUIController {

    @FXML
    private Button btn_Clear;

    @FXML
    private Button btn_Launch;

    @FXML
    private Button btn_SwitchSlider;

    @FXML
    private Button btn_SwitchTf;

    @FXML
    private Pane pane_SliderMode;

    @FXML
    private Pane pane_TfMode;

    @FXML
    private ImageView rocket_Iv;

    @FXML
    private Slider slider_AngleOfLaunch;

    @FXML
    private Slider slider_DistanceToTarget;

    @FXML
    private Slider slider_HeightOfLaunch;

    @FXML
    private Slider slider_InitialVelocity;

    @FXML
    private TextField tf_AngleOfLaunch;

    @FXML
    private TextField tf_DistanceToTarget;

    @FXML
    private TextField tf_HeightOfLaunch;

    @FXML
    private TextField tf_InitialVelocity;

    // Clear every value given by user
    @FXML
    void ClearOnAction(ActionEvent event) {
        tf_AngleOfLaunch.setText("");
        tf_DistanceToTarget.setText("");
        tf_HeightOfLaunch.setText("");
        tf_InitialVelocity.setText("");

        // --------------------------------------------- Do slider also -------------------------------------------//
    }

    @FXML
    void LaunchOnAction(ActionEvent event) {

    }

    @FXML
    void switchSliderOnAction(ActionEvent event) {
        pane_TfMode.setVisible(false);
        pane_SliderMode.setVisible(true);
    }

    @FXML
    void switchTfOnAction(ActionEvent event) {
        pane_TfMode.setVisible(true);
        pane_SliderMode.setVisible(false);
    }

    @FXML
    void initialize() {

    }

}
