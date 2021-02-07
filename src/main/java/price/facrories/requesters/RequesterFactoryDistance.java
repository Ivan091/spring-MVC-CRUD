package price.facrories.requesters;

import messengers.MessengerOutput;
import request.Requester;
import request.messaging.MessengerBeforeRequester;
import request.parsing.ParserStringToDouble;
import request.validation.ValidatorRequest;

public class RequesterFactoryDistance extends RequesterFactoryAbstract<String, Double> {

    public RequesterFactoryDistance(RequesterFactory<String> innerFactory) {
        super(innerFactory);
    }

    @Override
    public Requester<Double> create() {
        return
                new ValidatorRequest<>(
                        new ValidatorRequest<>(
                                new ParserStringToDouble(
                                        new MessengerBeforeRequester<>(
                                                "Enter distance, km\n",
                                                System.out,
                                                innerFactory.create()
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
