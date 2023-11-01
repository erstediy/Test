import validations.FieldValidator;

import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TariffController {
    private final Map<Class<?>, FieldValidator<?>> fieldValidators;

    /**
     * parameter get injected by spring or manually, does not matter
     */
    public TariffController(List<FieldValidator<?>> fieldValidators) {
        this.fieldValidators = fieldValidators.stream().collect(Collectors.toMap(FieldValidator::supportedType, Function.identity()));
    }

    private void validate(Object dto) {
        Arrays.stream(dto.getClass().getDeclaredFields()).forEach(x -> {
            x.setAccessible(true);
            try {
                FieldValidator<?> validator = fieldValidators.get(x.getClass());
                if (validator == null) {
                    throw new NoSuchProviderException();
                }
                Object o = x.get(dto);
                x.set(dto, validator.validate(o));
            } catch (IllegalAccessException | NoSuchProviderException ignored) {}
        });
    }
}
