package Draudimas;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public class KintamujuKlase {

    Forma forma;            // PERDUODAM ESAMĄ FORMĄ

    private int amzius;
    private int n;
    private int vardiklis;
    private double rodiklis;
    private double daugiklis;
    private double ismoka;
    private double imoka;
    private double palukanos;

    private double tolydusA;
    private double diskretusA;
    private double kaupiamasisTolydusA;
    private double kaupiamasisDiskretusA;
    private double grynasisKaupimasA;
    private double tolydusa;
    private double isankstinisa;
    private double veluojantisa;
    private double galutinisa;

    public KintamujuKlase(Forma forma) {
        this.forma = forma;
    }

    public int getAmzius() {
        return amzius;
    }

    public int getn() {
        return n;
    }

    public int getVardiklis() {
        return vardiklis;
    }

    public double getRodiklis() {
        return rodiklis;
    }

    public double getDaugiklis() {
        return daugiklis;
    }

    public double getIsmoka() {
        return ismoka;
    }

    public double getImoka() {
        return imoka;
    }

    public double getPalukanos() {
        return palukanos;
    }

    public double getTolydusA() {
        return tolydusA;
    }

    public void setTolydusA(double tolydusA) {
        this.tolydusA = tolydusA;
    }

    public double getDiskretusA() {
        return diskretusA;
    }

    public void setDiskretusA(double diskretusA) {
        this.diskretusA = diskretusA;
    }

    public double getKaupiamasisTolydusA() {
        return kaupiamasisTolydusA;
    }

    public void setKaupiamasisTolydusA(double kaupiamasisTolydusA) {
        this.kaupiamasisTolydusA = kaupiamasisTolydusA;
    }

    public double getKaupiamasisDiskretusA() {
        return kaupiamasisDiskretusA;
    }

    public void setKaupiamasisDiskretusA(double kaupiamasisDiskretusA) {
        this.kaupiamasisDiskretusA = kaupiamasisDiskretusA;
    }

    public double getGrynasisKaupimasA() {
        return grynasisKaupimasA;
    }

    public void setGrynasisKaupimasA(double grynasisKaupimasA) {
        this.grynasisKaupimasA = grynasisKaupimasA;
    }

    public double getTolydusa() {
        return tolydusa;
    }

    public void setTolydusa(double tolydusa) {
        this.tolydusa = tolydusa;
    }

    public double getIsankstinisa() {
        return isankstinisa;
    }

    public void setIsankstinisa(double isankstinisa) {
        this.isankstinisa = isankstinisa;
    }

    public double getVeluojantisa() {
        return veluojantisa;
    }

    public void setVeluojantisa(double veluojantisa) {
        this.veluojantisa = veluojantisa;
    }

    public double getGalutinisa() {
        return galutinisa;
    }

    public void setGalutinisa(double galutinisa) {
        this.galutinisa = galutinisa;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setVardiklis(int vardiklis) {
        this.vardiklis = vardiklis;
    }

    public void setRodiklis(double rodiklis) {
        this.rodiklis = rodiklis;
    }

    public void setDaugiklis(double daugiklis) {
        this.daugiklis = daugiklis;
    }

    public void setIsmoka(double ismoka) {
        this.ismoka = ismoka;
    }

    public void setImoka(double imoka) {
        this.imoka = imoka;
    }

    public void setPalukanos(double palukanos) {
        this.palukanos = palukanos;
    }
}
