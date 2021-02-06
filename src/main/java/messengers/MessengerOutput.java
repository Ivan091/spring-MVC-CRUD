package messengers;

import messengers.Messenger;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MessengerOutput implements Messenger {

    protected final String message;

    protected final OutputStream outputStream;

    public MessengerOutput(String message, OutputStream outputStreamWriter) {
        this.message = message;
        this.outputStream = outputStreamWriter;
    }

    @Override
    public String send() {
        try {
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ignored){}
        return message;
    }
}
