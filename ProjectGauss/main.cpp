#include <iostream>
#include <vector>
#include <iomanip>
#include <cmath>

using namespace std;

struct Example{
    string name;
    vector<vector<double>> matrix;
};

enum class Method {
        BasicMethod,
        HighestValueInColumm,
        HighestValueWherever,
};

Example chooseMatrixToCalculate(vector<Example> AllExamples);
Example createMatrixByUser();

bool basicMethod(vector<vector<double>> &matrix, int rows, int columns);
bool highestValueInColumnMethod(vector<vector<double>> &matrix, int rows, int columns);
bool highestValueWhereverMethod(vector<vector<double>> &matrix,int shiftPattern[], int rows, int columns);

void findAndSwitchHighestValueInColumn(vector<vector<double>> &matrix, int step,int rows, int columns);
void findAndSwitchHighestValueWherever(vector<vector<double>> &matrix, int shiftPattern[], int step,int rows, int columns);

void shiftRows(vector<vector<double>> &matrix, int ind1, int ind2, int columns);
void shiftColumns(vector<vector<double>> &matrix, int shiftPattern[], int ind1, int ind2, int rows);

void subtractAllRowsInStep(vector<vector<double>> &matrix, int step, int rows, int columns);
void subtractTwoRows(vector<vector<double>> &matrix, double factor, int minuendIndex, int subtrahendIndex,int columns);

bool checkIfZero(vector<vector<double>> matrix, int step);
bool shouldBeZero(double numberSuspectedOfBeingZero);
void repairShiftedVector(double shiftedVector[],int shiftPattern[], int columns);
void calculateFinalVector(vector<vector<double>> matrix, double finalVector[], int columns);

void showMatrix(vector<vector<double>> matrix);
void showFinishedVector( double finalVector[],int columns);
void showShiftPattern(int shiftPattern[], int columns);


