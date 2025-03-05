package com.project_arka.stock.ports.driven.jpa.mysql.mapper;

import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.BrandEntity;
import org.mapstruct.Mapper;

import static com.project_arka.stock.ports.driven.jpa.mysql.util.AdapterConstants.SPRING_MAPPER;

@Mapper(componentModel = SPRING_MAPPER)
public interface IBrandEntityMapper {
    Brand brandEntityToBrand(BrandEntity brandEntity);

    BrandEntity brandToBrandEntity(Brand brand);
}

