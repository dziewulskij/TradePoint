package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product;

import ch.qos.logback.core.util.StringUtil;
import io.micrometer.common.util.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.CreateProductRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.CreateProductResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.GetProductResponse;

import java.util.List;

@Mapper(imports = {BusinessId.class, StringUtil.class})
public interface ProductApiMapper {

    @Mapping(source = "name", target = "name", qualifiedByName = "trim")
    @Mapping(source = "unit", target = "unit", qualifiedByName = "blankToNullTrim")
    CreateProductCommand toCreateCommand(CreateProductRequest request);

    CreateProductResponse toResponse(CreateProductResult result);

    GetProductResponse toResponse(GetProductResult result);

    List<GetProductResponse> toResponseList(List<GetProductResult> result);

    @Named("trim")
    default String trim(String value) {
        return value == null ? null : value.trim();
    }

    @Named("blankToNullTrim")
    default String blankToNullTrim(String value) {
        return StringUtils.isBlank(value) ? null : value.trim();
    }
}
