package price.facrories.functions;

import price.PriceCalculator;
import price.facrories.requesters.RequesterFactoryWeightConsole;

import java.util.TreeMap;
import java.util.function.Function;

public class WeightFactoryPriceCalculator implements FunctionFactory<Void, Long> {
    @Override
    public Function<Void, Long> create() {
        var priceCurve = new TreeMap<Double, Long>();
        priceCurve.put(0D, 1000L);
        priceCurve.put(100D, 2000L);
        priceCurve.put(400D, 5000L);
        return new PriceCalculator(priceCurve, new RequesterFactoryWeightConsole().create());
    }
}
