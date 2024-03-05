package heros;

public class Hero {

	private String name;
	private String role;
	private int level;
	private int experience;
	private final static int MAX_LEVEL = 100;
	private final static String[] ROLES = {"Warrior", "Priest",
			"Wizard", "Thief"};
	
	public Hero(String name) {
		this.name = name;
		this.level = 1;
		this.experience = 0;
	}
	
	// Method to set the role of the hero, modified to throw HeroException for invalid roles
    public void setRole(String role) throws HeroException {
        for (String r : ROLES) {
            if (r.equals(role)) {
                this.role = role;
                return;
            }
        }
        throw new HeroException("Invalid role: " + role);
    }
    
    // Additional constructor that takes name, role, level, and experience
    public Hero(String name, String role, int level, int experience) throws HeroException {
        this.name = name;
        setRole(role); // Validates the role
        setLevel(level); // Validates the level
        setExperience(experience); // Validates the experience
        if (!isValidLevelExperience(level, experience)) {
            throw new HeroException("The experience is not valid for the given level.");
        }
    }

    // Method to validate if the experience is appropriate for the level
    public boolean isValidLevelExperience(int level, int experience) {
        // Assuming the rule that the experience must at least be the square of level minus 1
        // to qualify for the given level, and not enough to surpass the level
        int minExperience = (level - 1) * (level - 1);
        int maxExperience = level * level;
        return experience >= minExperience && experience < maxExperience;
    }
    
    public void setLevel(int level) throws HeroException {
        if (level < 1 || level > MAX_LEVEL) {
            throw new HeroException("Invalid level: " + level);
        }
        this.level = level;
    }

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public int getLevel() {
		return level;
	}

	public int getExperience() {
		return experience;
	}
	
	public int expToLevelUp() {
		// this is not the "amount of experience NEEDED to
		// level up, based on the current amount of experience",
		// but rather the "level up" amount of experience
		return (int)Math.pow(this.level, 2);
	}
	
	public void gainExperience(int experience) {
		
		// it's not specified that we just keep adding experience
		// once you've reached max_levcel, but it makes the most
		// sense

		this.experience += experience;
		while ( (this.experience >= expToLevelUp()) && 
				(this.level < MAX_LEVEL)) {
			this.experience -= expToLevelUp();
			level++;
			System.out.println (this.name + " is now level " + this.level);
		}
	}
	
	public void setExperience(int experience) throws HeroException {
        if (experience < 0) {
            throw new HeroException("Invalid experience: " + experience);
        }
        this.experience = experience;
    }
	
	public String toString() {
		return this.name + " the " + this.role + " is level " + this.level +
				" with " + this.experience + " experience.";
	}
	
	// Main method for demonstration purposes
    public static void main(String[] args) {
        try {
            Hero h1 = new Hero("Bob");
            h1.setRole("Warrior");
            Hero h2 = new Hero("John");
            h2.setRole("Wizard");
            Hero h3 = new Hero("Jane");
            h3.setRole("Priest");
            Hero h4 = new Hero("Dimitri");
            h4.setRole("Thief");
            Hero h5 = new Hero("Greg");

            try {
                h5.setRole("Paladin"); // This should throw an exception
            } catch (HeroException e) {
                System.out.println(e.getMessage()); // Handle the exception for an invalid role
            }

            Hero[] heroes = {h1, h2, h3, h4, h5};
            for (Hero h : heroes) {
                System.out.println(h);
            }
            // Demonstrate experience gain
            h1.gainExperience(1);
            System.out.println(h1);
            h1.gainExperience(1000000); // Large experience gain to demonstrate leveling
            System.out.println(h1);

        } catch (HeroException e) {
            System.out.println("Failed to create a hero: " + e.getMessage());
        }
    }
    
}
