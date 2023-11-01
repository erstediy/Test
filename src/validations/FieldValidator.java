package validations;

public interface FieldValidator<T> {
     T validate(T value);

     Class<T> supportedType();
}
