package request.validation;

import messengers.MessengerOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import request.RequestTester;

import static org.mockito.Mockito.*;

class ValidatorRequestTest extends RequestTester {

    @Test
    void validTest() {
        var messenger = mock(MessengerOutput.class);
        var validator = new ValidatorRequest<>(() -> -1D, x -> x > 0, messenger);
        Assertions.assertFalse(validator.test());
        verify(messenger, times(1)).send();
    }
}