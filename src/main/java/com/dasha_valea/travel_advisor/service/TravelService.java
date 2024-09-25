package com.dasha_valea.travel_advisor.service;

import com.dasha_valea.travel_advisor.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelService {

    private List<Continent> continents;

    public List<City> findSuitableCities(int minRating, int minSafetyRating, Type preferredSightSeeingType) {
        List<City> suitableCities = new ArrayList<>();

        for (Continent continent : continents) {
            for (Country country : continent.getCountries()) {
                for (City city : country.getCities()) {
                    boolean meetsCriteria = city.getRating() >= minRating
                            && city.getSafetyRating() >= minSafetyRating;

                    boolean hasPreferredSightSeeing = city.getSeeings().stream()
                            .anyMatch(seeing -> seeing.getType() == preferredSightSeeingType);

                    if (meetsCriteria && hasPreferredSightSeeing) {
                        suitableCities.add(city);
                    }
                }
            }
        }
        return suitableCities;
    }


    @PostConstruct
    private void initContinents() {
        continents = List.of(
                new Continent().setName("Europe")
                        .setCountries(List.of(
                                new Country()
                                        .setName("Germany")
                                        .setLanguage("german")
                                        .setArea(357592)
                                        .setVisaNeeded(false)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("Berlin")
                                                        .setArea(891)
                                                        .setPopulation(3645000L)
                                                        .setRating(4)
                                                        .setSafetyRating(4)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Samurai museum")
                                                                        .setRating(4)
                                                                        .setType(Type.MUSEUM)
                                                        )),
                                                new City()
                                                        .setName("Munich")
                                                        .setArea(310)
                                                        .setPopulation(1472000L)
                                                        .setRating(5)
                                                        .setSafetyRating(5)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("English Garden")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Deutsches Museum")
                                                                        .setRating(4)
                                                                        .setType(Type.MUSEUM)
                                                        ))
                                        ))
                        )),
                new Continent().setName("Asia")
                        .setCountries(List.of(
                                new Country()
                                        .setName("Japan")
                                        .setLanguage("japanese")
                                        .setArea(377975)
                                        .setVisaNeeded(false)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("Tokyo")
                                                        .setArea(2194)
                                                        .setPopulation(13929286L)
                                                        .setRating(5)
                                                        .setSafetyRating(5)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Tokyo Tower")
                                                                        .setRating(4)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Meiji Shrine")
                                                                        .setRating(5)
                                                                        .setType(Type.CULTURE)
                                                        )),
                                                new City()
                                                        .setName("Kyoto")
                                                        .setArea(827)
                                                        .setPopulation(1474570L)
                                                        .setRating(5)
                                                        .setSafetyRating(5)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Fushimi Inari Shrine")
                                                                        .setRating(5)
                                                                        .setType(Type.CULTURE),
                                                                new SightSeeing()
                                                                        .setName("Kinkaku-ji")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE)
                                                        ))
                                        ))
                        )),
                new Continent().setName("Africa")
                        .setCountries(List.of(
                                new Country()
                                        .setName("South Africa")
                                        .setLanguage("english")
                                        .setArea(1219090)
                                        .setVisaNeeded(true)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("Cape Town")
                                                        .setArea(400)
                                                        .setPopulation(433688L)
                                                        .setRating(5)
                                                        .setSafetyRating(4)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Table Mountain")
                                                                        .setRating(5)
                                                                        .setType(Type.MOUNTAIN),
                                                                new SightSeeing()
                                                                        .setName("Robben Island")
                                                                        .setRating(4)
                                                                        .setType(Type.CULTURE)
                                                        )),
                                                new City()
                                                        .setName("Johannesburg")
                                                        .setArea(1644)
                                                        .setPopulation(5730000L)
                                                        .setRating(4)
                                                        .setSafetyRating(3)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Apartheid Museum")
                                                                        .setRating(5)
                                                                        .setType(Type.MUSEUM)
                                                        ))
                                        )),
                                new Country()
                                        .setName("Kenya")
                                        .setLanguage("swahili")
                                        .setArea(580367)
                                        .setVisaNeeded(true)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("Nairobi")
                                                        .setArea(696)
                                                        .setPopulation(4397073L)
                                                        .setRating(4)
                                                        .setSafetyRating(3)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Nairobi National Park")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Giraffe Centre")
                                                                        .setRating(4)
                                                                        .setType(Type.MOUNTAIN)
                                                        ))
                                        ))
                        )),
                new Continent().setName("North America")
                        .setCountries(List.of(
                                new Country()
                                        .setName("United States")
                                        .setLanguage("english")
                                        .setArea(9833517)
                                        .setVisaNeeded(true)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("New York City")
                                                        .setArea(783)
                                                        .setPopulation(8419600L)
                                                        .setRating(5)
                                                        .setSafetyRating(4)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Statue of Liberty")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Metropolitan Museum of Art")
                                                                        .setRating(5)
                                                                        .setType(Type.MUSEUM)
                                                        )),
                                                new City()
                                                        .setName("Los Angeles")
                                                        .setArea(1302)
                                                        .setPopulation(3980400L)
                                                        .setRating(4)
                                                        .setSafetyRating(3)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Hollywood Sign")
                                                                        .setRating(4)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Griffith Observatory")
                                                                        .setRating(4)
                                                                        .setType(Type.SEE)
                                                        ))
                                        ))
                        )),
                new Continent().setName("South America")
                        .setCountries(List.of(
                                new Country()
                                        .setName("Brazil")
                                        .setLanguage("portuguese")
                                        .setArea(8515767)
                                        .setVisaNeeded(true)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("Rio de Janeiro")
                                                        .setArea(1200)
                                                        .setPopulation(6748000L)
                                                        .setRating(5)
                                                        .setSafetyRating(3)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Christ the Redeemer")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Sugarloaf Mountain")
                                                                        .setRating(5)
                                                                        .setType(Type.MOUNTAIN)
                                                        )),
                                                new City()
                                                        .setName("São Paulo")
                                                        .setArea(1521)
                                                        .setPopulation(12325232L)
                                                        .setRating(4)
                                                        .setSafetyRating(3)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Ibirapuera Park")
                                                                        .setRating(4)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("São Paulo Museum of Art")
                                                                        .setRating(4)
                                                                        .setType(Type.MUSEUM)
                                                        ))
                                        ))
                        )),
                new Continent().setName("Australia")
                        .setCountries(List.of(
                                new Country()
                                        .setName("Australia")
                                        .setLanguage("english")
                                        .setArea(7692024)
                                        .setVisaNeeded(true)
                                        .setCities(List.of(
                                                new City()
                                                        .setName("Sydney")
                                                        .setArea(12368)
                                                        .setPopulation(5230330L)
                                                        .setRating(5)
                                                        .setSafetyRating(4)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Sydney Opera House")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("Sydney Harbour Bridge")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE)
                                                        )),
                                                new City()
                                                        .setName("Melbourne")
                                                        .setArea(9990)
                                                        .setPopulation(5086000L)
                                                        .setRating(4)
                                                        .setSafetyRating(5)
                                                        .setSeeings(List.of(
                                                                new SightSeeing()
                                                                        .setName("Royal Botanic Gardens")
                                                                        .setRating(5)
                                                                        .setType(Type.SEE),
                                                                new SightSeeing()
                                                                        .setName("National Gallery of Victoria")
                                                                        .setRating(4)
                                                                        .setType(Type.MUSEUM)
                                                        ))
                                        ))
                        ))
        );
    }


}
