package com.swifty.webapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@RequiredArgsConstructor @AllArgsConstructor
public class ApiResponse<T> {
	@NonNull private Integer statusCode;
	@NonNull private String message;
	private T data;
}