package com.bsale.airline.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AirlineData {
    private Integer code;
    private Optional<Flight> flight;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String errors;

    public AirlineData(Integer code, Optional<Flight> flight, String errors) {
        this.code = code;
        this.flight = flight;
        this.errors = errors;
    }

    public String getErrors() {
        return errors;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        if (flight.isEmpty()) {
            return ResponseEntity.ok(flight).getHeaders();
        } else return flight;
    }

}
