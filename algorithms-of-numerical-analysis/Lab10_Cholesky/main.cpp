#include <iostream>
#include <cmath>
#include <vector>
#include <iomanip>

using namespace std;
void showMatrix(vector<vector<double>> matrix);
void calculateFirstVector(vector<vector<double>> matrix, double finalVector[], int columns);
int main()
{
    vector<vector<double>> example = {{9,-9,-6,9,-24},
                            {-9,13,10,-11,30},
                            {-6,10,17,-5,28},
                            {9,-11,-5,15,-29}};
    for(int col = 0; col < example[0].size()-1; col++){
        for(int row = 0; row < example.size(); row++){
            if(row < col){
                example[row][col] = 0;

                continue;
            }

            if(col==row){
                int sum = 0;
                for(int i = 0; i < col;i++){
                    sum += pow(example[row][i],2);
                }

                example[row][col] = example[row][col]-sum;
                if(example[row][col] < 0){
                    cout<<"Na przekatnej wartosc ujemna, przerywam prace"<<endl;
                    return 0;
                }
                example[row][col] = sqrt(example[row][col]);
                //zcout<<"l"<<row+1<<col+1<<" = "<<example[row][col]<<endl;
                continue;
            }

            int sum = 0;
            for(int i = 0; i < col;i++){
                    sum += example[row][i]*example[col][i];

                    //cout<<"l"<<row+1<<i+1<<"*l"<<row<<i+1<<" = "<<example[row][i]<<"*"<<example[row-1][i]<<endl;
            }

            example[row][col] = (example[row][col]-sum)/example[col][col];
            //cout<<"l"<<row+1<<col+1<<" = "<<example[row][col]<<endl;
        }
        showMatrix(example);
        cout<<endl;
    }
}

void calculateFirstVector(vector<vector<double>> matrix, double finalVector[], int columns){
    for(int i = 0; i <matrix.size(); i++){
        double sum = 0;
        //For each calculated X
        for(int x = 0 x <;x++ ){
            sum += finalVector[x]*matrix[i][x];
        }
        finalVector[i] = (matrix[i][columns-1]-sum)/matrix[i][i];
    }
}

void showMatrix(vector<vector<double>> matrix){
    for(int i = 0; i < matrix.size(); i++){
        for(int x = 0; x < matrix[0].size()-1; x++){
            cout<<setw(10)<<setprecision(3)<<matrix[i][x];
        }
        cout<<" |"<<setw(9)<<setprecision(3)<<matrix[i][matrix[0].size()-1]<<endl;
    }
}
