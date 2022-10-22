package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartureBeforeArrivalServiceImplTest {

    @Test
    void shouldFilterOutOneFlight() {
        List<Flight> listFlight = FlightsTestData.getListFlightWhereOneFlightFilterByDepartureBeforeArrival();
        List<Flight> expected = List.of(listFlight.get(1), listFlight.get(2));

        List<Flight> actual = listFlight.stream()
                .filter(new DepartureBeforeArrivalServiceImpl())
                .toList();
        System.out.println(expected.get(0));
        Assertions.assertEquals(expected, actual);
    }
}
