public class Encription {
    public class Ceasar {
        public static String Encrypt(String entryValue, int encryptingKey) {
            //122 - 65 = 57
            var charArray = entryValue.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = MoveByValue(charArray[i], encryptingKey);
            }

            return String.copyValueOf(charArray);
        }

        public static String Decrypt(String entryValue, int encryptingKey) {
            return Encrypt(entryValue, -encryptingKey);
        }
    }

    private static char MoveByValue(char value, int key)
    {
        var newValue = (int)value + key;
        if(newValue > 122)
        {
            newValue = newValue - 58;
        }
        else if(newValue < 65)
        {
            newValue = newValue + 58;
        }

        return (char)newValue;
    }

    public class Key {
        public static String Encrypt(String entryValue, String encryptingKey) {
            return InternalEncrypt(entryValue, encryptingKey, true);
        }

        public static String Decrypt(String entryValue, String encryptingKey) {
            return InternalEncrypt(entryValue, encryptingKey, false);
        }

        private static String InternalEncrypt(String entryValue, String encryptingKey, Boolean encrypt) {
            var entryValueChars = entryValue.toCharArray();
            var encryptingKeyChars = encryptingKey.toCharArray();
            var modifier = encrypt ? 1 : -1;

            int currentEncryptionKey = 0;
            for (int i = 0; i < entryValueChars.length; i++) {
                var encryptionValue = (int)encryptingKeyChars[currentEncryptionKey] * modifier;

                var newValue = (int) entryValueChars[i] + encryptionValue;
                if(newValue >= 127)
                {
                    newValue = newValue - 127;
                }
                else if(newValue < 0)
                {
                    newValue = newValue + 127;
                }
                entryValueChars[i] = (char) newValue;

                currentEncryptionKey ++;
                if(currentEncryptionKey >= encryptingKeyChars.length)
                {
                    currentEncryptionKey = 0;
                }
            }

            return String.copyValueOf(entryValueChars);
        }
    }
}
