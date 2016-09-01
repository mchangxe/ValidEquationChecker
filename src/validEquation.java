

import java.util.Scanner;

public class validEquation {


    public static void main(String args){


        Boolean validOrNot = checkValidity(args);


        System.out.println(validOrNot);
    }

    public static Boolean checkValidity( String a) {

        boolean validOrNot = true;

        String[] userInputArray = a.split("\\s+");

        for (int i = 0; i < (userInputArray.length-1); i++) {
            if (isNumeric(userInputArray[i]) == false && isOperator(userInputArray[i]) == false) {
                validOrNot = false;

            }
        }


        //checking for parathesis
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

        // checking for operator and numeric value relationship
        for (int i = 0; i < userInputArray.length; i++) {
            if (userInputArray[i].equals("(")) {
                if (isOperator(userInputArray[i + 1]) == true) {
                    validOrNot = false;
                }
            } else if (userInputArray[i].equals(")")) {

            } else if (isNumeric(userInputArray[i]) == true) {
                if (i == 0) {
                    if (isNumeric(userInputArray[i + 1]) == true) {
                        validOrNot = false;
                    }
                } else if (i == (userInputArray.length - 1)) {
                    if (isNumeric(userInputArray[i - 1]) == true) {
                        validOrNot = false;
                    }
                } else if (isNumeric(userInputArray[i - 1]) == true || isNumeric(userInputArray[i + 1]) == true) {
                    validOrNot = false;
                } else validOrNot = false;
            } else if (isOperator(userInputArray[i]) == true) {
                if(isOperator(userInputArray[i+1]) == true){
                    validOrNot = false;
                }else if (userInputArray[i+1].equals(")")){
                    validOrNot = false;
                }

            }else validOrNot = false;

        }
        return validOrNot;
    }


    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean isOperator(String s) {
        if (s.matches("[+-]")){
            return true;
        }else if (s.matches("[*/]")){
            return true;
        }else return false;
    }
}




