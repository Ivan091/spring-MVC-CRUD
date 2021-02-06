import messengers.MessengerOutput;
import request.messaging.MessageRequester;
import request.parsing.ParserStringToDouble;
import request.*;
import request.validation.ValidatorRequest;

import java.util.Scanner;


// a * b + c * d

public class Main {
    public static void main(String[] args){

        var a =
        new ValidatorRequest<>(
                new ValidatorRequest<>(
                        new ParserStringToDouble(
                                new MessageRequester<>(
                                        "Enter double value\n",
                                        System.out,
                                        new RequesterExternalValue(new Scanner(System.in))
                                ),
                                new MessengerOutput(
                                        "Value not Valid\n",
                                        System.out)
                        ),
                        (x -> x > 0),
                        new MessengerOutput(
                                "Value cannot be less than 0\n",
                                System.out)
                ),
                (x -> x < 10000),
                new MessengerOutput(
                        "Value cannot be bigger than 10000\n",
                        System.out)
        );

        System.out.println(a.request());
    }
}
