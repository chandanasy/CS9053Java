package arraylists;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class FruitArraylist {

    public static void main(String[] args) {
        
        // This ArrayList MUST be parameterized to hold Fruit objects
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();

        // Creating the specified fruit objects and adding them to the ArrayList
        Apple nonRottenRedApple = new Apple("Sweet", "Crisp", "Red", false);
        fruitArrayList.add(nonRottenRedApple);

        Apple rottenGreenApple1 = new Apple("Tart", "Soft", "Green", true);
        fruitArrayList.add(rottenGreenApple1);
        Apple rottenGreenApple2 = new Apple("Tart", "Soft", "Green", true);
        fruitArrayList.add(rottenGreenApple2);

        // Creating a random number generator for lemon sourness
        Random random = new Random();

        Lemon lemon1 = new Lemon(random.nextInt(101), "Sour", false);
        fruitArrayList.add(lemon1);
        Lemon lemon2 = new Lemon(random.nextInt(101), "Sour", false);
        fruitArrayList.add(lemon2);
        Lemon lemon3 = new Lemon(random.nextInt(101), "Sour", false);
        fruitArrayList.add(lemon3);

        Orange rottenOrange1 = new Orange("Mandarin", "Sweet", true);
        fruitArrayList.add(rottenOrange1);
        Orange rottenOrange2 = new Orange("Mandarin", "Sweet", true);
        fruitArrayList.add(rottenOrange2);

        // 2.a   Print the ArrayList
        for (Fruit fruit : fruitArrayList) {
            System.out.println(fruit);
        }
        
        
        //2.b    Average lemon sourness
        int totalSourness = 0;
        int lemonCount = 0;
        for (Fruit fr : fruitArrayList) {
            if (fr instanceof Lemon) {
                Lemon lemon = (Lemon) fr;
                totalSourness += lemon.getSourness();
                lemonCount++;
            }
        }
        
        if (lemonCount > 0) { // to avoid division by zero
            double averageSourness = (double) totalSourness / lemonCount;
            System.out.println("Average sourness of all Lemon objects: " + averageSourness);
        } else {
            System.out.println("No Lemon objects found in the ArrayList.");
        }
        
        //2.c 
        
        System.out.println("Removing any TART, SOFT, GREEN, and ROTTEN APPLES");
        Apple rottenGreenApple11 = new Apple("Tart", "Soft", "Green", true);

        if (rottenGreenApple11 != null) {
            List<Fruit> toRemove = new ArrayList<>();

            for (Fruit fruit : fruitArrayList) {
                if (fruit instanceof Apple) {
                    Apple apple = (Apple) fruit;

                    if (apple.getColor().equals(rottenGreenApple11.getColor()) 
                    		&& apple.getTaste().equals(rottenGreenApple11.getTaste())
                    		&& apple.getTexture().equals(rottenGreenApple11.getTexture())
                    		&& apple.isRotten() == rottenGreenApple11.isRotten()) {
                        System.out.println(apple + " is equal to the Apple object in the variable.");
                        toRemove.add(apple);
                    }

                    if (apple == rottenGreenApple11) {
                        System.out.println(apple + " is the same object as the one in the variable.");
                    }
                }
            }

            fruitArrayList.removeAll(toRemove);

            System.out.println("ArrayList after removal:");
            for (Fruit fruit : fruitArrayList) {
                System.out.println(fruit);
            }
        }
    

        
        
    }
}


