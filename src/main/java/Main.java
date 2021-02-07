// a * b + c * d

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import price.DeliveryPriceCalculator;
import price.facrories.requesters.DistanceFactoryPriceCalculator;
import price.facrories.requesters.WeightFactoryPriceCalculator;
import price.money.Dollar;
import request.messaging.MessengerConnectRequester;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            new MessengerConnectRequester<>(
                    "Final price is ",
                    System.out,
                    new DeliveryPriceCalculator(
                            new DistanceFactoryPriceCalculator().create(),
                            new WeightFactoryPriceCalculator().create()
                    ),
                    (m, v) -> m + new Dollar(v).asString()
            ).request();
        } catch (RequestInterruptedException | RequestFailureException re) {
            System.out.println(re.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
