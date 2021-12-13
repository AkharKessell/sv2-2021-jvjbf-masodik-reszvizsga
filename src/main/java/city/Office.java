package city;

public class Office extends Building {
    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if (!isFreeTable(numberOfTablesPerLevel)) {
            throw new IllegalArgumentException("invalid tables");
        } else {
            this.company = company;
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }
    }

    private boolean isFreeTable(int numberOfTablesPerLevel) {
        double areaPerTables = getArea() / numberOfTablesPerLevel;
        return areaPerTables >= 2 && areaPerTables <= 5;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * numberOfTablesPerLevel;
    }
}