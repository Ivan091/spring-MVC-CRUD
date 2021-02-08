package price.facrories.requesters;

import requesters.Requester;

public interface RequesterFactory<R> {
    Requester<R> create();
}
