package price.facrories.functions;

import price.facrories.Factory;

import java.util.function.Function;

public interface FunctionFactory<T, R> extends Factory<Function<T, R>> {
    Function<T, R> create();
}
