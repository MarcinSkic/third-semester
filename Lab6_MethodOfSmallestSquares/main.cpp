#include <iostream>
#include <cmath>
#include <tgmath.h>

using namespace std;

void ShowResult(int choice, float a0, float a1){
    switch(choice){
    case 1:
        cout<<"Przyblizona funkcja: y = "<<a1<<"x + "<<a0;
        break;
    case 2:
        cout<<"Przyblizona funkcja: y = "<<a1<<"1/x + "<<a0;
        break;
    case 3:
        cout<<"Przyblizona funkcja: y = e^"<<a1<<"x + e^"<<a0;
        break;
    }
}

void Method(int choice, int n, float xTab[], float fTab[]){

    switch(choice){
    case 1:
        break;
    case 2:
        for(int i = 0; i < n; i++){
            xTab[i] = 1/xTab[i];
        }
        break;
    case 3:
        for(int i = 0 ;i < n;i++){
            xTab[i] = log(xTab[i]);
            fTab[i] = log(fTab[i]);

        }
        break;
    default:
        cout<<"WRONG";
        return;
    }

    float sumX = 0, sumY = 0, sumX2 = 0, sumXY = 0;

    for(int i = 0; i < n; i++){
        sumX += xTab[i];
        sumY += fTab[i];
        sumX2 += pow(xTab[i],2);
        sumXY += xTab[i]*fTab[i];
    }
    cout<<sumX<<" "<<sumY<<" "<<sumX2<<" "<<sumXY<<"\n";

    float W,W0,W1,a0,a1;

    W = n*sumX2 - (sumX*sumX);
    W0 = sumY*sumX2 - (sumX*sumXY);
    W1 = n*sumXY - (sumY*sumX);

    cout<<W<<" "<<W0<<" "<<W1<<"\n";

    a0 = W0/W;
    a1 = W1/W;


    ShowResult(choice, a0,a1);
}

int main()
{
    int choice;
    cout<<"Jaka funkcje podasz?\n";
    cout<<"1 -> f(x) ax + b\n";
    cout<<"2 -> f(x) = a/x + b\n";
    cout<<"3 -> f(x) = a*b^x gdzie za x podajemy e^x\n";
    cout<<"Wybor: ";
    cin>>choice;

    int n;
    cout<<"Podaj n: ";
    cin>>n;

    float x[n];
    cout<<"Podaj wezly x: \n";
    for(int i = 0; i < n;i++){
        cin>>x[i];
    }

    float f[n];
    cout<<"Podaj wartosci funkcji f: \n";
    for(int i = 0; i < n;i++){
        cin>>f[i];
        f[i] = exp(f[i]);
    }

    Method(choice,n,x,f);
}

