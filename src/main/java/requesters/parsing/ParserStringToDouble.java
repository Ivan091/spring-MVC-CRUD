package requesters.parsing;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import messengers.Messenger;
import requesters.Requester;
import requesters.RequesterFailureMessengerAbstract;

public class ParserStringToDouble extends RequesterFailureMessengerAbstract<String, Double> {

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
