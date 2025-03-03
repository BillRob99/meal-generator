package mealgenerator.transformer;

public interface Transformer<T, U> {
    U transform(T source);
}
