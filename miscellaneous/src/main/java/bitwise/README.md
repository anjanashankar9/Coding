## Bitwise Operators:

&, |, ^, ~, <<, >>

* <b>The left shift (<<) and right shift (>>) operators should not be used for negative numbers.</b>
   If any of the operands is a negative number, it results in undefined behavior.
   
* <b>XOR is the most useful operator</b>
   A number XORed with itself, would give the result 0.
   
* <b>The left shift and right shift operators are equivalent to multiplication and division by 2 respectively</b>
   It only works if the numbers are positive.
  
* <b>The & operator can be used to quickly check if the number is even or odd</b>
   (x & 1) would be non zero only if x is odd, otherwise the value would be 0.
   
* <b>~ operator should be used carefully.</b>
   Result of ~ on a small number can be a large number if the result is stored in an unsigned variable.
   And the result may be a negative number if the result is stored in a signed variable.

* <b>Setting a bit in a number</b>
  Can be done using an OR (|) operator.
  E.g If you want to set the nth bit in a number,
  first shift 1 to n position via left shift (1<<n) and then use OR to set the bit.
  
  num |= (1<<n); //Sets the nth bit
  
* <b>Clear a bit in a number</b>




#### References:<br>
<a hef="https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/">Geeks For Geeks</a> 
<a hef="https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/">Geeks For Geeks</a> 
