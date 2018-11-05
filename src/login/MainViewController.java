package login;

import history.historyController;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import login.LoginManager;
import payment.PaymentController;

import java.io.IOException;

/** Controls the main application screen */
public class MainViewController {
    @FXML private Button logoutButton;
    @FXML private Label  sessionLabel;

    public void initialize() {}

    public void initSessionID(final LoginManager loginManager, String sessionID) {
        sessionLabel.setText(sessionID);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                loginManager.logout();
            }
        });
    }

    public void makePayment(ActionEvent event)
    {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../payment/paymentView.fxml"));
            Parent root = (Parent) loader.load();

            PaymentController payController=loader.getController();
            // secController.myFunction(textField.getText());

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accountHistory(ActionEvent event)
    {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../history/history.fxml"));
            Parent root = (Parent) loader.load();

            historyController hisController=loader.getController();
            // secController.myFunction(textField.getText());

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}