package request.messaging;

import messengers.MessengerOutput;
import request.Requester;

import java.io.OutputStream;

public abstract class MessengerRequesterAbstract<R> extends MessengerOutput implements Requester<R> {

    protected final Requester<R> requester;

    public MessengerRequesterAbstract(String message, OutputStream outputStream, Requester<R> requester) {
        super(message, outputStream);
        this.requester = requester;
    }
}
