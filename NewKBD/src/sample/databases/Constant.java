package sample.databases;

public class Constant {

    //All tables
    public static final String AUTHOR = "author";
    public static final String CONSIGNMENT = "consignment";
    public static final String FOODSTUFF = "foodstuff";
    public static final String INGREDIENTS_INFO = "ingredients_info";
    public static final String PROVIDER = "provider";
    public static final String RECIPE = "recipe";

    //Select each tables
    public static final String SELECT_AUTHOR = "SELECT author_id, author_lastname, author_firstname, author_country, birthday FROM author";
    public static final String SELECT_CONSIGNMENT = "SELECT date, provider_id, ingredients, price FROM consignment";
    public static final String SELECT_FOODSTUFF = "SELECT foodstuff_name, ingredients, recipe_id, calories_food FROM foodstuff";
    public static final String SELECT_INGREDIENTS_INFO = "SELECT ingredients, weight, method_for_preparing, calories FROM ingredients_info";
    public static final String SELECT_PROVIDER = "SELECT provider_id, ingredients, address, phone FROM provider";
    public static final String SELECT_RECIPE = "SELECT recipe_id, recipe_name, description, author_id FROM recipe";

    //For search
    public static final String CONSIGNMENT_DATE = "consignment.date";
    public static final String CONSIGNMENT_PROVIDER_ID = "consignment.provider_id";

    public static final String LEFT_JOIN = " LEFT JOIN ";
    public static final String ON = " ON ";
    public static final String INSERT = " INSERT INTO ";
    public static final String DELETE = " DELETE FROM ";
    public static final String WHERE = " WHERE ";
    public static final String AND = " AND ";
    public static final String UPDATE = " UPDATE ";
    public static final String SET = " SET ";

    public static final String VALUES = " VALUES ";
    public static final String COMMA = ", ";
    public static final String EQUAL = " = ";
    public static final String SEMICOLON = ";";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    //author table
    public static final String AUTHOR_ID = "author_id";
    public static final String AUTHOR_LASTNAME = "author_lastname";
    public static final String AUTHOR_FIRSTNAME = "author_firstname";
    public static final String AUTHOR_COUNTRY = "author_country";
    public static final String BIRTHDAY = "birthday";

    //consignment table
    public static final String DATE = "date";
    public static final String PROVIDER_ID = "provider_id";
    public static final String INGREDIENTS = "ingredients";
    public static final String PRICE = "price";

    //foodstuff table
    public static final String FOODSTUFF_NAME = "foodstuff_name";
    public static final String RECIPE_ID = "recipe_id";
    public static final String CALORIES_FOOD = "calories_food";

    //ingredients_info table
    public static final String WEIGHT = "weight";
    public static final String METHOD_FOR_PREPARING = "method_for_preparing";
    public static final String CALORIES = "calories";

    //provider table
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";

    //recipe table
    public static final String RECIPE_NAME = "recipe_name";
    public static final String DESCRIPTION = "description";
    public static final String FS_RECIPE_ID = "foodstaff.recipe_id";
    public static final String RC_RECIPE_ID = "recipe.recipe_id";

    public static final String SELECT_FOODNAME_RECIPENAME = "SELECT foodstuff_name, ingredients, recipe_name FROM foodstuff";
    public static final String SELECT_SORT_MIN_CALORIES = "SELECT foodstuff_name, ingredients, recipe_id, calories_food  FROM foodstuff ORDER BY calories_food";

    public static final String LEFT_JOIN_FOODSTUFF_RECIPE = " " + LEFT_JOIN + RECIPE + ON + FS_RECIPE_ID + EQUAL + RC_RECIPE_ID;

    //Values for tables
    public static final String VALUES_AUTHOR = "(author_id, author_lastname, author_firstname, author_country, birthday)";
    public static final String VALUES_CONSIGNMENT = "(date, provider_id, ingredients, price)";
    public static final String VALUES_FOODSTUFF = "(foodstuff_name, ingredients, recipe_id, calories_food)";
    public static final String VALUES_INGREDIENTS_INFO = "(ingredients, weight, method_for_preparing)";
    public static final String VALUES_PROVIDER = "(provider_id, ingredients, address, phone)";
    public static final String VALUES_RECIPE = "(recipe_id, recipe_name, description, author_id)";
}
