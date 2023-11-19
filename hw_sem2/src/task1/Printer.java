package task1;

/*
 * Напишите программу, которая проверяет, является ли введенная текстовая строка числом с плавающей точкой (float).
Программа пытается преобразовать введенную строку в число float, и если это успешно, она выводит полученное число.
Если преобразование не удалось, программа выдаёт сообщение об ошибке и возвращает специальное значение Float.NaN, чтобы обозначить ошибку.
 */

class IsFloat {
    public static float isFloat(String input) {

        float isFloat = 0;
        try {
            isFloat = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. Please, try again.");
            isFloat = Float.NaN;
        }
        return isFloat;
    }
}

public class Printer {
    public static void main(String[] args) {
        String input;

        if (args.length == 0) {
            input = "3.14a"; // По умолчанию используем "3.14", если аргумент не передан
        } else {
            input = args[0];
        }

        float result = IsFloat.isFloat(input);
        System.out.println(result);
    }
}

/**
 * Printer
 */
// public class Printer {

// public static void main(String[] args) {
// String p = "3.14ddd";
// float pp = Float.parseFloat(p);
// System.out.println(pp);
// }
// }