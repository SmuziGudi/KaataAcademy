import java.util.*;


public class Main {
    public static void main(String[] args) {
        Integer[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI", "X"};

        System.out.println("input:");
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String op = "";
        do {
            String input = sc.next();

            String[] strings = input.split("\\W");
            String[] operator = input.split("\\w");
            try {
                boolean flag = false;
                for (int i = 0; i < roman.length; i++) {
                    if (roman[i].equals(strings[0]) || roman[i].equals(strings[1])) {
                        flag = true;
                    }
                }
                    //flag = true, значит будем иметь дело с римскими обозначениями
                    if (flag) {
                        a = romanToNumber(strings[0]);
                        b = romanToNumber(strings[1]);
                    } else {
                        a = Integer.parseInt(strings[0]);
                        b = Integer.parseInt(strings[1]);
                    }
                    op = operator[operator.length - 1];

                if (operation(a, b, op) < 0 || operator.length > 1){
                    throw new RuntimeException();
                }
                if(flag){
                    String result = numberToRoman(operation(a, b, op));
                    System.out.println("output: " + result);
                 }
                else if (a <= 10 && b <= 10) {
                    if (operation(a, b, op) >= 0) {
                        System.out.println("output: " + operation(a, b, op));
                    }
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }

    public static int romanToNumber(String strings) {
        if (strings.equals("I")) return 1;
        if (strings.equals("II")) return 2;
        if (strings.equals("III")) return 3;
        if (strings.equals("IV")) return 4;
        if (strings.equals("V")) return 5;
        if (strings.equals("VI")) return 6;
        if (strings.equals("VII")) return 7;
        if (strings.equals("VIII")) return 8;
        if (strings.equals("IX")) return 9;
        if (strings.equals("X")) return 10;
        return 0;
    }
    private static String numberToRoman(int result) {
        switch (result) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 11:
                return "XI";
            case 12:
                return "XII";
            case 13:
                return "XIII";
            case 14:
                return "XIV";
            case 15:
                return "XV";
            case 16:
                return "XVI";
            case 17:
                return "XVII";
            case 18:
                return "XVIII";
            case 19:
                return "XIX";
            case 20:
                return "XX";

            default:
                return null;
        }
    }

    private static int operation(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}