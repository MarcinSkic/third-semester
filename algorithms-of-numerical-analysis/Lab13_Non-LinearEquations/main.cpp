#include <iostream>
#include <cmath>

using namespace std;

float functionRoot(float x){
    return pow(x,3)-71;
}
float derivativeRoot(float x){
    return 3*x*x;
}

void Bisekcja(float epsilon);
void Newton(float epsilon);

int main()
{
    float epsilon,divider;
    cout<<"Podaj dokladnosc (epsilon): ";
    cin>>epsilon;

    Bisekcja(epsilon);
    cout<<endl<<"-------------------"<<endl;
    Newton(epsilon);

}

void Bisekcja(float epsilon){
    float a = 3,b = 5, s;
    int k = 0;
    if(!(functionRoot(a)*functionRoot(b)<0)){
        cout<<"Nie spelnia warunkow";
        return;
    }

    while(true){
        s = (a+b)/2;
        if(abs(functionRoot(s))<epsilon){
            cout<<"Wartosc pierwiastka: "<<s<<endl;
            cout<<"Wartosc funkcji: "<<functionRoot(s)<<endl;
            cout<<"Liczba iteracji: "<<k<<endl;

            return;
        }

        if(functionRoot(a)*functionRoot(s)<0){
            b = s;
        } else {
            a = s;
        }

        k++;
        if(k > 2000){
            cout<<"Wartosc pierwiastka: "<<s<<endl;
            cout<<"Wartosc funkcji: "<<functionRoot(s)<<endl;
            cout<<"Liczba iteracji: "<<k<<endl;
            return;
        }
    }
}

void Newton(float epsilon){
    float x = 4;
    int k = 0;
    if(derivativeRoot(x) == 0){
        cout<<"Nie spelnia warunkow";
        return;
    }

    while(abs(functionRoot(x))>=epsilon){
        x = x-(functionRoot(x)/derivativeRoot(x));

        k++;
        if(k > 2000){
            break;
        }
    }

    cout<<"Wartosc pierwiastka: "<<x<<endl;
    cout<<"Wartosc funkcji: "<<functionRoot(x)<<endl;
    cout<<"Liczba iteracji: "<<k<<endl;
}
