package com.defaultcompany;

import java.io.*;

public class Main {


    public static void main(String[] args) {
	    readFile();
    }

    public static void readFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("Part5ToBeFixed.txt")));
            String[] bigNumbers;
            String[] smollNumbers;
            bigNumbers = reader.readLine().split(" ");
            smollNumbers = reader.readLine().split(" ");

            System.out.println(bigNumbers[2]);
            saveFile(bigNumbers,smollNumbers);

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(String[] bigNumbers, String[] smollNumbers){
        try {
            FileWriter savior = new FileWriter(new File("Part5Fixed.txt"),true);

            for(int i = 0; i < bigNumbers.length;i++){
                savior.append(bigNumbers[i]+";"+smollNumbers[i]+"\n");
            }

            savior.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

