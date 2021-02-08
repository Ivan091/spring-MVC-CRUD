import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import price.DeliveryPriceCalculator;
import price.facrories.*;
import price.money.Dollar;
import requesters.messaging.MessengerConnectRequester;

public class Main {
    public static void main(String[] args) throws RequestFailureException {
        new Main().run();
    }

    public void run() throws RequestFailureException {
        try {
            new MessengerConnectRequester<>(
                    "Final price is ",
                    System.out,
                    new DeliveryPriceCalculator(
                            new DistancePriceCalculatorFactory(
                                    new DistanceRequesterFactory(
                                            new ConsoleRequesterBasicFactory().create()
                                    ).create(),
                                    new RequesterSCVFileFactory(
                                            getClass().getResourceAsStream("/distance_price.scv")
                                    ).create()
                            ).create(),
                            new WeightPriceCalculatorFactory(
                                    new WeightRequesterFactory(
                                            new ConsoleRequesterBasicFactory().create()
                                    ).create(),
                                    new RequesterSCVFileFactory(
                                            getClass().getResourceAsStream("/weight_price.scv")
                                    ).create()
                            ).create()
                    ),
                    (m, v) -> m + new Dollar(v).asString()
            ).request();
        } catch (RequestInterruptedException e) {
            System.out.print("bye");
        }
    }
}
