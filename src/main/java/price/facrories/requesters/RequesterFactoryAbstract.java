package price.facrories.requesters;

import requesters.Requester;

public abstract class RequesterFactoryAbstract<I, R> implements RequesterFactory<R> {

    protected final Requester<I> innerRequester;

    public RequesterFactoryAbstract(Requester<I> innerRequester) {
        this.innerRequester = innerRequester;
    }
}
