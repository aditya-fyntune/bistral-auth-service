package com.bistral.app.bistral_auth_service.dtos;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Builder
public class PageResponse <T>{

    private List<T> data;
}
