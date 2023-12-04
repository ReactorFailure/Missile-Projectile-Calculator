package Project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Kevin Wei
 */
public class loginController {
    //Stuff for switching scenes
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_hint;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_exit;

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private Label lbl_hint;

    @FXML
    private Label lbl_error;


    
    /** 
     * This is the method to switch from login screen to the main UI
     * 
     * @param e The actionEvent of the button
     * @throws IOException if any IO probles occures
     */
    @FXML
    public void switchToGUI(ActionEvent e) throws IOException {

        if(tf_username.getText().equals("SoupLover123") && pf_password.getText().equals("givefreerobux7")) {

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI.fxml")));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            lbl_error.setVisible(true);
            SoundEffects.oof();
        }
    }

    /**
     * Shows the username and the password to the user
     * 
     * @param e The actionEvent of the button
     */
    @FXML
    void hintOnAction(ActionEvent e) {
        lbl_hint.setVisible(true);
    }

    /**
     * Clears the textts in the textField and the passwordField
     * 
     * @param e The actionEvent of the button
     */
    @FXML
    void clearOnAction(ActionEvent e) {
        tf_username.setText("");
        pf_password.setText("");
    }

    /**
     * Closes the program
     * 
     * @param e The actionEvent of the button
     */
    @FXML
    void exitOnAction(ActionEvent e) {
        Platform.exit();
    }
}
