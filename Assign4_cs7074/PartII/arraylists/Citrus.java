package arraylists;
import java.util.Objects;

public class Citrus extends Fruit {
    private String taste;

    // Default constructor
    public Citrus() {
        super(); // calls the default constructor of the Fruit class
        this.taste = "Unknown";
    }

    // Parameterized constructor
    public Citrus(String taste, String color, boolean rotten) {
        super(color, rotten); // calls the parameterized constructor of the Fruit class
        this.taste = taste;
    }

    // Getter and Setter for taste
    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Citrus{" +
                "id=" + getId() +
                ", color='" + getColor() + '\'' +
                ", rotten=" + isRotten() +
                ", taste='" + taste + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Citrus citrus = (Citrus) obj;
        return Objects.equals(taste, citrus.taste);
    }


    public static void main(String[] args) {
        // Test the Citrus class
        Citrus orange = new Citrus("Sweet", "Orange", false);
        System.out.println(orange.toString());

        Citrus lemon = new Citrus("Sour", "Yellow", false);
        System.out.println(lemon.toString());
    }
}
