package sample.databases;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private String description;
    private int authorId;

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getDescription() {
        return description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public Recipe(int recipeId, String recipeName, String description, int authorId){
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.description = description;
        this.authorId = authorId;
    }
}
