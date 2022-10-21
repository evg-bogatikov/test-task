package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.function.Predicate;

public class DepartureBeforeArrivalServiceImpl implements Predicate<Flight> {

    @Override
    public boolean test(Flight flight) {
        for (Segment segment :
                flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return false;
            }
        }
        return true;
    }
}
