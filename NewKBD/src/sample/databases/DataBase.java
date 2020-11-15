package sample.databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBase {
    private String url = "jdbc:mysql://localhost:3306/kbd2";
    private Properties p;

    private List<Author> author;
    private List<Consignment> consignment;
    private List<Foodstuff> foodstuff;
    private List<Ingredients_info> ingredients_info;
    private List<Provider> provider;
    private List<Recipe> recipe;


    private void settingProperties() {
        p = new Properties();
        p.setProperty("user", "root");
        p.setProperty("password", "31082001");
        p.setProperty("useUnicode", "true");
        p.setProperty("characterEncoding", "cp1251");
    }


    private String addAp(String string) {
        return '\'' + string + '\'';
    }

    public List<Author> getAuthor() {
        return author;
    }

    public List<Consignment> getConsignment() {
        return consignment;
    }

    public List<Foodstuff> getFoodstuff() {
        return foodstuff;
    }

    public List<Ingredients_info> getIngredients_info() {
        return ingredients_info;
    }

    public List<Provider> getProvider() {
        return provider;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    //Search for tasks
    public String eqSearchConsignment(String date, String number){
        String result = Constant.SELECT_CONSIGNMENT +
            Constant.WHERE + Constant.CONSIGNMENT_DATE + Constant.EQUAL + addAp(date) + Constant.AND +
            Constant.CONSIGNMENT_PROVIDER_ID + Constant.EQUAL + number;
        return result;
    }

    public List<Consignment> searchConsignment(String date, String number) throws SQLException, ClassNotFoundException {
        ArrayList<Consignment> result = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(eqSearchConsignment(date, number));
            while (resultSet.next()) {
                result.add(new Consignment(
                        resultSet.getString(1),
                        Integer.parseInt(resultSet.getString(2)),
                        resultSet.getString(3),
                        Integer.parseInt(resultSet.getString(4))));
            }
            //System.out.println("We're created Technics.");
        }
        return result;
    }

    public String eqSearchFoodStuffRecipe(){
        String result = Constant.SELECT_FOODNAME_RECIPENAME + Constant.LEFT_JOIN_FOODSTUFF_RECIPE;
        return result;
    }

    public List<Foodstuff> searchFoodStuffRecipe() throws SQLException, ClassNotFoundException {
        ArrayList<Foodstuff> result = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(eqSearchFoodStuffRecipe());
            while (resultSet.next()) {
                result.add(new Foodstuff(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        Integer.parseInt(resultSet.getString(0)),
                        Integer.parseInt(resultSet.getString(0))));
            }
            //System.out.println("We're created Technics.");
        }
        return result;
    }

    public String eqSearchMinCalories(){
        String result = Constant.SELECT_SORT_MIN_CALORIES;
        return result;
    }

    public List<Foodstuff> searchMinCalories() throws SQLException, ClassNotFoundException {
        ArrayList<Foodstuff> result = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(eqSearchMinCalories());
            while (resultSet.next()) {
                result.add(new Foodstuff(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        Integer.parseInt(resultSet.getString(3)),
                        Integer.parseInt(resultSet.getString(4))));
            }
            //System.out.println("We're created Technics.");
        }
        return result;
    }

    //"Where" for tables, to take special things from tables
    private String whereAuthor(Author author) {
        String result = Constant.WHERE +
                Constant.AUTHOR_ID + Constant.EQUAL + author.getAutorId() + Constant.AND +
                Constant.AUTHOR_LASTNAME + Constant.EQUAL + addAp(author.getAuthorLastName()) + Constant.AND +
                Constant.AUTHOR_FIRSTNAME + Constant.EQUAL + addAp(author.getAuthorFirstName()) + Constant.AND +
                Constant.AUTHOR_COUNTRY + Constant.EQUAL + addAp(author.getAuthorCountry())+ Constant.AND +
                Constant.BIRTHDAY + Constant.EQUAL + addAp(author.getBirthday());
        return result;
    }

    private String whereConsignment(Consignment consignment) {
        String result = Constant.WHERE +
                Constant.DATE + Constant.EQUAL + addAp(consignment.getDate()) + Constant.AND +
                Constant.PROVIDER_ID + Constant.EQUAL + consignment.getProviderId() + Constant.AND +
                Constant.INGREDIENTS + Constant.EQUAL + addAp(consignment.getIngredients()) + Constant.AND +
                Constant.PRICE + Constant.EQUAL + consignment.getPrice();
        return result;
    }

    private String whereFoodstuff(Foodstuff foodstuff) {
        String result = Constant.WHERE +
                Constant.FOODSTUFF_NAME + Constant.EQUAL + addAp(foodstuff.getFoodStuffName()) + Constant.AND +
                Constant.INGREDIENTS + Constant.EQUAL + addAp(foodstuff.getIngredients()) + Constant.AND +
                Constant.RECIPE_ID + Constant.EQUAL + foodstuff.getRecipeId() + Constant.AND +
                Constant.CALORIES_FOOD + Constant.EQUAL + foodstuff.getCaloriesFood();
        return result;
    }

    private  String whereIngredients_info(Ingredients_info ingredients_info){
        String result = Constant.WHERE +
                Constant.INGREDIENTS + Constant.EQUAL + addAp(ingredients_info.getIngredients()) + Constant.AND +
                Constant.WEIGHT + Constant.EQUAL + ingredients_info.getWeight() + Constant.AND +
                Constant.METHOD_FOR_PREPARING + Constant.EQUAL + addAp(ingredients_info.getMethodForPreparing()) + Constant.AND +
                Constant.CALORIES + Constant.EQUAL + ingredients_info.getCalories();
        return result;
    }

    private String whereProvider(Provider provider){
        String result = Constant.WHERE +
                Constant.PROVIDER_ID + Constant.EQUAL + provider.getProviderId() + Constant.AND +
                Constant.INGREDIENTS + Constant.EQUAL + addAp(provider.getIngredients()) + Constant.AND +
                Constant.ADDRESS + Constant.EQUAL + addAp(provider.getAddress()) + Constant.AND +
                Constant.PHONE + Constant.EQUAL + provider.getPhone();
        return result;
    }

    private String whereRecipe(Recipe recipe){
        String result = Constant.WHERE +
                Constant.RECIPE_ID + Constant.EQUAL + recipe.getRecipeId() + Constant.AND +
                Constant.RECIPE_NAME + Constant.EQUAL + addAp(recipe.getRecipeName()) + Constant.AND +
                Constant.DESCRIPTION + Constant.EQUAL + addAp(recipe.getDescription()) + Constant.AND +
                Constant.AUTHOR_ID + Constant.EQUAL + recipe.getAuthorId();
        return result;
    }

    //"Set" for all tables
    private void setAuthor() throws ClassNotFoundException, SQLException {
        author = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(Constant.SELECT_AUTHOR);
            while (resultSet.next()) {
                author.add(new Author(
                        Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
           // System.out.println("We're created Author.");
        }
    }

    private void setConsignment() throws ClassNotFoundException, SQLException {
        consignment = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(Constant.SELECT_CONSIGNMENT);
            while (resultSet.next()) {
                consignment.add(new Consignment(
                        resultSet.getString(1),
                        Integer.parseInt(resultSet.getString(2)),
                        resultSet.getString(3),
                        Integer.parseInt(resultSet.getString(4))));
            }
           // System.out.println("We're created location Of Consignment.");
        }
    }

    private void setFoodstuff() throws ClassNotFoundException, SQLException {
        foodstuff = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(Constant.SELECT_FOODSTUFF);
            while (resultSet.next()) {
                foodstuff.add(new Foodstuff(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        Integer.parseInt(resultSet.getString(3)),
                        Integer.parseInt(resultSet.getString(4))));
            }
           // System.out.println("We're created Food Stuff.");
        }
    }

    private void setIngredients_info() throws ClassNotFoundException, SQLException {
        ingredients_info = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(Constant.SELECT_INGREDIENTS_INFO);
            while (resultSet.next()) {
                ingredients_info.add(new Ingredients_info(
                        resultSet.getString(1),
                        Integer.parseInt(resultSet.getString(2)),
                        resultSet.getString(3),
                        Integer.parseInt(resultSet.getString(4))));
            }
           // System.out.println("We're created Ingredients information.");
        }
    }

    private void setProvider() throws ClassNotFoundException, SQLException {
        provider = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(Constant.SELECT_PROVIDER);
            while (resultSet.next()) {
                provider.add(new Provider(
                        Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        Integer.parseInt(resultSet.getString(4))));
            }
            //System.out.println("We're created Provider.");
        }
    }

    private void setRecipe() throws ClassNotFoundException, SQLException {
        recipe = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        settingProperties();
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(Constant.SELECT_RECIPE);
            while (resultSet.next()) {
                recipe.add(new Recipe(
                        Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        Integer.parseInt(resultSet.getString(4))));
            }
            //System.out.println("We're created Recipe.");
        }
    }

    //"Add" for all tables
    public void addAuthor(Author added) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.INSERT + Constant.AUTHOR + Constant.VALUES_AUTHOR +
                    Constant.VALUES + Constant.LEFT_BRACKET +
                    added.getAutorId() + Constant.COMMA +
                    addAp(added.getAuthorLastName()) + Constant.COMMA +
                    addAp(added.getAuthorFirstName()) + Constant.COMMA +
                    addAp(added.getAuthorCountry()) + Constant.COMMA +
                    addAp(added.getBirthday()) + Constant.RIGHT_BRACKET + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            author.add(added);
            System.out.println("We're added.");
        }
    }

    public void addConsignment(Consignment added) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.INSERT + Constant.CONSIGNMENT + Constant.VALUES_CONSIGNMENT +
                    Constant.VALUES + Constant.LEFT_BRACKET +
                    addAp(added.getDate()) + Constant.COMMA +
                    added.getProviderId() + Constant.COMMA +
                    addAp(added.getIngredients()) + Constant.COMMA +
                    added.getPrice() + Constant.RIGHT_BRACKET + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            consignment.add(added);
            System.out.println("We're added.");
        }
    }

    public void addFoodStuff(Foodstuff added) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.INSERT + Constant.FOODSTUFF + Constant.VALUES_FOODSTUFF +
                    Constant.VALUES + Constant.LEFT_BRACKET +
                    addAp(added.getFoodStuffName()) + Constant.COMMA +
                    addAp(added.getIngredients()) + Constant.COMMA +
                    added.getRecipeId() + Constant.COMMA +
                    added.getCaloriesFood() + Constant.RIGHT_BRACKET + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            foodstuff.add(added);
            System.out.println("We're added.");
        }
    }

    public void addIngredientsInfo(Ingredients_info added) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.INSERT + Constant.INGREDIENTS_INFO + Constant.VALUES_INGREDIENTS_INFO +
                    Constant.VALUES + Constant.LEFT_BRACKET +
                    addAp(added.getIngredients()) + Constant.COMMA +
                    added.getWeight() + Constant.COMMA +
                    addAp(added.getMethodForPreparing()) + Constant.COMMA +
                    added.getCalories() + Constant.RIGHT_BRACKET + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            ingredients_info.add(added);
            System.out.println("We're added.");
        }
    }

    public void addProvider(Provider added) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.INSERT + Constant.PROVIDER + Constant.VALUES_PROVIDER +
                    Constant.VALUES + Constant.LEFT_BRACKET +
                    added.getProviderId() + Constant.COMMA +
                    addAp(added.getIngredients()) + Constant.COMMA +
                    addAp(added.getAddress()) + Constant.COMMA +
                    added.getPhone() + Constant.RIGHT_BRACKET + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            provider.add(added);
            System.out.println("We're added.");
        }
    }

    public void addRecipe(Recipe added) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.INSERT + Constant.RECIPE + Constant.VALUES_RECIPE +
                    Constant.VALUES + Constant.LEFT_BRACKET +
                    added.getRecipeId() + Constant.COMMA +
                    addAp(added.getRecipeName()) + Constant.COMMA +
                    addAp(added.getDescription()) + Constant.COMMA +
                    added.getAuthorId() + Constant.RIGHT_BRACKET + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            recipe.add(added);
            System.out.println("We're added.");
        }
    }

    //"Delete" for all tables
    public void deleteAuthor(Author deleted) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.DELETE + Constant.AUTHOR + whereAuthor(deleted) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < author.size(); i++) {
                if (author.get(i) == deleted) {
                    author.remove(i);
                }
            }
        }
    }

    public void deleteConsignment(Consignment deleted) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.DELETE + Constant.CONSIGNMENT + whereConsignment(deleted) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < consignment.size(); i++) {
                if (consignment.get(i) == deleted) {
                    consignment.remove(i);
                }
            }
        }
    }

    public void deleteFoodStuff(Foodstuff deleted) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.DELETE + Constant.FOODSTUFF + whereFoodstuff(deleted) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < foodstuff.size(); i++) {
                if (foodstuff.get(i) == deleted) {
                    foodstuff.remove(i);
                }
            }
        }
    }

    public void deleteIngredientsInfo(Ingredients_info deleted) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.DELETE + Constant.INGREDIENTS_INFO + whereIngredients_info(deleted) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < ingredients_info.size(); i++) {
                if (ingredients_info.get(i) == deleted) {
                    ingredients_info.remove(i);
                }
            }
        }
    }

    public void deleteProvider(Provider deleted) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.DELETE + Constant.PROVIDER + whereProvider(deleted) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < provider.size(); i++) {
                if (provider.get(i) == deleted) {
                    provider.remove(i);
                }
            }
        }
    }

    public void deleteRecipe(Recipe deleted) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.DELETE + Constant.RECIPE + whereRecipe(deleted) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < recipe.size(); i++) {
                if (recipe.get(i) == deleted) {
                    recipe.remove(i);
                }
            }
        }
    }

    //"Edit" for all tables
    public void editAuthor(Author edited, Author newAuthor) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.UPDATE + Constant.AUTHOR + Constant.SET +
                    Constant.AUTHOR_ID + Constant.EQUAL + newAuthor.getAutorId() + Constant.COMMA +
                    Constant.AUTHOR_LASTNAME + Constant.EQUAL + addAp(newAuthor.getAuthorLastName()) + Constant.COMMA +
                    Constant.AUTHOR_FIRSTNAME + Constant.EQUAL + addAp(newAuthor.getAuthorFirstName()) + Constant.COMMA +
                    Constant.AUTHOR_COUNTRY + Constant.EQUAL + addAp(newAuthor.getAuthorCountry()) + Constant.COMMA +
                    Constant.BIRTHDAY + Constant.EQUAL + addAp(newAuthor.getBirthday()) + whereAuthor(edited) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < author.size(); i++) {
                if (author.get(i) == edited) {
                    author.set(i, newAuthor);
                    break;
                }
            }
        }
    }

    public void editConsignment(Consignment edited, Consignment newConsignment) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.UPDATE + Constant.CONSIGNMENT + Constant.SET +
                    Constant.DATE + Constant.EQUAL + addAp(newConsignment.getDate()) + Constant.COMMA +
                    Constant.PROVIDER_ID + Constant.EQUAL + newConsignment.getProviderId() + Constant.COMMA +
                    Constant.INGREDIENTS + Constant.EQUAL + addAp(newConsignment.getIngredients()) + Constant.COMMA +
                    Constant.PRICE + Constant.EQUAL + newConsignment.getPrice() + whereConsignment(edited) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < consignment.size(); i++) {
                if (consignment.get(i) == edited) {
                    consignment.set(i, newConsignment);
                    break;
                }
            }
        }
    }

    public void editFoodStuff(Foodstuff edited, Foodstuff newFoodStuff) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.UPDATE + Constant.FOODSTUFF + Constant.SET +
                    Constant.FOODSTUFF_NAME + Constant.EQUAL + addAp(newFoodStuff.getFoodStuffName()) + Constant.COMMA +
                    Constant.INGREDIENTS + Constant.EQUAL + addAp(newFoodStuff.getIngredients()) + Constant.COMMA +
                    Constant.RECIPE_ID + Constant.EQUAL + newFoodStuff.getRecipeId() + Constant.COMMA +
                    Constant.CALORIES_FOOD + Constant.EQUAL + newFoodStuff.getCaloriesFood() + whereFoodstuff(edited) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < consignment.size(); i++) {
                if (foodstuff.get(i) == edited) {
                    foodstuff.set(i, newFoodStuff);
                    break;
                }
            }
        }
    }

    public void editIngredientsInfo(Ingredients_info edited, Ingredients_info newIngredientsInfo) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.UPDATE + Constant.INGREDIENTS_INFO + Constant.SET +
                    Constant.INGREDIENTS + Constant.EQUAL + addAp(newIngredientsInfo.getIngredients()) + Constant.COMMA +
                    Constant.WEIGHT + Constant.EQUAL + newIngredientsInfo.getWeight() + Constant.COMMA +
                    Constant.METHOD_FOR_PREPARING + Constant.EQUAL + addAp(newIngredientsInfo.getMethodForPreparing()) + Constant.COMMA +
                    Constant.CALORIES + Constant.EQUAL + newIngredientsInfo.getCalories() + whereIngredients_info(edited) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < ingredients_info.size(); i++) {
                if (ingredients_info.get(i) == edited) {
                    ingredients_info.set(i, newIngredientsInfo);
                    break;
                }
            }
        }
    }

    public void editProvider(Provider edited, Provider newProvider) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.UPDATE + Constant.PROVIDER + Constant.SET +
                    Constant.PROVIDER_ID + Constant.EQUAL + newProvider.getProviderId() + Constant.COMMA +
                    Constant.INGREDIENTS + Constant.EQUAL + addAp(newProvider.getIngredients()) + Constant.COMMA +
                    Constant.ADDRESS + Constant.EQUAL + addAp(newProvider.getAddress()) + Constant.COMMA +
                    Constant.PHONE + Constant.EQUAL + newProvider.getPhone() + whereProvider(edited) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < provider.size(); i++) {
                if (provider.get(i) == edited) {
                    provider.set(i, newProvider);
                    break;
                }
            }
        }
    }

    public void editRecipe(Recipe edited, Recipe newRecipe) throws SQLException {
        Connection connection = DriverManager.getConnection(url, p);
        try (Statement statement = connection.createStatement()) {
            String eq = Constant.UPDATE + Constant.RECIPE + Constant.SET +
                    Constant.RECIPE_ID + Constant.EQUAL + newRecipe.getRecipeId() + Constant.COMMA +
                    Constant.RECIPE_NAME + Constant.EQUAL + addAp(newRecipe.getRecipeName()) + Constant.COMMA +
                    Constant.DESCRIPTION + Constant.EQUAL + addAp(newRecipe.getDescription()) + Constant.COMMA +
                    Constant.AUTHOR_ID + Constant.EQUAL + newRecipe.getAuthorId() + whereRecipe(edited) + Constant.SEMICOLON;
            statement.executeUpdate(eq);
            for (int i = 0; i < recipe.size(); i++) {
                if (recipe.get(i) == edited) {
                    recipe.set(i, newRecipe);
                    break;
                }
            }
        }
    }

    //Function for create DataBase
    public DataBase() throws ClassNotFoundException, SQLException {
        setAuthor();
        setConsignment();
        setFoodstuff();
        setIngredients_info();
        setProvider();
        setRecipe();
        //System.out.println("We're created database.");
    }
}

