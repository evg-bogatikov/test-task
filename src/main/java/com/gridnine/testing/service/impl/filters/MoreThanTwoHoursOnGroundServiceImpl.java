package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class MoreThanTwoHoursOnGroundServiceImpl implements Predicate<Flight> {

    @Override
    public boolean test(Flight flight) {
        if (flight.getSegments().size() > 1) {
            List<Segment> segments = flight.getSegments();
            long totalTime = 0L;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrivalDate = segments.get(i).getArrivalDate();
                LocalDateTime departureDate = segments.get(i + 1).getDepartureDate();
                totalTime += Duration.between(arrivalDate, departureDate).toHours();
            }
            return totalTime <= 2;
        }
        return true;
    }
}
