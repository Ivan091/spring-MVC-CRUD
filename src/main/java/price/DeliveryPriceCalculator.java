package price;

import price.facrories.functions.FunctionFactory;
import request.Requester;

import java.util.function.Function;

public class DeliveryPriceCalculator implements Requester<Long> {

    private final Function<Void, Long> pricePerKg;
    private final Function<Void, Long> pricePerKm;

    public DeliveryPriceCalculator(Function<Void, Long> pricePerKg,
                                   Function<Void, Long> pricePerKm) {
        this.pricePerKg = pricePerKg;
        this.pricePerKm = pricePerKm;
    }

    public DeliveryPriceCalculator(FunctionFactory<Void, Long> pricePerKgFactory,
                                   FunctionFactory<Void, Long> pricePerKmFactory) {
        this.pricePerKg = pricePerKgFactory.create();
        this.pricePerKm = pricePerKmFactory.create();
    }

    @Override
    public Long request() {
        return pricePerKg.apply(null) + pricePerKm.apply(null);
    }
}
