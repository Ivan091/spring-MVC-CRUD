// a * b + c * d

import price.DeliveryPriceCalculator;
import price.facrories.requesters.DistanceFactoryPriceCalculator;
import price.facrories.requesters.WeightFactoryPriceCalculator;
import price.money.Dollar;
import request.messaging.MessengerConnectRequester;

public class Main {
    public static void main(String[] args) {

        new MessengerConnectRequester<>(
                "Final price is ",
                System.out,
                new DeliveryPriceCalculator(
                        new DistanceFactoryPriceCalculator(),
                        new WeightFactoryPriceCalculator()
                ),
                (m, v) -> m + new Dollar(v).asString()
        ).request();
    }
}
