package com.auca.library;

import com.auca.library.domain.Location;
import com.auca.library.enums.LocationType;
import com.auca.library.service.LocationService;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class LocationServiceTest {

    private LocationService locationService;

    @Before
    public void setUp() {
        locationService = new LocationService();
    }

    @Test
    public void createProvince_withNoParent_succeeds() {
        String uniqueCode = "PROV_" + UUID.randomUUID().toString().substring(0, 5);
        Location province = new Location(uniqueCode, "Kigali City", LocationType.PROVINCE, null);
        Location created = locationService.createLocation(province, null);
        assertNotNull(created.getLocationId());
    }

    @Test
    public void createDistrict_withValidProvinceParent_succeeds() {
        String provinceCode = "PROV_" + UUID.randomUUID().toString().substring(0, 5);
        Location province = new Location(provinceCode, "Northern Province", LocationType.PROVINCE, null);
        Location createdProvince = locationService.createLocation(province, null);

        String districtCode = "DIST_" + UUID.randomUUID().toString().substring(0, 5);
        Location district = new Location(districtCode, "Musanze", LocationType.DISTRICT, null);
        Location createdDistrict = locationService.createLocation(district, createdProvince.getLocationId());

        assertNotNull(createdDistrict.getLocationId());
        assertEquals(createdProvince.getLocationId(), createdDistrict.getParentId());
    }

    @Test(expected = Exception.class)
    public void createDistrict_withMissingParent_throwsException() {
        String districtCode = "DIST_" + UUID.randomUUID().toString().substring(0, 5);
        Location district = new Location(districtCode, "Orphan District", LocationType.DISTRICT, null);
        locationService.createLocation(district, UUID.randomUUID());
    }

    @Test(expected = Exception.class)
    public void createLocation_duplicateLocationCode_throwsException() {
        String duplicateCode = "DUP_" + UUID.randomUUID().toString().substring(0, 5);
        Location loc1 = new Location(duplicateCode, "First Instance", LocationType.PROVINCE, null);
        locationService.createLocation(loc1, null);

        Location loc2 = new Location(duplicateCode, "Second Instance", LocationType.PROVINCE, null);
        locationService.createLocation(loc2, null);
    }
}