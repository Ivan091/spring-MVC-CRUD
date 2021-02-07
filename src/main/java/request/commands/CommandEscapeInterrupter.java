package request.commands;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import request.Requester;
import request.RequesterAbstract;

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
