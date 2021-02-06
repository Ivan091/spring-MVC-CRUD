package requestor;

public class ParserStringToDouble extends RequesterMessengerAbstract<Double, String> {

    public ParserStringToDouble(Requester<String> requester, Messenger errorMessenger) {
        super(requester, errorMessenger);
    }

    @Override
    public Double request() {
        try {
            return Double.parseDouble(requester.request());
        } catch (NumberFormatException e){
            errorMessenger.send();
            return this.request();
        }
    }
}