int main()
{

    Example ex1;
    ex1.name = "Przyklad 10_1 z skryptu, obliczalny";
    ex1.matrix = {{1,1,0,-3,1},
                {1,4,-1,-4,-2},
                {0.5,0.5,-3,-5.5,1.5},
                {1.5,3,-5,-9,-0.5}};

    Example ex2;
    ex2.name = "Przyklad 10_2 z skryptu, obliczalny";
    ex2.matrix = {{2.25,-2.5,4,-5.25,-1},
                {-3,-7.5,6.5,0,17},
                {-6.25,-12.5,0.25,5.25,24.25},
                {9,10,7,-21,-33}};

    Example ex3;
    ex3.name = "Cwiczenie 10_2 z skryptu, obliczalny";
    ex3.matrix = {{1,2,-1,2,0},
                {1,0,-2,4,4},
                {0,-3,1.5,7,0},
                {0,-1,1,6,-1}};

    Example ex4;
    ex4.name = "Cwiczenie 10_3 z skryptu, obliczalny";
    ex4.matrix = {{14,-13,3,-16,-42,-37},
                {3.5,-18,13,-23.75,-21,-5.5},
                {3.5,3,-5.25,9.25,10.5,12.5},
                {2,14.5,-10.5,18.5,21,23.5},
                {1.5,6.75,-9.25,17,-10.5,-45.25}};

    Example ex5;
    ex5.name = "Cwiczenie 4 z ETrapeza, obliczalny";
    ex5.matrix = {{1,1,1,1,4},
                {-1,1,1,1,2},
                {-1,-1,1,1,0},
                {-1,-1,-1,1,-2}};

    Example ex6;
    ex6.name = "Uklad sprzeczny";
    ex6.matrix = {{1,-1,3},
                {2,-2,7}};

    Example ex7;
    ex7.name = "Uklad wiecej niz jedno rozwiazanie";
    ex7.matrix = {{1,1,2,4},
                {1,1,-1,1},
                {2,2,1,5}};

    Example ex8;
    ex8.name = "Metoda podstawowa sie wylozy, obliczalny";
    ex8.matrix = {{0,-1,1,6,-1},
                {1,0,-2,4,4},
                {0,-3,1.5,7,0},
                {1,2,-1,2,0}};

    Example ex9;
    ex9.name = "Macierz osobliwa";
    ex9.matrix = {{4,3,1,2,-1},
                {1,1,1,1,4},
                {1,1,1,1,0},
                {1,1,1,1,0}};

    Example ex10;
    ex10.name = "Obliczalny";
    ex10.matrix = {{1,2,0,1},
                {3,0,2,3},
                {0,2,0,2}};

    Example ex11;
    ex11.name = "Uklad sprzeczny";
    ex11.matrix = {{1,2,0,1},
                {0,-6,2,0},
                {0,0,0,2}};

    Example ex12;
    ex12.name = "Uklad wiele rozwiazan";
    ex12.matrix = {{0,2,0,1},
                {0,-6,2,0},
                {0,1,1,2}};

    Example ex13;
    ex13.name = "Wykrywa bledne przestawienie przy naprawianiu finalowego vektora";
    ex13.matrix = {{12,5,3,675,3},
                {43,1,24,3,12},
                {21,43,325,2,23},
                {324,234,23,23,23}};

    vector<Example> AllExamples = {ex1,ex2,ex3,ex4,ex5,ex6,ex7,ex8,ex9,ex10,ex11,ex12,ex13};

    Example choosenExample = chooseMatrixToCalculate(AllExamples);
    vector<vector<double>> matrix = choosenExample.matrix;

    int rows = matrix.size(), columns = matrix[0].size(), step;

    system("cls");
    cout<<"Wybrana macierz: "<<choosenExample.name<<endl;
    showMatrix(matrix);

    int choice;
    cout<<endl<<"Wybierz metode 0 - bazowa, 1 - najwiekszy element w kolumnie, 2 - najwiekszy element wszedzie: "<<endl;
    cout<<"Twoj wybor: ";
    cin>>choice;
    system("cls");

    Method method = (Method) choice;

    int shiftPattern[columns-1];

    switch(method){
        case Method::BasicMethod:
            if(!basicMethod(matrix,rows,columns)){
                return 0;
            }
            break;
        case Method::HighestValueInColumm:
            if(!highestValueInColumnMethod(matrix,rows,columns)){
                return 0;
            }
            break;
        case Method::HighestValueWherever:

            for(int i = 0;i < columns-1; i++){
                shiftPattern[i] = i;
            }

            if(!highestValueWhereverMethod(matrix,shiftPattern,rows,columns)){
                return 0;
            }

            break;
        default:

            cout<<"Brak takiej metody, koniec programu";
            return 0;


    }


    if(checkIfZero(matrix,columns-1)){  //Better check needed
        if(fabs(matrix[rows-1][columns-1]) < 1e-5){
            cout<<"Uklad rownan moze miec wiecej niz jedno rozwiazanie, koniec programu";
        } else {
            cout<<"Uklad rownan jest sprzeczny bo "<<matrix[rows-1][columns-2]<<"*x"<<rows<<" =/= "<<matrix[rows-1][columns-1]<<", koniec programu";
        }
        return 0;
    }

    double finalVector[columns-1];

    calculateFinalVector(matrix,finalVector,columns);

    if(method == Method::HighestValueWherever){
        cout<<endl<<"Przed naprawa wektora x'ow: "<<endl;
        showFinishedVector(finalVector,columns);
        showShiftPattern(shiftPattern,columns);

        repairShiftedVector(finalVector,shiftPattern,columns);

        cout<<endl<<"Po naprawie wektora x'ow: "<<endl;
        showFinishedVector(finalVector,columns);
        showShiftPattern(shiftPattern,columns);
    }

    cout<<endl<<endl<<"\t\tKONCOWY WYNIK"<<endl;
    showFinishedVector(finalVector,columns);
    cout<<endl;

    return 0;
}

Example chooseMatrixToCalculate(vector<Example> AllExamples){
    int choice;
    cout<<"Wybierz ktory przyklad chcesz policzyc: "<<endl;
    for(int i = 0; i < AllExamples.size(); i++){
        cout<<"Wybor "<<(i+1)<<" - "<<AllExamples[i].name<<endl;
        showMatrix(AllExamples[i].matrix);
        cout<<endl;
    }
    cout<<"Wybor "<<(AllExamples.size()+1)<<" - Podaj wlasna macierz"<<endl;
    cout<<"Twoj wybor: ";
    cin>>choice;

    if(choice <= AllExamples.size() && choice >= 0){
        return AllExamples[choice-1];
    } else {
        return createMatrixByUser();
    }
}

