package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MoreThanTwoHoursOnGroundServiceImplTest {
    @Test
    void shouldFilterOutTwoFlights() {
        List<Flight> flights = FlightBuilder.createFlights();
        int expected = flights.size() - 2;

        List<Flight> actual = flights.stream()
                .filter(new MoreThanTwoHoursOnGroundServiceImpl())
                .toList();

        Assertions.assertEquals(expected, actual.size());
    }
}
