package price.facrories.requesters;

public abstract class RequesterFactoryAbstract<I, R> implements RequesterFactory<R> {

    protected final RequesterFactory<I> innerFactory;

    public RequesterFactoryAbstract(RequesterFactory<I> innerFactory) {
        this.innerFactory = innerFactory;
    }
}
