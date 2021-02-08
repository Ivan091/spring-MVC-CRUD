package request.validation;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import messengers.Messenger;
import request.Requester;
import request.RequesterFailureMessengerAbstract;

import java.util.function.Predicate;

public class ValidatorRequester<R> extends RequesterFailureMessengerAbstract<R, R> {

    private final Predicate<R> predicate;

    public ValidatorRequester(Requester<R> requester, Predicate<R> predicate, Messenger errorMessenger) {
        super(requester, errorMessenger);
        this.predicate = predicate;
    }

    @Override
    public R request() throws RequestFailureException, RequestInterruptedException {
        var requestValue = requester.request();
        if (predicate.test(requestValue)) {
            return requestValue;
        } else {
            throw new RequestFailureException(errorMessenger.send());
        }
    }
}
