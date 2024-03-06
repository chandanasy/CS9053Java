package fruit;
import java.util.Objects;

public class Fruit {
    private String color;
    private boolean rotten;
    private static int nextId = 1; // static field to hold the next ID value
    private final int id; // final because ID should not be changed once it's set

    // Default constructor
    public Fruit() {
        this.color = "Unknown";
        this.rotten = false;
        this.id = nextId++;
    }

    // Parameterized constructor
    public Fruit(String color, boolean rotten) {
        this.color = color;
        this.rotten = rotten;
        this.id = nextId++;
    }

    // Getter and Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter and Setter for rotten
    public boolean isRotten() {
        return rotten;
    }

    public void setRotten(boolean rotten) {
        this.rotten = rotten;
    }

    // Getter for id, no setter because id should not be changed
    public int getId() {
        return id;
    }

    // toString method to display class data
    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", rotten=" + rotten +
                '}';
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fruit fruit = (Fruit) obj;
        return rotten == fruit.rotten &&
               id == fruit.id &&
               Objects.equals(color, fruit.color);
    }

    public static void main(String[] args) {
        // Test the Fruit class
        Fruit apple = new Fruit("Red", false);
        System.out.println(apple.toString());

        Fruit banana = new Fruit("Yellow", false);
        System.out.println(banana.toString());
    }
}