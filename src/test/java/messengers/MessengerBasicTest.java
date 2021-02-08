package messengers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class MessengerBasicTest {

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    String s = "";

    @Test
    void sendEmpty() {
        s = "";
        new MessengerBasic(s, os).send();
        Assertions.assertEquals(s, os.toString());
    }

    @Test
    void sendText() {
        s = "Some text";
        new MessengerBasic(s, os).send();
        Assertions.assertEquals(s, os.toString());
    }

    @Test
    void sendCharacters() {
        s = "qwertyuiop[]asdfghjkl;'zxcvbnm,./1234567890-=";
        new MessengerBasic(s, os).send();
        Assertions.assertEquals(s, os.toString());
    }
}