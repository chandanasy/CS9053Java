import java.util.ArrayList;
import java.util.Collections;

// Define the abstract base class SportsPlayer
abstract class SportsPlayer implements Comparable<SportsPlayer> {
    private int weight;
    private String gender; // "male" or "female"
    private static int nextId = 1;
    private final int id;

    protected SportsPlayer(int weight, String gender) {
        this.weight = weight;
        this.gender = gender;
        this.id = nextId++;
    }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public int getId() { return id; }

    @Override
    public int compareTo(SportsPlayer other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SportsPlayer that = (SportsPlayer) obj;
        return weight == that.weight && gender.equals(that.gender);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "weight=" + weight +
               ", gender='" + gender + '\'' +
               ", id=" + id +
               '}';
    }
}

// Define the abstract subclass BallSportsPlayer
abstract class BallSportsPlayer extends SportsPlayer {
    protected BallSportsPlayer(int weight, String gender) {
        super(weight, gender);
    }
}

// Define the abstract subclass FieldSportsPlayer
abstract class FieldSportsPlayer extends SportsPlayer {
    protected FieldSportsPlayer(int weight, String gender) {
        super(weight, gender);
    }
}

// Define the abstract subclass RunningSportsPlayer
abstract class RunningSportsPlayer extends SportsPlayer {
    protected RunningSportsPlayer(int weight, String gender) {
        super(weight, gender);
    }
}

// Define concrete classes for each type of sports player
class ShotputPlayer extends FieldSportsPlayer {
    private int maxDistance;

    public ShotputPlayer(int weight, String gender, int maxDistance) {
        super(weight, gender);
        this.maxDistance = maxDistance;
    }

    public int getMaxDistance() { return maxDistance; }
    public void setMaxDistance(int maxDistance) { this.maxDistance = maxDistance; }
}

class TrackPlayer extends RunningSportsPlayer {
    private int distance;

    public TrackPlayer(int weight, String gender, int distance) {
        super(weight, gender);
        this.distance = distance;
    }

    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
}

class BaseballPlayer extends BallSportsPlayer {
    private int rbi;

    public BaseballPlayer(int weight, String gender, int rbi) {
        super(weight, gender);
        this.rbi = rbi;
    }

    public int getRbi() { return rbi; }
    public void setRbi(int rbi) { this.rbi = rbi; }
}

class BasketballPlayer extends BallSportsPlayer {
    private int height;

    public BasketballPlayer(int weight, String gender, int height) {
        super(weight, gender);
        this.height = height;
    }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}

class VolleyballPlayer extends BallSportsPlayer {
    private int maxPoints;

    public VolleyballPlayer(int weight, String gender, int maxPoints) {
        super(weight, gender);
        this.maxPoints = maxPoints;
    }

    public int getMaxPoints() { return maxPoints; }
    public void setMaxPoints(int maxPoints) { this.maxPoints = maxPoints; }
}

class PoleVaultPlayer extends FieldSportsPlayer {
    private int maxHeight;

    public PoleVaultPlayer(int weight, String gender, int maxHeight) {
        super(weight, gender);
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() { return maxHeight; }
    public void setMaxHeight(int maxHeight) { this.maxHeight = maxHeight; }
}

class CrossCountryPlayer extends RunningSportsPlayer {
    private double bestMileTime;

    public CrossCountryPlayer(int weight, String gender, double bestMileTime) {
        super(weight, gender);
        this.bestMileTime = bestMileTime;
    }

    public double getBestMileTime() { return bestMileTime; }
    public void setBestMileTime(double bestMileTime) { this.bestMileTime = bestMileTime; }
}

