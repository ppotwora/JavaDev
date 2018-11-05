package login;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import payment.PaymentController;
import register.RegisterController;

import java.io.IOException;

/** Controls the login screen */
public class LoginController {
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button register;

    public void initialize() {
    }


        public void initManager ( final LoginManager loginManager){
            loginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String sessionID = authorize();
                    if (sessionID != null) {
                        loginManager.authenticated(sessionID);
                    }
                }
            });
        }

        /**
         * Check authorization credentials.
         *
         * If accepted, return a sessionID for the authorized session
         * otherwise, return null.
         */
        private String authorize () {
            return
                    "ppotwora".equals(user.getText()) && "pp".equals(password.getText())
                            ? generateSessionID()
                            : null;
        }

        private static int sessionID = 0;

        private String generateSessionID () {
            sessionID++;
            return "ppotwora " + sessionID;
        }

        public void registerNewAccount(ActionEvent event)
        {
            try {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../register/register.fxml"));
                Parent root = (Parent) loader.load();

                RegisterController secController=loader.getController();
               // secController.myFunction(textField.getText());

                Stage stage=new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
