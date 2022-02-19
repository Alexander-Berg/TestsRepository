#///////////////////////////unit tests on Python/////////////////////////

#Basic Test

import unittest

class TestStringMethods(unittest.TestCase):

    def test_upper(self):
        self.assertEqual('foo'.upper(), 'FOO')

    def test_isupper(self):
        self.assertTrue('FOO'.isupper())
        self.assertFalse('Foo'.isupper())

    def test_split(self):
        s = 'hello world'
        self.assertEqual(s.split(), ['hello', 'world'])
        # check that s.split fails when the separator is not a string
        with self.assertRaises(TypeError):
            s.split(2)

if __name__ == '__main__':
    unittest.main()

#The simplest TestCase subclass will simply implement a test method (i.e. a method whose name starts with test) in order to perform specific testing code:

import unittest

class DefaultWidgetSizeTestCase(unittest.TestCase):
    def test_default_widget_size(self):
        widget = Widget('The widget')
        self.assertEqual(widget.size(), (50, 50))

#Tests can be numerous, and their set-up can be repetitive. 
# Luckily, we can factor out set-up code by implementing a method called setUp(),
# which the testing framework will automatically call for every single test we run:

import unittest

class WidgetTestCase(unittest.TestCase):
    def setUp(self):
        self.widget = Widget('The widget')

    def test_default_widget_size(self):
        self.assertEqual(self.widget.size(), (50,50),
                         'incorrect default size')

    def test_widget_resize(self):
        self.widget.resize(100,150)
        self.assertEqual(self.widget.size(), (100,150),
                         'wrong size after resize')

#If the setUp() method raises an exception while the test is running, the framework will consider the test to have suffered an error,
# and the test method will not be executed.
#Similarly, we can provide a tearDown() method that tidies up after the test method has been run:

import unittest

class WidgetTestCase(unittest.TestCase):
    def setUp(self):
        self.widget = Widget('The widget')

    def tearDown(self):
        self.widget.dispose()
        

#However, should you want to customize the building of your test suite, you can do it yourself:

def suite():
    suite = unittest.TestSuite()
    suite.addTest(WidgetTestCase('test_default_widget_size'))
    suite.addTest(WidgetTestCase('test_widget_resize'))
    return suite

if __name__ == '__main__':
    runner = unittest.TextTestRunner()
    runner.run(suite())

#Basic skipping looks like this:

class MyTestCase(unittest.TestCase):

    @unittest.skip("demonstrating skipping")
    def test_nothing(self):
        self.fail("shouldn't happen")

    @unittest.skipIf(mylib.__version__ < (1, 3),
                     "not supported in this library version")
    def test_format(self):
        # Tests that work for only a certain version of the library.
        pass

    @unittest.skipUnless(sys.platform.startswith("win"), "requires Windows")
    def test_windows_support(self):
        # windows specific testing code
        pass

    def test_maybe_skipped(self):
        if not external_resource_available():
            self.skipTest("external resource not available")
        # test code that depends on the external resource
        pass

#Classes can be skipped just like methods:

@unittest.skip("showing class skipping")
class MySkippedTestCase(unittest.TestCase):
    def test_not_run(self):
        pass

#Expected failures use the expectedFailure() decorator.

class ExpectedFailureTestCase(unittest.TestCase):
    @unittest.expectedFailure
    def test_fail(self):
        self.assertEqual(1, 0, "broken")

#This decorator skips the test unless the passed object has a certain attribute:

def skipUnlessHasattr(obj, attr):
    if hasattr(obj, attr):
        return lambda func: func
    return unittest.skip("{!r} doesn't have {!r}".format(obj, attr))

@unittest.skip(reason)
#Unconditionally skip the decorated test. reason should describe why the test is being skipped.

@unittest.skipIf(condition, reason)
#Skip the decorated test if condition is true.

@unittest.skipUnless(condition, reason)
#Skip the decorated test unless condition is true.

@unittest.expectedFailure
#Mark the test as an expected failure or error. If the test fails or errors in the test function itself (rather than in one of the test fixture methods) then it will be considered a success. If the test passes, it will be considered a failure.

exception unittest.SkipTest(reason)
#This exception is raised to skip a test.

#Usually you can use TestCase.skipTest() or one of the skipping decorators instead of raising this directly

"""
This is the "example" module.

The example module supplies one function, factorial().  For example,

>>> factorial(5)
120
"""

