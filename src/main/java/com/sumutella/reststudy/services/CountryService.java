package com.sumutella.reststudy.services;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Location;

import java.util.List;

/**
 * @author sumutella
 * @time 6:26 PM
 * @since 11/22/2019, Fri
 */
public interface CountryService {
    List<Country> getCountries();
    List<Location> getLocations(String id);
}
