Coursera: Functional Programming in Scala
-----------------------------------------

## Links
- Setup environment: https://class.coursera.org/progfun-005/wiki/ToolsSetup
- IntelliJ Setup: https://class.coursera.org/progfun-005/wiki/IntelliJ_IDEA

### 1.1 - Programming Paradigms
------------------------------

Main programming paradigms

1. Imperative - Java, C
2. Functional
3. Logic

OOP orthogonal to all three paradigms. 

Modify mutable variables

Von Neumann computer

    Processory <--- Bus -----> Memory

Processory reads data from memory with a bus. And size of the bus is 32 (or 64 bit). Bus carries one word at a time. Von Numann Style of Programming - Conceptualizing programs word by word. We want to read into more big data structure.

We need other techniques for defining high-level abstractions such as collections. polynomials, shapes, strings, documents.

Theory of mathematics

    Normally in mathematics theory does not describe mutations

For Instance sum of polynomial equations,

    (a*x + b) + (c*x + d) = (a+c)*x + (b+d)

But it does not define an "operator" to change the coefficients while keeping the polynomial same.

    "operator" => function in programming language

while in imperative programming we can change the coefficients. Breaking theory of mutation

While they do somethings right like Java keeps Strings immutable.

Mutation can destroy useful laws in theories

Functional Programming
1. In restricted sense
2. In wider sense

In restricted sense, 
- Variables can not be muted
- Assignment is not there
- No control structres

In wider sense
- functions are first-class citizens. You can use functions like any other data.

Restricted: Pure lisp, XPath, XQuery, FP
Wider: Lisp, Clojure, Scala, Ruby, JS

Why functional programming is becoming increasingly popular ?

- Good for exploiting parallelism for multicore and cloud computing and concurrency

2011 Oscon Java - Working Hard to keep it simple

### 1.2 - Elements of Programming
------------

REPL: Read Eval Print Loop

Expressions in Scala

    def square(x:Int) = x * x;
    def sumOfSquares(x:Int, y:Int) = square(x) + square(y);

Compare the above expression with expression in mathematics. It is almost same.

Primitive Types are as in Java but written campitalized. e.g.

Int 32-bit Integers
Double 64-bit floating point numbers
Boolean boolean values

#### The Substitution Model: Substitue the values in expression until we reach the value

    sumOfSquares(3, 2+2)
    sumOfSquares(3, 4);
    square(3) + square(4);
    3*3 + square(4);
    9 + square(4);
    45

This is formalized in Lambda calculus which gives a foundation for functional programming

#### Side Effects:
- Does not work with operators which change the value in place like x++, y--
- Recursion e.g. def loop:int = loop; This can not be reduced.

#### Evaluation of functions:

1. Call-by-value: Substitution. Has the advantage that it evaluates every function argument only once.  

2. Call-by-name: Interpreter reduces function arguments to values before rewriting the function application. Has the advantage that a function argument is not evaluated if corresponding parameter is unused in evaluation of function body.
    sumOfSquares(3, 2+2)
    square(3) + square(2+2)
    3*3 + square(2+2)
    9 + square(2+2)
    9 + (2+2) * (2+2)
    9 + 4*4
    25

#### Question: def test(x:Int, y:Int):Int = x*x
Calculate the number of steps with CBV and CBN for test(2*3, 4*5)

Call By Value

    test(2*3, 4*5)
    test(6, 4*5)
    test(6, 20)
    6 * 6
    36

Call By Name

    test(2*3, 4*5)
    (2*3) * (2*3)
    6 * (2*3)
    6 * 6
    36

Answer: Same number of steps.

### 1.3 - Evaluation Strategies
-------------------------------

- Both methods terminate with same value
- If CBV termintaes, then CBN also terminates but reverse is not true. e.g.
    
    def constOne(x: Int, y: Int): Int = 1
    constOne(1, loop)

- In this case, CBN terminates because `loop` is not reduced to its value
- While, CBV does not terminate because `loop` will try to reduce to its value and will never reach termination.

- Scala normally uses CBV but if function parameter starts with => it uses call-by-name
- CBV is more efficient than CBN  because it avoids repeated computations. (Exponentially faster) Consider the case of recursion.
- You can force Scala to compute by CBN by using =>. e.g.

    def constOne(x: Int, y: => Int) = 1
    const(1+2, loop) // Works fine
    const(loop, 1+2) // Since loop is CBV, it tries to reduce itself and we are stuck in infnite sycle.

### 1.4 - Expressions
---------------------

1. Conditional Experssions
2. Boolean Expressions

