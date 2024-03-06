public class HeroMain {

    public static void main(String[] args) {
        Hero hero = new Hero("Aragorn");
        hero.setRole("Warrior");
        hero.gainExperience(50); // Adjust the experience value as needed
        System.out.println(hero.toString());
    }
}