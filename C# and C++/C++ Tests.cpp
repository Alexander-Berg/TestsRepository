TEST_METHOD(BasicTest)
{
CRootFinder rooter;
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

#include <math.h>
...
double CRootFinder::SquareRoot(double v)
{
double result = v;
double diff = v;
while (diff > result/1000)
{
double oldResult = result;
result = result - (result*result - v)/(2*result);
diff = abs (oldResult - result);
}
return result;
}

#include <stdexcept>
...
// Verify that negative inputs throw an exception.
TEST_METHOD(NegativeRangeTest)
{
wchar_t message[200];
CRootFinder rooter;
for (double v = -0.1; v > -3.0; v = v - 0.5)
{
try
{
// Should raise an exception:
double result = rooter.SquareRoot(v);
_swprintf(message, L"No exception for input %g", v);
Assert::Fail(message, LINE_INFO());
}
catch (std::out_of_range ex)
{
continue; // Correct exception.
}
catch (...)
{
_swprintf(message, L"Incorrect exception for %g", v);
Assert::Fail(message, LINE_INFO());
}
}
}

#include <stdexcept>
...
double CRootFinder::SquareRoot(double v)
{
// Validate parameter:
if (v < 0.0)
{
throw std::out_of_range("Can't do square roots of negatives");
}

// old code:
 result = result - (result*result - v)/(2*result);
// new code:
result = (result + v/result)/2.0;

//2 objects are equal
template<typename T>
static void Assert::AreEqual(
const T& expected,
const T& actual,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 doubles are equal
static void Assert::AreEqual(
double expected,
double actual,
double tolerance,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 floats are equal
static void Assert::AreEqual(
float expected,
float actual,
float tolerance,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 chat strings are equal
static void Assert::AreEqual(
const char* expected,
const char* actual,
bool ignoreCase = false,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 w_char strings are equal
static void Assert::AreEqual(
const wchar_t* expected,
const wchar_t* actual,
bool ignoreCase = false,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 doubles not equal
static void Assert::AreNotEqual(
double notExpected,
double actual,
double tolerance,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 floats not equal
static void Assert::AreNotEqual(
float notExpected,
float actual,
float tolerance,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 char strings are not equal
static void Assert::AreNotEqual(
const char* notExpected,
const char* actual,
bool ignoreCase = false,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//2 w_char strings not equal
static void Assert::AreNotEqual(
const wchar_t* notExpected,
const wchar_t* actual,
bool ignoreCase = false,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verify that two references are not equal based on operator==.
template<typename T>
static void Assert::AreNotEqual(
const T& notExpected,
const T& actual,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verify that two references refer to the same object instance (identity)
template<typename T>
static void Assert::AreSame(
const T& expected,
const T& actual,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

// Verify that two references do not refer to the same object instance (identity)
template<typename T>
static void Assert::AreNotSame (
const T& notExpected,
const T& actual,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verify that a pointer is NULL.
template<typename T>
static void Assert::IsNull(
const T* actual,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verify that a pointer is not NULL
template<typename T>
static void Assert::IsNotNull(
const T* actual,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verify that a condition is true
static void Assert::IsTrue(
bool condition,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verify that a condition is false
static void Assert::IsFalse(
bool condition,
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Force the test case result to be failed
static void Assert::Fail(
const wchar_t* message = NULL,
const __LineInfo* pLineInfo = NULL)

//Verifies that two Windows Runtime pointers are equal
template<typename T>
static void Assert::AreEqual(
T^ expected,
T^ actual,
Platform::String^ message = nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that two Platform::String^ strings are equal
template<typename T>
static void Assert::AreEqual(
T^ expected,
T^ actual,
Platform::String^ message= nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that two Windows Runtime references reference the same object.
template<typename T>
static void Assert::AreSame(
T% expected,
T% actual,
Platform::String^ message= nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that two Windows Runtime pointers are not equal.
template<typename T>
static void Assert::AreNotEqual(
T^ notExpected,
T^ actual,
Platform::String^ message = nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that two Platform::String^ strings are not equal.
static void Assert::AreNotEqual(
Platform::String^ notExpected,
Platform::String^ actual,
bool ignoreCase = false,
Platform::String^ message= nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that two Windows Runtime references do not reference the same object.
template<typename T>
static void Assert::AreNotSame(
T% notExpected,
T% actual,
Platform::String^ message= nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that a Windows Runtime pointer is a nullptr.
template<typename T>
static void Assert::IsNull(
T^ actual,
Platform::String^ message = nullptr,
const __LineInfo* pLineInfo= nullptr)

//Verifies that a Windows Runtime pointer is not a nullptr.
template<typename T>
static void Assert::IsNotNull(
T^ actual,
Platform::String^ message= nullptr,
const __LineInfo* pLineInfo= nullptr)

//verify that a function raises an exception:
template<typename _EXPECTEDEXCEPTION, typename _FUNCTOR>
static void Assert::ExpectException(
_FUNCTOR functor,
const wchar_t* message= NULL,
const __LineInfo* pLineInfo= NULL)

//Verify that a function raises an exception:
template<typename _EXPECTEDEXCEPTION, typename _RETURNTYPE>
static void Assert::ExpectException(
_RETURNTYPE (*func)(),
const wchar_t* message= NULL,
const __LineInfo* pLineInfo = NULL)

//Logger
//Write a string to the Output Window
static void Logger::WriteMessage(const wchar_t* message)
static void Logger::WriteMessage(const char* message)

//C++ TEST EXAMPLE
// USAGE EXAMPLE
#include <CppUnitTest.h>
using namespace Microsoft::VisualStudio::CppUnitTestFramework;
BEGIN_TEST_MODULE_ATTRIBUTE()
TEST_MODULE_ATTRIBUTE(L"Date", L"2010/6/12")
END_TEST_MODULE_ATTRIBUTE()
TEST_MODULE_INITIALIZE(ModuleInitialize)
{
Logger::WriteMessage("In Module Initialize");
}
TEST_MODULE_CLEANUP(ModuleCleanup)
{
Logger::WriteMessage("In Module Cleanup");
}
TEST_CLASS(Class1)
{
public:
Class1()
{
Logger::WriteMessage("In Class1");
}
~Class1()
{
Logger::WriteMessage("In ~Class1");
}
TEST_CLASS_INITIALIZE(ClassInitialize)
{
Logger::WriteMessage("In Class Initialize");
}
TEST_CLASS_CLEANUP(ClassCleanup)
{
Logger::WriteMessage("In Class Cleanup");
}
BEGIN_TEST_METHOD_ATTRIBUTE(Method1)
TEST_OWNER(L"OwnerName")
TEST_PRIORITY(1)
END_TEST_METHOD_ATTRIBUTE()
TEST_METHOD(Method1)
{
Logger::WriteMessage("In Method1");
Assert::AreEqual(0, 0);
}
TEST_METHOD(Method2)
{
Assert::Fail(L"Fail");
}
};


