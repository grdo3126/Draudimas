package Draudimas;

public class Integralas {

    private static final double padidejimas = 1E-4;

    double skaiciuotiIntegrala(double apatinisRezis, double virsutinisRezis, IFunkcija funkcija) {

        int zenklas = 1;
        double ats = 0;

        if (apatinisRezis > virsutinisRezis) {

            double laikinasApatinisRezis = apatinisRezis;
            apatinisRezis = virsutinisRezis;
            virsutinisRezis = laikinasApatinisRezis;
            zenklas = -1;
        }

        for (double i = apatinisRezis * padidejimas; i < virsutinisRezis; i += padidejimas) {
            double atstumas = i - apatinisRezis;
            ats += (padidejimas / 2) * (funkcija.f(apatinisRezis + atstumas) +
                    funkcija.f(apatinisRezis + atstumas - padidejimas));
        }

        return ats * zenklas;
    }
}
