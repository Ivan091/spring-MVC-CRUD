package request.validation;

import messengers.MessengerBasic;
import org.junit.jupiter.api.Test;
import request.RequestTester;

import static org.mockito.Mockito.mock;

class ValidatorRequesterTest extends RequestTester {

    @Test
    void validTest() {
        var messenger = mock(MessengerBasic.class);
        var validator = new ValidatorRequester<>(() -> -1D, x -> x > 0, messenger);
    }
}