package price.facrories.requesters;

import exceptions.RequesterCreationException;
import messengers.MessengerBasic;
import requesters.Requester;
import requesters.messaging.MessengerBeforeRequester;
import requesters.parsing.ParserStringToDouble;
import requesters.validation.ValidatorRequester;

public class WeightRequesterFactory extends RequesterFactoryAbstract<String, Double> {

    public WeightRequesterFactory(RequesterFactory<String> innerFactory) {
        super(innerFactory);
    }

    @Override
    public Requester<Double> create() throws RequesterCreationException {
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
