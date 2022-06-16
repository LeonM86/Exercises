package ch.csbe.modul404.personregistration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtAge;
    @FXML
    private TextArea txaDescription;
    @FXML
    private Label lblWarning;
    @FXML
    private TableView<Person> tablePerson;
    @FXML
    private TableColumn<Person, String> tblName;
    @FXML
    private TableColumn<Person, String> tblLastname;
    @FXML
    private TableColumn<Person, String> tblDescription;
    @FXML
    private TableColumn<Person, String> tblAge;
    @FXML
    private void checkInput(KeyEvent event) {
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
            txtAge.setStyle("-fx-border-color: red");
            lblWarning.setText("Bitte geben Sie das Alter als Zahl ein.");
            txtAge.setText("");
        } else {
            lblWarning.setText("");
            txtAge.setStyle("-fx-border-color: green");
        }
    }

    public void OnButtonClearClick() {
        clearFields();
    }

    public void OnAddButtonClick() {
        lblWarning.setText("");
        validateFields();
    }

    public void validateFields() {
        if (txtName.getText().equals("") || txtLastname.getText().equals("") || txtAge.getText().equals("") || txaDescription.getText().equals("")) {
            lblWarning.setText("Bitte füllen Sie alle Felder korrekt aus.");
        }  else {
           addPerson();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        tblName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        tblLastname.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tblDescription.setCellValueFactory(new PropertyValueFactory<Person, String>("description"));
        tblAge.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
    }

    public void add(Person person) {
        tablePerson.getItems().add(person);
    }


    public void addPerson() {
        Person person = new Person(txtName.getText(), txtLastname.getText(), txaDescription.getText(), txtAge.getText());
        add(person);
        clearFields();
    }

    private void clearFields() {
        txtName.clear();
        txtLastname.clear();
        txaDescription.clear();
        txtAge.clear();
    }

    public void switchToLoginScene(ActionEvent event) throws Exception {
        Parent rootParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene root = new Scene(rootParent);
        Stage login = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login.setScene(root);
        login.setTitle("Login");
        login.show();
    }

}