Just like functions/expressions, definitions can also also differentiated by "by-name" and "by-value".

Example of By Name:

    def result(x:Int, y:Int)

Example of By Value:

    val x = 2
    val y = square(2)

Observe, we called square by its name and in y, 4 is stored instead of square(2). Reduced expression is stored in y and hence by value.

Another Example

    def loop: Boolean = loop
    def x = loop // No evaluation and works fine
    val y = loop // Does not terminate. Infinite recursion because value is computed.

#### Exercise: Write Implementation of AND operator

Solution

    def and(x: Boolean, y:Boolean) = {
      return if (x) y else x
    }

    def(true, false); // Works
    def(false, true); // Works
    def(true, loop); // Infinite loop because 2nd argument is CBV

    def and(x: Boolean, y: => Boolean) = {
      return if (x) y else x
    }
 
     and(false, loop); // Works now and gives false

### 1.5 - Newtons method for calculatin square root
-------------

In scala, recursive functions must have return type while it is optional for non-recursive functions. Scala tries to calculate the return type from RHS of function and in recursive function it would go into loop to find out return type and hence Scala enforces you to define return type in recursive functions while it is optional in non-recursive functions.

Worksheet is more advanced than REPL and better for quick testing

### 1.6 - Blocks and Lexical Scope
-------

- Scope is defined with `{} - braces`.
- We can define multiple functions inside a function definition.e.g

    def squareRoot(x: Double) = {
      def a(guess: Double) = {
        // Do something with guess and x
        // x is available here
      }
    }

- There are two benefits of scoping, Namespace polluting and Code clean
- `;` is optional 
- Two ways to write multi line expression

    (someLongExpression1
      + expression2
    )

    OR

    someLongExpression1 + 
        expression2

### 1.7 - Tail Recursion
------

If a function calls itself as the last step of its definition then it is called tail calls (or tail recursion) and this can be evalated in one stack frame. (Sort of iteration) and hence constant space

    Tail recursive functions are iterative processes.

Example: GCD

    def gcd(a: Int, b:Int) = if (b == 0) a else gcd(b, a%b)

Exercise: Compute factorial

    def factorial(num: Double) = {
      if (num === 1) return 1

      return num * facorial(n-1)
    }

But this is not a tail recursion function because it has to return and return the computed value.

Tail recursions can help avoid Stackoverflow execptions.

We can enforce tailRecursion with `@tailrec` annotation in scala.
If annotation is given and implementation is not tail recursive, it will throw an error.

Exercise: Factorial definition as Tail recursion

    def factorial(n: Int) = {
      def loop(n: Int, result: Double) {
        if (n == 0) result
        else loop(n-1, n * result)
      }

      loop(n, 1)
    }


### 2.1 - Higher Order functions
----------

High Order functions which take functions as arguments and can return functions. Example

    def sumInts(a: Int, b: Int) = if (a > b) 0 else a + sumInts(a+1, b)
    def sumCubes(a: Int, b: Int) = if (a > b) 0 else cube(a) + sumInts(a + 1, b)

Similarly, we may have to repeat the code for multiple logic like

- Calculate sum of facorials between `a` and `b`
- Calculate sum of squares between `a` and `b`

So, Pass this logic as anargument like this

    def sumInt(f: Int => Int, a: Int, b: Int) = 
      if (a > b) return 0
      else 
        return f(a) + sumInts(a + 1, b)

Function type

    f: Int => Int

Anonymous functions

    (x: Int) => x * x * x

Q: Write above sumInts using tail recursion.

    def sumInts(f: Int => Int, a: Int, b: Int) = {
      def loop(a: Int, result: Int) if (a > b) result else loop(a+1, result + f(a))
      
      loop(a, 0)
    }

### 2.2 - Currying
------------------

Inbuilt support for functions that return functions. It is very useful in functional programming.

    def sum(f: Int => Int)(a: Int, b:Int): Int = 
        if (a > b) 0 else f(a) + sum(f)(a+1, b)

Exercise

1. Write Product function that calculates product values of function for points on given interval ?
2. Write factorial in terms of product
3. General function to generalize sum and product.

    // Solution 1
    def product(a: Int, b: Int) = {
      def loop(a: Int, result: Int) = 
        if (a > b) result else loop(a+1, result * a)
    
      loop(a, 1)
    }

    // Using curry

    def product(f: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 1
      else f(a) * product(f)(a+1, b)
    }

    product(x => x*x)(3,4) // Product of squares

    // Solution 2
    def factorial(n: Int) = product(x => x)(1, n)

