package request.parsing;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import messengers.Messenger;
import request.ErrorMessengerRequesterAbstract;
import request.Requester;

public class ParserStringToDouble extends ErrorMessengerRequesterAbstract<String, Double> {

    public ParserStringToDouble(Requester<String> requester, Messenger errorMessenger) {
        super(requester, errorMessenger);
    }

    @Override
    public Double request() throws RequestFailureException, RequestInterruptedException {
        try {
            return Double.parseDouble(requester.request());
        } catch (NumberFormatException e) {
            throw new RequestFailureException(errorMessenger.send());
        }
    }
}
