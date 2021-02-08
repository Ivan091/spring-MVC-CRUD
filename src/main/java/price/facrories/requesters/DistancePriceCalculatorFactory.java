package price.facrories.requesters;

import exceptions.RequesterCreationException;
import price.PriceCalculator;
import requesters.Requester;

import java.util.SortedMap;

public class DistancePriceCalculatorFactory extends RequesterFactoryAbstract<Double, Long> {

    private final RequesterFactory<SortedMap<Double, Long>> priceCurveFactory;

    public DistancePriceCalculatorFactory(RequesterFactory<Double> innerFactory,
                                          RequesterFactory<SortedMap<Double, Long>> priceCurveFactory) {
        super(innerFactory);
        this.priceCurveFactory = priceCurveFactory;
    }

    @Override
    public Requester<Long> create() throws RequesterCreationException {
        return new PriceCalculator(innerFactory.create(), priceCurveFactory.create());
    }
}
