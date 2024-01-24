import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayValidator {
    private static String birthday;

    public BirthdayValidator(String birthday) {
        this.birthday = birthday;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static boolean isValidBirthday() {
        // Устанавливаем ожидаемый формат даты
        SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
        form.setLenient(false); // Устанавливаем строгий режим для проверки даты

        try {
            // Проверяем, что дата соответствует формату и год четырехзначный
            if (birthday.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                Date date = form.parse(birthday);
                // Проверка, что дата не в будущем
                if (date.after(new Date())) {
                    System.out.println("Дата рождения в будущем!");
                    return false;
                } else {
                    System.out.println("Дата рождения в прошлом!");
                    return true;
                }
            } else {
                System.out.println("Неверный формат даты. Год должен быть четырехзначным!");
                return false;
            }
        } catch (ParseException e) {
            // Обработка исключения при неверном формате даты
            System.out.println("Ошибка парсинга даты. Неверный формат!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Принятое значение= "+birthday;
    }
}
