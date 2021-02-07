package request;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;

public interface Requester<R> {
    R request() throws RequestFailureException, RequestInterruptedException;
}
