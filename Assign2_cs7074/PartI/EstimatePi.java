
public class EstimatePi {

	
	public static void estimatePi() {
		double sum = 0;
		int iterations = 0;
        while (Math.abs(Math.sqrt(6 * sum) - Math.PI) > 0.0001) {
            iterations++;
            sum += 1.0 / (iterations * iterations);	
        }
		
	
        
    double piEstimate = Math.sqrt(6 * sum);
    
    System.out.println("Pi is estimated as " + piEstimate + " after " + iterations + " iterations");
	}
	
	public static void main(String[] args) {	
		estimatePi();
		
	}
	
}
