package validations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("String")
@RequiredArgsConstructor
public class StringValidator implements FieldValidator<String> {

    @Override
    public String validate(Object o) {
        String string = (String) o;
        if(string.isBlank()) {
            System.out.println("BLANK");
        }
        return string;
    }
}
