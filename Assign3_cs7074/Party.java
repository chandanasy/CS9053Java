
import java.util.Arrays;

public class Party {
    private Hero[] heroes;

    public Party() {
        heroes = new Hero[3]; // Initialize array for 3 Hero objects
    }

    public void addHero(Hero hero, int index) {
        if (index >= 0 && index < heroes.length) {
            heroes[index] = hero; // Add or replace the Hero at the given index
        }
    }

    public void removeHero(int index) {
        if (index >= 0 && index < heroes.length) {
            heroes[index] = null; // Remove the Hero from the given index
            // Shift the remaining heroes
            for (int i = index; i < heroes.length - 1; i++) {
                heroes[i] = heroes[i + 1];
            }
            heroes[heroes.length - 1] = null;
        }
    }

    public Hero getHero(int index) {
        if (index >= 0 && index < heroes.length) {
            return heroes[index];
        }
        return null;
    }

    public void gainExperience(int experience) {
        System.out.println("The party gained " + experience + " experience.");
        for (Hero hero : heroes) {
            if (hero != null) {
                hero.gainExperience(experience);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(heroes)
                .filter(hero -> hero != null)
                .map(hero -> hero.getName() + " the " + hero.getRole() + " is level " + hero.getLevel() + " with " + hero.getExperience() + " experience.")
                .reduce("Party:", (a, b) -> a + b + "");
    }
}

