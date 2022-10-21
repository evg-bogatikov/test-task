package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.service.impl.FlightFiltersServiceImpl;
import com.gridnine.testing.service.impl.filters.DepartureBeforeArrivalServiceImpl;
import com.gridnine.testing.service.impl.filters.DepartureBeforeCurrentTimeServiceImpl;
import com.gridnine.testing.service.impl.filters.MoreThanTwoHoursOnGroundServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFiltersServiceImpl flightFilters = new FlightFiltersServiceImpl();

        flightFilters.addFilter(new DepartureBeforeCurrentTimeServiceImpl());
        flightFilters.addFilter(new DepartureBeforeArrivalServiceImpl());
        flightFilters.addFilter(new MoreThanTwoHoursOnGroundServiceImpl());

        flights.stream()
                .filter(flightFilters::filter)
                .forEach(flight -> System.out.println("Result: " + flight.toString()));
    }
}
