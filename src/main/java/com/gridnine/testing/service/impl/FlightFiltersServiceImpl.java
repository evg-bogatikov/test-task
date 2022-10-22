package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFiltersService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FlightFiltersServiceImpl implements FlightFiltersService {

    private final List<Predicate<Flight>> flightFilterServices = new ArrayList<>();

    @Override
    public boolean filter(Flight flight) {
        for (Predicate<Flight> flightFilterService :
                flightFilterServices) {
            if(!flightFilterService.test(flight))
                return false;
        }
        return true;
    }

    @Override
    public void addFilter(Predicate<Flight> filter) {
        flightFilterServices.add(filter);
    }
}
