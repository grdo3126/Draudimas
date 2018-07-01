package Draudimas;

public class IsmokosIrImokosSkaiciavimas {

    Forma forma;                // PERDUODAM ESAMĄ FORMĄ

    public IsmokosIrImokosSkaiciavimas(Forma forma) {
        this.forma = forma;
    }

    // PARENKAME a PAGAL PASIRINKTĄ ĮMOKŲ TIPĄ

    public void priskyrimasGalutinioa() {

        if (Forma.gautiPasirinkimą(forma.getImokuRusisBox()) == 0) {
            forma.kintamieji.setGalutinisa(forma.kintamieji.getTolydusa());
        }
        if (Forma.gautiPasirinkimą(forma.getImokuRusisBox()) == 1) {
            forma.kintamieji.setGalutinisa(forma.kintamieji.getIsankstinisa());
        }
        if (Forma.gautiPasirinkimą(forma.getImokuRusisBox()) == 2) {
            forma.kintamieji.setGalutinisa(forma.kintamieji.getVeluojantisa());
        }
    }

    // SKAIČIUOJAME ĮMOKĄ PAGAL PASIRINKTĄ DRAUDIMO RŪŠĮ

    public double imokosSkaiciavimas() throws ClassNotFoundException {

        VerciuSkaiciavimas vertes = new VerciuSkaiciavimas(this.forma);
        vertes.verciuSkaiciavimasDiskreciuAtveju();
        vertes.verciuSkaiciavimasTolydziuAtveju();
        priskyrimasGalutinioa();

        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 0) {
            return (forma.kintamieji.getIsmoka() * forma.kintamieji.getTolydusA()) / forma.kintamieji.getGalutinisa();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 1) {
            return (forma.kintamieji.getIsmoka() * forma.kintamieji.getDiskretusA()) / forma.kintamieji.getGalutinisa();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 2) {
            return (forma.kintamieji.getIsmoka() * forma.kintamieji.getKaupiamasisTolydusA()) / forma.kintamieji.getGalutinisa();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 3) {
            return (forma.kintamieji.getIsmoka() * forma.kintamieji.getKaupiamasisDiskretusA()) / forma.kintamieji.getGalutinisa();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 4) {
            return (forma.kintamieji.getIsmoka() * forma.kintamieji.getGrynasisKaupimasA()) / forma.kintamieji.getGalutinisa();
        } else return 0;
    }

    // SKAIČIUOJAME IŠMOKĄ PAGAL PASIRINKTĄ DRAUDIMO RŪŠĮ

    public double ismokosSkaiciavimas() throws ClassNotFoundException {

        VerciuSkaiciavimas vertes = new VerciuSkaiciavimas(this.forma);
        vertes.verciuSkaiciavimasDiskreciuAtveju();
        vertes.verciuSkaiciavimasTolydziuAtveju();
        priskyrimasGalutinioa();

        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 0) {
            return (forma.kintamieji.getImoka() * forma.kintamieji.getGalutinisa()) / forma.kintamieji.getTolydusA();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 1) {
            return (forma.kintamieji.getImoka() * forma.kintamieji.getGalutinisa()) / forma.kintamieji.getDiskretusA();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 2) {
            return (forma.kintamieji.getImoka() * forma.kintamieji.getGalutinisa()) / forma.kintamieji.getKaupiamasisTolydusA();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 3) {
            return (forma.kintamieji.getImoka() * forma.kintamieji.getGalutinisa()) / forma.kintamieji.getKaupiamasisDiskretusA();
        }
        if (Forma.gautiPasirinkimą(forma.getDraudimoRusisBox()) == 4) {
            return (forma.kintamieji.getImoka() * forma.kintamieji.getGalutinisa()) / forma.kintamieji.getGrynasisKaupimasA();
        } else return 0;
    }
}