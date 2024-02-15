
public class ReverseSentence {

	public static String reverseSentence(String sentence) {
		//split the sentence into words.
        String[] words = sentence.split("\\s+");

        //reverse the array of words.
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        //ensure the first word of the resulting sentence is capitalized
        // and the original first word is lowercased if it's moved
        if (words.length > 0) {
            words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1).toLowerCase();
            if (words.length > 1) {
                words[words.length - 1] = words[words.length - 1].substring(0, 1).toLowerCase() + words[words.length - 1].substring(1);
            }
        }

        //join the words back into a sentence
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String result = reverseSentence("The quick brown fox jumps over the lazy dog");
        System.out.println(result);
    }
}
		
