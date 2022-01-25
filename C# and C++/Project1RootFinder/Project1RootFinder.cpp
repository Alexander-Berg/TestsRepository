// Project1RootFinder.cpp : Defines the exported functions for the DLL.
//

#include "framework.h"
#include "Project1RootFinder.h"


// This is an example of an exported variable
PROJECT1ROOTFINDER_API int nProject1RootFinder=0;

// This is an example of an exported function.
PROJECT1ROOTFINDER_API int fnProject1RootFinder(void)
{
    return 0;
}

// This is the constructor of a class that has been exported.
CProject1RootFinder::CProject1RootFinder()
{
    return;
}

// Find the square root of a number.
double CProject1RootFinder::SquareRoot(double v)
{
    return 0.0;
}