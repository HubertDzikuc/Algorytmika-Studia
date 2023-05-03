public class SystemFormation {

    public static String dec2Any(int val, int system)
    {
        String out = "";

        while(val > 0) {
            out += (char)(val%system + '0');
            val /= system;
        }

        String value = "";
        for(int i = out.length() - 1; i > -1; i--)
        {
            value += out.charAt(i);
        }

        return value;
    }

    public static int any2Dec(String val, int system)
    {
        int value = 0;
        for(int i =0; i< val.length(); i++)
        {
            value *= system;
            value += (val.charAt(i) - '0');
        }

        return value;
    }

    public static String String2Dec(String entryValue)
    {
        StringBuilder result = new StringBuilder();
        var entryValueChars = entryValue.toCharArray();

        for (var charValue: entryValueChars) {
            var valueInDec = dec2Any((int)charValue, 2);
            result.append(valueInDec);
        }

        return result.toString();
    }
}
