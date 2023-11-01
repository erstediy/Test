package validations;

import domain.exceptions.PriceValidationException;
import org.springframework.stereotype.Service;
import ru.mvideo.b4p.billing.redistribution.openapi.model.TariffParameters;

import java.math.BigDecimal;

@Service("TariffParameters")
public class TariffParametersValidator implements FieldValidator<TariffParameters> {

  @Override
  public TariffParameters validate(Object o) {
    TariffParameters parameters = (TariffParameters) o;
      BigDecimal priceS = parameters.getPriceS();
    BigDecimal priceM = parameters.getPriceM();
    BigDecimal priceL = parameters.getPriceL();

    if (priceS == null || priceM == null || priceL == null) {
      throw new PriceValidationException(parameters);
    }
    if (!(priceS.scale() == 0 && priceM.scale() == 0 && priceL.scale() == 0)) {
      throw new PriceValidationException(parameters);
    }
    System.out.println("Success");
    return parameters;
  }
}