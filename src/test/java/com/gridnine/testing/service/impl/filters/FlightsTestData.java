package com.gridnine.testing.service.impl.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class FlightsTestData {

    public static List<Flight> getListFlightWhereOneFlightFilterByDepartureBeforeArrival() {
        LocalDateTime now = LocalDateTime.now();
        return List.of(
                //A flight that departs before it arrives
                new Flight(List.of(
                        new Segment(
                                now.plusDays(1),
                                now.plusDays(2)
                        ),
                        new Segment(
                                now,
                                now.minusHours(6)
                        ),
                        new Segment(
                                now.plusDays(3),
                                now.plusDays(4)
                        )
                )),
                new Flight(List.of(
                        new Segment(
                                now.minusDays(6),
                                now.minusDays(5)
                        )
                )),
                new Flight(List.of(
                        new Segment(
                                now.minusDays(4),
                                now.minusDays(3)
                        ),
                        new Segment(
                                now.plusDays(1),
                                now.plusDays(2)
                        )
                )
                ));
    }

    public static List<Flight> getListFlightWhereOneFlightFilterByDepartureBeforeCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return List.of(
                new Flight(List.of(
                        new Segment(now.plusDays(2), now.plusDays(3))
                )),
                //A flight departing in the past
                new Flight(List.of(
                        new Segment(now.minusDays(3), now.minusDays(2))
                )),
                new Flight(List.of(
                        new Segment(now.plusDays(1), now.plusDays(2)),
                        new Segment(now.plusDays(7), now.plusDays(8))
                )
                ));
    }

    public static List<Flight> getListFlightWhereOneFlightFilterByMoreThanTwoHoursOnGround() {
        LocalDateTime now = LocalDateTime.now();
        return List.of(
                //A flight with more than two hours ground time
                new Flight(List.of(
                        new Segment(now, now.plusHours(3)),
                        new Segment(now.plusHours(8), now.plusDays(3))
                )),
                new Flight(List.of(
                        new Segment(
                                LocalDateTime.of(2022, 7, 15, 12, 44),
                                LocalDateTime.of(2022, 7, 22, 14, 31)
                        )
                )),
                //A flight with more than two hours ground time
                new Flight(List.of(
                        new Segment(now, now.plusHours(3)),
                        new Segment(now.plusHours(4), now.plusHours(6)),
                        new Segment(now.plusHours(8), now.plusHours(9))
                )
                ));
    }
}
