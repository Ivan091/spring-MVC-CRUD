package request;

import messengers.Messenger;

public abstract class ErrorMessengerRequesterAbstract<R, I> extends RequesterAbstract<R, I> {

    protected final Messenger errorMessenger;

    public ErrorMessengerRequesterAbstract(Requester<I> requester, Messenger errorMessenger) {
        super(requester);
        this.errorMessenger = errorMessenger;
    }
}
