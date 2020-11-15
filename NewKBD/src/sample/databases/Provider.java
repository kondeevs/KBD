package sample.databases;

public class Provider {
    private int providerId;
    private String ingredients;
    private String address;
    private int phone;

    public int getProviderId() {
        return providerId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public Provider(int providerId, String ingredients, String address, int phone){
        this.providerId = providerId;
        this.ingredients = ingredients;
        this.address = address;
        this.phone = phone;
    }
}
