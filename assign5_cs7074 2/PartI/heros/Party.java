package heros;

import java.util.ArrayList;

public class Party {
    private ArrayList<Hero> heroes; // Use ArrayList for dynamic resizing

    public Party() {
        heroes = new ArrayList<>(); // Initialize the ArrayList
    }

    // Modified to add a hero without needing an index
    public void addHero(Hero hero) {
        if (!heroes.contains(hero)) { // Check if hero is already in the party
            heroes.add(hero);
        } else {
            System.out.println(hero.getName() + " is already in the party");
        }
    }
    
    // Method to remove a hero by object reference
    public void removeHero(Hero hero) {
        if (heroes.contains(hero)) {
            heroes.remove(hero);
        } else {
            System.out.println("Hero not found in the party.");
        }
    }

    // Method to distribute experience evenly among all heroes in the party
    public void gainExperience(int experience) {
        System.out.println("The party has gained " + experience + " experience");
        if (!heroes.isEmpty()) {
            int individualExperience = (int)Math.ceil((double)experience / heroes.size());
            for (Hero hero : heroes) {
                hero.gainExperience(individualExperience);
            }
        }
    }
    
    // Override toString to list all heroes in the party
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Party:\n");
        for (Hero hero : heroes) {
            sb.append(hero.toString()).append("\n");
        }
        return sb.toString();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        try {
            Party party = new Party();
            Hero h1 = new Hero("Bob");
            h1.setRole("Warrior");
            Hero h2 = new Hero("John");
            h2.setRole("Wizard");
            Hero h3 = new Hero("Jane");
            h3.setRole("Priest");
            Hero h4 = new Hero("Dimitri");
            h4.setRole("Thief");
            
            party.addHero(h1);
            party.addHero(h2);
            party.addHero(h3);
            party.addHero(h4);
            
            System.out.println(party);
            
            party.removeHero(h3);
            System.out.println("After removing Jane:\n" + party);
            
            party.gainExperience(100);
            System.out.println("After gaining experience:\n" + party);
        } catch (HeroException e) {
            System.out.println(e.getMessage());
        }
    }
}

