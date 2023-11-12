package validation;

import enums.ErrorMessage;
import enums.Menu;
import java.util.Map;
public class MenuValidator {

    public static void validateNonMenu(Map<String, Integer> menuHashMap) {
        for (String menuList : menuHashMap.keySet()) {
            if (validateNonMenuHelper(menuList)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
            }
        }
    }
    public static void validateDuplicateMenu(Map<String, Integer> menuHashMap, String menu) {
        if (menuHashMap.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_MENU.getErrorMessage());
        }
    }

    public static void validateOnlyDrink(Map<String, Integer> menuHashMap) {
        if (validateOnlyDrinkHelper(menuHashMap)){
            throw new IllegalArgumentException(ErrorMessage.ONLY_DRINK.getErrorMessage());
        }
    }
    private static boolean validateNonMenuHelper(String inputMenu) {
        for (Menu menu : Menu.values()) {
            if (inputMenu.equals(menu.name())) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateOnlyDrinkHelper(Map<String, Integer> menuHashMap) {
        for (String menuList : menuHashMap.keySet()) {
            Menu menu = Menu.valueOf(menuList);
            if (menu.getCategory() != "음료") { // 리팩토링 필요
                return false;
            }
        }
        return true;
    }
}
