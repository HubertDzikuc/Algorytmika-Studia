import java.util.ArrayList;

public class Compresion {
    public class Counting {

        public static String Compress(String entryValue)
        {
            StringBuilder result = new StringBuilder();
            var entryValueChars = entryValue.toCharArray();
            char currentGroupingValue = entryValueChars[0];
            int counterInGroup = 0;
            for(int i =0 ; i < entryValueChars.length; i++)
            {
                var currentValue = entryValueChars[i];
                if(currentValue == currentGroupingValue)
                {
                    counterInGroup ++;
                }
                else
                {
                    result.append(counterInGroup);
                    result.append(currentGroupingValue);
                    counterInGroup = 1;
                    currentGroupingValue = currentValue;
                }
            }

            result.append(counterInGroup);
            result.append(currentGroupingValue);

            return result.toString();
        }

        public static String Decompress(String entryValue)
        {
            StringBuilder result = new StringBuilder();
            var entryValueChars = entryValue.toCharArray();
            String currentGroupingCount = "";
            for(int i =0 ; i < entryValueChars.length; i ++)
            {
                var currentValue = entryValueChars[i];
                if(currentValue >= '0' && currentValue <= '9')
                {
                    currentGroupingCount += currentValue;
                }
                else
                {
                    for(int j = 0; j < Integer.parseInt(currentGroupingCount); j++)
                    {
                        result.append(currentValue);
                    }
                    currentGroupingCount = "";
                }
            }

            return result.toString();
        }
    }
}
