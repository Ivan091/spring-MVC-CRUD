package requesters;

import messengers.Messenger;


public abstract class RequesterFailureMessengerAbstract<I, R> extends RequesterAbstract<I, R> {

    protected final Messenger errorMessenger;

    public RequesterFailureMessengerAbstract(Requester<I> requester, Messenger errorMessenger) {
        super(requester);
        this.errorMessenger = errorMessenger;
    }
}
