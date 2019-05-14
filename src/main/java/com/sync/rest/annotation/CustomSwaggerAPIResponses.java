package com.sync.rest.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success..!!!"),
        @ApiResponse(code = 401, message = "Not authorized..!!!"),
        @ApiResponse(code = 403, message = "Forbidden..!!!"),
        @ApiResponse(code = 404, message = "Not found..!!!") })
public @interface CustomSwaggerAPIResponses {

}
