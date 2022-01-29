package com.skic;

public class ExerciseOne {
    public int[] fillAray(){
        int array[] = new int[100];
        for(int i = 0; i < array.length ;i++){
            array[i] = i;
        }
        return array;
    }

    public void show1DArray(int[] array){
        float suma = 0;
        int [] sumsOfColumns = new int[10];
        for(int i = 0; i<array.length;i++){
            if(i < 10){
                System.out.print("0");
            }

            sumsOfColumns[i%10] += array[i];

            System.out.print(array[i]+", ");

            if(i%10 == 9){
                System.out.println();
            }
        }

        for (int i = 0; i < sumsOfColumns.length ;i++){
            System.out.print(sumsOfColumns[i]+", ");
        }
    }
}