Example createMatrixByUser(){
    int mSize;
    double temp;
    Example created;
    vector<vector<double>> matrix;
    vector<double> row;

    system("cls");
    cout<<"Podaj wielkosc macierzy (dlugosc wierszy lub kolumn): ";
    cin>>mSize;

    if(mSize < 1){
        cout<<"Podano zla wielkosc, ustawiam 2"<<endl;
        mSize = 2;
    }

    for(int i = 0; i < mSize; i++){
        cout<<"WIERSZ: "<<(i+1)<<endl;
        row.clear();

        for(int x = 0; x < mSize; x++){
            cout<<"Podaj wspolczynnik przy x"<<(x+1)<<": ";
            cin>>temp;
            row.push_back(temp);
        }
        cout<<"Podaj wyraz wolny: ";
        cin>>temp;
        row.push_back(temp);
        matrix.push_back(row);
    }

    created.matrix = matrix;
    created.name = "Wlasna";

    return created;
}

bool basicMethod(vector<vector<double>> &matrix, int rows, int columns){
    int step;
    for(step = 1; step < rows; step++){

        cout<<endl<<"\t\tKROK "<<step<<"\t\t"<<endl<<endl;

        cout<<"\t\tMacierz przed krokiem "<<step<<"\t\t"<<endl;

        showMatrix(matrix);

        if(checkIfZero(matrix,step)){
            cout<<"Znaleziono zero na przekatnej, ta metoda konczy wtedy dzialanie";
            return false;
        }

        subtractAllRowsInStep(matrix,step,rows,columns);

        cout<<"\t\tMacierz po kroku "<<step<<"\t\t"<<endl;

        showMatrix(matrix);
    }
    return true;
}

bool highestValueInColumnMethod(vector<vector<double>> &matrix, int rows, int columns){
    int step;
    for(step = 1; step < rows; step++){

        cout<<endl<<"\t\tKROK "<<step<<"\t\t"<<endl<<endl;

        cout<<"\t\tMacierz przed krokiem "<<step<<"\t\t"<<endl;

        showMatrix(matrix);

        findAndSwitchHighestValueInColumn(matrix,step,rows,columns);

        cout<<endl<<"\tMacierz po znalezieniu elementu maksymalnego w kolumnie: "<<"\t\t"<<endl;

        showMatrix(matrix);

        if(checkIfZero(matrix,step)){
            cout<<"Znaleziono zero na przekatnej, ta metoda konczy wtedy dzialanie";
            return false;
        }

        subtractAllRowsInStep(matrix,step,rows,columns);

        cout<<endl<<"\t\tMacierz po kroku "<<step<<"\t\t"<<endl;

        showMatrix(matrix);
    }
    return true;
}

void findAndSwitchHighestValueInColumn(vector<vector<double>> &matrix, int step,int rows, int columns){
    double maxValue = fabs(matrix[step-1][step-1]);
    int newMaxInd = 0;

    for(int i = step; i < rows; i++ ){
        if(maxValue < fabs(matrix[i][step-1])){
            newMaxInd = i;
            maxValue = fabs(matrix[i][step-1]);
        }
    }

    if(newMaxInd != 0){
        shiftRows(matrix,step-1,newMaxInd,columns);
    }
}

bool highestValueWhereverMethod(vector<vector<double>> &matrix, int shiftPattern[], int rows, int columns){
    int step;
    for(step = 1; step < rows; step++){

        cout<<endl<<"\t\tKROK "<<step<<"\t\t"<<endl<<endl;

        cout<<"\t\tMacierz przed krokiem "<<step<<"\t\t"<<endl;

        showMatrix(matrix);

        findAndSwitchHighestValueWherever(matrix,shiftPattern,step,rows,columns);

        cout<<endl<<"\tMacierz po znalezieniu elementu maksymalnego: "<<"\t\t"<<endl;

        showMatrix(matrix);

        if(checkIfZero(matrix,step)){
            cout<<"Znaleziono zero przy metodzie maksymalnej, macierz osobliwa";
            return false;
        }

        subtractAllRowsInStep(matrix,step,rows,columns);

        cout<<endl<<"\t\tMacierz po kroku "<<step<<"\t\t"<<endl;

        showMatrix(matrix);
    }
    return true;
}

