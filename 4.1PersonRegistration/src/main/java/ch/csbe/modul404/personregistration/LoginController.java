package ch.csbe.modul404.personregistration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;


public class LoginController {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label txtErrorUsername;
    @FXML
    private TextField txtUsername;
    @FXML
    private Label txtErrorPassword;
    @FXML
    private PasswordField pwfPassword;
    @FXML
    private Button btnNext;


    public void onLoginButtonClick() {
        txtErrorUsername.setText("");
        txtErrorPassword.setText("");
        validateUsername();
        validatePassword();
    }

    public void validateUsername() {
        if (txtUsername.getText().equals("")) {
            txtErrorUsername.setText("Bitte geben Sie Ihren Benutzernamen ein.");
        } else {
            nextButton();
        }
    }

    public void validatePassword() {
        if (pwfPassword.getText().equals("")) {
            txtErrorPassword.setText("Bitte geben Sie Ihr Passwort ein.");
        } else {
            nextButton();
        }
    }

    public void nextButton() {
        btnNext.setDisable(false);
    }

    public void switchToRegisterScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PersonRegistrationMain.class.getResource("register.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene register = new Scene(fxmlLoader.load());
        stage.setScene(register);
        stage.setTitle("Registration");
        stage.show();

    }

    public void onCloseButtonClick(ActionEvent event) {
        System.exit(0);
    }

}
