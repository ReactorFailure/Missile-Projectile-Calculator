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


    //Method to switch from login to GUI
    @FXML
    public void switchToGUI(ActionEvent e) throws IOException {

        // if(tf_username.getText().equals("SoupLover123") && pf_password.getText().equals("givefreerobux7")) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI.fxml")));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        // } else {
        //     lbl_error.setVisible(true);
        //     SoundEffects.oof();
        // }
    }

    @FXML
    void hintOnAction(ActionEvent e) {
        lbl_hint.setVisible(true);
    }

    @FXML
    void clearOnAction(ActionEvent e) {
        tf_username.setText("");
        pf_password.setText("");
    }

    @FXML
    void exitOnAction(ActionEvent e) {
        Platform.exit();
    }
}
