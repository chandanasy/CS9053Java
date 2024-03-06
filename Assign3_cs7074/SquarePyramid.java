
public class SquarePyramid {

    private static int nextId = 1;
    private int id;
    private double side;
    private double height;

    public SquarePyramid(double side, double height) {
        this.id = nextId++;
        this.side = side;
        this.height = height;
    }
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return (1.0 / 3) * side * side * height;
    }

    public double getSlantHeight() {
        return Math.sqrt((side / 2) * (side / 2) + height * height);
    }

    public double getSurfaceArea() {
        double slantHeight = getSlantHeight();
        return side * side + 2 * side * slantHeight;
    }

    public int getId() {
        return id;
    }

}
