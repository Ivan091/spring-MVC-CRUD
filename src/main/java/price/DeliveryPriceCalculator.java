package price;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import request.Requester;

public class DeliveryPriceCalculator implements Requester<Long> {

    private final Requester<Long> weightPrice;
    private final Requester<Long> distancePrice;

    public DeliveryPriceCalculator(Requester<Long> weightPrice,
                                   Requester<Long> distancePrice) {
        this.weightPrice = weightPrice;
        this.distancePrice = distancePrice;
    }

    @Override
    public Long request() throws RequestFailureException, RequestInterruptedException {
        return weightPrice.request() + distancePrice.request();
    }
}
