package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MoreThanTwoHoursOnGroundServiceImplTest {

    @Test
    void shouldFilterOutTwoFlights() {
        List<Flight> flights = FlightsTestData.getListFlightWhereOneFlightFilterByMoreThanTwoHoursOnGround();
        List<Flight> expected = List.of(flights.get(1));

        List<Flight> actual = flights.stream()
                .filter(new MoreThanTwoHoursOnGroundServiceImpl())
                .toList();

        Assertions.assertEquals(expected, actual);
    }
}
