import java.util.Scanner;

public class InputData {

    public String[] checkInputData() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println(
                        "Введите ФИО, дату рождения(формат dd.mm.yyyy) номер телефона(формат 89991234567), пол(формат f/m)");
                String stringData = sc.nextLine();
                String[] arrayStringData = stringData.split(" ");

                // System.out.println(Arrays.toString(splitStringData));
                try {
                    if (arrayStringData.length == 6) {
                        return arrayStringData;
                    } else {
                        throw new AmountDataException("Вы что-то не ввели или ввели лишнее, ввели: "
                                + arrayStringData.length + " данных из 6", arrayStringData.length);
                    }
                } catch (AmountDataException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
