package messengers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class MessengerOutputTest {

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    String s = "";

    @Test
    void sendEmpty() {
        s = "";
        new MessengerOutput(s, os).send();
        Assertions.assertEquals(s, os.toString());
    }

    @Test
    void sendText() {
        s = "Some text";
        new MessengerOutput(s, os).send();
        Assertions.assertEquals(s, os.toString());
    }

    @Test
    void sendCharacters() {
        s = "qwertyuiop[]asdfghjkl;'zxcvbnm,./1234567890-=";
        new MessengerOutput(s, os).send();
        Assertions.assertEquals(s, os.toString());
    }
}