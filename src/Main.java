
///неудача:(

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Введите данные через пробел!");
        System.out.println("Пример записи: Иванов Иван Иваныч 15.05.1969 89153332201 m");
        System.out.println("Обратите внимание, что пол должен быть указан латинскими буквами m или f");
        Person person1=getPersonFromUser();// а если недостаточно данных7((((((
        //System.out.println("..... тест после ввода главной строки: "+person1.getSurname());
        RussianSymbolValidator surname= new RussianSymbolValidator(person1.getSurname());
        //System.out.println("..... тест записи валидатора: "+str);

        //далее нужно делать метод метод для isValid...
        boolean isValid=surname.testStringValidity();
        if(isValid){
            //сохранение данных
            System.out.println(person1.getSurname()+" сохранён");
        }
        else {
            //данные не сохранены, потребовать исправить ошибку
            System.out.println("! Исправте ошибку: "+person1.getSurname());
            //String surname= scanner.nextLine();
            person1.setSurname(scanner.nextLine());//возможность один раз исправить
        }

        RussianSymbolValidator name= new RussianSymbolValidator(person1.getName());
        isValid = name.testStringValidity();
        if(isValid){
            //сохранение данных
            System.out.println(person1.getName()+" сохранён");
        }
        else {
            //данные требуют изменения, потребовать исправить ошибку
            System.out.println("! Исправте ошибку: "+person1.getName());
            //String surname= scanner.nextLine();
            person1.setName(scanner.nextLine());//возможность один раз исправить
        }

        RussianSymbolValidator patronymic= new RussianSymbolValidator(person1.getPatronymic());
        isValid = patronymic.testStringValidity();
        if(isValid){
            //сохранение данных
            System.out.println(person1.getPatronymic()+" сохранён");
        }
        else {
            //данные требуют изменения, потребовать исправить ошибку
            System.out.println("! Исправте ошибку: "+person1.getPatronymic());
            //String surname= scanner.nextLine();
            person1.setPatronymic(scanner.nextLine());//возможность один раз исправить
        }

        BirthdayValidator birthday= new BirthdayValidator(person1.getBirthDay());
        isValid = birthday.isValidBirthday();
        if(isValid){
            //сохранение данных
            System.out.println(person1.getBirthDay()+" сохранён");
        }
        else {
            //данные требуют изменения, потребовать исправить ошибку
            System.out.println("! Исправте ошибку : "+person1.getBirthDay());
            //String surname= scanner.nextLine();
            person1.setBirthDay(scanner.nextLine());//возможность один раз исправить
        }

        TelephoneValidator tel= new TelephoneValidator(person1.getTelephoneNumber());
        if(isValid){
            //сохранение данных
            System.out.println(person1.getTelephoneNumber()+" сохранён");
        }
        else {
            //данные требуют изменения, потребовать исправить ошибку
            System.out.println("! Исправте ошибку : "+person1.getTelephoneNumber());
            //String surname= scanner.nextLine();
            person1.setTelephoneNumber(scanner.nextLine());//возможность один раз исправить
        }


        isValid = isGenderValid(person1.getGender());
        if(isValid){
            //сохранение данных
            System.out.println(person1.getGender()+" сохранён");
        }
        else {
            //данные требуют изменения, потребовать исправить ошибку
            System.out.println("! Исправте ошибку : "+person1.getGender());
            //String surname= scanner.nextLine();
            person1.setGender(scanner.nextLine());//возможность один раз исправить
        }

        System.out.println("Проверка введённых данных: " +person1);

    }

    public static Person getPersonFromUser(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("начинай со строки ниже:");
        String userdata= scanner.nextLine();
        String[] data= userdata.split(" ");
        //Где лучше обработать?
        if(data.length==6) {
            return new Person(data[0], data[1], data[2], data[3], data[4], data[5]);
        }
        else {
            return null;
        }
    }

    public static boolean isGenderValid(String gender) {
        try {
            return "f".equals(gender) || "m".equals(gender);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}