public int AddIntegers(int first, int second)
{
int sum = first;
for( int i = 0; i < second; i++)
{
sum += 1;
}
return sum;
}

private TestContext testContextInstance;
public TestContext TestContext
{
get { return testContextInstance; }
set { testContextInstance = value; }
}

[DataSource(@"Provider=Microsoft.SqlServerCe.Client.4.0; Data Source=C:\Data\MathsData.sdf;", "Numbers")]
[TestMethod()]
public void AddIntegers_FromDataSourceTest()
{
var target = new Maths();
// Access the data
int x = Convert.ToInt32(TestContext.DataRow["FirstNumber"]);
int y = Convert.ToInt32(TestContext.DataRow["SecondNumber"]);
int expected = Convert.ToInt32(TestContext.DataRow["Sum"]);
int actual = target.IntegerMethod(x, y);
Assert.AreEqual(expected, actual,
"x:<{0}> y:<{1}>",
new object[] {x, y});
}

[DataSource(
dataProvider,
connectionString,
tableName,
dataAccessMethod
)]

using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
namespace TestProject1
{
[TestClass]
public class UnitTest1
{
private TestContext context;
public TestContext TestContext
{
get { return context; }
set { context = value; }
}
[TestMethod()]
[DeploymentItem("MyTestProject\\testdatasource.accdb")]
[DataSource("MyJetDataSource")]
public void MyTestMethod()
{
int a = Int32.Parse(context.DataRow["Arg1"].ToString());
int b = Int32.Parse(context.DataRow["Arg2"].ToString());
Assert.AreNotEqual(a, b, "A value was equal.");
}
[TestMethod()]
[DeploymentItem("MyTestProject\\data.xlsx")]
[DataSource("MyExcelDataSource")]
public void MyTestMethod2()
{
Assert.AreEqual(context.DataRow["Val1"], context.DataRow["Val2"]);
}
}
}