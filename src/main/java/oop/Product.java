package oop;

public class Product {
    double price;
    String name;
    String category;

    public void applyPriceDiscount(double discountPercentage){
        price = getPriceAfterDiscount(discountPercentage);
    }

    //methods in methods
    //when we use in a few places the same code ,is good to put that in one method
    public double getPriceAfterDiscount(double discountPercentage){
        return price - price * discountPercentage;
    }
}
