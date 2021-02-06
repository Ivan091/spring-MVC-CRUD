package price.facrories.requesters;

import messengers.MessengerOutput;
import request.Requester;
import request.RequesterExternalValue;
import request.messaging.MessageRequester;
import request.parsing.ParserStringToDouble;
import request.validation.ValidatorRequest;

import java.util.Scanner;

public class RequesterFactoryWeightConsole implements RequesterFactory<Double> {

    @Override
    public Requester<Double> create() {
        return
                new ValidatorRequest<>(
                        new ValidatorRequest<>(
                                new ParserStringToDouble(
                                        new MessageRequester<>(
                                                "Enter weight, kg\n",
                                                System.out,
                                                new RequesterExternalValue(new Scanner(System.in))
                                        ),
                                        new MessengerOutput(
                                                "You must enter a number\n",
                                                System.out)
                                ),
                                (x -> x > 0),
                                new MessengerOutput(
                                        "Weight cannot be less than 0\n",
                                        System.out)
                        ),
                        (x -> x <= 500),
                        new MessengerOutput(
                                "We don't deliver so heavy products (500 max)\n",
                                System.out)
                );
    }
}
