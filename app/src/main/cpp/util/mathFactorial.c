#include "mathFactorial.h"
#include <math.h>

/*
 *
 */
static double factorial(double x){
    return x < 0 ? NAN : tgamma(x+1);
}
mathUtilNamespace const mathUtil = { factorial};


//Implementation below does not work for doubles as factorization is defined strictly on integers.
//        if(number <= 1){
//            return 1;
//        }
//        return number * factorial(number-1);



