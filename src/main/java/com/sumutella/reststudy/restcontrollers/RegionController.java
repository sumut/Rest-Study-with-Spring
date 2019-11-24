package com.sumutella.reststudy.restcontrollers;

import com.sumutella.reststudy.entities.Country;
import com.sumutella.reststudy.entities.Region;
import com.sumutella.reststudy.exceptionhandling.EntityNotFoundException;
import com.sumutella.reststudy.exceptionhandling.IncorrectRestParameterException;
import com.sumutella.reststudy.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionServiceImpl;

    @RequestMapping("")
    public List<Region> showRegions(){
        return regionServiceImpl.getRegions();
    }

    @RequestMapping("/{regionId}")
    public List<Country> getCountriesInRegion(@PathVariable String regionId){
        Integer id = null;
        try {
            id = Integer.parseInt(regionId);
        } catch (NumberFormatException nfe){
            throw new IncorrectRestParameterException("request parameter " +regionId+" cannot be converted to integer");
        }

        List<Country> countriesInCustomRegion = regionServiceImpl.getCountries(id);

        if (countriesInCustomRegion==null){
            throw  new EntityNotFoundException("There is no country with region code: "+regionId);
        }
        return regionServiceImpl.getCountries(id);
    }

}
