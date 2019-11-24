package com.sumutella.reststudy.restcontrollers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.sumutella.reststudy.entities.Department;
import com.sumutella.reststudy.entities.Location;
import com.sumutella.reststudy.exceptionhandling.EntityNotFoundException;
import com.sumutella.reststudy.exceptionhandling.IncorrectRestParameterException;
import com.sumutella.reststudy.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author sumutella
 * @time 6:38 PM
 * @since 11/22/2019, Fri
 */
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationServiceImpl;

    @RequestMapping("")
    public List<Location> getLocations(){
        List<Location> locations = null;
        try{
            ObjectMapper mapper = new ObjectMapper();
            Hibernate5Module hm = new Hibernate5Module();
            mapper.registerModule(hm);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // convert pojos to json
            locations =locationServiceImpl.getLocations();
            mapper.writeValue(new File("C:\\MyProjects\\Rest-Study-with-Spring\\data\\locations_io.json"), locations);

            // read json and convert to pojos
            locations = Arrays.asList(mapper.readValue(new File("C:\\MyProjects\\Rest-Study-with-Spring\\data\\locations_io.json"),
                    Location[].class));

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @RequestMapping("/{locationId}")
    public List<Department> getDepartmentsInLocation(@PathVariable String locationId){
        List<Department> departmentsInLocation = null;
        Integer id = null;
        try {
            id = Integer.parseInt(locationId);
        } catch (NumberFormatException nfe){
            throw new IncorrectRestParameterException("request paramaneter "+locationId+" cannot be converted to integer");
        }

        try{
            ObjectMapper mapper = new ObjectMapper();
            Hibernate5Module hm = new Hibernate5Module();
            mapper.registerModule(hm);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // convert pojos to json
            departmentsInLocation =locationServiceImpl.getDepartments(id);
            mapper.writeValue(new File("C:\\MyProjects\\Rest-Study-with-Spring\\data\\departments_incustomlocation_io.json"), departmentsInLocation);

            // read json and convert to pojos
            departmentsInLocation = Arrays.asList(mapper.readValue(new File("C:\\MyProjects\\Rest-Study-with-Spring\\data\\departments_incustomlocation_io.json"),
                    Department[].class));

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (departmentsInLocation==null){
            throw new EntityNotFoundException("There is no department with location code: "+locationId);
        }


        return departmentsInLocation;
    }


}
