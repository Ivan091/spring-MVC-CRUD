package price.facrories;

import requesters.Requester;

public interface RequesterFactory<R> {
    Requester<R> create();
}
