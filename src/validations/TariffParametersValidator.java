package validations;

import domain.exceptions.PriceValidationException;
import org.springframework.stereotype.Service;

import model.TariffParameters;
import ru.mvideo.b4p.billing.redistribution.openapi.model.TariffParameters;

import java.math.BigDecimal;

@Service("TariffParameters")
public class TariffParametersValidator implements FieldValidator<TariffParameters> {

  @Override
  public TariffParameters validateInternal(TariffParameters o) {
    BigDecimal priceS = o.getPriceS();
    BigDecimal priceM = o.getPriceM();
    BigDecimal priceL = o.getPriceL();

    if (priceS == null || priceM == null || priceL == null) {
      throw new PriceValidationException(o);
    }
    if (!(priceS.scale() == 0 && priceM.scale() == 0 && priceL.scale() == 0)) {
      throw new PriceValidationException(o);
    }
    System.out.println("Success");
    return o;
  }
}