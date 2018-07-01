package Draudimas;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Forma extends Application {

    // VISŲ REIKALINGŲ CONTROLS'Ų IR KINTAMŲJŲ SUKŪRIMAS

    KintamujuKlase kintamieji;
    Validacija validacija = new Validacija(this);
    Stage stage = new Stage();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    GridPane gridPaneImokoms = new GridPane();
    GridPane gridPaneIsmokai = new GridPane();

    Button isejimoMygtukas = new Button("Išeiti");      //REIKALINGAS VISIEMS GRIDPANE
    Button grizti = new Button("Grįžti");               //REIKALINGAS VISIEMS GRIDPANE
    Button skaiciuotiIsmoka = new Button("Skaičiuoti išmoką");
    Button skaiciuotiImokas = new Button("Skaičiuoti įmokas");

    private TextField txtMetai = new TextField();
    private TextField txtPalukanos = new TextField();
    private TextField txtIsmoka = new TextField();
    private TextField txtImokos = new TextField();
    private TextField txtRodiklis = new TextField();
    private TextField txtDaugiklis = new TextField();

    Label lblImokos = new Label("Pasirinkite, kokio dydžio įmokas norite mokėti:");
    Label lblIsmoka = new Label("Pasirinkite norimą išmoką:");
    Label lblAmzius = new Label("Įveskite savo amžių:");
    Label lblDraudimoRusis = new Label("Pasirinkite draudimo rūšį:");
    Label lblImokuRusis = new Label("Pasirinkite įmokų tipą:");
    Label funkcija = new Label("Pasirinkite išgyvenamumo funkciją:");
    Label lblVardiklis = new Label("Įveskite vardiklį:");
    Label lblRodiklis = new Label("Įveskite rodiklį:");
    Label lblDaugiklis = new Label("Įveskite daugiklį:");
    Label lblMetai = new Label("Įveskite, keleriems metams norite draustis:");
    Label lblPalukanos = new Label("Įveskite banko taikomą palūkanų normą:");
    Label lblLytis = new Label("Pasirinkite lytį:");

    private ChoiceBox<String> funkcijos = new ChoiceBox<>();
    private ChoiceBox<String> draudimoRusis = new ChoiceBox<>();
    private ChoiceBox<String> imokuRusis = new ChoiceBox<>();
    private ChoiceBox<String> boxAmzius = new ChoiceBox<>();
    private ChoiceBox<String> boxVardiklis = new ChoiceBox<>();

    private RadioButton vyras = new RadioButton("Vyras");
    private RadioButton moteris = new RadioButton("Moteris");
    private ToggleGroup group = new ToggleGroup();

    public Forma() {

        // APSIBRĖŽIAM, KĄ DARO IŠEITI IR GRĮŽTI MYGTUKAI, UŽPILDOM CHECK BOXUS IR SUGRUPUOJAM RADIO BUTTONS

        isejimoMygtukas.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        grizti.setOnAction((ActionEvent event1) -> {
            stage.close();
            start(new Stage());
        });

        choiceBoxUzpildymas();

        vyras.setToggleGroup(group);
        moteris.setToggleGroup(group);
    }


    @Override
    public void start(Stage stage) {

        initUI(stage, new GridPane());
    }

    private void initUI(Stage stage, GridPane gridPane1) {

        Button btn = new Button("Skaičiuoti įmokas");
        btn.setOnAction((ActionEvent event) -> {
            skaiciuotiImokas();
            stage.close();
        });

        Button btn1 = new Button("Skaičiuoti išmoką");
        btn1.setOnAction((ActionEvent event) -> {
            skaiciuotiIsmoka();

            stage.close();
        });

        gridPane1.setHgap(10);
        gridPane1.setVgap(10);
        gridPane1.setPadding(new Insets(25, 25, 25, 25));

        gridPane1.add(btn, 0, 2, 1, 1);
        gridPane1.add(btn1, 1, 2, 1, 1);
        gridPane1.add(isejimoMygtukas, 2, 5, 1, 1);

        Scene scene1 = new Scene(gridPane1, 350, 150);

        stage.setTitle("Draudimas n metų laikotarpiui");
        stage.setScene(scene1);
        stage.show();
    }

    public void choiceBoxUzpildymas() {

        funkcijos.getItems().addAll("(1-(x/vardiklis))^rodiklis", "e^(-daugiklis*x)");

        draudimoRusis.getItems().addAll("n metų gyvybės draudimas, kai išmoka mokama iškart po mirties",
                "n metų gyvybės draudimas, kai išmoka mokama mirties metų gale",
                "n metų kaupiamasis draudimas, kai išmoka mokama iškart po mirties",
                "n metų kaupiamasis draudimas, kai išmoka mokama mirties metų gale",
                "n metų grynasis kaupimas, kai išmoka mokama mirties metų gale");

        imokuRusis.getItems().addAll("Tolygiai mokamos įmokos",
                "Įmokos mokamos metų pradžioje",
                "Įmokos mokamos metų gale");

        for (int i = 1; i <= 100; i++) {
            boxAmzius.getItems().addAll(String.valueOf(i));
        }
        for (int i = 90; i <= 100; i++) {
            boxVardiklis.getItems().addAll(String.valueOf(i));
        }
    }

    public void formosElementuItraukimas(GridPane gridPane, Scene scene) {

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(lblDraudimoRusis, 0, 1);
        gridPane.add(draudimoRusis, 1, 1);
        gridPane.add(lblImokuRusis, 0, 2);
        gridPane.add(imokuRusis, 1, 2);
        gridPane.add(funkcija, 0, 3);
        gridPane.add(funkcijos, 1, 3);
        gridPane.add(lblAmzius, 0, 4);
        gridPane.add(boxAmzius, 1, 4);
        gridPane.add(lblMetai, 0, 5);
        gridPane.add(txtMetai, 1, 5);
        gridPane.add(lblPalukanos, 0, 7);
        gridPane.add(txtPalukanos, 1, 7);
        gridPane.add(grizti, 2, 10);
        gridPane.add(isejimoMygtukas, 3, 10);
        gridPane.add(lblLytis, 2, 4);
        gridPane.add(vyras, 3, 4);
        gridPane.add(moteris, 4, 4);

        stage.setScene(scene);
        stage.show();
    }

    public void skaiciuotiImokas() {

        gridPaneImokoms = new GridPane();

        formosElementuItraukimas(gridPaneImokoms, new Scene(gridPaneImokoms, 1100, 500));

        funkcijosParametruPasirinkimas(gridPaneImokoms);

        skaiciuotiImokas.setOnAction((ActionEvent event) -> {

            kintamieji = new KintamujuKlase(this);

            try {
                if (validacija.tikrintiArIvestaIsmoka()) {
                    if (validacija.ismokosValidacija())
                        kintamieji.setIsmoka(Double.parseDouble(txtIsmoka.getText()));
                }

                nuskaitymasIrTikrinimas();

                IsmokosIrImokosSkaiciavimas vertes = new IsmokosIrImokosSkaiciavimas(this);

                alert.setTitle("Įmokų dydis");
                alert.setHeaderText("Jums reikės kasmet mokėti:");
                alert.setContentText(String.valueOf(vertes.imokosSkaiciavimas()));
                alert.show();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        });

        gridPaneImokoms.add(txtIsmoka, 1, 6);
        gridPaneImokoms.add(skaiciuotiImokas, 1, 10);
        gridPaneImokoms.add(lblIsmoka, 0, 6);

        stage.setTitle("Įmokų skaičiavimas");
    }


    public void skaiciuotiIsmoka() {

        gridPaneIsmokai = new GridPane();

        formosElementuItraukimas(gridPaneIsmokai, new Scene(gridPaneIsmokai, 1100, 500));

        funkcijosParametruPasirinkimas(gridPaneIsmokai);

        skaiciuotiIsmoka.setOnAction((ActionEvent event) -> {

            kintamieji = new KintamujuKlase(this);

            try {

                if (validacija.tikrintiArIvestaImoka()) {
                    if (validacija.imokuValidacija())
                        kintamieji.setImoka(Double.parseDouble(txtImokos.getText()));
                }

                nuskaitymasIrTikrinimas();

                IsmokosIrImokosSkaiciavimas vertes = new IsmokosIrImokosSkaiciavimas(this);

                alert.setTitle("Išmokos dydis");
                alert.setHeaderText("Jums būtų išmokama išmoka:");
                alert.setContentText(String.valueOf(vertes.ismokosSkaiciavimas()));
                alert.show();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        });

        gridPaneIsmokai.add(txtImokos, 1, 6);
        gridPaneIsmokai.add(skaiciuotiIsmoka, 1, 10);
        gridPaneIsmokai.add(lblImokos, 0, 6);

        stage.setTitle("Išmokos skaičiavimas");
    }

    public void nuskaitymasIrTikrinimas() throws Exception {

        if (validacija.funkcijosPasirinkimoValidacija()) {                                      // jei pasirinkta funkcija

            if (gautiPasirinkimą(funkcijos) == 0 && validacija.tikrintiArIvestasRodiklis() &&   // jei pasirinkta pirma funkcija
                    validacija.tikrintiArPasirinktasVardiklis()) {                              // jei įvestas rodiklis ir vardiklis

                if (validacija.pirmosFunkcijosParametruValidacija()) {                          // jei įvesti teisingi parametrai
                    kintamieji.setVardiklis(Integer.parseInt(boxVardiklis.getValue()));
                    kintamieji.setRodiklis(Double.parseDouble(txtRodiklis.getText()));
                }
            }

            if (gautiPasirinkimą(funkcijos) == 1 && validacija.tikrintiArIvestasDaugiklis()) {  // jei pasirinkta antra funkcija
                // ir įvestas daugiklis
                if (validacija.antrosFunkcijosParametruValidacija()) {                          // jei teisingai įvestas daugiklis
                    kintamieji.setDaugiklis(Double.parseDouble(txtDaugiklis.getText()));
                }
            }
        }

        if (validacija.amziausPasirinkimoValidacija()) {                                        // jei pasirinktas amžius
            kintamieji.setAmzius(gautiPasirinkimą(boxAmzius) + 1);
        }

        if (validacija.tikrintiArIvestiMetai()) {                                               // jei įvesti metai
            if (validacija.metuValidacija()) {                                                  // jei gerai įvesti metai
                kintamieji.setN(Integer.parseInt(txtMetai.getText()));
            }
        }

        if (validacija.tikrintiArIvestosPalukanos()) {                                          // jei įvestos palūkanos
            if (validacija.palukanuValidacija()) {                                              // jei teisingai įvestos palūkanos
                kintamieji.setPalukanos(Double.parseDouble(txtPalukanos.getText()));
            }
        }

        validacija.draudimoRusiesValidacija();                                                  // ar pasirinkta draudimo rūšis
        validacija.imokuRusiesValidacija();                                                     // ar pasirinkta įmokų rūšis

        stage.close();
    }

    public void funkcijosParametruPasirinkimas(GridPane gridPane) {

        // NUO FUNKCIJOS PASIRINKIMO PRIKLAUSANČIŲ PARAMETRŲ ĮVEDIMO ATSIRADIMAS

        funkcijos.setOnAction((ActionEvent event) -> {

            if (gautiPasirinkimą(funkcijos) == 0) {
                isvalytiFunkcijosParametruPasirinkimus(gridPane);           // pirma išvalom buvusius ir pridedam reikiamus
                gridPane.add(lblVardiklis, 2, 3);
                gridPane.add(boxVardiklis, 3, 3);
                gridPane.add(lblRodiklis, 4, 3);
                gridPane.add(txtRodiklis, 5, 3);
            }

            if (gautiPasirinkimą(funkcijos) == 1) {
                isvalytiFunkcijosParametruPasirinkimus(gridPane);          // pirma išvalom buvusius ir pridedam reikiamus
                gridPane.add(lblDaugiklis, 2, 3);
                gridPane.add(txtDaugiklis, 3, 3);
            }
        });
    }

    public void isvalytiFunkcijosParametruPasirinkimus(GridPane gridPane) {

        List<Node> salinamiNode = new ArrayList<>();

        for (int i = 2; i <= 5; i++) {                                       // 2-5 stulpeliai
            if (paimtiNodePagalIndeksus(3, i, gridPane) != null) {      // 3 eilutė
                salinamiNode.add(paimtiNodePagalIndeksus(3, i, gridPane));
            }
        }
        gridPane.getChildren().removeAll(salinamiNode);
    }

    public Node paimtiNodePagalIndeksus(int eilutesIndeksas, int stulpelioIndeksas, GridPane gridPane) {

        Node rezultatas = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (gridPane.getRowIndex(node) == eilutesIndeksas && gridPane.getColumnIndex(node) == stulpelioIndeksas) {
                rezultatas = node;
                break;
            }
        }
        return rezultatas;
    }

    public static int gautiPasirinkimą(ChoiceBox<String> choiceBox) {

        List pasirinkimai = choiceBox.getItems();

        if (pasirinkimai != null) {
            return pasirinkimai.indexOf(choiceBox.getSelectionModel().getSelectedItem());
        } else return -1;
    }

    // TEXT FIELD'Ų GET METODAI

    public TextField getTxtMetai() {
        return this.txtMetai;
    }

    public TextField getTxtIsmoka() {
        return this.txtIsmoka;
    }

    public TextField getTxtImokos() {
        return this.txtImokos;
    }

    public TextField getTxtDaugiklis() {
        return this.txtDaugiklis;
    }

    public TextField getTxtRodiklis() {
        return this.txtRodiklis;
    }

    public TextField getTxtPalukanos() {
        return this.txtPalukanos;
    }

    // CHOICE BOX'Ų GET METODAI

    public ChoiceBox getFunkcijosBox() {
        return this.funkcijos;
    }

    public ChoiceBox getDraudimoRusisBox() {
        return this.draudimoRusis;
    }

    public ChoiceBox getImokuRusisBox() {
        return this.imokuRusis;
    }

    public ChoiceBox getAmziusBox() {
        return this.boxAmzius;
    }

    public ChoiceBox getVardiklisBox() {
        return this.boxVardiklis;
    }

    // BUTTON'Ų GET METODAI

    public RadioButton getVyras() {
        return this.vyras;
    }

    public RadioButton getMoteris() {
        return this.moteris;
    }

    public static void main(String[] args) {

        launch(args);

    }
}

