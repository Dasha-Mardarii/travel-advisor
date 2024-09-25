package com.dasha_valea.travel_advisor.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SightSeeing {
    private String name;
    private Type type;
    // From 1 to 5
    private Integer rating;
}

enum Type {
    MUSEUM, CULTURE, SEE, MOUNTAIN
}
