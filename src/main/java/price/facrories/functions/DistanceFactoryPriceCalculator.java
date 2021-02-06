package price.facrories.functions;

import price.PriceCalculator;
import price.facrories.requesters.RequesterFactoryDistanceConsole;

import java.util.TreeMap;
import java.util.function.Function;

public class DistanceFactoryPriceCalculator implements FunctionFactory<Void, Long> {

    @Override
    public Function<Void, Long> create() {
        var priceCurve = new TreeMap<Double, Long>();
        priceCurve.put(0D, 200L);
        priceCurve.put(1000D, 500L);
        priceCurve.put(6000D, 700L);
        return new PriceCalculator(priceCurve, new RequesterFactoryDistanceConsole().create());
    }
}
