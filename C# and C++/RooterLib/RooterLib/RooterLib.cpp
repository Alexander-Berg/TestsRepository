#include "pch.h"
#include "RooterLib.h"
#include <math.h>
#include <stdexcept>

// constructor
CRooterLib::CRooterLib()
{
}
// Find the square root of a number.
double CRooterLib::SquareRoot(double v)
{
	return 0.0;
}


// Find the square root of a number.
double CRooterLib::SquareRoot(double v)
{
	double result = v;
	double diff = v;
	while (diff > result / 1000)
	{
		double oldResult = result;
		result = result - (result * result - v) / (2 * result);
		diff = abs(oldResult - result);
	}
	return result;
}

double CRooterLib::SquareRoot(double v)
{
	//Validate the input parameter:
	if (v < 0.0)
	{
		throw std::out_of_range("Can't do square roots of negatives");
	}

	// old code
//result = result - (result*result - v)/(2*result);
// new code
//	result = (result + v / result) / 2.0;