package requesters.parsing;

import messengers.MessengerBasic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requesters.RequestTester;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

class ParserStringToDoubleTest extends RequestTester {

    MessengerBasic error = mock(MessengerBasic.class);

    @Test
    void requestNoErrorIfNumber() {
        var parser = new ParserStringToDouble(createBasicRequest("123"), error);
        //parser.request();
        verify(error, times(0)).send();
    }

    @Test
    void requestOneErrorAfterSuccess() {
        var parser = new ParserStringToDouble(createBasicRequest("asd 123"), error);
        //parser.request();
        verify(error, times(1)).send();
        Assertions.assertThrows(NoSuchElementException.class, parser::request);
    }
}