package price.money;

public abstract class MoneyAbstract implements Money {

    protected final Long moneyInMinValues;

    public MoneyAbstract(long moneyInMinValues) {
        this.moneyInMinValues = moneyInMinValues;
    }
}
