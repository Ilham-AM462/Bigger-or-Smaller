package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {
    public void PressBack(MouseEvent event) throws IOException {
        Parent MenuParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene MenuScene = new Scene(MenuParent);
        Stage stagee = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stagee.setScene(MenuScene);
        stagee.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
