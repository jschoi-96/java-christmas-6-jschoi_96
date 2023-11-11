package validation;

import enums.ErrorMessage;
import enums.Menu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    private static boolean validateNonMenuHelper(String inputMenu) {
        for (Menu menu : Menu.values()) {
            if (inputMenu.equals(menu.name())) {
                return false;
            }
        }
        return true;
    }
}
