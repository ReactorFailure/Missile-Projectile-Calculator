package Project;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
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

/**
 * @author Zeyu Huang
 */

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
    private Button btn_Exit;

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

    /**
     * Clear every value given by user once the button is pressed
     * 
     * @param event The ActionEvent that the button produces
     */
    @FXML
    void clearOnAction(ActionEvent event) {
        launchValues.clear();

        for (TextField tf : array_TextFields) {
            tf.setText("");
        }

        for (Slider slider : array_Sliders) {
            slider.setValue(0);
        }
        ta_Messages.clear();
        btn_Launch.setDisable(true);
    }

    /**
     * Exit program once the button is pressed
     * 
     * @param event The ActionEvent that the button produces
     */
    @FXML
    void exitOnAction(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Starts the animation of the rocket once the button is pressed
     * 
     * @param event The ActionEvent that the button produces
     * @throws IOException If any IO errors were to happen
     */
    @FXML
    void launchOnAction(ActionEvent event) throws IOException {
        startAnimation(event);

        // Disable launch btn
        btn_Launch.setDisable(true);
    }

    /**
     * Changes the UI from textfield to slider.
     * 
     * @param event The ActionEvent that the button produces
     */
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

    /**
     * Changes the UI from slider to textfield.
     * 
     * @param event The ActionEvent that the button produces
     */
    @FXML
    void switchTfOnAction(ActionEvent event) {
        // Switch to other mode
        pane_TfMode.setVisible(true);
        pane_SliderMode.setVisible(false);

        // Resets textfields to latest updated value
        if (!launchValues.isEmpty()) {
            for (int i = 0; i < array_TextFields.size(); i++) {
                array_TextFields.get(i).setText(String.format("%.0f", launchValues.get(i)));
            }
        }
    }

    /**
     * Changes the pane that shows the preview of the trajectory
     * 
     * @param event The ActionEvent that the button produces
     */
    @FXML
    void updateOnAction(ActionEvent event) {
        // reset launch values
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
        // adjusts textfields to show slider value
        sliderTf_AngleOfLaunch.textProperty().bind(
                slider_AngleOfLaunch.valueProperty().asString("%.0f"));
        sliderTf_HeightOfLaunch.textProperty().bind(
                slider_HeightOfLaunch.valueProperty().asString("%.0f"));
        sliderTf_InitialVelocity.textProperty().bind(
                slider_InitialVelocity.valueProperty().asString("%.0f"));
        sliderTf_GravitationalAcceleration.textProperty().bind(
                slider_GravitationalAcceleration.valueProperty().asString("%.0f"));

        // Setting the max values for sliders
        slider_AngleOfLaunch.setMax(89);
        slider_GravitationalAcceleration.setMax(15);
        slider_GravitationalAcceleration.setMajorTickUnit(5);

        // Arraylist of slider
        array_Sliders.add(slider_AngleOfLaunch);
        array_Sliders.add(slider_GravitationalAcceleration);
        array_Sliders.add(slider_HeightOfLaunch);
        array_Sliders.add(slider_InitialVelocity);

        // Arraylist of TextFields
        array_TextFields.add(tf_AngleOfLaunch);
        array_TextFields.add(tf_GravitationalAcceleration);
        array_TextFields.add(tf_HeightOfLaunch);
        array_TextFields.add(tf_InitialVelocity);

        // So it doesn't focus on the btn
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

    /**
     * To Check if the string is a number
     * 
     * @param str The string that we want to check
     * @return True if the string is a number and false if it isn't
     */
    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Run this method if the user sees the textfields.
     * Add all the inputed values into a physics object and returns a message that
     * the
     * input is not within our range of values.
     */
    private void tfMode() {
        // Verify that the textfield has only number
        for (TextField tf : array_TextFields) {
            if (!isNumber(tf.getText())) {
                ta_Messages.setText("Please only input numbers in the textfield");
                btn_Launch.setDisable(true);
                return;
            }
        }

        // verify the constraints for the textfields
        if (Integer.parseInt(tf_AngleOfLaunch.getText()) < 1 || Integer.parseInt(tf_AngleOfLaunch.getText()) > 89
                || Double.parseDouble(tf_HeightOfLaunch.getText()) < 1
                || Double.parseDouble(tf_HeightOfLaunch.getText()) > 100
                || Double.parseDouble(tf_InitialVelocity.getText()) < 1
                || Double.parseDouble(tf_InitialVelocity.getText()) > 100
                || Double.parseDouble(tf_GravitationalAcceleration.getText()) < 1
                || Double.parseDouble(tf_GravitationalAcceleration.getText()) > 15) {
            ta_Messages.setText(
                    "Please set text fields to allowed values\nAngle:1-89, Height:1-100, Velocity:1-100, Gravitational Acceleration:1-15");
            btn_Launch.setDisable(true);
            SoundEffects.oof();
            return;
        }

        // Clear the messages if everything is fine
        ta_Messages.setText("");

        // To pass the values into the physics class
        for (TextField tf : array_TextFields) {
            launchValues.add(Double.parseDouble(tf.getText()));
        }

        // creating object physics
        physics = new Physics(launchValues);

        // Changes the pane that displays the path
        changePane();

        // Reenabling the launch btn
        btn_Launch.setDisable(false);
    }

    /**
     * Run this method if the user sees the sliders.
     * Add all the inputed values into a physics object and returns a message that
     * the
     * input is not within our range of values.
     */
    private void sliderMode() {
        // Verify that the textfield has only number
        for (Slider sliders : array_Sliders) {
            if (sliders.getValue() == 0) {
                ta_Messages.setText("The numbers on the sliders can't be zero");
                SoundEffects.oof();
                return;
            }
        }
        // Clear the messages if everything is fine
        ta_Messages.setText("");

        for (Slider slider : array_Sliders) {
            launchValues.add(slider.getValue());
        }

        // creating object physics
        physics = new Physics(launchValues);

        // Changes the pane that displays the path
        changePane();

        // Reenabling the launch btn
        btn_Launch.setDisable(false);
    }

    /**
     * This method switches the scene. It goes from the current scene to the scene
     * of the animation
     * 
     * @param event The ActionEvent used for getting the stage our scene is from
     * @throws IOException If there is any IO problems
     */
    private void startAnimation(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnimationScene.fxml"));
        Parent root = loader.load();

        // Retrieve the controller after loading
        AnimationSceneController controller = loader.getController();
        controller.setPhysics(physics);
        controller.animation();

        stage.setScene(new Scene(root));
        stage.setMinWidth(500);
        stage.setTitle("Animation running");
        stage.show();
    }

    /**
     * This mathod changes how the input interface looks like. Either from sliders
     * to textfield of the other way around
     */
    public void changePane() {
        path.setStartY(y_Axis.getEndY() - physics.getHeightOfLaunch());
        path.setEndX(physics.calcDistance() + x_Axis.getStartX());

        path.setControlX(((path.getEndX() + path.getStartX()) / 2));
        path.setControlY(physics.calcMaxHeight() / 2);
    }

    /**
     * This method updates the textArea under the main GUI. It tells the user
     * information about the path of the rocket.
     * 
     * @param phy The physics object used in order to find the information of the
     *            rocket.
     */
    public void onReturn(Physics phy) {
        //to display the previous used launch values
        this.launchValues = phy.getLaunchValues();
        for (int i = 0; i < array_TextFields.size(); i++) {
            array_TextFields.get(i).setText(String.format("%.0f", launchValues.get(i)));
        }

        String str = String.format("The rocket traveled a distance of %.2f meters in %.2f seconds\n",
                phy.calcDistance(), phy.calcTime());
        str += String.format("The max height reached was %.2f meters", phy.calcMaxHeight());

        ta_Messages.setText(str);
    }
}
