package sample.databases;

public class Ingredients_info {
    private String ingredients;
    private int weight;
    private String methodForPreparing;
    private int calories;

    public String getIngredients() {
        return ingredients;
    }

    public int getWeight() {
        return weight;
    }

    public String getMethodForPreparing() {
        return methodForPreparing;
    }

    public int getCalories() {
        return calories;
    }

    public Ingredients_info(String ingredients, int weight, String methodForPreparing, int calories){
        this.ingredients = ingredients;
        this.weight = weight;
        this.methodForPreparing = methodForPreparing;
        this.calories = calories;
    }
}
