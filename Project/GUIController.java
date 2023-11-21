package Project;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GUIController {
    // An array list of textfield and slider
    ArrayList<TextField> array_TextFields = new ArrayList<>();
    ArrayList<Slider> array_Sliders = new ArrayList<>();

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
    private TextArea ta_Messages;

    @FXML
    private TextField tf_AngleOfLaunch;

    @FXML
    private TextField tf_DistanceToTarget;

    @FXML
    private TextField tf_HeightOfLaunch;

    @FXML
    private TextField tf_InitialVelocity;

    @FXML
    // Clear every value given by user
    void ClearOnAction(ActionEvent event) {
        for (TextField tf : array_TextFields) {
            tf.setText("");
        }

        for (Slider slider : array_Sliders) {
            slider.setValue(0);
        }
    }

    @FXML
    void LaunchOnAction(ActionEvent event) {
        // Verify that the textfield has only number
        for (TextField tf : array_TextFields) {
            if (!isNumber(tf.getText())) {
                ta_Messages.setText("Please only input numbers in the textfield");
                return;
            }
        }
        // Clear the messages if everything is fine
        ta_Messages.setText("");
    }

    @FXML
    void switchSliderOnAction(ActionEvent event) {
        // Switch to other mode
        pane_TfMode.setVisible(false);
        pane_SliderMode.setVisible(true);

        // Clear the textfield
        for (TextField tf : array_TextFields) {
            tf.setText("");
        }
    }

    @FXML
    void switchTfOnAction(ActionEvent event) {
        // Switch to other mode
        pane_TfMode.setVisible(true);
        pane_SliderMode.setVisible(false);

        // Clear the slider
        for (Slider slider : array_Sliders) {
            slider.setValue(0);
        }
    }

    @FXML
    void initialize() {
        // Arraylist of slider
        array_Sliders.add(slider_AngleOfLaunch);
        array_Sliders.add(slider_DistanceToTarget);
        array_Sliders.add(slider_HeightOfLaunch);
        array_Sliders.add(slider_InitialVelocity);

        // Arraylisto of TextFields
        array_TextFields.add(tf_AngleOfLaunch);
        array_TextFields.add(tf_DistanceToTarget);
        array_TextFields.add(tf_HeightOfLaunch);
        array_TextFields.add(tf_InitialVelocity);

        // So it doesnt focus on the btn
        btn_Clear.setFocusTraversable(false);
        btn_Launch.setFocusTraversable(false);
        btn_SwitchSlider.setFocusTraversable(false);
        btn_SwitchTf.setFocusTraversable(false);

        // Always start with the text field mode
        pane_SliderMode.setVisible(false);
        pane_TfMode.setVisible(true);
    }

    // To Check if a string is a number
    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
