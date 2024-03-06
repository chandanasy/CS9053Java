package fruit;

public class Lemon extends Citrus {
    private int sourness;

    // Default constructor
    public Lemon() {
        super(); // Calls the default constructor of the Citrus class
        this.sourness = 0; // Default value, can be adjusted as needed
    }

    // Parameterized constructor
    public Lemon(int sourness, String taste, boolean rotten) {
        super(taste, "Yellow", rotten); // Calls the parameterized constructor of the Citrus class and sets the color to "Yellow"
        this.sourness = sourness;
    }

    // Getter and Setter for sourness
    public int getSourness() {
        return sourness;
    }

    public void setSourness(int sourness) {
        this.sourness = sourness;
    }

    @Override
    public String toString() {
        return "Lemon{" +
                "id=" + getId() +
                ", color='" + getColor() + '\'' +
                ", rotten=" + isRotten() +
                ", taste='" + getTaste() + '\'' +
                ", sourness=" + sourness +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Lemon lemon = (Lemon) obj;
        return sourness == lemon.sourness;
    }

    public static void main(String[] args) {
        // Test the Lemon class
        Lemon regular = new Lemon(7, "Sour", false); // Assuming sourness is on a scale of 1-10, with 10 being very sour
        System.out.println(regular.toString());

        Lemon extraSour = new Lemon(10, "Very Sour", false);
        System.out.println(extraSour.toString());
        Lemon lemon1 = new Lemon(8, "Sour", false);
        Lemon lemon2 = new Lemon(8, "Sour", false);
        System.out.println("Are lemon1 and lemon1 equal? " + lemon1.equals(lemon1)); // Should return true
        System.out.println("Are lemon1 and lemon2 equal? " + lemon1.equals(lemon2)); // Should return false
    }
}
