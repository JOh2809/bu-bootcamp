#include <stdio.h>

/* Correct swap using pointers */
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* This does not work because the function receives copies,
   not the addresses of the original variables. */
void broken_swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}

int main(void)
{
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);

    printf("After swap:  x = %d, y = %d\n", x, y);

    printf("\nTesting broken_swap:\n");

    int a = 30;
    int b = 40;

    printf("Before broken_swap: a = %d, b = %d\n", a, b);

    broken_swap(a, b);

    printf("After broken_swap:  a = %d, b = %d\n", a, b);

    return 0;
}