#ifndef FACTORIALNATIVE_MATHFACTORIAL_H
#define FACTORIALNATIVE_MATHFACTORIAL_H

typedef struct {
    double (*factorial)(double);
} mathUtilNamespace;

extern mathUtilNamespace const mathUtil;

#endif //FACTORIALNATIVE_MATHFACTORIAL_H
