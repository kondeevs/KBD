package sample.databases;

public class Foodstuff {
    private String foodStuffName;
    private String ingredients;
    private int recipeId;
    private int caloriesFood;

    public String getFoodStuffName() {
        return foodStuffName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getCaloriesFood() {
        return caloriesFood;
    }

    public Foodstuff(String foodStuffName, String ingredients, int recipeId, int caloriesFood){
        this.foodStuffName = foodStuffName;
        this.ingredients = ingredients;
        this.recipeId = recipeId;
        this.caloriesFood = caloriesFood;
    }
}
