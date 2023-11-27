package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class GUIController {

    // An array list of textfield and slider
    ArrayList<TextField> array_TextFields = new ArrayList<>();
    ArrayList<Slider> array_Sliders = new ArrayList<>();
    ArrayList<Double> launchValues = new ArrayList<>();

    // Global physics class
    Physics physics;

    @FXML
    private Button btn_Clear;

    @FXML
    private Button btn_Launch;

    @FXML
    private Button btn_SwitchSlider;

    @FXML
    private Button btn_SwitchTf;

    @FXML
    private Button btn_Update;

    @FXML
    private Pane pane_SliderMode;

    @FXML
    private Pane pane_TfMode;

    @FXML
    private QuadCurve path;

    @FXML
    private ImageView rocket_Iv;

    @FXML
    private Slider slider_AngleOfLaunch;

    @FXML
    private Slider slider_GravitationalAcceleration;

    @FXML
    private Slider slider_HeightOfLaunch;

    @FXML
    private Slider slider_InitialVelocity;

    @FXML
    private TextField sliderTf_AngleOfLaunch;

    @FXML
    private TextField sliderTf_GravitationalAcceleration;

    @FXML
    private TextField sliderTf_HeightOfLaunch;

    @FXML
    private TextField sliderTf_InitialVelocity;

    @FXML
    private TextArea ta_Messages;

    @FXML
    private TextField tf_AngleOfLaunch;

    @FXML
    private TextField tf_GravitationalAcceleration;

    @FXML
    private TextField tf_HeightOfLaunch;

    @FXML
    private TextField tf_InitialVelocity;

    @FXML
    private Line x_Axis;

    @FXML
    private Line y_Axis;

    @FXML
    // Clear every value given by user
    void clearOnAction(ActionEvent event) {
        launchValues.clear();

        for (TextField tf : array_TextFields) {
            tf.setText("");
        }

        for (Slider slider : array_Sliders) {
            slider.setValue(0);
        }
        btn_Launch.setDisable(true);
    }

    @FXML
    // Starts the animation
    void launchOnAction(ActionEvent event) throws IOException {
        startAnimation(event);

        // Disable launch btn
        btn_Launch.setDisable(true);
    }

    @FXML
    void switchSliderOnAction(ActionEvent event) {
        // Switch to other mode
        pane_TfMode.setVisible(false);
        pane_SliderMode.setVisible(true);

        // Resets textfields to latest updated value
        if (!launchValues.isEmpty()) {
            for (int i = 0; i < array_Sliders.size(); i++) {
                array_Sliders.get(i).setValue(launchValues.get(i));
            }
        }

    }

    @FXML
    void switchTfOnAction(ActionEvent event) {
        // Switch to other mode
        pane_TfMode.setVisible(true);
        pane_SliderMode.setVisible(false);

        // Resets textfields to latest updated value
        if (!launchValues.isEmpty()) {
            for (int i = 0; i < array_TextFields.size(); i++) {
                array_TextFields.get(i).setText(launchValues.get(i).toString());
            }
        }
    }

    @FXML

    void updateOnAction(ActionEvent event) {
        //reset launch values
        launchValues.clear();
        // Check if its in textfield mode
        if (pane_TfMode.isVisible()) {
            tfMode();
        } else {
            sliderMode();
        }
    }

    @FXML
    void initialize() {
        //adjusts textfields to show slider value
        sliderTf_AngleOfLaunch.textProperty().bind(
                slider_AngleOfLaunch.valueProperty().asString("%.0f"));
        sliderTf_HeightOfLaunch.textProperty().bind(
                slider_HeightOfLaunch.valueProperty().asString("%.0f"));
        sliderTf_InitialVelocity.textProperty().bind(
                slider_InitialVelocity.valueProperty().asString("%.0f"));
        sliderTf_GravitationalAcceleration.textProperty().bind(
                slider_GravitationalAcceleration.valueProperty().asString("%.0f"));

        // Arraylist of slider
        array_Sliders.add(slider_AngleOfLaunch);
        array_Sliders.add(slider_GravitationalAcceleration);
        array_Sliders.add(slider_HeightOfLaunch);
        array_Sliders.add(slider_InitialVelocity);

        // Arraylisto of TextFields
        array_TextFields.add(tf_AngleOfLaunch);
        array_TextFields.add(tf_GravitationalAcceleration);
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

        // Have the launch button disable
        btn_Launch.setDisable(true);
    }

    // To Check if a string is a number
    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void tfMode() {
        // Verify that the textfield has only number
        for (TextField tf : array_TextFields) {
            if (!isNumber(tf.getText())) {
                ta_Messages.setText("Please only input numbers in the textfield");
                btn_Launch.setDisable(true);
                return;
            }
        }
        // Clear the messages if everything is fine
        ta_Messages.setText("");

        // To pass the values into the physics class
        for (TextField tf : array_TextFields) {
            launchValues.add(Double.parseDouble(tf.getText()));
        }

        // creating object physics
        physics = new Physics(launchValues);

        // Reenabling the launch btn
        btn_Launch.setDisable(false);
    }

    private void sliderMode() {
        for (Slider slider : array_Sliders) {
            launchValues.add(slider.getValue());
        }

        // creating object physics
        physics = new Physics(launchValues);
        // Reenabling the launch btn
        btn_Launch.setDisable(false);
    }

    // Creates another scene and makes it appear on stage
    private void startAnimation(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnimationScene.fxml"));
        Parent root = loader.load();

        // Retrieve the controller after loading
        AnimationSceneController controller = loader.getController();
        controller.setPhysics(physics);
        controller.animation(e);

        stage.setScene(new Scene(root));
        stage.setTitle("Animation running");
        stage.setResizable(false);
        stage.show();
    }

    public void onReturn(Physics phy, ActionEvent e) {

    }
}
