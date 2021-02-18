import exceptions.RequestFailureException;
import exceptions.RequestInterruptedException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import price.factories.DeliveryPriceCalculatorFactory;

public class Main {
    public static void main(String[] args) throws RequestFailureException {
        new Main().run();
    }

    public void run() throws RequestFailureException {

        var appContext = new ClassPathXmlApplicationContext("spring-config.xml");
        try {
            appContext.getBean(DeliveryPriceCalculatorFactory.class).create().request();
        } catch (RequestInterruptedException e) {
            System.out.print("bye");
        }
    }
}
