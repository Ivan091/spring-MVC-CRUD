package price.facrories.requesters;

import exceptions.RequesterCreationException;
import requesters.Requester;

public interface RequesterFactory<R> {
    Requester<R> create() throws RequesterCreationException;
}
