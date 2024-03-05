package heros;

public class HeroException extends Exception {
    // Default serialVersionUID for serialization
    private static final long serialVersionUID = 1L;

    public HeroException(String message) {
        super(message);
    }
}
