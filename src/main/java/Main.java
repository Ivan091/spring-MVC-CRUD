import exceptions.RequestInterruptedException;
import price.DeliveryPriceCalculator;
import price.facrories.requesters.*;
import price.money.Dollar;
import request.messaging.MessengerConnectRequester;
import request.repeater.RepeaterRequest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            new MessengerConnectRequester<>(
                    "Final price is ",
                    System.out,
                    new DeliveryPriceCalculator(
                            new RepeaterRequest<>(
                                    new DistancePriceCalculatorFactory(
                                            new DistanceRequesterFactory(
                                                    new ConsoleRequesterBasicFactory()
                                            )
                                    ).create()
                            ),
                            new RepeaterRequest<>(
                                    new WeightPriceCalculatorFactory(
                                            new WeightRequesterFactory(
                                                    new ConsoleRequesterBasicFactory()
                                            )
                                    ).create()
                            )
                    ),
                    (m, v) -> m + new Dollar(v).asString()
            ).request();
        } catch (RequestInterruptedException re) {
            System.out.print(re.getMessage());
        } catch (Exception e) {
            System.out.print(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
