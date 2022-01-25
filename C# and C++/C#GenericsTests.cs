public void SizeOfLinkedListTestHelper<T>()
{
T val = default(T); // TODO: Initialize to an appropriate value
MyLinkedList<T> target = new MyLinkedList<T>(val); // TODO: Initialize to an appropriate value
int expected = 0; // TODO: Initialize to an appropriate value
int actual;
actual = target.SizeOfLinkedList();
Assert.AreEqual(expected, actual);
Assert.Inconclusive("Verify the correctness of this test method.");
}
[TestMethod()]
public void SizeOfLinkedListTest()
{
SizeOfLinkedListTestHelper<GenericParameterHelper>();
}

public void SizeOfLinkedListTestHelper<T>()
{
T val = default(T);
MyLinkedList<T> target = new MyLinkedList<T>(val); // step 1
for (int i = 0; i < 4; i++) // step 2
{
MyLinkedList<T> newNode = new MyLinkedList<T>(val);
target.Append(newNode);
}
int expected = 5; // step 3
int actual;
actual = target.SizeOfLinkedList(); // step 4
Assert.AreEqual(expected, actual); // step 5
}
[TestMethod()]
public void SizeOfLinkedListTest()
{
SizeOfLinkedListTestHelper<int>(); // step 6
SizeOfLinkedListTestHelper<char>(); // step 7
}

using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
namespace ClassLibrary2
{
public class Employee
{
public Employee(string s, int i)
{
}
}
public class GenericList<T> where T : Employee
{
private class Node
{
private T data;
public T Data
{
get { return data; }
set { data = value; }
}
}
}

using ClassLibrary2;
using Microsoft.VisualStudio.TestTools.UnitTesting;
namespace TestProject1
{
[TestClass()]
public class GenericList_NodeTest
{
public void DataTestHelper<T>()
where T : Employee
{
GenericList_Shadow<T>.Node target = new GenericList_Shadow<T>.Node(); // TODO: Initialize to an
appropriate value
T expected = default(T); // TODO: Initialize to an appropriate value
T actual;
target.Data = expected;
actual = target.Data;
Assert.AreEqual(expected, actual);
Assert.Inconclusive("Verify the correctness of this test method.");
}
[TestMethod()]
public void DataTest()
{
Assert.Inconclusive("No appropriate type parameter is found to satisfies the type constraint(s)
of T. " +
"Please call DataTestHelper<T>() with appropriate type parameters.");
}
}
}

