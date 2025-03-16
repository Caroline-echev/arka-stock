package com.project_arka.stock.data;

import com.project_arka.stock.domain.model.Address;
import com.project_arka.stock.ports.driving.http.dto.request.AddressRequest;


    public class AddressData {

        public static AddressRequest getAddressRequest() {
            return AddressRequest.builder()
                    .street("Calle 26 #85-50")
                    .city("Bogotá")
                    .state("Cundinamarca")
                    .country("Colombia")
                    .nomenclature("#85-50")
                    .observation("Tercer piso, oficina 302")
                    .build();
        }



        public static String getAddress() {
            return "Calle 26 #85-50, Bogotá, Cundinamarca, Colombia, #85-50, Tercer piso, oficina 302";
        }
    }


