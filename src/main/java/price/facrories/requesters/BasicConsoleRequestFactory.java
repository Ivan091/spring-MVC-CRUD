package price.facrories.requesters;

import request.Requester;
import request.RequesterExternalValue;
import request.commands.CommandEscapeInterrupter;

import java.util.Scanner;

public class BasicConsoleRequestFactory implements RequesterFactory<String> {
    @Override
    public Requester<String> create() {
        return
                new CommandEscapeInterrupter(
                        new RequesterExternalValue(new Scanner(System.in))
                );
    }
}
