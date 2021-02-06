package request.validation;

import messengers.Messenger;
import request.messaging.RequesterMessengerAbstract;
import request.Requester;

import java.util.function.Predicate;

public class ValidatorRequest<R> extends RequesterMessengerAbstract<R, R> implements Validator<R> {

    private final Predicate<R> predicate;

    public ValidatorRequest(Requester<R> requester, Predicate<R> predicate, Messenger errorMessenger) {
        super(requester, errorMessenger);
        this.predicate = predicate;
    }

    @Override
    public R request() {
        var requestValue = requester.request();
        if (predicate.test(requestValue)){
            return requestValue;
        } else {
            errorMessenger.send();
            return requester.request();
        }
    }

    @Override
    public boolean isValid(R value) {
        return predicate.test(value);
    }
}
