// a * b + c * d

import price.DeliveryPriceCalculator;
import price.facrories.functions.DistanceFactoryPriceCalculator;
import price.facrories.functions.WeightFactoryPriceCalculator;
import price.money.Dollar;
import request.messaging.MessengerConnectRequester;

public class Main {
    public static void main(String[] args) {

        var deliveryPriceCalculator = new DeliveryPriceCalculator(
                new DistanceFactoryPriceCalculator(),
                new WeightFactoryPriceCalculator()
        );

        var messengerConnect = new MessengerConnectRequester<>(
                "Final price is ",
                System.out,
                deliveryPriceCalculator,
                (m, v) -> m + new Dollar(v).asString()
        );

        messengerConnect.request();
    }
}
