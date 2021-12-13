package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    private List<String> getMen() {
        List<String> menOnly = new ArrayList<>();
        for (Human human : humans) {
            if (isMan(human)) {
                menOnly.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }
        return menOnly;
    }

    private boolean isMan(Human human) {
        return human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3");
    }

    public void readHumansFromFile(Path path) {
        try {
            for (String line : Files.readAllLines(path)) {
                String[] humanValues = line.split(";");
                humans.add(new Human(humanValues[0], humanValues[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getMen());
        } catch (IOException ioe) {
            throw new IllegalStateException("cant write file!", ioe);
        }
    }
    public List<Human> getHumans() {
        return List.copyOf(humans);
    }
}