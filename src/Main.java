import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);




        Map<String, String> data = new HashMap<>();



        while (true) {

            System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");

            String input = scanner.nextLine();




            if (input.isEmpty()) {

                break;

            }




            String[] parts = input.split(" ");




            if (parts.length != 6) {

                System.out.println("Ошибка ввода данных. Попробуйте еще раз.");

                continue;

            }



            String lastName = parts[0];

            String firstName = parts[1];

            String patronymic = parts[2];

            String dateOfBirth = parts[3];

            String phoneNumber = parts[4];

            String gender = parts[5];




            if (!isValidDate(dateOfBirth) || !isValidPhoneNumber(phoneNumber) || !isValidGender(gender)) {

                System.out.println("Ошибка ввода данных. Попробуйте еще раз.");

                continue;

            }




            String dataString = lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender;





            try {



                BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));

                writer.write(dataString);

                writer.newLine();

                writer.close();

            } catch (IOException e) {

                System.out.println("Ошибка при записи в файл.");

                e.printStackTrace();

            }




            data.put(lastName, dataString);

        }




        for (Map.Entry<String, String> entry : data.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());

        }





        scanner.close();

    }




    private static boolean isValidDate(String date) {

        String regex = "\\d{2}\\.\\d{2}\\.\\d{4}";

        return date.matches(regex);

    }




    private static boolean isValidPhoneNumber(String phoneNumber) {

        String regex = "\\d+";

        return phoneNumber.matches(regex);

    }




    private static boolean isValidGender(String gender) {

        return gender.equals("f") || gender.equals("m");

    }

}