package price;

import price.facrories.requesters.RequesterFactory;
import request.Requester;

public class DeliveryPriceCalculator implements Requester<Long> {

    private final Requester<Long> weightPrice;
    private final Requester<Long> distancePrice;

    public DeliveryPriceCalculator(Requester<Long> weightPrice,
                                   Requester<Long> distancePrice) {
        this.weightPrice = weightPrice;
        this.distancePrice = distancePrice;
    }

    public DeliveryPriceCalculator(RequesterFactory<Long> weightPriceFactory,
                                   RequesterFactory<Long> distancePriceFactory) {
        this.weightPrice = weightPriceFactory.create();
        this.distancePrice = distancePriceFactory.create();
    }

    @Override
    public Long request() {
        return weightPrice.request() + distancePrice.request();
    }
}
