package arraylists;
import java.util.Objects;

public class Apple extends Fruit {
    private String taste;
    private String texture;

    // Default constructor
    public Apple() {
        super(); // Calls the default constructor of the Fruit class
        this.taste = "Unknown";
        this.texture = "Unknown";
    }

    // Parameterized constructor
    public Apple(String taste, String texture, String color, boolean rotten) {
        super(color, rotten); // Calls the parameterized constructor of the Fruit class
        this.taste = taste;
        this.texture = texture;
    }

    // Getter and Setter for taste
    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    // Getter and Setter for texture
    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + getId() +
                ", color='" + getColor() + '\'' +
                ", rotten=" + isRotten() +
                ", taste='" + taste + '\'' +
                ", texture='" + texture + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Apple apple = (Apple) obj;
        return Objects.equals(taste, apple.taste) &&
               Objects.equals(texture, apple.texture);
    }



    public static void main(String[] args) {
        // Test the Apple class
        Apple redApple = new Apple("Sweet", "Crispy", "Red", false);
        System.out.println(redApple.toString());

        Apple greenApple = new Apple("Sour", "Crunchy", "Green", false);
        System.out.println(greenApple.toString());
        
        Apple apple1 = new Apple("Sweet", "Crispy", "Red", false);
        Apple apple2 = new Apple("Sweet", "Crispy", "Red", false);
        Apple apple3 = new Apple("Sour", "Soft", "Green", false);

        System.out.println("Are apple1 and apple1 equal? " + apple1.equals(apple1)); // Should return true
        System.out.println("Are apple1 and apple3 equal? " + apple1.equals(apple3)); // Should return false
    }
}
