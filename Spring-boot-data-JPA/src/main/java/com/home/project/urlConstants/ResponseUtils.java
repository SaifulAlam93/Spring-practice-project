package com.home.project.urlConstants;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ResponseUtils {
	private ResponseUtils(){
		
	}

	public static  List<ErrorResponseDto> getCustomError(BindingResult result){
		List<ErrorResponseDto> errors = new ArrayList<>();
		ErrorResponseDto customError = null;

		for (FieldError error: result.getFieldErrors()){
			customError = new ErrorResponseDto(error.getField(),error.getDefaultMessage());
			errors.add(customError);
		}
		return errors;
	}

	public static Response getFailResponse(BindingResult bindingResults, String message){
		return Response.builder()
				.timestamp(new Date().getTime())
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.status(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.message(message)
				.errors(ResponseUtils.getCustomError(bindingResults))
				.totalCount(bindingResults.getErrorCount())
				.build();
	}

	public static Response getFailResponse(HttpStatus httpStatus, String message){
		return Response.builder()
				.timestamp(new Date().getTime())
				.statusCode(httpStatus.value())
				.status(httpStatus.getReasonPhrase())
				.message(message)
				.build();
	}

	public static Response getSuccessResponse(HttpStatus httpStatus, Object content, String message){
		return Response.builder()
				.timestamp(new Date().getTime())
				.statusCode(httpStatus.value())
				.status(httpStatus.getReasonPhrase())
				.message(message)
				.content(content)
				.build();
	}

	public static Response getSuccessResponse(HttpStatus httpStatus, Object content, long totalCount, String message){
		return Response.builder()
				.timestamp(new Date().getTime())
				.statusCode(httpStatus.value())
				.status(httpStatus.getReasonPhrase())
				.message(message)
				.totalCount(totalCount)
				.content(content)
				.build();
	}

	public static Response getSuccessResponse(HttpStatus httpStatus, Object content, long totalCount, int numberOfElements, String message){
		return Response.builder()
				.timestamp(new Date().getTime())
				.statusCode(httpStatus.value())
				.status(httpStatus.getReasonPhrase())
				.message(message)
				.totalCount(totalCount)
				.numberOfElements(numberOfElements)
				.content(content)
				.build();
	}

	public static String getPageNameFromBreadcrumb(String uiScreen) {
		if (uiScreen == null) {
			return "";
		}
		String breadCrumb[] = uiScreen.split(">");
		return breadCrumb[breadCrumb.length - 1];
	}
}
