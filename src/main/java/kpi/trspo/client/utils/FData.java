package kpi.trspo.client.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FData {
    private static final Random rand = new Random();
    private static final List<String> names = Arrays.asList("Vova", "Vlad", "Alex", "Sasha");
    private static final List<String> surnames = Arrays.asList("Petrov", "Vasiliev", "Durov", "Titov");
    private static final List<String> phoneNumbers = Arrays.asList("+380687751468", "+380687771111", "0685551111", "0994442222");
    private static final List<String> materials = Arrays.asList("Sosna 4m", "Brus 20x20", "Dranka 25mm", "Gorbil");

    public static String getName(){return names.get(rand.nextInt(names.size()));}

    public static String getSurname(){return surnames.get(rand.nextInt(surnames.size()));}

    public static String getPhone(){return phoneNumbers.get(rand.nextInt(phoneNumbers.size()));}

    public static String getMaterial(){return materials.get(rand.nextInt(materials.size()));}

    public static double getVolume(){return rand.nextDouble() * 10.0;}

    public static double getPrice(){return rand.nextDouble() * 2000.0;}

    public static double getPPrice(){return rand.nextDouble() * 400.0;}
}
