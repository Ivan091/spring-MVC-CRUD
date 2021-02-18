package requesters.messaging;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import requesters.Requester;

import java.io.OutputStream;


public class MessengerBeforeRequester<R> extends MessengerRequesterAbstract<R> {

    public MessengerBeforeRequester(String message, OutputStream outputStream, Requester<R> requester) {
        super(message, outputStream, requester);
    }

    @Override
    public R request() throws RequestFailureException, RequestInterruptedException {
        send();
        return requester.request();
    }
}
