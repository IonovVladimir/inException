public class RussianSymbolValidator {
    private String testString;


    public RussianSymbolValidator(String testString) {
        this.testString = testString;
    }

    public boolean testStringValidity() {
        try {
            boolean valid = testString.matches("^[а-яА-ЯёЁ]+$"); // исключение посторонних символов
            if (valid) {
                System.out.println("Язык верный");
                return true;
            } else {
                throw new IllegalArgumentException("Некорректный ввод "+ testString+". Язык ввода неверный или присутствуют посторонние символы.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("Проверка слова " + testString + " выполнена.");
        }
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    @Override
    public String toString() {
        return  "Принятое значение= "+testString;
    }
}
