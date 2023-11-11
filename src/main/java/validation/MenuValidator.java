package validation;

import enums.ErrorMessage;
import enums.Menu;

import java.util.HashMap;
import java.util.Map;

public class MenuValidator {

    public static void validateNonMenu(Map<String, Integer> menuHashMap) {
        for (String menuList : menuHashMap.keySet()) {
            if (validateNonMenuHelper(menuList)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
            }
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
