package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Menu implements Initializable {

    public void pressedPlay(MouseEvent event) throws IOException {
        Parent PlayParent = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene PlayScene = new Scene(PlayParent);
        Stage stagee = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stagee.setScene(PlayScene);
        stagee.show();
    }
    public void pressedAbout(MouseEvent event) throws IOException {
        Parent AboutParent = FXMLLoader.load(getClass().getResource("About.fxml"));
        Scene AboutScene = new Scene(AboutParent);
        Stage stagee = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stagee.setScene(AboutScene);
        stagee.show();
    }

    @FXML
    private AnchorPane ScenePane;

    public void pressedExit(){
        Stage stage = (Stage) ScenePane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
