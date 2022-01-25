// The following ifdef block is the standard way of creating macros which make exporting
// from a DLL simpler. All files within this DLL are compiled with the PROJECT1ROOTFINDER_EXPORTS
// symbol defined on the command line. This symbol should not be defined on any project
// that uses this DLL. This way any other project whose source files include this file see
// PROJECT1ROOTFINDER_API functions as being imported from a DLL, whereas this DLL sees symbols
// defined with this macro as being exported.
#ifdef PROJECT1ROOTFINDER_EXPORTS
#define PROJECT1ROOTFINDER_API __declspec(dllexport)
#else
#define PROJECT1ROOTFINDER_API __declspec(dllimport)
#endif

// This class is exported from the dll
class PROJECT1ROOTFINDER_API CProject1RootFinder {
public:
	CProject1RootFinder(void);
	double SquareRoot(double v);
	// TODO: add your methods here.
};

extern PROJECT1ROOTFINDER_API int nProject1RootFinder;

PROJECT1ROOTFINDER_API int fnProject1RootFinder(void);
