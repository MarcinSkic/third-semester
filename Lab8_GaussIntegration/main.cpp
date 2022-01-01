#include <iostream>
#include <cmath>


using namespace std;

void GaussChebyshev(){
    float n = 3;
    n++;
    float result = 0;
    for(int i = 0; i < n; i++){
        float H = M_PI/n;
        float x = cos(((2*i+1)*M_PI)/(2*n));
        result += H*(x*x);
    }
    cout<<"GaussChebyshev: "<<result<<endl;
}

void GaussLegendre(){
    int n = 4;
    n++;
    float xTab[n] = {-0.906180,-0.538469,0,0.538469,0.906180};

    float HTab[n];
    HTab[0] = 0.236927;
    HTab[1] = 0.478629;
    HTab[2] = 0.568889;
    HTab[3] = 0.478629;
    HTab[4] = 0.236927;

    float result = 0;
    for(int i = 0; i < n; i++){
        result += HTab[i]*(1/sqrt(1+pow(xTab[i],2)));

    }
    cout<<"GaussLegendre: "<<result<<endl;
}

void GaussLaguerre(){
    int n = 3;
    n++;
    float xTab[n];
    xTab[0] = 0.322548;
    xTab[1] = 1.745761;
    xTab[2] = 4.536620;
    xTab[3] = 9.395071;

    float HTab[n];
    HTab[0] = 0.603154;
    HTab[1] = 0.357419;
    HTab[2] = 0.038888;
    HTab[3] = 0.000539;

    float result = 0;
    for(int i = 0; i < n; i++){
        result += HTab[i]*(exp(-xTab[i])*sin(xTab[i])/xTab[i]);
    }
    cout<<"GaussLaguerre: "<<result<<endl;
}

int main()
{
    GaussChebyshev();
    GaussLegendre();
    GaussLaguerre();
    return 0;
}

