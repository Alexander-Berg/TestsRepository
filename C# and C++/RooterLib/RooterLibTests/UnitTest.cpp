#include "pch.h"
#include "CppUnitTest.h"
#include "..\RooterLib\RooterLib.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace RooterLibTests
{
    TEST_CLASS(UnitTest1)
    {
    public:
        TEST_METHOD(TestMethod1)
        {
        Assert::AreEqual(1, 1);
        }
        TEST_METHOD(BasicTest)
        {
            CRooterLib rooter;
            Assert::AreEqual(
                // Expected value:
                0.0,
                // Actual value:
                rooter.SquareRoot(0.0),
                // Tolerance:
                0.01,
                // Message:
                L"Basic test failed",
                // Line number - used if there is no PDB file:
                LINE_INFO());
        }
        TEST_METHOD(RangeTest)
        {
            CRooterLib rooter;
            for (double v = 1e-6; v < 1e6; v = v * 3.2)
            {
                double expected = v;
                double actual = rooter.SquareRoot(v * v);
                double tolerance = expected / 1000;
                Assert::AreEqual(expected, actual, tolerance);
            }
        };
        // Verify that negative inputs throw an exception.
        TEST_METHOD(NegativeRangeTest)
        {
            wchar_t message[200];
            CRooterLib rooter;
            for (double v = -0.1; v > -3.0; v = v - 0.5)
            {
                try
                {
                    // Should raise an exception:
                    double result = rooter.SquareRoot(v);
                    swprintf_s(message, L"No exception for input %g", v);
                    Assert::Fail(message, LINE_INFO());
                }
                catch (std::out_of_range ex)
                {
                    continue; // Correct exception.
                }
                catch (...)
                {
                    swprintf_s(message, L"Incorrect exception for %g", v);
                    Assert::Fail(message, LINE_INFO());
                }
            }
        }
    };

}

