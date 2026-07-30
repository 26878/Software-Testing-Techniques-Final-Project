package com.auca.library.domain;

import com.auca.library.enums.LocationType;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "locations", uniqueConstraints = @UniqueConstraint(columnNames = {"location_code"}))
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private UUID locationId;

    @Column(name = "location_code", nullable = false, unique = true)
    private String locationCode;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type", nullable = false)
    private LocationType locationType;

    @Column(name = "parent_id")
    private UUID parentId;

    public Location() {
    }

    public Location(String locationCode, String locationName, LocationType locationType, UUID parentId) {
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationType = locationType;
        this.parentId = parentId;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }
}