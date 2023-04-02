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
               return convertNumToRoman(Integer.parseInt(result));
            }
        }
    }

    static int romanToNumber(String roman) {
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
                return -1;
        }
    }

    static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        if (numArabian < 1) {
            throw new ArithmeticException("в римской системе нет нуля или отрицательных чисел");
        }
        return roman[numArabian];

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
