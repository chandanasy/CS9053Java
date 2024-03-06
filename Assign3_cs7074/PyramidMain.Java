
public class PyramidMain {

    public static void main(String[] args) {
        SquarePyramid pyramid = new SquarePyramid(3.0, 4.0);
        System.out.println("Volume: " + pyramid.getVolume());
        System.out.println("Surface Area: " + pyramid.getSurfaceArea());
        System.out.println("Pyramid ID: " + pyramid.getId());
    }
}