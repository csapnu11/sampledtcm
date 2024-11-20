package models;
import java.util.ArrayList;

import java.util.List;

public class Region {

    private String name;

    public Region(String name) {
        this.name = name;
    }

    private List<Location> locations = new ArrayList<>();

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
