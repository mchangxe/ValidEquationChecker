

public class validEquation {

    /*
     * This is the main function that will be used to check if an input is a valid mathematical expression or not
     * If the string is indeed valid, the output of this function will be the input string itself.
     * If the string is invalid, the output of this function will be a string "not valid".
     */
    public static String checkValidity(String a) {

        /*
         * a counter to keep track of progress. Initial value is set to be true. If conditions are met and indicates
         * that the string is an invalid expression, then this counter will be set to false. In anywhere else of this
         * class, the counter will never be set back to true to avoid errors.
         */
        boolean validOrNot = true;

        //extract all the non-space characters into a string array
        String[] userInputArray = a.split("\\s+");


        //checking if every character is valid. Could either be a number or an operator or a parenthesis.
        for (int i = 0; i < (userInputArray.length); i++) {
            if (isNumeric(userInputArray[i]) == false && isOperator(userInputArray[i]) == false && isParenthesis(userInputArray[i]) == false) {
                validOrNot = false;
            }
        }


        /* Checking for parenthesis errors. Utilizes a counter
         * Whenever an open parenthesis is found, the counter gets increased by one
         * Whenever a close parenthesis is found, the counter gets decreased by one
         * For a valid mathematical equation, the number of open parenthesis must always be greater or equal to than the number of close parenthesis
         * and must be equal when the equation is finished
         */
        int parenthesisCount = 0;
        for (int i = 0; i < userInputArray.length; i++) {
            if (userInputArray[i].equals("(")) {
                parenthesisCount++;
            } else if (userInputArray[i].equals(")")) {
                parenthesisCount--;
            }
            if (parenthesisCount < 0) {
                validOrNot = false;
            }
        }
        if (parenthesisCount != 0) {
            validOrNot = false;
        }


        /*
         * Checking for operator, number relationship. For every 2 numbers, there should be an operator
         * Total number of numbers should be 1+(number of operators)
         */
        int numberOfOperator = 0;
        int numberOfMathNum = 0;
        for (int i=0; i<userInputArray.length; i++){
            if (isNumeric(userInputArray[i])) numberOfMathNum++;
            if (isOperator(userInputArray[i])) numberOfOperator++;
        }
        if (numberOfMathNum - numberOfOperator != 1) validOrNot =false;

        /*
         * Final return statement
         * If the validOrNot counter is true, then the expression is a valid equation and function returns the string
         * If the counter is false, then the function returns "not valid"
         */
        if (validOrNot == true) return a;
        else return "not valid";
    }


    /*
     * Checks if the input string is a numeric number or not.
     * Returns true if string is indeed a numeric number.
     * Returns false if string is not a numeric number.
     * The or statement separates the case of being an integer and the case of being a decimal
     */
    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+") || s.matches("[-+]\\d+\\.?\\d*");
    }

    /*
     * Checks if the input string is an operator from the set: " + - * /"
     * Returns true if string is indeed an operator
     * Returns false if string is not an operator
     */
    public static boolean isOperator(String s) {
        if (s.matches("[+-]")){
            return true;
        }else if (s.matches("[*/]")){
            return true;
        }else return false;
    }

    /*
     * Checks if the input string is a parenthesis
     * Returns true if string is indeed a parenthesis
     * Returns false if string is not a parenthesis
     */
    public static boolean isParenthesis(String s) {
        if (s.equals("(") || s.equals(")")) return true;
        else return false;
    }
}




