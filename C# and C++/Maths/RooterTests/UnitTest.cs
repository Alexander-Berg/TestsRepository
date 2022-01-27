
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Maths;

namespace RooterTests
{
    [TestClass]
    public class UnitTest1
    {
        private double ToleranceHelper(double expected)
        {
            return expected / 1000;
        }

        [TestMethod]
        public void TestMethod1()
        {
            
            
         Assert.AreEqual(0, 0);
            
        }
        [TestMethod]
        public void BasicTest()
        {
            Maths.Rooter rooter = new Rooter();
            double expected = 0.0;
            double actual = rooter.SquareRoot(expected * expected);
            double tolerance = .001;
            Assert.AreEqual(expected, actual, tolerance);
        }
        [TestMethod]
        public void RangeTest()
        {
            Rooter rooter = new Rooter();
            for (double v = 1e-6; v < 1e6; v = v * 3.2)
            {
                double expected = v;
                double actual = rooter.SquareRoot(v * v);
                double tolerance = ToleranceHelper(expected);
                Assert.AreEqual(expected, actual, tolerance);
            }
        }
        // Old code
        // double tolerance = expected/1000;
        // New code
        
    }
}
