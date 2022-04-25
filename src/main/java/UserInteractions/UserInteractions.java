package UserInteractions;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInteractions {

    /**
     * Print welcome message for the user
     */
    public void welcome(){
        System.out.println("Welcome to Currency Converter\n");
    }

    /**
     * Give the user the option to choose between different conversion rate. By Entering a number between 1-3.
     * The method assert that the user's input is valid and return it.
     * If the user's input is not valid, the user is notified and he
     * will need to enter new value, until valid value is recieve.
     * @return valid user input between 1-3
     */
    public int chooseConversionRate(){

        boolean validChoise = true;
        int dollarOrShekelValue = 0;

        System.out.println("Please choose an option (1-3) \n" +
                "1. Dollars to Shekels \n" +
                "2. Shekels to Dollars \n" +
                "3. Shekels to Euro");

        while (validChoise){
            try {
                Scanner scanner = new Scanner(System.in);
                dollarOrShekelValue = scanner.nextInt();

                if (dollarOrShekelValue <= 3 && dollarOrShekelValue > 0){
                    System.out.println("false");
                    validChoise = false;
                    System.out.println(dollarOrShekelValue);
                }else {
                    System.out.println("Invalid Choice, please try again");
                }
            }catch (Exception e){
                System.out.println("Invalid Choice, please try again");
            }
        }
        return dollarOrShekelValue;
    }


    /**
     * This method ask from the user a number to convert.
     * And validate that the number is valid (number & bigger than 0)
     * If the user's input is not valid, the user is notified, and he
     * will need to enter new value, until valid value is recieve.
     * @return valid user input
     */
    public double amountToConvert(){
        Scanner scanner = new Scanner(System.in);
        double amountToConvert = 0;

        System.out.println("Please enter an amount to convert");

        try {
            amountToConvert  = scanner.nextDouble();
            if (amountToConvert <= 0) {
                System.out.println("Invalid Choice, please try again");
                amountToConvert();
            }
        }catch (Exception e){
            System.out.println("Invalid Choice, please try again");
            amountToConvert();
        }

        return amountToConvert;
    }

    /**
     * Ask the user to enter if he wish to start new conversion session or to end the session.
     * The method validate If the user's input is not valid, the user is notified, and he
     * will need to enter new value, until valid value is recieve.
     * @return true if user chose yes, and false if user chose no.
     */
    public boolean startOver(){
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean yesNo = true;
        System.out.println("Do you Wish to Start over and Calculate new value? \n" +
                "1. Y for Yes \n" +
                "2. N to Exit");

            while(yesNo){
                try {
                    input = scanner.next();
                    if(input.equalsIgnoreCase("y")){
                        yesNo = true;
                        break;
                    }else if(input.equalsIgnoreCase("n")){
                        yesNo = false;
                    }else{
                        System.out.println("Invalid Choice, please try again");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        return yesNo;
    }

    /**
     * Print thank you message when the user chose to end the converting session.
     */
    public void endMessage(){
        System.out.println("Tanks for using our currency converter");
    }

    /**
     * This method receive a list and write it into a file
     * @param resultsList List from the user of he's last conversion session that contains the numbers
     *                    and the conversion type text.
     * @param fileName The name of the output file
     */
    public void writeResultsToTextFile(ArrayList<String> resultsList, String fileName) {

        try {
            FileWriter myWriter = new FileWriter(fileName);
            String result = resultsList.toString().replace("]","" );
            myWriter.write(result.replace("[","" ));

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * This methos open the generated text file at the end of the conversion session.
     * @param fileName Text file name to open
     */
    public void openTextFile(String fileName){
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(fileName));
        }catch (Exception e){}

    }

    /**
     * This method is use for unit test asserion, to make sure that the file content is as expected.
     * @param fileName Text file name to read from
     * @return List of the file's content
     */
    public ArrayList<String> readResultsFromFileToList(String fileName){
        ArrayList<String> list = new ArrayList<String>();

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while (br.ready()) {
                    list.add(br.readLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
    }
}
