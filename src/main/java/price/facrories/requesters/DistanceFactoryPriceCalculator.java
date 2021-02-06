package price.facrories.requesters;

import price.PriceCalculator;
import request.Requester;

import java.util.TreeMap;

public class DistanceFactoryPriceCalculator implements RequesterFactory<Long> {

    @Override
    public Requester<Long> create() {
        var priceCurve = new TreeMap<Double, Long>();
        priceCurve.put(0D, 200L);
        priceCurve.put(1000D, 500L);
        priceCurve.put(6000D, 700L);
        return new PriceCalculator(new RequesterFactoryDistanceConsole().create(), priceCurve);
    }
}
