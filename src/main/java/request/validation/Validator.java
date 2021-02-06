package request.validation;

public interface Validator<T> {
    boolean isValid(T value);
}
