package com.dasha_valea.travel_advisor.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class City {
    private String name;
    private Integer area;
    private Long population;
    // From 1 to 5
    private Integer rating;
    // From 1 to 5
    private Integer safetyRating;
}
