[TestClass]
public class TestClass1
{
[TestMethod]
public void TestCurrentYear()
{
int fixedYear = 2000;
// Shims can be used only in a ShimsContext:
using (ShimsContext.Create())
{
// Arrange:
// Shim DateTime.Now to return a fixed date:
System.Fakes.ShimDateTime.NowGet =
() =>
{ return new DateTime(fixedYear, 1, 1); };
// Instantiate the component under test:
var componentUnderTest = new MyComponent();
// Act:
int year = componentUnderTest.GetTheCurrentYear();
// Assert:
// This will always be true if the component is working:
Assert.AreEqual(fixedYear, year);
}
}
}
<TestClass()> _
Public Class TestClass1
<TestMethod()> _
Public Sub TestCurrentYear()
Using s = Microsoft.QualityTools.Testing.Fakes.ShimsContext.Create()
Dim fixedYear As Integer = 2000
' Arrange:
' Detour DateTime.Now to return a fixed date:
System.Fakes.ShimDateTime.NowGet = _
Function() As DateTime
Return New DateTime(fixedYear, 1, 1)
End Function
' Instantiate the component under test:
Dim componentUnderTest = New MyComponent()
' Act:
Dim year As Integer = componentUnderTest.GetTheCurrentYear
' Assert:
' This will always be true if the component is working:
Assert.AreEqual(fixedYear, year)
End Using
End Sub
End Class

//unit test code
// create a ShimsContext cleans up shims
using (ShimsContext.Create()) {
// hook delegate to the shim method to redirect DateTime.Now
// to return January 1st of 2000
ShimDateTime.NowGet = () => new DateTime(2000, 1, 1);
Y2KChecker.Check();
}

//unit test code
[Test]
public void Y2kCheckerTest() {
using(ShimsContext.Create()) {
...
} // clear all shims
}

[TestClass]
public class TestClass1
{
[TestMethod]
public void TestCurrentYear()
{
int fixedYear = 2000;
using (ShimsContext.Create())
{
// Arrange:
// Detour DateTime.Now to return a fixed date:
System.Fakes.ShimDateTime.NowGet =
() =>
{ return new DateTime(fixedYear, 1, 1); };
// Instantiate the component under test:
var componentUnderTest = new MyComponent();
// Act:
int year = componentUnderTest.GetTheCurrentYear();
// Assert:
// This will always be true if the component is working:
Assert.AreEqual(fixedYear, year);
}
}
}
<TestClass()> _
Public Class TestClass1
<TestMethod()> _
Public Sub TestCurrentYear()
Using s = Microsoft.QualityTools.Testing.Fakes.ShimsContext.Create()
Dim fixedYear As Integer = 2000
' Arrange:
' Detour DateTime.Now to return a fixed date:
System.Fakes.ShimDateTime.NowGet = _
Function() As DateTime
Return New DateTime(fixedYear, 1, 1)
End Function
' Instantiate the component under test:
Dim componentUnderTest = New MyComponent()
' Act:
Dim year As Integer = componentUnderTest.GetTheCurrentYear
' Assert:
' This will always be true if the component is working:
Assert.AreEqual(fixedYear, year)
End Using
End Sub
End Class

// code under test
public class MyClass {
public int MyMethod() {
...
}
}

// unit test code
ShimMyClass.AllInstances.MyMethod = () => 5;

// Fakes generated code
public class ShimMyClass : ShimBase<MyClass> {
public static class AllInstances {
public static Func<MyClass, int>MyMethod {
set {
...
}
}
}
}

// unit test code
var myClass1 = new ShimMyClass()
{
MyMethod = () => 5
};
var myClass2 = new ShimMyClass { MyMethod = () => 10 };

// Fakes generated code
public class ShimMyClass : ShimBase<MyClass> {
public Func<int> MyMethod {
set {
...
}
}
public MyClass Instance {
get {
...
}
}
}

// unit test code
var shim = new ShimMyClass();
var instance = shim.Instance;

// unit test code
var shim = new ShimMyClass();
MyClass instance = shim; // implicit cast retrieves the runtime instance

// unit test code
ShimMyClass.ConstructorInt32 = (@this, value) => {
var shim = new ShimMyClass(@this) {
ValueGet = () => -5
};
};

// unit test code
public ShimMyClass() { }
public ShimMyClass(MyClass instance) : base(instance) { }

// Fakes generated code
public class ShimMyClass : ShimBase<MyClass>
{
public static Action<MyClass, int> ConstructorInt32 {
set {
...
}
}
public ShimMyClass() { }
public ShimMyClass(MyClass instance) : base(instance) { }
...
}

public abstract class MyBase {
public int MyMethod() {
...
}
}
public class MyChild : MyBase {
}

// unit test code
var child = new ShimMyChild();
new ShimMyBase(child) { MyMethod = () => 5 };

// Fakes generated code
public class ShimMyChild : ShimBase<MyChild> {
public ShimMyChild() { }
public ShimMyChild(Child child)
: base(child) { }
}
public class ShimMyBase : ShimBase<MyBase> {
public ShimMyBase(Base target) { }
public Func<int> MyMethod
{ set { ... } }
}

public class MyClass : IEnumerable<int> {
public IEnumerator<int> GetEnumerator() {
...
}
...
}

// unit test code
var shimMyClass = new ShimMyClass();
shimMyClass.Bind(new List<int> { 1, 2, 3 });

// Fakes generated code
public class ShimMyClass : ShimBase<MyClass> {
public ShimMyClass Bind(IEnumerable<int> target) {
...
}
}

// unit test code
ShimFile.WriteAllTextStringString = (fileName, content) => {
ShimsContext.ExecuteWithoutShims(() => {
Console.WriteLine("enter");
File.WriteAllText(fileName, content);
Console.WriteLine("leave");
});
};

// unit test code
ShimsDelegates.Action<string, string> shim = null;
shim = (fileName, content) => {
try {
Console.WriteLine("enter");
// remove shim in order to call original method
ShimFile.WriteAllTextStringString = null;
File.WriteAllText(fileName, content);
}
finally
{
// restore shim
ShimFile.WriteAllTextStringString = shim;
Console.WriteLine("leave");
}
};
// initialize the shim
ShimFile.WriteAllTextStringString = shim;

