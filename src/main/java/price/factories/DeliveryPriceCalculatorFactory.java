package price.factories;

import price.DeliveryPriceCalculator;
import price.money.Dollar;
import requesters.Requester;
import requesters.messaging.MessengerConnectRequester;

public class DeliveryPriceCalculatorFactory implements RequesterFactory<Long> {
    @Override
    public Requester<Long> create() {
        var consoleRequester = new ConsoleRequesterBasicFactory().create();
        return new MessengerConnectRequester<>(
                "Final price is ",
                System.out,
                new DeliveryPriceCalculator(
                        new DistancePriceCalculatorFactory(
                                new DistanceRequesterFactory(
                                        consoleRequester
                                ).create(),
                                new RequesterSCVFileFactory(
                                        getClass().getClassLoader().getResourceAsStream("distance_price.scv")
                                ).create()
                        ).create(),
                        new WeightPriceCalculatorFactory(
                                new WeightRequesterFactory(
                                        consoleRequester
                                ).create(),
                                new RequesterSCVFileFactory(
                                        getClass().getClassLoader().getResourceAsStream("weight_price.scv")
                                ).create()
                        ).create()
                ),
                (m, v) -> m + new Dollar(v).asString()
        );
    }
}
