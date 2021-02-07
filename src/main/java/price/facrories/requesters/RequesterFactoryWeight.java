package price.facrories.requesters;

import messengers.MessengerOutput;
import request.Requester;
import request.messaging.MessengerBeforeRequester;
import request.parsing.ParserStringToDouble;
import request.validation.ValidatorRequest;

public class RequesterFactoryWeight extends RequesterFactoryAbstract<String, Double> {

    public RequesterFactoryWeight(RequesterFactory<String> innerFactory) {
        super(innerFactory);
    }

    @Override
    public Requester<Double> create() {
        return
                new ValidatorRequest<>(
                        new ValidatorRequest<>(
                                new ParserStringToDouble(
                                        new MessengerBeforeRequester<>(
                                                "Enter weight, kg\n",
                                                System.out,
                                                innerFactory.create()
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
