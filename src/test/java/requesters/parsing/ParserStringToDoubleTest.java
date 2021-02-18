package requesters.parsing;

import exceptions.RequestFailureException;
import messengers.Messenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ParserStringToDoubleTest {
    Messenger error = mock(Messenger.class);

    @Test
    void requestNoErrorIfNumber() {
        var parser = new ParserStringToDouble(() -> "213.123", error);
        Assertions.assertDoesNotThrow(
                () -> Assertions.assertEquals(213.123, parser.request())
        );
        verify(error, times(0)).send();
    }

    @Test
    void requestOneErrorAfterSuccess() {
        var parser = new ParserStringToDouble(() -> "asd", error);
        verify(error, times(1)).send();
        Assertions.assertThrows(RequestFailureException.class, parser::request);
    }
}