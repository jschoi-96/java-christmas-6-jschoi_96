package view;

import utils.Parser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readDate() {
        String input = Console.readLine();
        return Parser.convertToInt(input);
    }
}
