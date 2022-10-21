package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class DepartureBeforeCurrentTimeServiceImpl implements Predicate<Flight> {

    @Override
    public boolean test(Flight flight) {
        for (Segment segment :
                flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now()))
                return false;
        }
        return true;
    }
}
