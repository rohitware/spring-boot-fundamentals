package com.rohit.spring_boot_fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.rohit.spring_boot_fundamentals.dto.ErrorResponse;

class GlobalExceptionHandlerTest {

    @Test
    void handlesUnexpectedExceptionsWithGenericInternalServerError() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/students");

        ResponseEntity<ErrorResponse> response = handler.handleGenericException(
                new RuntimeException("internal detail"),
                request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(500, response.getBody().getStatus());
        assertEquals("An unexpected error occurred", response.getBody().getMessage());
        assertEquals("/students", response.getBody().getPath());
    }
}
