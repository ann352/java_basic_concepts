package modifiers;

public class Product {

    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        if(price <0)throw new RuntimeException("Negative price is not allowed");
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        if(price <0)throw new RuntimeException("Negative price is not allowed");
        this.price = price;
    }
    //Now only legal way to change the price is to use setPrice() which ensures correctness of the value
    //But since the price field is private, we also should provide getter to get its value

    //usage of modifiers:
    //package-private - we use when methods and fields, or classes should be freely accessible by all classes in our package
    //public - all classes, fields and methods that are public are intended for use by everyone
    //private, protected, package-private (lack of modifier) - more internal / complicated, or those whose irresponsible use could spoil the intended operation of the application

}
