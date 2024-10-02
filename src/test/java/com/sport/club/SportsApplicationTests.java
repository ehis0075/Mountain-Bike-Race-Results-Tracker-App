package com.sport.club;

import com.sport.club.model.Race;
import com.sport.club.model.RaceResult;
import com.sport.club.model.Rider;
import com.sport.club.repository.RaceResultRepository;
import com.sport.club.service.RiderService;
import com.sport.club.service.implementation.RaceResultServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class SportsApplicationTests {

    @Mock
    private RaceResultRepository raceResultRepository;

    @Mock
    private RiderService riderService;

    @InjectMocks
    private RaceResultServiceImpl raceResultService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFastestThreeRiders() {
        Long raceId = 1L;
        Rider rider1 = new Rider(1L, "John Doe");
        Rider rider2 = new Rider(2L, "Jane Smith");
        Rider rider3 = new Rider(3L, "Mark Johnson");

        Race race = new Race(1L, "Mountain Bike Challenge", "Highland Park", LocalDate.parse("2024-10-10"));

        RaceResult result1 = new RaceResult(1L, rider1, race, 120.5, 1, true);
        RaceResult result2 = new RaceResult(2L, rider2, race, 115.7, 2, true);
        RaceResult result3 = new RaceResult(3L, rider3, race, 130.2, 3, true);

        when(raceResultRepository.findByRaceIdOrderByPositionAsc(raceId)).thenReturn(Arrays.asList(result1, result2, result3));

        List<Rider> fastestRiders = raceResultService.getFastestThreeRiders(raceId);

        assertEquals(3, fastestRiders.size());
        assertEquals(rider1, fastestRiders.get(0));
        assertEquals(rider2, fastestRiders.get(1));
        assertEquals(rider3, fastestRiders.get(2));
    }


    @Test
    public void testGetRidersWhoDidNotFinish() {
        Long raceId = 1L;
        Rider rider1 = new Rider(1L, "John Doe");
        Rider rider2 = new Rider(2L, "Jane Smith");

        Race race = new Race(1L, "Mountain Bike Challenge", "Highland Park", LocalDate.parse("2024-10-10"));

        RaceResult result1 = new RaceResult(1L, rider1, race, null, 1, false);
        RaceResult result2 = new RaceResult(2L, rider2, race, null, 2, false);

        when(raceResultRepository.findByRaceIdAndDidFinishFalse(raceId)).thenReturn(Arrays.asList(result1, result2));

        List<Rider> nonFinishers = raceResultService.getRidersWhoDidNotFinish(raceId);

        assertEquals(2, nonFinishers.size());
        assertEquals(rider1, nonFinishers.get(0));
        assertEquals(rider2, nonFinishers.get(1));
    }

    @Test
    public void testGetRidersWhoDidNotParticipate() {
        Long raceId = 1L;
        Rider rider1 = new Rider(1L, "John Doe");
        Rider rider2 = new Rider(2L, "Jane Smith");
        Rider rider3 = new Rider(3L, "Mark Johnson");

        Race race = new Race(1L, "Mountain Bike Challenge", "Highland Park", LocalDate.parse("2024-10-10"));

        RaceResult result1 = new RaceResult(1L, rider1, race, null, null, true);

        when(riderService.getRiderList()).thenReturn(Arrays.asList(rider1, rider2, rider3));
        when(raceResultRepository.findByRaceId(raceId)).thenReturn(List.of(result1));

        List<Rider> nonParticipants = raceResultService.getRidersWhoDidNotParticipate(raceId);

        assertEquals(2, nonParticipants.size());
        assertTrue(nonParticipants.contains(rider2));
        assertTrue(nonParticipants.contains(rider3));
    }

}
