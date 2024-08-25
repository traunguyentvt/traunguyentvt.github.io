package nvntrau.com;

import java.util.*;

public class BeerExpert {
    public static List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();

        switch (color) {
            case "light":
                brands.add("Jack Pale");
                brands.add("Red Moose");
                break;

            case "amber":
                brands.add("Amber Pil");
                brands.add("Red Amber");
                break;

            case "brown":
                brands.add("Brown Bear");
                brands.add("Bock Brown");
                break;

            default:
                brands.add("Gout Stout");
                brands.add("Darkest Ale");
                break;
        }

        return brands;
    }
}
