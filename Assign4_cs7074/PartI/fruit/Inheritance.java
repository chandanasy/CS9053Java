package fruit;

public class Inheritance {

	public static void main(String[] args) {
		//some scratch space to experiment/debug Fruit objects
		Fruit apple = new Fruit("Red", false);
        System.out.println(apple.toString());

        Fruit banana = new Fruit("Yellow", false);
        System.out.println(banana.toString());
        
        Citrus orange = new Citrus("Sweet", "Orange", false);
        System.out.println(orange.toString());

        Citrus lemon = new Citrus("Sour", "Yellow", false);
        System.out.println(lemon.toString());
        
        Apple redApple = new Apple("Sweet", "Crispy", "Red", false);
        System.out.println(redApple.toString());

        Apple greenApple = new Apple("Sour", "Crunchy", "Green", false);
        System.out.println(greenApple.toString());
        
        Orange navel = new Orange("Navel", "Sweet", false);
        System.out.println(navel.toString());

        Orange valencia = new Orange("Valencia", "Juicy", false);
        System.out.println(valencia.toString());
        
        Lemon regular = new Lemon(7, "Sour", false); // Assuming sourness is on a scale of 1-10, with 10 being very sour
        System.out.println(regular.toString());

        Lemon extraSour = new Lemon(10, "Very Sour", false);
        System.out.println(extraSour.toString());
	}

}