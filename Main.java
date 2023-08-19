import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static String[] calc(String input){
        String[] calcul = input.split(" ");
        if (calcul.length >= 5){
            String indexes = scanner.nextLine();
            if (operation != 0){
                char[] new_str = new char[10];
                for (int i = 0; i < input.length(); i++){
                    new_str[i] = input.charAt(i);
                    if(new_str[i] == '+'){throw new RuntimeException("В выражении может быть только 1 +");}
                    if(new_str[i] == '-'){throw new RuntimeException("В выражении может быть только 1 -");}
                    if(new_str[i] == '*'){throw new RuntimeException("В выражении может быть только 1 *");}
                    if(new_str[i] == '/'){throw new RuntimeException("В выражении может быть только 1 /");}
                }
            }
            return calc(input);
        }else {
            return calcul;
        }
    }
    public static void main (String[] args) throws Exception, NumberFormatException {
        System.out.println("Input: ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]", 10);
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        String string04 = stable00.trim();
        calc(userInput);
        number1 = romanToNumber(string04);
        number2 = romanToNumber(string03);
        try {
            if (number1 != 0 && number2 != 0){
                if (number1 < 0 && number2 < 0) {
                    result = 0;
                } else {
                    result = calculated(number1, number2, operation);
                    System.out.println("Output: ");
                    try{
                        String resultRoman = convertNumToRoman(result);
                        System.out.println(resultRoman);
                        return;
                    } catch (Exception e) {
                        throw new RuntimeException("Римское число не может быть отрицательным");
                    }
                }
            }
            number1 = Integer.parseInt(string04);
            number2 = Integer.parseInt(string03);
        }catch (NumberFormatException e) {
            throw new RuntimeException("Калькулятор может работать только с 2 римскими или с 2 арабскими числами");
        }
        if (number1 > 10 || number2 > 10){
            throw new Exception("Введи 2 числа в диапозоне от 0 до 10");
        }
        result = calculated(number1, number2, operation);
        System.out.println("Output: \n"+result);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"null","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber (String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return 0;
        }
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Попробуй сначала, введи 2 натуральных числа > 0");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
