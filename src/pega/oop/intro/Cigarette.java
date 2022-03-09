package pega.oop.intro;

public class Cigarette {
        //// Attributes
        int price;
        String brands;
        String flavors;

        //// Constructors

    public Cigarette (int price, String brands, String flavors) {
        this.price = price;
        this.brands = brands;
        this.flavors = flavors;

    }
        //// Methods
    public int getPrice () {
        return price;
    }
    public String getBrands () {
        return brands;
    }
    public String getFlavors () {
        return flavors;
    }
}

