package com.home.project.urlConstants;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String field;
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String message;

}
