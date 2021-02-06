package requestor;

public abstract class RequesterMessengerAbstract<R, I> extends RequesterAbstract<R, I> {

    protected final Messenger errorMessenger;

    public RequesterMessengerAbstract(Requester<I> requester, Messenger errorMessenger) {
        super(requester);
        this.errorMessenger = errorMessenger;
    }
}
