package validations;

public interface FieldValidator<T> {

     default T validate(Object o) {
          return validateInternal(supportedType().cast(o));
     }

     T validateInternal(T value);

     Class<T> supportedType();
}
