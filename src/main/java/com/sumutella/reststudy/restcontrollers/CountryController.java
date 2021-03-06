package com.sumutella.reststudy.restcontrollers;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Location;
import com.sumutella.reststudy.exceptionhandling.EntityNotFoundException;
import com.sumutella.reststudy.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sumutella
 * @time 6:38 PM
 * @since 11/22/2019, Fri
 */
@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryServiceImpl;


    @GetMapping("")
    public List<Country> getCountries(){
        return countryServiceImpl.getCountries();
    }

    @RequestMapping("/{countryId}")
    public List<Location> getLocationsInCountry(@PathVariable String countryId) {
        List<Location> locationsInCustomCountry = countryServiceImpl.getLocations(countryId);
        if (locationsInCustomCountry==null){
            throw new EntityNotFoundException("There is no location with country code:" + countryId);
        }
        return locationsInCustomCountry;
    }


}
