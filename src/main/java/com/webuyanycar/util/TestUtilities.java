package com.webuyanycar.util;

import com.webuyanycar.base.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtilities {
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 20;


    public static ArrayList<Car> loadExistingCarData(String fileName) {

        ArrayList<Car> carData = new ArrayList<>();
        ArrayList<String> lineOfData = readFile(fileName, "output");
        System.out.println("this is " + lineOfData);
        for (String data : lineOfData) {
            Object[] VehicleData = data.split(",");
            Car car = new Car(VehicleData[0].toString(), VehicleData[1].toString(), VehicleData[2].toString(), VehicleData[3].toString());
            carData.add(car);

        }

        return carData;

    }


    public static ArrayList<String> readFile(String fileName, String typeOfFile) {
        ArrayList<String> data = new ArrayList<>();
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/webuyanycar/testdata/" + fileName;
        String regex = "\\b[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}\\b";

        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (typeOfFile.equals("input")) {
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {

                        data.add(matcher.group().replaceAll("\\s", ""));
                    }
                } else {
                    data.add(line);
                }

                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return data;
    }

    public static String randomMileage(int min, int max) {

        Random random = new Random();

        int randomNumber = min + random.nextInt(max - min + 1);

        return String.format("%,d", randomNumber);
    }

}
