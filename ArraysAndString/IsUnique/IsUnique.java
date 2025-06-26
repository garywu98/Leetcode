import java.util.Set;
import java.util.HashSet;

/*
Is Unique
Problem: Implement an algorithm to determine if a string has all unique characters.
Alternative Problem: What if you cannot use additional data structures?
*/
public class IsUnique {
    /*
    1. Create a set for characters seen
    2. Loop through all characters in inputString
        3. If current character is not seen, add it to the set
        4. Else return false
    3. If we break out of loop, return true since no character was seen twice
    */
    public static boolean isUnique( String inputString ) 
    {
        Set<Character> charSeen = new HashSet<>();
        for(int i = 0; i < inputString.length(); i++)
        {
            char current = inputString.charAt(i);
            if(charSeen.contains(current))
            {
                return false;
            }

            charSeen.add(current);
        }

        return true;
    }

    /*
    1. Create an array of boolean values, size 128 (ASCII has 128 unique values)
    2. Loop through all character in inputString
        3. Get int value (index) of character
        4. If boolean value at index, return false
        5. Else set boolean value to true at index
    6. If we break out of loop, return true since no character was seen twice
    */
    public static boolean isUniqueNoAdditionalDS( String inputString ) 
    {
        boolean[] charSeen = new boolean[128];

        for(int i = 0; i < inputString.length(); i++)
        {
            int current_val_index = inputString.charAt(i);
            if(charSeen[current_val_index])
            {
                return false;
            }

            charSeen[current_val_index] = true;
        }

        return true;
    }

    public static void main(String[] args)
    {
        /*
        Tests:
            1. Edge case: empty string, expect true
            2. False case: failedfailed, expect false
            3. True case: noDuplicate, expect true
            4. Long case: qwertyuiopasdfghjklzxcvbnm1234567890, expect true
        */
        System.out.println("Edge case: empty string, expect true");
        System.out.println(isUnique(""));
        System.out.println(isUniqueNoAdditionalDS(""));
        System.out.println("False case: failedfailed, expect false");
        System.out.println(isUnique("failedfailed"));
        System.out.println(isUniqueNoAdditionalDS("failedfailed"));
        System.out.println("True case: noDuplicate, expect true");
        System.out.println(isUnique("noDuplicate"));
        System.out.println(isUniqueNoAdditionalDS("noDuplicate"));
        System.out.println("Long case: qwertyuiopasdfghjklzxcvbnm1234567890, expect true");
        System.out.println(isUnique("qwertyuiopasdfghjklzxcvbnm1234567890"));
        System.out.println(isUniqueNoAdditionalDS("qwertyuiopasdfghjklzxcvbnm1234567890"));
    }
}