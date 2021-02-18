package requesters.repeaters;

import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import requesters.Requester;
import requesters.RequesterAbstract;


public class RepeaterRequest<R> extends RequesterAbstract<R, R> {

    public RepeaterRequest(Requester<R> requester) {
        super(requester);
    }

    @Override
    public R request() throws RequestInterruptedException {
        try {
            return requester.request();
        } catch (RequestFailureException re) {
            return request();
        }
    }
}
