public class Anagram {
    public static boolean isAnagram(String value, String value2)
    {
        var valueLength = value.length();
        var value2Length = value2.length();

        if(valueLength != value2Length)
        {
            return false;
        }

        var resultsTable = new int[128];
        var valueChars = value.toCharArray();
        var value2Chars = value2.toCharArray();

        for (int i =0; i< valueLength; i++)
        {
            var valueCharInt = (int)valueChars[i];
            resultsTable[valueCharInt] += 1;
        }

        for (int i =0; i< valueLength; i++)
        {
            var valueCharInt = (int)value2Chars[i];
            resultsTable[valueCharInt] -= 1;
        }

        for (var result : resultsTable) {
            if(result != 0)
            {
                return false;
            }
        }

        return true;
    }
}
