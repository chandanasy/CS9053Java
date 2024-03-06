import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
	
	private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
	private String fileName;
 
    public ListOfNumbers () {
       
    	this.rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	
    }
    
    public ArrayList getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		
    		RDFTriple<Integer, Integer, Integer> t = new RDFTriple<Integer, Integer, Integer>(number1, number2, number3);
    		this.rdfTripleList.add(t);

    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() {
        this.rdfTripleList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");

                if (numbers.length != 3) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }

                try {
                    Integer subj = Integer.parseInt(numbers[0]);
                    Integer pred = Integer.parseInt(numbers[1]);
                    Integer obj = Integer.parseInt(numbers[2]);

                    System.out.println("Read: " + subj + " " + pred + " " + obj);

                    RDFTriple<Integer, Integer, Integer> triple = new RDFTriple<>(subj, pred, obj);
                    this.rdfTripleList.add(triple);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred()+ " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (input != null) {
                try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	listOfNumbers.createList();
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    	ListOfNumbers.cat("outFile.txt");
    }

}




