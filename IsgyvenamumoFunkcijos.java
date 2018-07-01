package Draudimas;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public class IsgyvenamumoFunkcijos implements IFunkcijos{

    @Override
    public DerivativeStructure pirmaFunkcija(DerivativeStructure x, double vardiklis, double rodiklis){

        DerivativeStructure y = x.divide(-vardiklis).add(1).pow(rodiklis);
        return y;
    }

    @Override
    public DerivativeStructure antraFunkcija(DerivativeStructure x, double daugiklis){

        DerivativeStructure y = (x.exp().multiply(-1*daugiklis));
        return y;
    }

}
