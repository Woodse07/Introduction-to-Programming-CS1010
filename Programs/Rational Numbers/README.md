****Rational Numbers Data Type and Test Client.

In mathematics, a rational number is any number that can be expressed as the quotient or fraction a/b of two integers: a (the numerator) and b (the denominator), with b not equal to zero [see http://en.wikipedia.org/wiki/Rational_number]. Since b (the denominator) may be equal to 1, every integer is also a rational number.  

Write a Java data type (Java class) Rational whose values (Java object) represent rational numbers. Your data type must store the numerator and denominator of the rational number and must provide the following operations (Java instance methods):</br>
(1) constructor operation which takes two integers (a numerator and a denominator), and which constructs a rational number value with the given numerator and denominator.</br>
(2) constructor operation which takes an integer (a numerator) and which constructs a rational number value representing the given integer.  </br>
(3) add operation which takes a rational number value and which returns a rational  number value which is the sum of this rational number and the given rational  number.</br>
(4) subtract operation which takes a rational number value and which returns a rational number value which is this rational number less the given rational number.</br>
(5) multiply operation which takes a rational number value and which returns a  rational number value which is the product of this rational number and the given rational number.</br>
(6) divide operation which takes a rational number value and which returns a rational number value which is the quotient of this rational number by the given rational number.</br>
(7) equals operation which determines whether this rational number value is equal to a given rational number value, for example, 1/3 equals 2/6, however 2/3 does not  equal 5/10.</br>
(8) isLessThan operation which determines whether this rational number value is less than a given rational number value, for example, 50/100 is less than 2/3, however 1/2 is not less than 3/9.</br>
(9) simplify operation which returns a rational number value which is this rational number value reduced to its lowest terms and expressed with a positive denominator, for example, 6/8 simplifies to 3/4 and 50/-100 simplifies to -1/2 and -6/-9 simplifies to 2/3. [Hint: you will need to use and write a greatest common divisor (GCD) function.]</br>
(10) toString operation which returns a String value representation of this rational number value.</br>
Note: rational number value refers to a Rational object. For the methods add, subtract, multiply and divide, a new relational object (with the correct numerator and denominator) needs to be returned. The simplify method updates the values in the existing object and returns it.
Write a Java program (a separate Java Class) which will test your rational number data type, by allowing a user to enter fraction values (two sets of numerator and denominator values) which will be added, subtracted, multiplied, divided, compared (equals and less than) and simplified by your program. Your program should print the results of all these computations to the standard output once the user provides the  fraction values. </br>
