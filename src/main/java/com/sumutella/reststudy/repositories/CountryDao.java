package com.sumutella.reststudy.repositories;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Location;

import java.util.List;

/**
 * @author sumutella
 * @time 6:17 PM
 * @since 11/22/2019, Fri
 */
public interface CountryDao {
    List<Country> getCountries();
    List<Location> getLocations(String id);
}
