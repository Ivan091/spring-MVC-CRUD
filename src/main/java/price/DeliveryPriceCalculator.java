package price;

import price.facrories.requesters.RequesterFactory;
import request.Requester;

public class DeliveryPriceCalculator implements Requester<Long> {

    private final Requester<Long> pricePerKg;
    private final Requester<Long> pricePerKm;

    public DeliveryPriceCalculator(Requester<Long> pricePerKg,
                                   Requester<Long> pricePerKm) {
        this.pricePerKg = pricePerKg;
        this.pricePerKm = pricePerKm;
    }

    public DeliveryPriceCalculator(RequesterFactory<Long> pricePerKgFactory,
                                   RequesterFactory<Long> pricePerKmFactory) {
        this.pricePerKg = pricePerKgFactory.create();
        this.pricePerKm = pricePerKmFactory.create();
    }

    @Override
    public Long request() {
        return pricePerKg.request() + pricePerKm.request();
    }
}
