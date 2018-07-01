package Draudimas;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public class VerciuSkaiciavimas {

    Forma forma;                // PERDUODAM ESAMĄ FORMĄ
    Integralas integralas = new Integralas();
    IFunkcijos funkcija = new IsgyvenamumoFunkcijos();

    public VerciuSkaiciavimas(Forma forma) {
        this.forma = forma;
    }

    public void verciuSkaiciavimasTolydziuAtveju() {

        DerivativeStructure x = new DerivativeStructure(1, 1, 0, forma.kintamieji.getAmzius()); //funkcijos kintamasis - amžius
        DerivativeStructure pirmaFunkcijaAmzius = funkcija.pirmaFunkcija(x, forma.kintamieji.getVardiklis(),
                forma.kintamieji.getRodiklis());
        DerivativeStructure antraFunkcijaAmzius = funkcija.antraFunkcija(x, forma.kintamieji.getDaugiklis());


        // JEI PASIRINKTA PIRMA FUNKCIJA

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 0) {

            // n metų gyvybės draudimas
            forma.kintamieji.setTolydusA(integralas.skaiciuotiIntegrala(0, forma.kintamieji.getn(), t -> {

                return ((Math.pow((1 / (1 + forma.kintamieji.getPalukanos())), t)) *
                        ((-1 * funkcija.pirmaFunkcija(x.add(t), forma.kintamieji.getVardiklis(), forma.kintamieji.getRodiklis()).
                                getPartialDerivative(1)) / pirmaFunkcijaAmzius.getValue()));

            }));
        }

        // JEI PASIRINKTA ANTRA FUNKCIJA

        if (Forma.gautiPasirinkimą(forma.getFunkcijosBox()) == 1) {

            // n metų gyvybės draudimas
            forma.kintamieji.setTolydusA(integralas.skaiciuotiIntegrala(0, forma.kintamieji.getn(), t -> {

                return ((Math.pow((1 / (1 + forma.kintamieji.getPalukanos())), t)) *
                        ((-1 * funkcija.antraFunkcija(x.add(t), forma.kintamieji.getDaugiklis()).getPartialDerivative(1)) /
                                antraFunkcijaAmzius.getValue()));
            }));
        }

        // n metų kaupiamasis draudimas
        forma.kintamieji.setKaupiamasisTolydusA(forma.kintamieji.getTolydusA() + forma.kintamieji.getGrynasisKaupimasA());

        // tolydus a
        forma.kintamieji.setTolydusa((1 - forma.kintamieji.getTolydusA() - forma.kintamieji.getGrynasisKaupimasA()) /
                Math.log(1 + forma.kintamieji.getPalukanos()));
    }

    public void verciuSkaiciavimasDiskreciuAtveju() throws ClassNotFoundException {

        // SKAIČIUOJAM DISKREČIUS DYDŽIUS

        DuomenuBaze duomenuBaze = new DuomenuBaze();
        duomenuBaze.paimtiIsDB(this.forma);

        //pradinė A reikšmė (pirmas sumos dėmuo)
        forma.kintamieji.setDiskretusA((1 / (1 + forma.kintamieji.getPalukanos())) * ((duomenuBaze.getDuomenis(0) -
                duomenuBaze.getDuomenis(1)) / duomenuBaze.getDuomenis(0)));

        for (int k = 1; k < forma.kintamieji.getn(); k++) {

            // n metų gyvybės draudimas
            forma.kintamieji.setDiskretusA(forma.kintamieji.getDiskretusA() +
                    Math.pow((1 / (1 + forma.kintamieji.getPalukanos())), k) *
                            ((duomenuBaze.getDuomenis(k) - (duomenuBaze.getDuomenis(k + 1))) /
                                    (duomenuBaze.getDuomenis(0))));

        }

        //n metų grynasis kaupimas
        forma.kintamieji.setGrynasisKaupimasA(Math.pow((1 / (1 + forma.kintamieji.getPalukanos())), forma.kintamieji.getn()) *
                ((duomenuBaze.getDuomenis(forma.kintamieji.getn())) /
                        (duomenuBaze.getDuomenis(0))));

        // n metų kaupiamasis
        forma.kintamieji.setKaupiamasisDiskretusA(forma.kintamieji.getDiskretusA() + forma.kintamieji.getGrynasisKaupimasA());

        // metų pradžioje mokamos įmokos
        forma.kintamieji.setIsankstinisa(1);                    //pradinė reikšmė

        for (int k = 1; k < forma.kintamieji.getn(); k++) {
            forma.kintamieji.setIsankstinisa(forma.kintamieji.getIsankstinisa() +
                    Math.pow((1 / (1 + forma.kintamieji.getPalukanos())), k) *
                            (duomenuBaze.getDuomenis(k) / (duomenuBaze.getDuomenis(0))));
        }

        // metų gale mokamos įmokos
        forma.kintamieji.setVeluojantisa(forma.kintamieji.getIsankstinisa() - 1 + forma.kintamieji.getGrynasisKaupimasA());
    }
}
