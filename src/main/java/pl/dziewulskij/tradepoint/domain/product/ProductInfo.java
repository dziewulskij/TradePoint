package pl.dziewulskij.tradepoint.domain.product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface ProductInfo {

    UUID getBusinessId();

    String getName();

    String getUnit();

    BigDecimal getNewestPrice();

    LocalDate getPriceSetOnDay();

}
