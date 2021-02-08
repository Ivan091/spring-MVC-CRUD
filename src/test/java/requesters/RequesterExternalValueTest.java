package requesters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class RequesterExternalValueTest extends RequestTester {

    @Test
    void requestValues() {
        var str = "123 qwe plm";
        var requester = createBasicRequest(str);
        Assertions.assertEquals("123", requester.request());
        Assertions.assertEquals("qwe", requester.request());
        Assertions.assertEquals("plm", requester.request());
    }

    @Test
    void requestEmpty() {
        var str = "";
        var requester = createBasicRequest(str);
        Assertions.assertThrows(NoSuchElementException.class, requester::request);
    }
}