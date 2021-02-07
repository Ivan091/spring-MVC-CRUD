package request.validation;

import messengers.MessengerOutput;
import org.junit.jupiter.api.Test;
import request.RequestTester;

import static org.mockito.Mockito.mock;

class ValidatorRequestTest extends RequestTester {

    @Test
    void validTest() {
        var messenger = mock(MessengerOutput.class);
        var validator = new ValidatorRequest<>(() -> -1D, x -> x > 0, messenger);
    }
}