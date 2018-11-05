package history;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.EventObject;

public class historyController {
    private Stage stage;
    @FXML
    private void handleOk(ActionEvent event) {

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


}
