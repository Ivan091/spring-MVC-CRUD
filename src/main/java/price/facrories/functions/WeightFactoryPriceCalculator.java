package price.facrories.functions;

import price.PriceCalculator;

import java.util.TreeMap;
import java.util.function.Function;

public class WeightFactoryPriceCalculator implements FunctionFactory<Double, Long> {
    @Override
    public Function<Double, Long> create() {
        var priceCurve = new TreeMap<Double, Long>();
        priceCurve.put(0D, 1000L);
        priceCurve.put(100D, 2000L);
        priceCurve.put(400D, 5000L);
        return new PriceCalculator(priceCurve);
    }
}
