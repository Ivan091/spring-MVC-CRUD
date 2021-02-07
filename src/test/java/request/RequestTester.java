package request;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RequestTester {

    public RequesterExternalValue createBasicRequest(String str) {
        return new RequesterExternalValue(
                new Scanner(
                        new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8))
                )
        );
    }
}
