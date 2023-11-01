package validations;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("UUID")
public class UUIDValidator implements FieldValidator<UUID> {

    @Override
    public UUID validate(Object o) {
        UUID uuid = (UUID) o;
        return uuid;
    }
}
