package Draudimas;

import javafx.scene.control.Alert;


public class Validacija extends Exception {

    Forma forma;                // PERDUODAM ESAMĄ FORMĄ
    String klaidosPranesimas;   // KIEKVIENAI KLAIDAI PRISKIRSIM PRANEŠIMĄ
    Alert alert = new Alert(Alert.AlertType.ERROR);

    public Validacija(Forma forma) {
        this.forma = forma;
    }

    public boolean tikrintiArIvestasRodiklis() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 0 && forma.getTxtRodiklis().getText().equals("")) {
            klaidosPranesimas = "Įveskite rodiklį";
            setAlert();
            return false;
        } else return true;
    }

    public boolean tikrintiArIvestasDaugiklis() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 1 && forma.getTxtDaugiklis().getText().equals("")) {
            klaidosPranesimas = "Įveskite daugiklį";
            setAlert();
            return false;
        } else return true;
    }

    public boolean tikrintiArIvestiMetai() throws Exception {

        if (forma.getTxtMetai().getText().equals("")) {
            klaidosPranesimas = "Įveskite metus";
            setAlert();
            return false;
        } else return true;
    }

    public boolean tikrintiArIvestosPalukanos() throws Exception {

        if (forma.getTxtPalukanos().getText().equals("")) {
            klaidosPranesimas = "Įveskite palūkanas";
            setAlert();
            return false;
        } else return true;
    }

    public boolean tikrintiArIvestaIsmoka() throws Exception {

        if (forma.getTxtIsmoka().getText().equals("")) {
            klaidosPranesimas = "Įveskite norimą išmoką";
            setAlert();
            return false;
        } else return true;
    }

    public boolean tikrintiArIvestaImoka() throws Exception {

        if (forma.getTxtImokos().getText().equals("")) {
            klaidosPranesimas = "Įveskite norimas įmokas";
            setAlert();
            return false;
        } else return true;
    }

// DRAUDIMO LAIKOTARPIO IR IŠGYVENAMUMO FUNKCIJŲ PARAMETRŲ TIKRINIMAS

    public boolean pirmosFunkcijosParametruValidacija() throws Exception {

        if (Double.parseDouble(forma.getTxtRodiklis().getText()) <= 0 || Double.parseDouble(forma.getTxtRodiklis().getText()) > 10) {
            klaidosPranesimas = "Blogai įvestas rodiklis";
            setAlert();
            return false;
        } else return true;
    }


    public boolean antrosFunkcijosParametruValidacija() throws Exception {

        if (Double.parseDouble(forma.getTxtDaugiklis().getText()) <= 0) {
            klaidosPranesimas = "Blogai įvestas daugiklis";
            setAlert();
            return false;
        } else return true;
    }


    public boolean metuValidacija() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 0) {
            if (Integer.parseInt(forma.getTxtMetai().getText()) <= 0 || Integer.parseInt(forma.getTxtMetai().getText()) >= forma.kintamieji.getVardiklis() - forma.kintamieji.getAmzius()) {
                klaidosPranesimas = "Blogai įvesti metai";
                setAlert();
                return false;
            } else return true;
        }

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 1) {
            if (Integer.parseInt(forma.getTxtMetai().getText()) <= 0 || Integer.parseInt(forma.getTxtMetai().getText()) >= 110) {
                klaidosPranesimas = "Blogai įvesti metai";
                setAlert();
                return false;
            } else return true;
        }
        return true;
    }

// IŠMOKOS LAUKELIO TIKRINIMAS

    public boolean ismokosValidacija() throws Exception {

        if (Double.parseDouble(forma.getTxtIsmoka().getText()) <= 0) {
            klaidosPranesimas = "Blogai įvesta išmoka";
            setAlert();
            return false;
        } else return true;
    }

// ĮMOKOS LAUKELIO TIKRINIMAS

    public boolean imokuValidacija() throws Exception {

        if (Double.parseDouble(forma.getTxtImokos().getText()) <= 0) {
            klaidosPranesimas = "Blogai įvesta įmoka";
            setAlert();
            return false;
        }
        return true;
    }

// PALŪKANŲ LAUKELIO TIKRINIMAS

    public boolean palukanuValidacija() throws Exception {

        if (Double.parseDouble(forma.getTxtPalukanos().getText()) <= 0 || Double.parseDouble(forma.getTxtPalukanos().getText()) >= 1) {
            klaidosPranesimas = "Blogai įvestos palūkanos";
            setAlert();
            return false;
        } else return true;
    }

// DRAUDIMO RŪŠIES PASIRINKIMO TIKRINIMAS

    public boolean draudimoRusiesValidacija() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == -1) {
            klaidosPranesimas = "Nepasirinkta draudimo rūšis";
            setAlert();
            return false;
        } else return true;
    }

    // ĮMOKŲ RŪŠIES PASIRINKIMO TIKRINIMAS

    public boolean imokuRusiesValidacija() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getImokuRusisBox()) == -1) {
            klaidosPranesimas = "Nepasirinkta įmokų rūšis";
            setAlert();
            return false;
        } else return true;
    }

    // VARDIKLIO PASIRINKIMO VALIDACIJA

    public boolean tikrintiArPasirinktasVardiklis() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 0 && Forma.gautiPasirinkimą(forma.getVardiklisBox()) == -1) {
            klaidosPranesimas = "Pasirinkite vardiklį";
            setAlert();
            return false;
        } else return true;
    }

    // FUNKCIJOS PASIRINKIMO VALIDACIJA

    public boolean funkcijosPasirinkimoValidacija() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == -1) {
            klaidosPranesimas = "Nepasirinkta funkcija";
            setAlert();
            return false;
        } else return true;
    }

    // AMŽIAUS PASIRINKIMO TIKRINIMAS

    public boolean amziausPasirinkimoValidacija() throws Exception {

        if (Forma.gautiPasirinkimą(forma.getAmziusBox()) == -1) {
            klaidosPranesimas = "Nepasirinktas amžius";
            setAlert();
            return false;
        } else return true;
    }

    public void setAlert() throws Exception {

        alert.setTitle("Klaida");
        alert.setHeaderText(klaidosPranesimas);
        alert.show();
        throw new Exception(klaidosPranesimas);

    }
}
