package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return this.name;
    }

    public long getFullArea() {
        return this.fullArea;
    }

    public List<Building> getBuildings() {
        return List.copyOf(buildings);
    }

    public void addBuilding(Building building) {
        if (getAreaOfBuildings() + building.getArea() <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    private double getAreaOfBuildings() {
        double sumBuilding = 0;
        for (Building building : buildings) {
            sumBuilding += building.getArea();
        }
        return sumBuilding;
    }

    public Building findHighestBuilding() {
        Building highestBuilding = buildings.get(0);
        for (Building building : buildings) {
            if (highestBuilding.getLevels() < building.getLevels()) {
                highestBuilding = building;
            }
        }
        return highestBuilding;
    }

    //---Akkor fordul le, ha List-et importálok a tesztbe :( ez nem ment....
    public List<Building> findBuildingsByStreet(String street) {
        List<Building> buildingList = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().getStreet().equals(street)) {
                buildingList.add(building);
            }
        }
        return buildingList;
    }

    public boolean isThereBuildingWithMorePeopleThan(int number) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > number) {
                return true;
            }
        }
        return false;
    }
}