package com.dasha_valea.travel_advisor.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Country {
    private String name;
    private Integer area;
    private List<City> cities;
    private String language;
    private boolean visaNeeded;
}
