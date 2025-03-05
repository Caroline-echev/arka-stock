package com.project_arka.stock.ports.driving.http.mapper;


import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.ports.driving.http.dto.request.BrandRequest;
import com.project_arka.stock.ports.driving.http.dto.response.BrandResponse;
import org.mapstruct.Mapper;

import static com.project_arka.stock.ports.driving.http.util.ApplicationConstants.SPRING_MAPPING;


@Mapper(componentModel = SPRING_MAPPING)
public interface IBrandMapperDto {
   BrandResponse brandToBrandResponse(Brand brand);
   Brand brandToBrandRequest(BrandRequest brandRequest);
}
