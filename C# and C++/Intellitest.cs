
/***Pex Assume***/

[PexMethod]
public void Test1(object o) {
// precondition: o should not be null
PexAssume.IsNotNull(o);
...
}

/***non-nullness assumption***/

[PexMethod]
public void Test2([PexAssumeNotNull] object o)
// precondition: o should not be null
{
...
}

/***Testing Internal Types***/

[assembly: InternalsVisibleTo("Microsoft.Pex,
PublicKey=002400000480000094000000060200000024000052534131000400000100010007d1fa57c4aed9f0a32e84aa0faefd0de9
e8fd6aec8f87fb03766c834c99921eb23be79ad9d5dcc1dd9ad236132102900b723cf980957fc4e177108fc607774f29e8320e92ea05
ece4e821c0a5efe8f1645c4c0c93c1ab99285d622caa652c1dfad63d745d6f2de5f17e5eaf0fc4963d261c8a12436518206dc093344d
5ad293")]

/***General Test Structure***/

[Test]
void MyTest() {
// data
ArrayList a = new ArrayList();
// method sequence
a.Add(5);
// assertions
Assert.IsTrue(a.Count==1);
Assert.AreEqual(a[0], 5);
}

/***Data Driven Test***/

[DataSource(
@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:\Projects\MyBank\TestData\AccountsTest.accdb",
"AddIntegerHelperData"
)]
[TestMethod()]
public void AddIntegerHelper_DataDrivenValues_AllShouldPass()
{
var target = new CheckingAccount();
int x = Convert.ToInt32(TestContext.DataRow["FirstNumber"]);
int y = Convert.ToInt32(TestContext.DataRow["SecondNumber"]);
int expected = Convert.ToInt32(TestContext.DataRow["Sum"]);
int actual = target.AddIntegerHelper(x, y);
Assert.AreEqual(expected, actual);
}

/***Generated Intellitest***/

[TestMethod]
[PexGeneratedBy(typeof(global::HelloWorldTest))]
[PexRaisedException(typeof(Exception))]
public void HelloWorldThrowsException167()
{
this.HelloWorld("Hello World!");
}

/***Intellitest HelloWorld***/

using System;
using Microsoft.Pex.Framework;
using Microsoft.VisualStudio.TestTools.UnitTesting;
[TestClass]
public partial class HelloWorldTest {
[PexMethod]
public void HelloWorld([PexAssumeNotNull]string value) {
if (value.StartsWith("Hello")
&& value.EndsWith("World!")
&& value.Contains(" "))
throw new Exception("found it!");
}
}

/***simple PUT***/

[PexMethod]
void ReplaceFirstChar(string target, char c) {
string result = StringHelper.ReplaceFirstChar(target, c);
Assert.AreEqual(result[0], c);
}

/***method that replaces the first character of a string***/

class StringHelper {
static string ReplaceFirstChar(string target, char c) {
if (target == null) throw new ArgumentNullException();
if (target.Length == 0) throw new ArgumentOutOfRangeException();
return c + target.Substring(1);
}
}

/***serialized input***/

[TestMethod, ExpectedException(typeof(ArgumentNullException))]
void ReplaceFirstChar0() {
this.ReplaceFirstChar(null, 0);
}
...
[TestMethod]
void ReplaceFirstChar10() {
this.ReplaceFirstChar("a", 'c');
}

/***Parameterized unit tests can be generic methods***/

[PexClass]
public partial class ListTest {
[PexMethod]
[PexGenericArguments(typeof(int))]
[PexGenericArguments(typeof(object))]
public void AddItem<T>(List<T> list, T value)
{ ... }
}

/***SetUp and Teat Down***/

using Microsoft.Pex.Framework;
using NUnit.Framework;
namespace MyTests
{
[PexClass]
[TestFixture]
public partial class MyTestClass
{
[SetUp]
public void Init()
{
// monitored
}
[PexMethod]
public void MyTest(int i)
{
}
[TearDown]
public void Dispose()
{
// monitored
}
}
}
/*** n+1 conditions ***/
[PexMethod]
void ParameterizedTest(int n)
{
for (int i=0; i<n; i++) { // conditions are "0<n", "1<n", ..., "!(n<n)"
...
}
for (int i=0; i<100; i++) { // irrelevant for MaxConditions, since conditions do not depend on input
...
}
}
/*** PexAssumeNotNull ***/
// assume foo is not null
[PexMethod]
public void SomeTest([PexAssumeNotNull]IFoo foo, ...) {}

public class Foo {
// this field should not be null
[PexAssumeNotNull]
public object Bar;
}
// never consider null for Foo types
[PexAssumeNotNull]
public class Foo {}







