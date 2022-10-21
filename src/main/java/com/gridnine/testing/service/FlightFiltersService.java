package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.function.Predicate;

public interface FlightFiltersService {
    boolean filter(Flight flight);
    void addFilter(Predicate<Flight> predicate);
}
