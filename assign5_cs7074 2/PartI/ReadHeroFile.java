import java.io.*;
import java.util.ArrayList;
import heros.Hero;
import heros.HeroException;

public class ReadHeroFile {

    // Method to create a Hero object from attributes
    public static Hero createHero(String name, String role, int level, int experience) throws HeroException {
        Hero hero = new Hero(name); // Assume Hero class has a constructor with name
        hero.setRole(role); // This may throw HeroException if the role is invalid
        hero.setLevel(level); // This may throw HeroException if the level is invalid
        hero.setExperience(experience); // This may throw HeroException if the experience is invalid
         // Validate that the experience is consistent with the level
     // Now, call the validation method; it should be public in Hero class
        if (!hero.isValidLevelExperience(level, experience)) {
            throw new HeroException("Experience does not match the level requirements.");
        }
        return hero;
    }

    public static void main(String[] args) {
        String filePath = "heroes.txt"; // Replace with your actual file path
        ArrayList<Hero> heroList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    // Split line into parts and create a hero
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String name = parts[0].trim();
                        String role = parts[1].trim();
                        int level = Integer.parseInt(parts[2].trim());
                        int experience = Integer.parseInt(parts[3].trim());
                        Hero hero = createHero(name, role, level, experience);
                        heroList.add(hero);
                    } else {
                        System.out.println("Skipping invalid line: " + line);
                    }
                } catch (HeroException e) {
                    // Catch and handle HeroException here
                    System.out.println("Error creating hero from line: " + line + " - " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Display the created heroes
        for (Hero hero : heroList) {
            System.out.println(hero);
        }
    }
}