void findAndSwitchHighestValueWherever(vector<vector<double>> &matrix, int shiftPattern[], int step,int rows, int columns){
    double maxValue = fabs(matrix[step-1][step-1]);
    int newMaxIndX = step-1;
    int newMaxIndY = step-1;

    for(int i = step-1; i < rows; i++ ){
        for(int x = step-1; x < columns-1;x++ ){
            if(maxValue < fabs(matrix[i][x])){
                newMaxIndY = i;
                newMaxIndX = x;
                maxValue = fabs(matrix[i][x]);
            }
        }
    }

    if(newMaxIndY != step-1){
        shiftRows(matrix,step-1,newMaxIndY,columns);
    }

    if(newMaxIndX != step-1){
        shiftColumns(matrix,shiftPattern,step-1,newMaxIndX,rows);
    }

}

bool checkIfZero(vector<vector<double>> matrix, int step){
    if(fabs(matrix[step-1][step-1]) <= 1e-7){
        cout<<"Znaleziono zero na indeksie: x["<<step<<":"<<step<<"]"<<endl;
        return true;
    }
    return false;
}

void shiftRows(vector<vector<double>> &matrix, int ind1, int ind2, int columns){
    for(int x = 0; x < columns; x++){
        swap(matrix[ind1][x],matrix[ind2][x]);
    }
}

void shiftColumns(vector<vector<double>> &matrix, int shiftPattern[], int ind1, int ind2, int rows){
    for(int i = 0; i < rows; i++){
        swap(matrix[i][ind1],matrix[i][ind2]);
    }
    swap(shiftPattern[ind1],shiftPattern[ind2]);
}

void subtractAllRowsInStep(vector<vector<double>> &matrix, int step, int rows, int columns){
    for(int i = step; i < rows; i++){
        double factor = matrix[i][step-1]/matrix[step-1][step-1];

        if(factor == 0){    //Skip if nothing changes after subtraction
            continue;
        }

        subtractTwoRows(matrix,factor,i,step-1,columns);
    }
}

void subtractTwoRows(vector<vector<double>> &matrix, double factor, int minuendIndex, int subtrahendIndex, int columns){
    for(int x = 0; x < columns; x++){
        matrix[minuendIndex][x] -= matrix[subtrahendIndex][x]*factor;   //minuend = odjemna, subtrahend = odjemnik

        /*if(shouldBeZero(matrix[minuendIndex][x])){
            matrix[minuendIndex][x] = 0;
        }*/
    }
}

bool shouldBeZero(double numberSuspectedOfBeingZero){
    if(fabs(numberSuspectedOfBeingZero) < 1e-8){
        return true;
    }
    return false;
}

void repairShiftedVector(double shiftedVector[],int shiftPattern[], int columns){\
    for(int x = 0; x < 2; x++){
        for(int i = 0; i < columns-1; i++){
        int temp = shiftPattern[i];
        if(temp != i){
            swap(shiftedVector[i],shiftedVector[temp]);
            swap(shiftPattern[i],shiftPattern[temp]);
        }
    }
    }
}

void calculateFinalVector(vector<vector<double>> matrix, double finalVector[], int columns){
    for(int i = columns-2; i >= 0; i--){
        double sum = 0;
        //For each calculated X
        for(int x = i+1; x <= columns-2;x++ ){
            sum += finalVector[x]*matrix[i][x];
        }
        finalVector[i] = (matrix[i][columns-1]-sum)/matrix[i][i];
    }
}

void showShiftPattern(int shiftPattern[], int columns){
    cout<<endl<<"ShiftPattern: ";
    for(int i = 0; i < columns-1;i++){
        cout<<shiftPattern[i]<<" ";
    }
    cout<<endl;
}

void showMatrix(vector<vector<double>> matrix){
    for(int i = 0; i < matrix.size(); i++){
        for(int x = 0; x < matrix[0].size()-1; x++){
            cout<<setw(10)<<setprecision(3)<<matrix[i][x];
        }
        cout<<" |"<<setw(9)<<setprecision(3)<<matrix[i][matrix[0].size()-1]<<endl;
    }
}

void showFinishedVector(double finalVector[],int columns){
    cout<<"x=[";
    for(int i = 0; i < columns-1; i++){
        cout<<setprecision(3)<<finalVector[i];
        if(i+1!=columns-1){
            cout<<", ";
        }
    }
    cout<<"]T";
}
