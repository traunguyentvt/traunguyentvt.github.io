package nvntrau.com;

import org.junit.*;

import java.util.List;

public class BeerExpertTest {

    @Test
    public void testGetBrandsLight() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("light");

        // Expected brands for light beer
        assertEquals(2, brands.size());
        assertTrue(brands.contains("Jack Pale"));
        assertTrue(brands.contains("Red Moose"));
    }

    @Test
    public void testGetBrandsAmber() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("amber");

        // Expected brands for amber beer
        assertEquals(2, brands.size());
        assertTrue(brands.contains("Amber Pil"));
        assertTrue(brands.contains("Red Amber"));
    }

    @Test
    public void testGetBrandsBrown() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("brown");

        // Expected brands for brown beer
        assertEquals(2, brands.size());
        assertTrue(brands.contains("Brown Bear"));
        assertTrue(brands.contains("Bock Brown"));
    }

    @Test
    public void testGetBrandsDark() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("dark");

        // Expected brands for dark beer
        assertEquals(2, brands.size());
        assertTrue(brands.contains("Gout Stout"));
        assertTrue(brands.contains("Darkest Ale"));
    }

    @Test
    public void testGetBrandsUnknownColor() {
        BeerExpert beerExpert = new BeerExpert();
        List<String> brands = beerExpert.getBrands("unknown");

        // Expected no brands for an unknown color
        assertEquals(0, brands.size());
    }
}

