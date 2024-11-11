package com.example.spring.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ProductResponseDto {
    private HttpStatus status;
    private String message;
}
