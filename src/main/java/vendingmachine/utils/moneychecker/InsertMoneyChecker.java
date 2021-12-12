package vendingmachine.utils.moneychecker;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.datatypechecker.IntegerChecker;

public class InsertMoneyChecker {
    private static final String INPUT_REQUEST_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String CONTENT_TYPE = "투입 금액";
    private static final int LOW_LIMIT = 0;
    private static final int MOD = 10;

    public static int getInsertMoney(){
        String input;

        do{
            System.out.println(INPUT_REQUEST_MESSAGE);
            input = Console.readLine();
        }while(!isRightInput(input));

        return Integer.parseInt(input);
    }

    private static boolean isRightInput(String input){
        boolean isRight = true;

        try{
            IntegerChecker.checkStringToInteger(input, CONTENT_TYPE);

            int balance = Integer.parseInt(input);
            IntegerChecker.checkLowLimit(balance, LOW_LIMIT, CONTENT_TYPE);
            IntegerChecker.checkDivideIntoMod(balance, MOD, CONTENT_TYPE);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            isRight = false;
        }

        return isRight;
    }
}
