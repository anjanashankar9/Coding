##Bitwise Operators:

&, |, ^, ~, <<, >>

* *The left shift (<<) and right shift (>>) operators should not be used for negative numbers.*
   If any of the operands is a negative number, it results in undefined behavior.
   
* *XOR is the most useful operator*
   A number XORed with itself, would give the result 0.
   
* *The left shift and right shift operators are equivalent to multiplication and division by 2 respectively*
   It only works if the numbers are positive.
  
* *The & operator can be used to quickly check if the number is even or odd*
   (x & 1) would be non zero only if x is odd, otherwise the value would be 0.
   
* *~ operator should be used carefully.*
   Result of ~ on a small number can be a large number if the result is stored in an unsigned variable.
   And the result may be a negative number if the result is stored in a signed variable.

* *Setting a bit in a number*
  Can be done using an OR (|) operator.
  E.g If you want to set the nth bit in a number,
  first shift 1 to n position via left shift (1<<n) and then use OR to set the bit.
  
  num |= (1<<n); //Sets the nth bit
  
* *Clear a bit in a number*




#### References:<br>
<a hef="https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/">Geeks For Geeks</a> 
<a hef="https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/">Geeks For Geeks</a> 