*Concept*: Instead of sending a method and other things as different arguments, extract out the method and we can then reuse it later. Example

    /**
    * In this case, sumOfSquare method is not getting reused.
    */
    sum(x=> x*x, 2, 4);

    /**
    * In this case, the following definition can be reused later on and can be passed to different method as well.
    */
    sum(x => x*x)(2,4);

### 2.3 - Fixed Point of function
---------------------------------

A fixed point x is defined as `f(x) = x` then x is the fixed point of f.
For example in square root, 

    y*y = x // y is sq root of x
    y = x/y

We can say that fixed point of (x/y) will be the square root of x where y is the variable/result. But there can be certain scenarios when 
we may oscillate between two values and we may not reach fixed point. Avergage damping technique is used in that case. That means the fixed poinf of new function (below) will be the square root.

    (x/y + y)/2 ~ y (precision of 0.001)

We can then write this function as curry like this:

    fixedPoint(averageDamp)(y => x/y)(1)

Comparing this equation to mathematics, we can write something like this:

    f(g)(x,y)
    // Observe f(g) is a higher order function here

### 2.6 - Data Abstraction
--------------------------

- We can use `private` keyword for private members
- There are inbuilt methods like require and assert in each class to avoid runtime errors 
- We can also define multiple constructos like java class e.g.

    def class Rational(x: Int, y: Int) = {
        // Second argument optional
        def this(x) = this(x, 1)

        // Constructor area
        val ratio = x/y
        
        // Other code for construction

    }

### 3.1 - Class Hierarchies
---------------------------
 
- Persistent Data structures - When old state of data structures is retained when a value is added/removed
- Persistene Data Structures play a very important role in functional programming
- Every class in Scala extends a common class `Object` class in java.lang
- Using `object` keyword instead of `class` will define a singleton instance and there is no other method to create another instance.eg.

    object EmptyNode extends IntSet {
      def contains(n:Int): Boolean = false
      def include(n: Int): IntSet = new NonEmpty(n, EmptyNode, EmptyNode)   
    }

- EmptyNode is value here so EmptyNode evaluates to itself
- Scala application must contain an object with main method like Java

#### Question: How can your prove that a recursion terminates ?

Answer: One of the ways to look at the recusive expression is that your recursion is always called on smaller subset.
Hence, at some point you will reach zero which is terminating point.

#### Dynamic Binding

