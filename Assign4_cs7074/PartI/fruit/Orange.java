package fruit;
import java.util.Objects;


public class Orange extends Citrus {
    private String type;

    // Default constructor
    public Orange() {
        super(); // Calls the default constructor of the Citrus class
        this.type = "Unknown";
    }

    // Parameterized constructor
    public Orange(String type, String taste, boolean rotten) {
        super(taste, "Orange", rotten); // Calls the parameterized constructor of the Citrus class and sets the color to "Orange"
        this.type = type;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "id=" + getId() +
                ", color='" + getColor() + '\'' +
                ", rotten=" + isRotten() +
                ", taste='" + getTaste() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Orange orange = (Orange) obj;
        return Objects.equals(type, orange.type);
    }



    public static void main(String[] args) {
        // Test the Orange class
        Orange navel = new Orange("Navel", "Sweet", false);
        System.out.println(navel.toString());

        Orange valencia = new Orange("Valencia", "Juicy", false);
        System.out.println(valencia.toString());
        
        // Comparing two Orange objects
        Orange orange1 = new Orange("Navel", "Sweet", false);
        Orange orange3 = new Orange("Valencia", "Juicy", false);

        System.out.println("Are orange1 and orange1 equal? " + orange1.equals(orange1)); // Should return true
        System.out.println("Are orange1 and orange3 equal? " + orange1.equals(orange3)); // Should return false
    }
}
