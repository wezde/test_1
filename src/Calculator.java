import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Scanner sc = new Scanner(System.in);
    static String result;
    static int number_1;
    static int number_2;
    static String operator;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите через пробел: число, оператор(+, -, *, /), число :");
        System.out.println(result = calc(sc.nextLine()));
    }

    public static String calc(String userInput) throws Exception {
        String result = "";
        String[] input = userInput.split(" ");
        if (input.length != 3) {
            throw new Exception("вы ввели неправильное число символов");
        }
        operator = input[1];

        try {
            number_1 = Integer.parseInt(input[0]);
            number_2 = Integer.parseInt(input[2]);
            if (number_1 > 10 || number_2 > 10) {
                throw new Exception("Вы ввели число больше 10.");
            } else {
             return result = calculated(number_1, number_2, operator);
            }
        } catch (NumberFormatException e) {
            number_1 = romanToNumber(input[0]);
            number_2 = romanToNumber(input[2]);
            if (number_1 < 0 || number_2 < 0) {
                throw new Exception("Вы ввели недопустимый символ");
            } else {
                result = calculated(number_1, number_2, operator);
                String resultRoman = convertNumToRoman(Integer.parseInt(result));
                return resultRoman;
            }
        }
    }

    static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        if (numArabian < 1) {
            throw new ArithmeticException("в римской системе нет нуля и отрицательных чисел");
        }
        final String s = roman[numArabian];
        return s;
    }

    static String calculated(int a, int b, String operator) throws Exception {
        switch (operator) {
            case ("+"):
                return result = String.valueOf(number_1 + number_2);
            case ("-"):
                return result = String.valueOf(number_1 - number_2);
            case ("*"):
                return result = String.valueOf(number_1 * number_2);
            case ("/"):
                return result = String.valueOf(number_1 / number_2);
            default:
                throw new Exception("Символ не является математическим оператором");
        }
    }
}
