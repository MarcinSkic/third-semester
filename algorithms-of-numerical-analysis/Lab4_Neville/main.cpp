#include <iostream>

using namespace std;

void Neville(int n, float p, float xTab[], float fTab[]);
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
    int n = 3;
    float x[n];
    float f[n];
    float p = 1;
    x[0] = -1;
    x[1] = 0;
    x[2] = 2;


    f[0] = -7;
    f[1] = -1;
    f[2] = 7;

    Neville(n,p,x,f);
}
bool CheckIfCorrect(int n, float p, float xTab[]){

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
void Neville(int n, float p, float xTab[], float fTab[]){

    if(!CheckIfCorrect(n,p,xTab)){
        return;
    }

    float ir[n];


    for(int i = 0; i < n; i++){
        ir[i] = fTab[i];
    }

    n--;

    for(int i = 1; i <= n; i++){
        for(int k = 0; k <= n-1;k++){
            ir[k] = ((p-xTab[k])*ir[k+1]-(1-xTab[i+k])*ir[k])/(xTab[k+i]-xTab[k]);
            cout<<ir[k]<<" ";
        }
    }
    cout<<"Wynik wynosi: "<<ir[0];
}
