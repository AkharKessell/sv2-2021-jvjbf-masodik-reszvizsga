package city;

public abstract class Building {

    private int area;
    private int levels;
    private Address address;

    public Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(int area, Address address) {
        this.area = area;
        this.address = address;
        levels = 1;
    }

    public abstract int calculateNumberOfPeopleCanFit();

    public int getFullArea() {
        return this.area * this.levels;
    }

    public int getArea() {
        return this.area;
    }

    public int getLevels() {
        return this.levels;
    }

    public Address getAddress() {
        return this.address;
    }
}