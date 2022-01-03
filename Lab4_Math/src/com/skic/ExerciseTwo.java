package com.skic;

import java.util.Random;

public class ExerciseTwo {
    Random random = new Random();
    int arraySize;
    public int[][] fill2DArray(){
        var size = random.nextInt(11)+10;
        int[][] array = new int[size][size];
        for(int i = 0; i < size ;i++){
            for (int x = 0; x < size; x++){
                if(x != i){
                    array[i][x] = random.nextInt(41)-20;
                } else {
                    array[i][x] = random.nextInt(2)-1;
                }
            }
        }
        return array;
    }

    public void showArray(int [][] array){
        int size = (int)Math.sqrt(array.length);

        for(int i = 0; i < size ;i++){
            for (int x = 0; x < size; x++){
                System.out.print(array[i][x]+"\t");
            }
            System.out.println();
        }
    }

    public void checkDifferenceBetweenSums(int [][] array){
        int size = (int)Math.sqrt(array.length);
        int evenRowsSum = 0;
        int unevenColumnsSum = 0;

        for(int i = 0; i < size;i+=2){
            for(int x = 0; x < size; x++){
                evenRowsSum += array[i][x];
            }
        }

        for(int i = 0; i < size;i++){
            for(int x = 1; x < size; x+=2){
                unevenColumnsSum += array[i][x];
            }
        }

        System.out.println("Stosunek sumy liczb na parzystych wierszach do liczb na nieparzystych kolumnach wynosi: "+evenRowsSum+":"+unevenColumnsSum);
    }
}
