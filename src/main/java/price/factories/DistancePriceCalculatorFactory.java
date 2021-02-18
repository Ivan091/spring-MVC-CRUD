package price.factories;

import price.PriceCalculator;
import requesters.Requester;

import java.util.SortedMap;


public class DistancePriceCalculatorFactory extends RequesterFactoryAbstract<Double, Long> {

    private final Requester<SortedMap<Double, Long>> priceCurveFactory;

    public DistancePriceCalculatorFactory(Requester<Double> innerRequester,
                                          Requester<SortedMap<Double, Long>> priceCurveFactory) {
        super(innerRequester);
        this.priceCurveFactory = priceCurveFactory;
    }

    @Override
    public Requester<Long> create() {
        return new PriceCalculator(innerRequester, priceCurveFactory);
    }
}
