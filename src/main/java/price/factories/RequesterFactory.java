package price.factories;

import requesters.Requester;


public interface RequesterFactory<R> {

    Requester<R> create();
}
