
public class CharacterFrequency {

	public static char charFrequency(String s) {
		//array to hold the count of each character assuming lowercase a-z only
        int[] count = new int[26]; //26 letters in  alphabet

        //iterate over string and increment the count for each character.
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        //find the character with highest frequency.
        int maxIndex = 0; //index of the character with highest count
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }

        //return the character with the highest frequency
        return (char) (maxIndex + 'a');
    }

    public static String randomStringGenerator(int chars) {
        char[] charArray = new char[chars];
        for (int i = 0; i < charArray.length; i++) {
            char c = (char) ((int) (Math.random() * 26) + 'a');
            charArray[i] = c;
        }
        return new String(charArray);
    }

	
	
	public static void main(String[] args) {
		String s = "abcdeapapqarr";
		char result = charFrequency(s);
		System.out.println("The highest occurring character is: '" + result + "'");
    }
}
	
