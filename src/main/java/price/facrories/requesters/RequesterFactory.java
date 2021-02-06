package price.facrories.requesters;

import price.facrories.Factory;
import request.Requester;

public interface RequesterFactory<R> extends Factory<Requester<R>> {
    Requester<R> create();
}
