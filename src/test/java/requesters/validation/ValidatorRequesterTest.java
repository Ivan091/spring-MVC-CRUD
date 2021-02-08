package requesters.validation;

import messengers.MessengerBasic;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class ValidatorRequesterTest {

    @Test
    void validTest() {
        var messenger = mock(MessengerBasic.class);
        var validator = new ValidatorRequester<>(() -> -1D, x -> x > 0, messenger);
    }
}