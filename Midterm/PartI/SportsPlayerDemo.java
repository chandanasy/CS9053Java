import java.util.ArrayList;
import java.util.Collections;


public class SportsPlayerDemo {
    public static void main(String[] args) {
        // Create an ArrayList to hold SportsPlayer objects
        ArrayList<SportsPlayer> players = new ArrayList<>();

        // Instantiate two of each concrete player class
        players.add(new ShotputPlayer(100, "male", 22));
        players.add(new ShotputPlayer(95, "female", 18));
        players.add(new TrackPlayer(75, "male", 200));
        players.add(new TrackPlayer(65, "female", 300));
        players.add(new BaseballPlayer(90, "male", 30));
        players.add(new BaseballPlayer(85, "female", 25));
        players.add(new BasketballPlayer(110, "male", 210));
        players.add(new BasketballPlayer(105, "female", 190));
        players.add(new VolleyballPlayer(80, "female", 10));
        players.add(new VolleyballPlayer(78, "male", 15));
        players.add(new PoleVaultPlayer(70, "male", 450));
        players.add(new PoleVaultPlayer(68, "female", 420));
        players.add(new CrossCountryPlayer(60, "female", 4.5));
        players.add(new CrossCountryPlayer(64, "male", 4.2));

        // Sort the list in ascending order of weight
        Collections.sort(players);
        System.out.println("Players sorted by ascending weight:");
        for (SportsPlayer player : players) {
            System.out.println(player);
        }

        // Sort the list in descending order of weight
        players.sort(Collections.reverseOrder());
        System.out.println("\nPlayers sorted by descending weight:");
        for (SportsPlayer player : players) {
            System.out.println(player);
        }

        // Calculate and print the average weight of players
        double averageWeight = getAverageWeight(players);
        System.out.println("\nAverage weight of players: " + averageWeight);
    }

    public static double getAverageWeight(ArrayList<SportsPlayer> players) {
        if (players.isEmpty()) {
            return 0.0;
        }
        double totalWeight = 0;
        for (SportsPlayer player : players) {
            totalWeight += player.getWeight();
        }
        return totalWeight / players.size();
    }
}
