import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Palindrom {
    //searchFileForPalindromsAndSendResultToFile("palindromy.txt", "outputPalindromy.txt");
    //searchFileForAnagramsAndSendResultToFile("anagramy.txt", "outputAnagrams.txt");

    public static void searchFileForAnagramsAndSendResultToFile(String inputFileName, String outputFileName) throws FileNotFoundException {
        var inputText = FileOperations.readFileString(inputFileName);
        FileOperations.cleanFile(outputFileName);

        ArrayList<String> anagrams = new ArrayList<>();

        var lineIndex = 0;
        for (var line : inputText)
        {
            var line2Index = 0;
            for (var line2 : inputText)
            {
                if (lineIndex != line2Index && Anagram.isAnagram(line, line2)) {
                    anagrams.add("[" + lineIndex + "] " + line + " : " + "[" + line2Index + "] " + line2);
                }
                line2Index++;
            }
            lineIndex++;
        }

        FileOperations.writeFile(anagrams, outputFileName);
    }

    public static void searchFileForPalindromsAndSendResultToFile(String inputFileName, String outputFileName) throws FileNotFoundException {
        var inputText = FileOperations.readFileString(inputFileName);
        FileOperations.cleanFile(outputFileName);

        ArrayList<String> palindroms = new ArrayList<>();

        for (var line : inputText)
        {
            if(Palindrom.isPalindrom(line))
            {
                palindroms.add(line);
            }
        }

        FileOperations.writeFile(palindroms, outputFileName);
    }
    public static boolean isPalindrom(String value)
    {
        var valueLength = value.length();

        for(int searchIndex = 0; searchIndex < valueLength; searchIndex++)
        {
            var lastSearchIndex = valueLength - searchIndex - 1;

            var currentSearchChar = value.charAt(searchIndex);
            var currentLastSearchChar = value.charAt(lastSearchIndex);

            if(currentSearchChar != currentLastSearchChar)
            {
                return false;
            }
        }

        return true;
    }
}
