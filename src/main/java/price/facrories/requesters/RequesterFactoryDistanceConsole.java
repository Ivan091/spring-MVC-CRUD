package price.facrories.requesters;

import messengers.MessengerOutput;
import request.Requester;
import request.RequesterExternalValue;
import request.messaging.MessageRequester;
import request.parsing.ParserStringToDouble;
import request.validation.ValidatorRequest;

import java.util.Scanner;

public class RequesterFactoryDistanceConsole implements RequesterFactory<Double> {

    @Override
    public Requester<Double> create() {
        return
                new ValidatorRequest<>(
                        new ValidatorRequest<>(
                                new ParserStringToDouble(
                                        new MessageRequester<>(
                                                "Enter distance, km\n",
                                                System.out,
                                                new RequesterExternalValue(new Scanner(System.in))
                                        ),
                                        new MessengerOutput(
                                                "You must enter a number\n",
                                                System.out)
                                ),
                                (x -> x > 0),
                                new MessengerOutput(
                                        "Distance cannot be less than 0\n",
                                        System.out)
                        ),
                        (x -> x <= 10000),
                        new MessengerOutput(
                                "We don't deliver products so far (10000 max)\n",
                                System.out)
                );
    }
}
