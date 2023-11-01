import validations.FieldValidator;

import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Map;

public class TariffController {
    private final Map<String, FieldValidator<?>> fieldValidators;

    public TariffController(Map<String, FieldValidator<?>> fieldValidators) {
        this.fieldValidators = fieldValidators;
    }

    private void validate(Object dto) {
        Arrays.stream(dto.getClass().getDeclaredFields()).forEach(x -> {
            x.setAccessible(true);
            try {
                FieldValidator<?> validator = fieldValidators.get(x.getType().getSimpleName());
                if (validator == null) {
                    throw new NoSuchProviderException();
                }
                x.set(dto, validator.validate(validator.supportedType().cast(x.get(dto))));
            } catch (IllegalAccessException | NoSuchProviderException ignored) {}
        });
    }
}
