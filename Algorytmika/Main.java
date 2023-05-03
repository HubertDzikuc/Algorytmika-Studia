import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Set value to be converted: ");
        Scanner scanner = new Scanner(System.in);
        var value = scanner.next();
        var converted = SystemFormation.String2Dec(value);
        System.out.println("Converted Value: " + converted);
    }
//        System.out.println("Set value to be compressed: ");
//        Scanner scanner = new Scanner(System.in);
//        var value = scanner.next();
//        var compressed = Compresion.Counting.Compress(value);
//        var decompressed = Compresion.Counting.Decompress(compressed);
//        var equal = value.equals(decompressed);
//
//        System.out.println("Compressed Value: " + compressed);
//        System.out.println("Decompressed Value: " + decompressed);
//        System.out.println("Decompressed Properly: " + equal);


//        System.out.println("Set value to be encrypted: ");
//        Scanner scanner = new Scanner(System.in);
//        var value = scanner.next();
//        var encryptingKey = "encryption";
//
//        var encryptedValue = Encription.Key.Encrypt(value, encryptingKey);
//        var decryptedValue = Encription.Key.Decrypt(encryptedValue, encryptingKey);
//        var equal = value.equals(decryptedValue);
//
//        System.out.println("Encrypted Value: " + encryptedValue);
//        System.out.println("Decrypted Value: " + decryptedValue);
//        System.out.println("Decrypted Properly: " + equal);
}