package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartureBeforeCurrentTimeServiceImplTest {

    @Test
    void shouldFilterOutOneFlight() {
        List<Flight> flights = FlightsTestData.getListFlightWhereOneFlightFilterByDepartureBeforeCurrentTime();
        List<Flight> expected = List.of(flights.get(0), flights.get(2));

        List<Flight> actual = flights.stream()
                .filter(new DepartureBeforeCurrentTimeServiceImpl())
                .toList();

        Assertions.assertEquals(expected, actual);
    }
}
