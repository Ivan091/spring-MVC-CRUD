package requesters.commands;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import requesters.Requester;
import requesters.RequesterAbstract;

public class CommandEscapeInterrupter extends RequesterAbstract<String, String> {

    public CommandEscapeInterrupter(Requester<String> requester) {
        super(requester);
    }

    @Override
    public String request() throws RequestFailureException, RequestInterruptedException {
        var request = requester.request();
        if (request.equalsIgnoreCase("q")) {
            throw new RequestInterruptedException();
        }
        return request;
    }
}
