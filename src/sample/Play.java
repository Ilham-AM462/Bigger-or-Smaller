package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class Play implements Initializable {
    private final Angka angka = new Angka();
    private int correct = 0;
    private String benar;

    @FXML
    private Label angka_awal;
    @FXML
    private Label booleanss;

    public Play() {
        randomize();
    }

    public void Startbutton(MouseEvent event) throws IOException {
        Parent PlayParent = FXMLLoader.load(getClass().getResource("Play.fxml"));
        Scene PlayScene = new Scene(PlayParent);
        Stage stagee = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stagee.setScene(PlayScene);
        stagee.show();
        randomize();
    }

    public void BackStart(MouseEvent event) throws IOException {
        Parent MenuParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene MenuScene = new Scene(MenuParent);
        Stage stagee = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stagee.setScene(MenuScene);
        stagee.show();
    }

    public void BackButton(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apa Anda Yakin?");
        alert.setHeaderText(null);
        alert.setContentText("Apa anda yakin akan Meninggalkan Permainan?\nJawaban Benar : " + correct);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                Parent MenuParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene MenuScene = new Scene(MenuParent);
                Stage stagee = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stagee.setScene(MenuScene);
                stagee.show();
            } else if (result.get() == ButtonType.CANCEL) ;
        }
    }

    public void setAngka_awal() {
        String s = String.valueOf(angka.getAngkaAwal());
        angka_awal.setText("Angka Sebelumnya : " + s);
    }


    public void randomize() {
        Random rand = new Random();
        if (angka.getAngkaAwal() != 0) {
            angka.setAngkaAwal(angka.getAngkaAkhir());
        } else {
            angka.setAngkaAwal(rand.nextInt(10) + 1);
        }
        angka.setAngkaAkhir(rand.nextInt(10) + 1);
        if (angka.getAngkaAwal() == angka.getAngkaAkhir()) {
            if (angka.getAngkaAwal() > 5) {
                angka.setAngkaAkhir(angka.getAngkaAwal() - 1);
            } else if (angka.getAngkaAwal() < 6) {
                angka.setAngkaAkhir(angka.getAngkaAwal() + 1);
            }
        } else if (angka.getAngkaAwal() == 5) {
            angka.setAngkaAkhir(rand.nextInt(5) + 6);
        } else if (angka.getAngkaAwal() == 6) {
            angka.setAngkaAkhir(rand.nextInt(5) + 1);
        }
    }

    public void LbhBesar(MouseEvent event) throws IOException {
        if (angka.getAngkaAkhir() > angka.getAngkaAwal()) {
            booleanss.setText("Benar!");
            correct++;
            randomize();
            setAngka_awal();
        } else if (angka.getAngkaAkhir() < angka.getAngkaAwal()) {
            benar = String.valueOf(correct);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Anda Salah!");
            alert.setHeaderText(null);
            alert.setContentText("Angka Selanjutnya : " + angka.getAngkaAkhir() + "\nJawaban benar : " + benar);
            alert.showAndWait();
            Parent MenuParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene MenuScene = new Scene(MenuParent);
            Stage stagee = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stagee.setScene(MenuScene);
            stagee.show();
        }
    }

    public void LbhKecil(MouseEvent event) throws IOException {
        if (angka.getAngkaAkhir() < angka.getAngkaAwal()) {
            booleanss.setText("Benar!");
            correct++;
            randomize();
            setAngka_awal();
        } else if (angka.getAngkaAkhir() > angka.getAngkaAwal()) {
            benar = String.valueOf(correct);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Anda Salah!");
            alert.setHeaderText(null);
            alert.setContentText("Angka Selanjutnya : " + angka.getAngkaAkhir() + "\nJawaban benar : " + benar);
            alert.showAndWait();
            Parent MenuParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene MenuScene = new Scene(MenuParent);
            Stage stagee = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stagee.setScene(MenuScene);
            stagee.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
