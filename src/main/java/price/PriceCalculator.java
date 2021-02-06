package price;

import request.Requester;

import java.util.List;
import java.util.SortedMap;

public class PriceCalculator implements Requester<Long> {

    private final SortedMap<Double, Long> priceCurve;
    private final Requester<Double> requester;

    public PriceCalculator(SortedMap<Double, Long> priceCurve,
                           Requester<Double> requester) {
        this.priceCurve = priceCurve;
        this.requester = requester;
    }

    @Override
    public Long request() {
        var value = requester.request();
        var price = 0L;
        var curve = List.copyOf(priceCurve.entrySet());
        for (var i = 0; i < curve.size() - 1; i++) {
            var current = curve.get(i);
            var next = curve.get(i + 1);
            if (value > next.getKey()) {
                price += Math.round((next.getKey() - current.getKey()) * current.getValue());
            } else {
                price += Math.round((value - current.getKey()) * current.getValue());
                break;
            }
        }

        var last = curve.get(curve.size() - 1);
        if (value > last.getKey()) {
            price += Math.round((value - last.getKey()) * last.getValue());
        }
        return price;
    }
}
