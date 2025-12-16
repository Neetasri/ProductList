package com.example.Product.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private  String apiPath;
    private HttpStatus HttpStatus;
    private String errorMessage;
    private LocalDateTime errorTime;
}
