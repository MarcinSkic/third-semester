#include <iostream>

using namespace std;
void Newton(int n, int p, int xTab[], int fTab[]);
int main()
{
    /*
    int n;
    cout<<"Podaj n: ";
    cin>>n;
    n++;

    int x[n];
    cout<<"Podaj wezly x: \n";
    for(int i = 0; i < n;i++){
        cin>>x[i];
    }

    int f[n];
    cout<<"Podaj wartosci funkcji f: \n";
    for(int i = 0; i < n;i++){
        cin>>f[i];
    }

    int p;
    cout<<"Podaj punkt p: ";
    cin>>p;
    */
    int n = 5;
    int x[n];
    int f[n];
    int p = -3;
    x[0] = -4;
    x[1] = -2;
    x[2] = 0;
    x[3] = 1;
    x[4] = 3;

    f[0] = -1;
    f[1] = -7;
    f[2] = -21;
    f[3] = -1;
    f[4] = 573;
    Newton(n,p,x,f);
}
bool CheckIfCorrect(int n, int p, int xTab[]){

    for(int i = 1; i < n; i++){
        if(xTab[i-1] >= xTab[i]){
            cout<<"Zle wezly";
            return false;
        }
    }
    if(p<xTab[0] || p>xTab[n-1]){
        cout<<"Zly punkt";
        return false;
    }
    return true;
}
void Newton(int n, int p, int xTab[], int fTab[]){

    if(!CheckIfCorrect(n,p,xTab)){
        return;
    }

    int ir[n];


    for(int i = 0; i < n; i++){
        ir[i] = fTab[i];
    }

    int result = ir[0], multiply = 1;

    n--;

    for(int i = 1; i <= n; i++){
        for(int k = n; k >= i; k--){
            ir[k] = ((ir[k]-ir[k-1])/(xTab[k]-xTab[k-i]));
        }
        multiply *= (p-xTab[i-1]);
        result += (ir[i]*multiply);
    }
    for(int i = 0; i <= n;i++){
        cout<<ir[i]<<" ";
    }
    /*for(int i = 1; i <= n; i++){
        multiply *= (p-xTab[i-1]);
        result += (ir[i]*multiply);
    }*/

    cout<<"Wynik wynosi: "<<result;
}
