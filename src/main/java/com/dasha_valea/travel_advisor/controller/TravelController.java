package com.dasha_valea.travel_advisor.controller;

import com.dasha_valea.travel_advisor.model.City;
import com.dasha_valea.travel_advisor.model.Type;
import com.dasha_valea.travel_advisor.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;

    @GetMapping("/suitableCities")
    public List<City> findCities(
            @RequestParam(name = "minRating", defaultValue = "1") int minRating,
            @RequestParam(name = "minSafetyRating", defaultValue = "1") int minSafetyRating,
            @RequestParam(name = "sightSeeingType", defaultValue = "SEE") String sightSeeingType) {

        Type preferredType;
        try {
            preferredType = Type.valueOf(sightSeeingType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid sightSeeingType: " + sightSeeingType);
        }

        // Find suitable cities based on user input
        return travelService.findSuitableCities(minRating, minSafetyRating, preferredType);
    }

}
