package request.messaging;

import messengers.Messenger;
import request.Requester;
import request.RequesterAbstract;

public abstract class RequesterMessengerAbstract<R, I> extends RequesterAbstract<R, I> {

    protected final Messenger errorMessenger;

    public RequesterMessengerAbstract(Requester<I> requester, Messenger errorMessenger) {
        super(requester);
        this.errorMessenger = errorMessenger;
    }
}
