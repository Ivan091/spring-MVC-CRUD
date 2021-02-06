package requestor;

public interface Validator<T> {
    boolean isValid(T value);
}
