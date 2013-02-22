def sum(f: (Int => Int))(a: Int, b: Int) = f(a) + f(b)
def pairSum = sum(_ * 2) _
def simpleSum = sum(identity) _
simpleSum(1, 2)
pairSum(1, 2)