package price.money;

public class Dollar extends MoneyAbstract {
    public Dollar(long moneyInMinValues) {
        super(moneyInMinValues);
    }

    @Override
    public String asString() {
        var sb = new StringBuilder(moneyInMinValues.toString());
        while (sb.length() < 3) {
            sb.insert(0, '0');
        }
        sb.insert(sb.length() - 2, ',');
        sb.insert(0, '$');
        return sb.toString();
    }
}
