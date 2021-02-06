package price.facrories.requesters;

import price.PriceCalculator;
import request.Requester;

import java.util.TreeMap;

public class WeightFactoryPriceCalculator implements RequesterFactory<Long> {
    @Override
    public Requester<Long> create() {
        var priceCurve = new TreeMap<Double, Long>();
        priceCurve.put(0D, 1000L);
        priceCurve.put(100D, 2000L);
        priceCurve.put(400D, 5000L);
        return new PriceCalculator(new RequesterFactoryWeightConsole().create(), priceCurve);
    }
}