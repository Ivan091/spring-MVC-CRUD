package price;

import java.util.List;
import java.util.SortedMap;
import java.util.function.Function;

public class PriceCalculator implements Function<Double, Long> {

    private final SortedMap<Double, Long> priceCurve;

    public PriceCalculator(SortedMap<Double, Long> priceCurve) {
        this.priceCurve = priceCurve;
    }

    @Override
    public Long apply(Double aDouble) {
        var result = 0L;
        var it = priceCurve.entrySet().iterator();
        var curve = List.copyOf(priceCurve.entrySet());
        for (var i = 0; i < curve.size() - 1; i++) {
            var current = curve.get(i);
            var next = curve.get(i + 1);
            if (aDouble > next.getKey()) {
                result += Math.round((next.getKey() - current.getKey()) * current.getValue());
            } else {
                result += Math.round((aDouble - current.getKey()) * current.getValue());
            }
        }

        var last = curve.get(curve.size() - 1);
        if (aDouble > last.getKey()) {
            result += Math.round((aDouble - last.getKey()) * last.getValue());
        }
        return result;
    }
}
