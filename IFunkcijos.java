package Draudimas;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

public interface IFunkcijos {

    DerivativeStructure pirmaFunkcija(DerivativeStructure x, double vardiklis, double rodiklis);
    DerivativeStructure antraFunkcija(DerivativeStructure x, double daugiklis);
}
