package requestor;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MessageRequester<R>  extends MessengerOutput implements Requester<R> {

    private final Requester<R> requester;

    public MessageRequester(String message, OutputStream outputStream, Requester<R> requester) {
        super(message, outputStream);
        this.requester = requester;
    }

    @Override
    public String send() {
        try {
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ignored){}
        return message;
    }

    @Override
    public R request() {
        send();
        return requester.request();
    }
}
