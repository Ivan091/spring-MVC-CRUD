package request.validation;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import messengers.Messenger;
import request.ErrorMessengerRequesterAbstract;
import request.Requester;

import java.util.function.Predicate;

public class ValidatorRequest<R> extends ErrorMessengerRequesterAbstract<R, R> {

    private final Predicate<R> predicate;

    public ValidatorRequest(Requester<R> requester, Predicate<R> predicate, Messenger errorMessenger) {
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