def factorial(n):
    """Return the factorial of n, an exact integer >= 0.

    >>> [factorial(n) for n in range(6)]
    [1, 1, 2, 6, 24, 120]
    >>> factorial(30)
    265252859812191058636308480000000
    >>> factorial(-1)
    Traceback (most recent call last):
        ...
    ValueError: n must be >= 0

    Factorials of floats are OK, but the float must be an exact integer:
    >>> factorial(30.1)
    Traceback (most recent call last):
        ...
    ValueError: n must be exact integer
    >>> factorial(30.0)
    265252859812191058636308480000000

    It must also not be ridiculously large:
    >>> factorial(1e100)
    Traceback (most recent call last):
        ...
    OverflowError: n too large
    """

    import math
    if not n >= 0:
        raise ValueError("n must be >= 0")
    if math.floor(n) != n:
        raise ValueError("n must be exact integer")
    if n+1 == n:  # catch a value like 1e300
        raise OverflowError("n too large")
    result = 1
    factor = 2
    while factor <= n:
        result *= factor
        factor += 1
    return result


if __name__ == "__main__":
    import doctest
    doctest.testmod()
    
#Here is a minimal example of such a test runner:

if __name__ == '__main__':
    import doctest
    flags = doctest.REPORT_NDIFF|doctest.FAIL_FAST
    if len(sys.argv) > 1:
        name = sys.argv[1]
        if name in globals():
            obj = globals()[name]
        else:
            obj = __test__[name]
        doctest.run_docstring_examples(obj, globals(), name=name,
                                       optionflags=flags)
    else:
        fail, total = doctest.testmod(optionflags=flags)
        print("{} failures out of {} tests".format(fail, total))


#/////////////////////////////////////////////////////MOCKS////////////////////////////////////////
#Mock and MagicMock objects create all attributes and methods as you access them and store details of how they have been used. You can configure them, to specify return values or limit what attributes are available, and then make assertions about how they have been used:


from unittest.mock import MagicMock
thing = ProductionClass()
thing.method = MagicMock(return_value=3)
thing.method(3, 4, 5, key='value')

thing.method.assert_called_with(3, 4, 5, key='value')
side_effect allows you to perform side effects, including raising an exception when a mock is called:


mock = Mock(side_effect=KeyError('foo'))
mock()
values = {'a': 1, 'b': 2, 'c': 3}
def side_effect(arg):
    return values[arg]

mock.side_effect = side_effect
mock('a'), mock('b'), mock('c')

mock.side_effect = [5, 4, 3, 2, 1]
mock(), mock(), mock()

#The patch() decorator / context manager makes it easy to mock classes or objects in a module under test. The object you specify will be replaced with a mock (or other object) during the test and restored when the test ends:


from unittest.mock import patch
@patch('module.ClassName2')
@patch('module.ClassName1')
def test(MockClass1, MockClass2):
    module.ClassName1()
    module.ClassName2()
    assert MockClass1 is module.ClassName1
    assert MockClass2 is module.ClassName2
    assert MockClass1.called
    assert MockClass2.called

test()

#With patch() it matters that you patch objects in the namespace where they are looked up. This is normally straightforward, but for a quick guide read where to patch.

#As well as a decorator patch() can be used as a context manager in a with statement:


with patch.object(ProductionClass, 'method', return_value=None) as mock_method:
    thing = ProductionClass()
    thing.method(1, 2, 3)

mock_method.assert_called_once_with(1, 2, 3)
#There is also patch.dict() for setting values in a dictionary just during a scope and restoring the dictionary to its original state when the test ends:


foo = {'key': 'value'}
original = foo.copy()
with patch.dict(foo, {'newkey': 'newvalue'}, clear=True):
    assert foo == {'newkey': 'newvalue'}

assert foo == original
#Mock supports the mocking of Python magic methods. The easiest way of using magic methods is with the MagicMock class. It allows you to do things like:

mock = MagicMock()
mock.__str__.return_value = 'foobarbaz'
str(mock)

mock.__str__.assert_called_with()
Mock allows you to assign functions (or other Mock instances) to magic methods and they will be called appropriately. The MagicMock class is just a Mock variant that has all of the magic methods pre-created for you (well, all the useful ones anyway).

#The following is an example of using magic methods with the ordinary Mock class:


mock = Mock()
mock.__str__ = Mock(return_value='wheeeeee')
str(mock)

#This ensures that your mocks will fail in the same way as your production code if they are used incorrectly:

from unittest.mock import create_autospec
def function(a, b, c):
    pass

mock_function = create_autospec(function, return_value='fishy')
mock_function(1, 2, 3)

mock_function.assert_called_once_with(1, 2, 3)
mock_function('wrong arguments')

