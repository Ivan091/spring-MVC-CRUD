package request;

public abstract class RequesterAbstract<R, I> implements Requester<R> {
    protected final Requester<I> requester;

    public RequesterAbstract(Requester<I> requester) {
        this.requester = requester;
    }
}
