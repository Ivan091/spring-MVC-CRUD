package request.messaging;

import request.Requester;

import java.io.OutputStream;

public class MessengerBeforeRequester<R> extends MessengerRequesterAbstract<R> {

    public MessengerBeforeRequester(String message, OutputStream outputStream, Requester<R> requester) {
        super(message, outputStream, requester);
    }

    @Override
    public R request() {
        send();
        return requester.request();
    }
}
