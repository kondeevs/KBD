package sample;

import sample.databases.*;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void startMenu() throws SQLException, ClassNotFoundException {
        System.out.println("1 - Food Stuff\n" +
                "2 - Recipe\n" +
                "3 - Providers\n" +
                "4 - Check Consignment by (date and provider)\n" +
                "5 - Dishes with min calories\n" +
                "6 - Dishes and Recipes list\n" +
                "7 - Exit\n");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        switch (a) {
            case 1: {
                try {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("\t" + "Food Staff" + "\t" + "Ingredients" + "\t\t" + "Recipe id" + "\t" + "Calories");
                    System.out.println("-----------------------------------------------------------------");
                    createFoodStuff();
                    System.out.println("-----------------------------------------------------------------");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Error" + e);
                }
                System.out.println("1 - Add new object in database\n" +
                        "2 - Delete object in database\n" +
                        "3 - Edit object in database\n" +
                        "4 - End\n");
                a = scanner.nextInt();
                switch (a) {
                    case 1: {
                        addObjectFoodStuff();
                        break;
                    }
                    case 2: {
                        deleteObjectFoodStuff();
                        break;
                    }
                    case 3: {
                        editObjectFoodStuff();
                        break;
                    }
                    case 4: {
                        break;
                    }
                }
                break;
            }
            case 2: {
                try {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("\t" + "Recipe id" + "\t" + "Recipe name" + "\t\t" + "Description" + "\t\t" + "Author id");
                    System.out.println("-----------------------------------------------------------------");
                    creatRecipe();
                    System.out.println("-----------------------------------------------------------------");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error" + e);
                    e.printStackTrace();
                }
                System.out.println("1 - Add new object in database\n" +
                        "2 - Delete object in database\n" +
                        "3 - Edit object in database\n" +
                        "4 - End\n");
                a = scanner.nextInt();
                switch (a) {
                    case 1: {
                        addObjectRecipe();
                        break;
                    }
                    case 2: {
                        deleteObjectRecipe();
                        break;
                    }
                    case 3: {
                        editObjectRecipe();
                        break;
                    }
                    case 4: {
                        break;
                    }
                }
                break;
            }
            case 3: {
                try {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("\t" + "Provider id" + "\t" + "Ingredients" + "\t\t" + "address" + "\t\t" + "Phone");
                    System.out.println("-----------------------------------------------------------------");
                    creatProvider();
                    System.out.println("-----------------------------------------------------------------");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error" + e);
                    e.printStackTrace();
                }
                System.out.println("1 - Add new object in database\n" +
                        "2 - Delete object in database\n" +
                        "3 - Edit object in database\n" +
                        "4 - End\n");
                a = scanner.nextInt();
                switch (a) {
                    case 1: {
                        addObjectProvider();
                        break;
                    }
                    case 2: {
                        deleteObjectProvider();
                        break;
                    }
                    case 3: {
                        editObjectProvider();
                        break;
                    }
                    case 4: {
                        break;
                    }
                }
                break;
            }
            case 4: {
                try {
                    serchConsignment();
                    System.out.println("-----------------------------------------------------------------");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error" + e);
                    e.printStackTrace();
                }
                break;
            }
            case 5: {
                try {
                    searchMinCalories();
                    System.out.println("-----------------------------------------------------------------");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error" + e);
                    e.printStackTrace();
                }
                break;
            }
            case 6: {
                try {
                    searchFoodStuffRecipe();
                    System.out.println("-----------------------------------------------------------------");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error" + e);
                    e.printStackTrace();
                }
                break;
            }
            case 7: {
                break;
            }
        }
    }


    public void createFoodStuff() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        int i = 0;
        List<Foodstuff> foodstuffs = db.getFoodstuff();
        while (i < foodstuffs.size()) {
            String test = foodstuffs.get(i).getFoodStuffName();
            String test1 = foodstuffs.get(i).getIngredients();
            int test2 = foodstuffs.get(i).getRecipeId();
            int test3 = foodstuffs.get(i).getCaloriesFood();

            System.out.println("\t" + test + "\t" + test1 + "\t\t" + test2 + "\t\t\t" + test3);
            i++;
        }
        i = 0;
    }

    public void creatRecipe() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        int i = 0;
        List<Recipe> recipes = db.getRecipe();
        while (i < recipes.size()) {
            int test = recipes.get(i).getRecipeId();
            String test1 = recipes.get(i).getRecipeName();
            String test2 = recipes.get(i).getDescription();
            int test3 = recipes.get(i).getAuthorId();

            System.out.println("\t\t" + test + "\t\t" + test1 + "\t\t\t" + test2 + "\t\t\t\t" + test3);
            i++;
        }
        i = 0;
    }

    public void creatProvider() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        int i = 0;
        List<Provider> providers = db.getProvider();
        while (i < providers.size()) {
            int test = providers.get(i).getProviderId();
            String test1 = providers.get(i).getIngredients();
            String test2 = providers.get(i).getAddress();
            int test3 = providers.get(i).getPhone();

            System.out.println("\t\t" + test + "\t\t" + test1 + "\t\t\t" + test2 + "\t\t" + test3);
            i++;
        }
        i = 0;
    }

    public void serchConsignment() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        System.out.println("Enter the data(xx.xx.xxxx): ");
        String data = scanner.nextLine();
        System.out.println("Enter Provider id: ");
        String id = scanner.nextLine();
        List<Consignment> consignments = db.searchConsignment(data, id);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Date" + "\t" + "Provider id" + "\t\t" + "Ingredients" + "\t\t" + "Price");
        System.out.println("-----------------------------------------------------------------");
        while (i < consignments.size()) {
            String test = consignments.get(i).getDate();
            int test1 = consignments.get(i).getProviderId();
            String test2 = consignments.get(i).getIngredients();
            int test3 = consignments.get(i).getPrice();

            System.out.println(" " + test + "  \t" + test1 + "\t\t\t" + test2 + "\t\t" + test3);
            i++;
        }
        i = 0;
    }

    public void searchMinCalories() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        int i = 0;
        List<Foodstuff> foodstuffs = db.searchMinCalories();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Food Staff" + "\t" + "Ingredients" + "\t\t" + "Recipe id" + "\t" + "Calories");
        System.out.println("-----------------------------------------------------------------");
        while (i < foodstuffs.size()) {
            String test = foodstuffs.get(i).getFoodStuffName();
            String test1 = foodstuffs.get(i).getIngredients();
            int test2 = foodstuffs.get(i).getRecipeId();
            int test3 = foodstuffs.get(i).getCaloriesFood();

            System.out.println("\t" + test + "\t" + test1 + "\t\t" + test2 + "\t\t\t" + test3);
            i++;
        }
        i = 0;
    }

    public void searchFoodStuffRecipe() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        int i = 0;
        List<Foodstuff> foodstuffs = db.searchFoodStuffRecipe();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Date" + "\t" + "Provider id" + "\t\t" + "Ingredients" + "\t\t" + "Price");
        System.out.println("-----------------------------------------------------------------");
        while (i < foodstuffs.size()) {
            String test = foodstuffs.get(i).getFoodStuffName();
            String test1 = foodstuffs.get(i).getIngredients();
            int test2 = foodstuffs.get(i).getRecipeId();
            int test3 = foodstuffs.get(i).getCaloriesFood();

            System.out.println(" " + test + "  \t" + test1 + "\t\t\t" + test2 + "\t\t" + test3);
            i++;
        }
        i = 0;
    }

    public void addObjectFoodStuff() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter new Food stuff name:");
        String newFoodStuff = scanner.nextLine();
        System.out.println("Enter new Ingredients name:");
        String newIngredients = scanner.nextLine();
        System.out.println("Enter new Recipe ID:");
        int newRecipe_id = scanner.nextInt();
        System.out.println("Enter new number of Calories:");
        int newCaloriesFood = scanner.nextInt();
        Foodstuff foodstuff = new Foodstuff(newFoodStuff, newIngredients, newRecipe_id, newCaloriesFood);
        db.addFoodStuff(foodstuff);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Food Staff" + "\t" + "Ingredients" + "\t\t" + "Recipe id" + "\t" + "Calories");
        System.out.println("-----------------------------------------------------------------");
        createFoodStuff();
        System.out.println("-----------------------------------------------------------------");
    }

    public void deleteObjectFoodStuff() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter Food stuff name for Delete:");
        String newFoodStuff = scanner.nextLine();
        System.out.println("Enter Ingredients name for Delete:");
        String newIngredients = scanner.nextLine();
        System.out.println("Enter Recipe ID for Delete:");
        int newRecipe_id = scanner.nextInt();
        System.out.println("Enter number of Calories for Delete:");
        int newCaloriesFood = scanner.nextInt();
        Foodstuff foodstuff = new Foodstuff(newFoodStuff, newIngredients, newRecipe_id, newCaloriesFood);
        db.deleteFoodStuff(foodstuff);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Food Staff" + "\t" + "Ingredients" + "\t\t" + "Recipe id" + "\t" + "Calories");
        System.out.println("-----------------------------------------------------------------");
        createFoodStuff();
        System.out.println("-----------------------------------------------------------------");
    }

    public void editObjectFoodStuff() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        System.out.println("Enter Food stuff name for Edit:");
        String newFoodStuff = scanner.nextLine();
        System.out.println("Enter Ingredients name for Edit:");
        String newIngredients = scanner.nextLine();
        System.out.println("Enter Recipe ID for Edit:");
        int newRecipe_id = scanner.nextInt();
        System.out.println("Enter number of Calories for Edit:");
        int newCaloriesFood = scanner.nextInt();

        Foodstuff foodstuff1 = new Foodstuff(newFoodStuff, newIngredients, newRecipe_id, newCaloriesFood);

        System.out.println("Enter new Food stuff name:");
        String oldFoodStuff = scanner.nextLine();
        oldFoodStuff = scanner.nextLine();
        System.out.println("Enter new Ingredients name:");
        String oldIngredients = scanner.nextLine();
        System.out.println("Enter new Recipe ID:");
        int oldRecipe_id = scanner.nextInt();
        System.out.println("Enter new number of Calories:");
        int oldCaloriesFood = scanner.nextInt();

        Foodstuff foodstuff = new Foodstuff(oldFoodStuff, oldIngredients, oldRecipe_id, oldCaloriesFood);

        db.editFoodStuff(foodstuff1, foodstuff);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Food Staff" + "\t" + "Ingredients" + "\t\t" + "Recipe id" + "\t" + "Calories");
        System.out.println("-----------------------------------------------------------------");
        createFoodStuff();
        System.out.println("-----------------------------------------------------------------");
    }

    public void addObjectRecipe() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter new Recipe ID:");
        int newRecipeId = scanner.nextInt();
        System.out.println("Enter new Recipe name:");
        String newRecipeName = scanner.nextLine();
        System.out.println("Enter new Description:");
        String newDescription = scanner.nextLine();
        System.out.println("Enter new Author ID:");
        int newAuthorId = scanner.nextInt();
        Recipe recipe = new Recipe(newRecipeId, newRecipeName, newDescription, newAuthorId);
        db.addRecipe(recipe);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Recipe id" + "\t" + "Recipe name" + "\t\t" + "Description" + "\t\t" + "Author id");
        System.out.println("-----------------------------------------------------------------");
        creatRecipe();
        System.out.println("-----------------------------------------------------------------");
    }

    public void deleteObjectRecipe() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter Recipe ID for Delete:");
        int newRecipeId = scanner.nextInt();
        System.out.println("Enter Recipe name for Delete:");
        String newRecipeName = scanner.nextLine();
        System.out.println("Enter Description for Delete:");
        String newDescription = scanner.nextLine();
        System.out.println("Enter Author ID for Delete:");
        int newAuthorId = scanner.nextInt();
        Recipe recipe = new Recipe(newRecipeId, newRecipeName, newDescription, newAuthorId);
        db.deleteRecipe(recipe);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Recipe id" + "\t" + "Recipe name" + "\t\t" + "Description" + "\t\t" + "Author id");
        System.out.println("-----------------------------------------------------------------");
        creatRecipe();
        System.out.println("-----------------------------------------------------------------");
    }

    public void editObjectRecipe() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        System.out.println("Enter Recipe ID for Edit:");
        int newRecipeId = scanner.nextInt();
        System.out.println("Enter Recipe name for Edit:");
        String newRecipeName = scanner.nextLine();
        System.out.println("Enter Description for Edit:");
        String newDescription = scanner.nextLine();
        System.out.println("Enter Author ID for Edit:");
        int newAuthorId = scanner.nextInt();

        Recipe recipe = new Recipe(newRecipeId, newRecipeName, newDescription, newAuthorId);

        System.out.println("Enter old Recipe ID:");
        int oldRecipeId = scanner.nextInt();
        System.out.println("Enter old Recipe name:");
        String oldRecipeName = scanner.nextLine();
        System.out.println("Enter old Description:");
        String oldDescription = scanner.nextLine();
        System.out.println("Enter old Author ID:");
        int oldAuthorId = scanner.nextInt();

        Recipe oldrecipe = new Recipe(oldRecipeId, oldRecipeName, oldDescription, oldAuthorId);

        db.editRecipe(oldrecipe, recipe);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Recipe id" + "\t" + "Recipe name" + "\t\t" + "Description" + "\t\t" + "Author id");
        System.out.println("-----------------------------------------------------------------");
        creatRecipe();
        System.out.println("-----------------------------------------------------------------");
    }

    public void addObjectProvider() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter new Provider ID:");
        int newProviderId = scanner.nextInt();
        System.out.println("Enter new Ingredients name:");
        String newIngredients = scanner.nextLine();
        System.out.println("Enter new Address:");
        String newAddress = scanner.nextLine();
        System.out.println("Enter new Phone number:");
        int newPhone = scanner.nextInt();
        Provider provider = new Provider(newProviderId, newIngredients, newAddress, newPhone);
        db.addProvider(provider);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Provider id" + "\t" + "Ingredients" + "\t\t" + "address" + "\t\t" + "Phone");
        System.out.println("-----------------------------------------------------------------");
        creatProvider();
        System.out.println("-----------------------------------------------------------------");
    }

    public void deleteObjectProvider() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter Provider ID for Delete:");
        int newProviderId = scanner.nextInt();
        System.out.println("Enter Ingredients name for Delete:");
        String newIngredients = scanner.nextLine();
        System.out.println("Enter Address for Delete:");
        String newAddress = scanner.nextLine();
        System.out.println("Enter Phone number for Delete:");
        int newPhone = scanner.nextInt();
        Provider provider = new Provider(newProviderId, newIngredients, newAddress, newPhone);
        db.deleteProvider(provider);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Recipe id" + "\t" + "Recipe name" + "\t\t" + "Description" + "\t\t" + "Author id");
        System.out.println("-----------------------------------------------------------------");
        creatRecipe();
        System.out.println("-----------------------------------------------------------------");
    }

    public void editObjectProvider() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        System.out.println("Enter new Provider ID:");
        int newProviderId = scanner.nextInt();
        System.out.println("Enter new Ingredients name:");
        String newIngredients = scanner.nextLine();
        System.out.println("Enter new Address:");
        String newAddress = scanner.nextLine();
        System.out.println("Enter new Phone number:");
        int newPhone = scanner.nextInt();

        Provider provider = new Provider(newProviderId, newIngredients, newAddress, newPhone);

        System.out.println("Enter old Provider ID:");
        int oldProviderId = scanner.nextInt();
        System.out.println("Enter old Ingredients name:");
        String oldIngredients = scanner.nextLine();
        System.out.println("Enter old Address:");
        String oldAddress = scanner.nextLine();
        System.out.println("Enter old Phone number:");
        int oldPhone = scanner.nextInt();

        Provider oldprovider = new Provider(oldProviderId, oldIngredients, oldAddress, oldPhone);

        db.editProvider(oldprovider, provider);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t" + "Recipe id" + "\t" + "Recipe name" + "\t\t" + "Description" + "\t\t" + "Author id");
        System.out.println("-----------------------------------------------------------------");
        creatRecipe();
        System.out.println("-----------------------------------------------------------------");
    }
}
