import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        isIsomorphic("foo", "bar");
        System.out.println(isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        //This approach leverages the fact that characters in a string can be represented 
        // as integers to efficiently track the last seen position of each character.

        // Array length is 256 because ASCII defines 256 unique characters
        int[] num1 = new int[256];
        int[] num2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // if c1 is a duplicate char, then it must have been mapped to c2 before
            // that's why we do that chack. 
            if (num1[c1] != num2[c2]) {
                return false;
            }

            num1[c1] = i + 1;
            num2[c2] = i + 1;
        }

        return true;
        
        // This approcah is more general as it deals with all characters outside the ASCII
        // Map<Character, Character> smap = new HashMap<>();
        // Map<Character, Character> tmap = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char c1 = s.charAt(i);
        //     char c2 = t.charAt(i);

        //     if ((smap.containsKey(c1) && smap.get(c1) != c2) || (tmap.containsKey(c2) && tmap.get(c2) != c1)) {
        //         return false;
        //     }
        //     smap.put(c1, c2);
        //     tmap.put(c2, c1);

        // }

        // return true;
    }
}
