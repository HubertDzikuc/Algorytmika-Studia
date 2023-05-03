import java.util.ArrayList;

public class BruteForce {

    public static ArrayList<Integer> search(String text, String pattern) {
        var textLength = text.length();
        var patternLength = pattern.length();
        var searchRange = textLength - patternLength + 1;
        ArrayList<Integer> results = new ArrayList<Integer>();

        for (int textIndex = 0; textIndex < searchRange; textIndex++)
        {
            boolean found = true;
            for(var searchIndex = 0; searchIndex < patternLength; searchIndex++)
            {
                var currentTextChar = text.charAt(textIndex + searchIndex);
                var currentPatternChar = pattern.charAt(searchIndex);

                if (currentTextChar != currentPatternChar)
                {
                    found = false;
                    break;
                }
            }

            if(found)
            {
                results.add(textIndex);
            }
        }

        return results;
    }
}
