package filemanipulation;

public class Human {
    private String identityNumber;
    private String name;

    public Human(String name, String identityNumber) {
        this.name = name;
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getIdentityNumber() {
        return this.identityNumber;
    }
}