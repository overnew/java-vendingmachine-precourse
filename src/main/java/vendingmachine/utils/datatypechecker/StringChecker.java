package vendingmachine.utils.datatypechecker;

import vendingmachine.constants.StringConstants;

import java.util.ArrayList;
import java.util.List;

public class StringChecker {
    //Error Message suffix
    public static final String CAN_BE_BLANK = "은 빈칸이 될수 없습니다.";
    public static final String CAN_BE_SAME_STRING= "은 같은 문자열이 올 수 없습니다.";

    public static List<String> parseStringBySeparator(String input, char separator){
        int parseBeginIndex = 0 , parseEndIndex =0;
        List<String> parsedStrings = new ArrayList<>();

        while((parseEndIndex = input.indexOf(separator, parseBeginIndex)) != -1 ){
            parsedStrings.add(input.substring(parseBeginIndex, parseEndIndex));
            parseBeginIndex = parseEndIndex +1;
        }

        if(parseBeginIndex < input.length()){
            parsedStrings.add(input.substring(parseBeginIndex)); //마지막 문자열 삽입
        }

        return parsedStrings;
    }

    public static void checkStringLength(String content, String contentType) throws IllegalArgumentException{

        if(content.length() == 0){
            throw new IllegalArgumentException(StringConstants.ERROR_MESSAGE_PREFIX + contentType + CAN_BE_BLANK);
        }

    }

    public static void checkSameString(List<String> strings, String contentType) throws IllegalArgumentException{

        for(String findString : strings){
            int firstIndex = strings.indexOf(findString);
            int lastIndex = strings.lastIndexOf(findString);

            if(firstIndex != lastIndex){
                throw new IllegalArgumentException(StringConstants.ERROR_MESSAGE_PREFIX + contentType + CAN_BE_SAME_STRING);
            }

        }

    }

}
