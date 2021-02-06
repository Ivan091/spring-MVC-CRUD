// a * b + c * d

import price.DeliveryPriceCalculator;
import price.facrories.functions.DistanceFactoryPriceCalculator;
import price.facrories.functions.WeightFactoryPriceCalculator;
import price.facrories.requesters.RequesterFactoryDistanceConsole;
import price.facrories.requesters.RequesterFactoryWeightConsole;

public class Main {
    public static void main(String[] args) {
        var deliveryPriceCalculator = new DeliveryPriceCalculator(
                new RequesterFactoryWeightConsole(),
                new RequesterFactoryDistanceConsole(),
                new WeightFactoryPriceCalculator(),
                new DistanceFactoryPriceCalculator());
    }
}
