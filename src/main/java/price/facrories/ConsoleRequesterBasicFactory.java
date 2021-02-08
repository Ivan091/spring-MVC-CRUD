package price.facrories;

import requesters.Requester;
import requesters.RequesterExternalValue;
import requesters.commands.CommandEscapeInterrupter;

import java.util.Scanner;

public class ConsoleRequesterBasicFactory implements RequesterFactory<String> {
    @Override
    public Requester<String> create() {
        return
                new CommandEscapeInterrupter(
                        new RequesterExternalValue(new Scanner(System.in))
                );
    }
}
