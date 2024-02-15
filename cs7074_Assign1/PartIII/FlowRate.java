public class FlowRate {

    public static double calculateFlowRate(double radius, double length, double dynamicViscosity, double pressureChange) {
        double pi = Math.PI;
        // Using the given formula to calculate flow rate in cubic meters per second
        double flowRate = (pressureChange * pi * Math.pow(radius, 4)) / (8 * dynamicViscosity * length);
        // Convert cubic meters per second to liters per second
        return flowRate * 1000; // 1 cubic meter = 1000 liters
    }
    
    public static void main(String[] args) {
        double radius = .0127; // meters
        double length = 5; // meters
        double dynamicViscosity = 8.9E-4; // Pascal-seconds (Pa·s)
        double pressureChange = 22000; // Pascals (Pa)
        
        double flowRate = calculateFlowRate(radius, length, dynamicViscosity, pressureChange);
        System.out.println("The flow rate in liters/sec is: " + flowRate);
    }
}
