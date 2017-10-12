package mappable;

import java.util.function.Function;

/**
 * Created by msav on 10/11/2017.
 */
public class Mappable<T> {

    private final T value;

    private Mappable(T value) {
        this.value = value;
    }

    public static <T> Mappable<T> of(T value) {
        return new Mappable<>(value);
    }

    public T get() {
        return value;
    }

    public <U> Mappable<U> map(Function<? super T, ? extends U> mapper) {
        return Mappable.of(mapper.apply(value));
    }
}
