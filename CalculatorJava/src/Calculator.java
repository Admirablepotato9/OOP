import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Calculator {
    
    // Sums two binary numbers and returns the result
    public static String sumBinary(String binary1, String binary2) {
        BigInteger sum1 = new BigInteger(binary1, 2);
        BigInteger sum2 = new BigInteger(binary2, 2);
        BigInteger sum = sum1.add(sum2);
        return sum.toString(2); // Returns the sum in binary
    }
    
    // Subtracts one binary number from another and returns the result
    public static String subtractBinary(String binary1, String binary2) {
        BigInteger res1 = new BigInteger(binary1, 2);
        BigInteger res2 = new BigInteger(binary2, 2);
        BigInteger diff = res1.subtract(res2);
        return diff.toString(2); // Returns the difference in binary
    }
    
    // Converts a decimal number to binary
    public static String decimalToBinary(String decimal) {
        BigDecimal BinNum = new BigDecimal(decimal);
        BigInteger intPart = BinNum.toBigInteger();
        BigDecimal fracPart = BinNum.remainder(BigDecimal.ONE);
        StringBuilder binaryBuilder = new StringBuilder(intPart.toString(2));
        
        if (fracPart.compareTo(BigDecimal.ZERO) != 0) {
            binaryBuilder.append('.');
            for (int i = 0; i < 10; i++) {
                fracPart = fracPart.multiply(BigDecimal.valueOf(2));
                binaryBuilder.append(fracPart.intValue());
                fracPart = fracPart.remainder(BigDecimal.ONE);
                if (fracPart.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
            }
        }
        
        return binaryBuilder.toString(); // Returns the binary representation
    }
    
    // Converts a decimal number to hexadecimal
    public static String decimalToHexadecimal(String decimal) {
        BigDecimal num = new BigDecimal(decimal);
        BigInteger intPart = num.toBigInteger();
        return intPart.toString(16); // Returns the integer part in hexadecimal
    }
    
    // Converts a decimal number to octal
    public static String decimalToOctal(String decimal) {
        BigDecimal num = new BigDecimal(decimal);
        BigInteger intPart = num.toBigInteger();
        return intPart.toString(8); // Returns the integer part in octal
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input validation for binary numbers
        String binary1, binary2;
        do {
            System.out.println("Enter the first binary number:");
            binary1 = scanner.nextLine();
        } while (!isValidBinary(binary1));

        do {
            System.out.println("Enter the second binary number:");
            binary2 = scanner.nextLine();
        } while (!isValidBinary(binary2));

        // Input validation for decimal number
        String decimal;
        do {
            System.out.println("Enter a decimal number:");
            decimal = scanner.nextLine();
        } while (!isValidDecimal(decimal));

        scanner.close();

        // Perform calculations and display results
        System.out.println("Binary sum: " + sumBinary(binary1, binary2));
        System.out.println("Binary subtraction: " + subtractBinary(binary1, binary2));
        System.out.println("Decimal to binary: " + decimalToBinary(decimal));
        System.out.println("Decimal to hexadecimal: " + decimalToHexadecimal(decimal));
        System.out.println("Decimal to octal: " + decimalToOctal(decimal));
    }

    // Validates if a string represents a valid binary number
    private static boolean isValidBinary(String binary) {
        return binary.matches("[01]+");
    }

    // Validates if a string represents a valid decimal number
    private static boolean isValidDecimal(String decimal) {
        try {
            new BigDecimal(decimal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}