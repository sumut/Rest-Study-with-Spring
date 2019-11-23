package com.sumutella.reststudy.repositories;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Region;

import java.util.List;

/**
 * @author sumutella
 * @time 6:14 PM
 * @since 11/22/2019, Fri
 */
public interface RegionDao {
    List<Region> getRegions();
    List<Country> getCountries(Integer id);
}
