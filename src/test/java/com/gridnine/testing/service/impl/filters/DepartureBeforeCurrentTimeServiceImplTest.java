package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartureBeforeCurrentTimeServiceImplTest {

    @Test
    void shouldFilterOutTwoFlight() {
        List<Flight> flights = FlightBuilder.createFlights();
        int expected = flights.size() - 2;

        List<Flight> actual = flights.stream()
                .filter(new DepartureBeforeCurrentTimeServiceImpl())
                .toList();

        Assertions.assertEquals(expected, actual.size());
    }
}
