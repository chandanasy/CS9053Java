
class Hero {
    private String name;
    private String role;
    private int level;
    private int experience;
    private static final int MAX_LEVEL = 100;
    private static final String[] ROLES = {"Warrior", "Priest", "Wizard", "Thief"};

    public Hero(String name) {
        this.name = name;
        this.role = "Unassigned";
        this.level = 1;
        this.experience = 0;
    }

    public void setRole(String role) {
        for (String validRole : ROLES) {
            if (validRole.equalsIgnoreCase(role)) {
                this.role = role;
                return;
            }
        }
        System.out.println("Invalid role");
        this.role = "Unassigned";
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

    public int xpToLevelUp() {
        return (level + 1) * (level + 1) - level * level;
    }

    public void gainExperience(int experience) {
        this.experience += experience;
        while (this.experience >= xpToLevelUp()) {
            if (level < MAX_LEVEL) {
                this.experience -= xpToLevelUp();
                level++;
                System.out.println(name + " has reached level " + level + "!");
            } else {
                this.experience = 0; // Reset experience if max level is reached
                System.out.println(name + " has reached the maximum level.");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return name + " the " + role + " is level " + level + " with " + experience + " experience.";
    }
}

