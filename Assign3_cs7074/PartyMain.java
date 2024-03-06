public class PartyMain {
    public static void main(String[] args) {
        Party party = new Party();
        
        // Create heroes
        Hero hero1 = new Hero("Thor");
        hero1.setRole("Warrior");
        Hero hero2 = new Hero("Groot");
        hero2.setRole("Thief");
        Hero hero3 = new Hero("Doctor Strange");
        hero3.setRole("Wizard");
        
        // Add heroes to the party
        party.addHero(hero1, 0);
        party.addHero(hero2, 1);
        party.addHero(hero3, 2);
        
        // Give the party experience
        party.gainExperience(100);
        
        // Print out the party information
        System.out.println(party.toString());
    }
}
