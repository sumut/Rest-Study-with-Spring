package com.sumutella.reststudy.repositories;

import com.sumutella.reststudy.entities.Department;
import com.sumutella.reststudy.entities.Location;

import java.util.List;

/**
 * @author sumutella
 * @time 6:21 PM
 * @since 11/22/2019, Fri
 */
public interface LocationDao {
    List<Location> getLocations();
    List<Department> getDepartments(Integer id);

}
