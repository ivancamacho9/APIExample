package com.rest.api.error;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class ErrorResponse {

    private String response;
    private String errorMessage;

}
