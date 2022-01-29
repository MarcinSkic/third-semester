#include <iostream>

using namespace std;
void Lagrange(int n,int p,int x[],int f[]);
//bool CheckLagrange(int n, int xTab[]);
int main()
{
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
    Lagrange(n,p,x,f);
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

void Lagrange(int n,int p,int xTab[],int fTab[]){

    if(!CheckIfCorrect(n,p,xTab)){
        return;
    }

    int result = 0;
    int multiply = 1;

    for(int i = 0; i < n;i++){
        for(int y = 0; y < n; y++){
            if(y==i){
                continue;
            }
            multiply *= ((p-xTab[y])/(xTab[i]-xTab[y]));
        }
        result += multiply*fTab[i];
        multiply = 1;
    }
    cout<<result;
}

