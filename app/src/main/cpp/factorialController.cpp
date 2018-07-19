#include <jni.h>
#include "util/mathFactorial.c"

extern "C" JNIEXPORT jdouble JNICALL

Java_untitled_factorialnative_MainActivity_factorial(JNIEnv *env, jobject instance, jdouble number){
        return mathUtil.factorial(number);
}
