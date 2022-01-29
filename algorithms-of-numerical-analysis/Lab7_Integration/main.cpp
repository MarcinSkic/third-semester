#include <iostream>
#include <cmath>
#include <math.h>

using namespace std;

double Functions(double x, int func){
    switch(func){
    case 1:
        return (pow(sin(x),2)+2);
    case 2:
        return (exp(x)*2*pow(x,3));
    case 3:
        return pow(cos(x),4);
    case 4:
        return 1/x;
    }

}

void TrapezeMethod(int n, double h,double x[], int func){
    double result = 0;
    for(int i = 0; i <= n; i++){
        if(i == 0 || i == n){
            result += 0.5*Functions(x[i],func);
        } else {
            result += Functions(x[i],func);
        }
    }
    result *= h;
    cout<<"Wyliczona calka wynosi: "<<result;
}

void Simpson(int n, double h, double x[], int func){
    double result = 0;
    int wykonaneSumy = 0;
    double sumParz = 0;
    double sumNparz = 0;
    double suma=0;
    for(int i = 0; i <= n; i++){

        if(i == 0 || i == n){
            result += Functions(x[i],func);
            wykonaneSumy++;
            cout<<"Aktualna suma 1: "<<result<<"\n";
            continue;
        } else if(i %2 == 1){
            sumNparz += (Functions(x[i],func));
            suma = (Functions(x[i],func));
            cout<<"Aktualna suma 2: "<<suma<<"\n";
            wykonaneSumy++;
            continue;
        } else if(i %2 == 0){
            sumParz += (Functions(x[i],func));
            suma=(Functions(x[i],func));
            wykonaneSumy++;
            cout<<"Aktualna suma 3: "<<suma<<"\n";
            continue;
        }
    }
    cout<<"wykonaneSumy: "<<wykonaneSumy;
    result += sumNparz*4;
    result += sumParz*2;
    result *= h;
    result /= 3;
    cout<<"Wyliczona calka wynosi: "<<result;
}

double PrepareMethod(int n){
    double a,b;
    int choice;

    cout<<"Podaj funkcje (1, 2, 3, 4): ";
    cin>>choice;

    switch(choice){
    case 1:
        a = 0;
        b = 2*M_PI;
        break;
    case 2:
        a = 0;
        b = 2;
        break;
    case 3:
        a = 0;
        b = 2*M_PI;
        break;
    case 4:
        a = 1;
        b = 7;
        break;
    default:
        cout<<"ZLE";
        return 0;
    }

    double h = (b-a)/n;

    double x[n+1];

    x[0] = a;
    cout<<x[0]<<" ";
    for(int i = 1; i <= n; i++){
        x[i] = x[i-1]+h;
        cout<<x[i]<<" ";
    }
    cout<<endl;
    char funcChoice;
    cout<<"Podaj tryb (Tt,Ss): ";
    cin>>funcChoice;

    if(n%2 == 0){

        switch(funcChoice){
        case 't':
        case 'T':
            TrapezeMethod(n,h,x,choice);
            break;
        case 'S':
        case 's':
            Simpson(n,h,x,choice);
            break;
        }
    } else {
        cout<<"N nie parzyste, tylko trapezy";
        TrapezeMethod(n,h,x,choice);
    }

}

int main()
{

    int n;
    cout<<"Podaj n: ";
    cin>>n;

    /*int a,b;

    cout<<"Podaj a: ";
    cin>>a;

    while(true){
        cout<<"Podaj b: ";
        cin>>b;
        if(a>=b){
            cout<<"a powinno byc mniejsze od b, podaj ponownie: ";
        } else {
            break;
        }
    }*/

    PrepareMethod(n);
    /*)
    int n = 5;
    double x[n];
    double f[n];
    double p = 1;
    x[0] = -3;
    x[1] = -1;
    x[2] = 0;
    x[3] = 2;
    x[4] = 4;

    f[0] = -17;
    f[1] = 9;
    f[2] = 17;
    f[3] = 23;
    f[4] = 25;
    Neville(n,p,x,f);*/
}


