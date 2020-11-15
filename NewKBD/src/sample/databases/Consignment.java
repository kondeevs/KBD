package sample.databases;

public class Consignment {
    private String date;
    private int providerId;
    private String ingredients;
    private int price;

    public String getDate() {
        return date;
    }

    public int getProviderId() {
        return providerId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    public Consignment(String date, int providerId, String ingredients, int price){
        this.date = date;
        this.providerId = providerId;
        this.ingredients = ingredients;
        this.price = price;
    }
}
