package price.facrories.requesters;

import messengers.MessengerBasic;
import request.Requester;
import request.messaging.MessengerBeforeRequester;
import request.parsing.ParserStringToDouble;
import request.validation.ValidatorRequester;

public class DistanceRequesterFactory extends RequesterFactoryAbstract<String, Double> {

    public DistanceRequesterFactory(RequesterFactory<String> innerFactory) {
        super(innerFactory);
    }

    @Override
    public Requester<Double> create() {
        return
                new ValidatorRequester<>(
                        new ValidatorRequester<>(
                                new ParserStringToDouble(
                                        new MessengerBeforeRequester<>(
                                                "Enter distance, km\n",
                                                System.out,
                                                innerFactory.create()
                                        ),
                                        new MessengerBasic(
                                                "You must enter a number\n",
                                                System.out)
                                ),
                                (x -> x > 0),
                                new MessengerBasic(
                                        "Distance cannot be less than 0\n",
                                        System.out)
                        ),
                        (x -> x <= 10000),
                        new MessengerBasic(
                                "We don't deliver products so far (10000 max)\n",
                                System.out)
                );
    }
}
