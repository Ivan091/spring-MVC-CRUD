package request.validation;

import org.junit.jupiter.api.Test;
import request.RequestTester;

class ValidatorRequestTest extends RequestTester {

    @Test
    void validTest() {
        var validator = new ValidatorRequest<>(() -> 10d, x -> x > 0, () -> "error");
        validator.request();
    }
}