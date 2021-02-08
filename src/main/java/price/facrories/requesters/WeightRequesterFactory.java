package price.facrories.requesters;

import messengers.MessengerBasic;
import request.Requester;
import request.messaging.MessengerBeforeRequester;
import request.parsing.ParserStringToDouble;
import request.validation.ValidatorRequester;

public class WeightRequesterFactory extends RequesterFactoryAbstract<String, Double> {

    public WeightRequesterFactory(RequesterFactory<String> innerFactory) {
        super(innerFactory);
    }

    @Override
    public Requester<Double> create() {
        return
                new ValidatorRequester<>(
                        new ValidatorRequester<>(
                                new ParserStringToDouble(
                                        new MessengerBeforeRequester<>(
                                                "Enter weight, kg\n",
                                                System.out,
                                                innerFactory.create()
                                        ),
                                        new MessengerBasic(
                                                "You must enter a number\n",
                                                System.out)
                                ),
                                (x -> x > 0),
                                new MessengerBasic(
                                        "Weight cannot be less than 0\n",
                                        System.out)
                        ),
                        (x -> x <= 500),
                        new MessengerBasic(
                                "We don't deliver so heavy products (500 max)\n",
                                System.out)
                );
    }
}