> Code that a method invokes depends upon the runtime argument/type of object that contains the method
> e.g. Empty contains 1
> e.g. (new NonEmpty(7, Empty, Empty) contains 7
> In this particular case contains method is called but runtime type defines which particular object will call that method.

### 3.2 - How Classes are organized
----------------

#### Imports
- Automatic imports from package scala (Int, Boolean, java.lang (e.g. Object), singleton object scala.Predef (assert, require)
- import `week._` is like wildcard import
- import `week.{a, b}` - selective import

#### Traits
- Scala is single inheritence language like Java but at certain times we need to break prototype chain and need definitions from several classes
- Traits are very similar to mixins in javascripts

    trait movable {
      def left: Int
      def top: Int
      def move(xOffset: Int, yOffset: Int) = {
        left += xOffset
        top += yOffset
      }
    }

    class square extends shape with moveable {
      // More code here
    }

- traits can not have state (means traits can not have values) similar to mixins
- Null is subtype for every ref type like we can assign null to string but not to an int. e.g.

    val x:Int = null // Error
    val s:String = null // Good

#### What is the type of if (true) 1 else false ?
Answer: Anyval. The simplest way to test such things is enter this string into worksheet or console and see the result.

#### Hierarchy

                  Any
        AnyVal---------------AnyRef
   Double, Float, Unit     Object (Iterable <- Seq <- List), String
                                 Null
                      Nothing
                      

### 3.3 - Polymorphism
----------------------

- Cons-list: Contain head and tail which points to rest of the list.
- Type is passed in square parameters e.g.

    trait List[T] {
      def isEmpty: Boolean
      def head: T
      def tail: List[T]  
    }

    // Adding val before arguments in class means it becomes member functions with same name
    // So there is no need of explicit constructor 
    class Cons[T](val head: Int, val tail: List[T]) extends List[T] {
      def isEmpty: Boolean = false
    }

    class Nil[T] extends List[T] {
      def isEmpty = true
      def head: Nothing = throw new NoSuchElementException("Nil.head") 
      def tail: Nothing = throw new NoSuchElementException("Nil.tail")
    }


- Type paramater can also be passed to functions. e.g.

    def singleton[T](elem: T) = cons(elem, new Nil[T])
    singleton[Int](1)
    singleton[Boolean](false)

- But type parameter in functions in redundant and compiler can deduce the type automatically so we can also replace calls like this

    singleton(1)
    singleton(false)

- Type Erasure: Type parameter do not affect evaluation of method at runtime    

#### Polymorphism

Two types of polymorphism
- Generic: Instances of function / class are created by type parametrization
- Subtyping: Instance of subclass can be passed to a method which expects base class

### 4.1 - Functions as Objects
------------------------------

- Every function A => B can be considered as 

    trait Function1[A, B] {
      def apply(x: A): B
    }

- So functions are objects with apply methods similar to javascript.
- Similarly we can also write different traits for method having more parameters.
- Anonymous functioons such as `x => x*x` is resolved as

    class Anon extends Function1[A, B] {
      def apply[T](x: T): T = x * x
      new Anon
    }

    // Or
    new Function1[A, B] {
      def apply[T](x: T): T = x * x
    }

### 4.2 Objects everywhere
--------------------------

Define a comparison operator in abstract Boolean class (assume false < true)

    abstract class Boolean {
      ...

      def ifThenElse[T](t :=> T, e :=> T): T
      
      def < (x: Boolean): Boolean = ifThenElse(false, x)

      // false < true : t
      // false < false: e
      // true < false: e
      // true < true: e
    }


### 4.3 - Subtyping and Generics
-------------------------------

- Suppose you want to define a method assertAllPos which should take an IntSet and return the same if all positive otherwise throw an exception. 
Decude the type of such a method.

    def assertAllPos(i: IntSet): IntSet

- This is fine for most of the cases but if we want to be more specific, we can write something like this

    def assertAllPos[S <: IntSet](i: IntSet): S
    // Here S is a variable/dynamic type which has an upperbound of IntSet which means this method can return IntSet, Nothing, Null etc.

- Similarly, we have other operators as well like [S >: Nothing] which means Nothing, AnyRef, IntSet, Any
- Or both, `[S <: InSet >: Nothing]`

- In Scala, Arrays are not co-variant while in java arrays are covariant.

#### Question: Can't we write the defnition of '+' in Int class with Generic type like `def +[T <: Double <: Int](that: T): T` ?

### 4.5 - Decomposition
-----------------------

- Define expression class, Number class and sum class
- If we want to add product class and String class, we may need to define lots of methods
- So break eval method into each class which solves this problem
- Scala also has isInstanceOf and asInstanceOf methods just like java has instanceOf operator and typecasting
- Suppose, we need to call another method reduce which simplifies an expression into smaller expression, but this method should be called only on expressions
- e.g. `a * b + a * c = a * (b + c)`
- For this we may need to define simplify method in each class heirarchy which we don't want
- OO decomposition is good in some cases but not in all cases.

### 4.6 - Pattern matching
--------------------------

- Problem we are trying to solve: Access object in a convenient way from a class heirarcy
- e.g. Expression -> Sum, Product, Number, Str
- Now, inside an eval method we check if argument is number then do this else do that.
- In decomposition, we moved the eval method inside each class but there can be certain times when we may have to check the instanceOf and then call the method but there can be certain methods specific to a class and we don't want to implement them in others.


- Pattern Matching is generalization of switch from C/Java (fromo numbers, strings) to Class heirarchies. For example

    def eval(e: Expr): Int = e match {
      case Number(n) => n
      case Sum(e1, e2) => eval(e1) + eval(e2)
      case Prod(e1, e2) => eval(e1) * eval(e2) 
    }

- We can also define this method in the base class itself. Then `e match` will be replaced by `this match`

### 4.7  - Lists
----------------

- Lists are immutable
- Lists are recursive
- Can be constructed with :: operator .e.g A :: B :: C
- Operators ending with : associate from right
- This means :: is a right operand unlike other operators (prepend operation)
- :: seen as method call of right hand operand e.g.
- val numList = 1 :: 2 :: 3 :: 4

#### Pattern Matching in Lists

    x :: xs -> Matches a list with x as the head element and xs shows any number of elements including Nil
    x :: y :: xs -> Matches a list with x and then y and then arbitary number of elements
    List() -> Empty list

#### Insertion Sort in Lists

    def iSort(l: List[Int]): List[Int] = l match {
      case List() => List()
      case List(h :: t) => insert(h, iSort(t))
    }

    def insert(x: Int, l: List[Int]): List[Int] = l match {
      case List() => List(x)
      case List(h :: t) => 
        if (x <= h) x :: l
        else insert(h, x :: t) // This should be replaced with x :: insert(h, t) Always remember to call recursion on smaller set
    }
