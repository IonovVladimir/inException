import java.io.IOException;

public class TelephoneValidator {
    private String testTelephone;

    public TelephoneValidator(String testTelephone) {
        this.testTelephone = testTelephone;
    }

    public String getTestTelephone() {
        return testTelephone;
    }

    public void setTestTelephone(String testTelephone) {
        this.testTelephone = testTelephone;
    }

    @Override
    public String toString() {
        return "Принятое значение= "+testTelephone;
    }

    public boolean testStringTelephone() {
        try {
            if(testTelephone.length()==11) {
                boolean valid = testTelephone.matches("^[0-9]+$"); // исключение посторонних символов
                if (valid) {
                    System.out.println("Номер корректный");
                    return true;
                } else {
                    throw new IllegalArgumentException("Некорректный ввод номера телефона " + testTelephone + ". Пример корректного ввода: 89883332201 ");
                }
            }
            else {
                throw new IOException("Номер телефона должен быть 11-ти значный!");
            }
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("Проверка телефона " + testTelephone + " выполнена.");
        }
    }
}
