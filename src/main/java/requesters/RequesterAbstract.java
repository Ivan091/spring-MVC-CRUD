package requesters;

public abstract class RequesterAbstract<I, R> implements Requester<R> {

    protected final Requester<I> requester;

    public RequesterAbstract(Requester<I> requester) {
        this.requester = requester;
    }
}
