## Bitwise Operators:

&, |, ^, ~, <<, >>

* <b>The left shift (<<) and right shift (>>) operators should not be used for negative numbers.</b><br>
   If any of the operands is a negative number, it results in undefined behavior.
   
* <b>XOR is the most useful operator</b><br>
   A number XORed with itself, would give the result 0.
   
* <b>The left shift and right shift operators are equivalent to multiplication and division by 2 respectively</b><br>
   It only works if the numbers are positive.
  
* <b>The & operator can be used to quickly check if the number is even or odd</b><br>
   (x & 1) would be non zero only if x is odd, otherwise the value would be 0.
   
* <b>~ operator should be used carefully.</b><br>
   Result of ~ on a small number can be a large number if the result is stored in an unsigned variable.
   And the result may be a negative number if the result is stored in a signed variable.

* <b>Setting a bit in a number</b><br>
  Can be done using an OR (|) operator.
  E.g If you want to set the nth bit in a number,
  first shift 1 to n position via left shift (1<<n) and then use OR to set the bit.
  
  num |= (1<<n); //Sets the nth bit
  
* <b>Clear a bit in a number</b><br>
  Can be done using the AND (&) operator.
  E.g If you want to unset the nth bit in a number,
  first shift 1 to n position via left shift (1<<n)
  then negate it so that it becomes zero (~(1<<n)) and then use AND to unset the bit 
  in the given number.
  
  num &= (~(1<<n)); //Unsets the nth bit
  
* <b>Toggling a bit at nth position</b><br>
  Can be done using an XOR (^) operator.
  E.g If you want to toggle the nth bit in a number,
  first shift 1 to n position via left shift (1<<n) and then use XOR to toggle the bit.
    
  num ~= (1<<n); //Toggles the nth bit
  
* <b>Checking if bit at nth position is set or unset</b><br>
  Use of AND (&) operator.
  Left shift 1 to nth position and then & with the given number
  
  return (num & (1<<pos))
  
* <b>Inverting every bit of a number. Also called as 1's complement</b><br>
  ~num
  

* <b>2's complement of a number</b><br>
  1's complement + 1
  
  (~num+1) or -num
  
* <b>Stripping off the lowest set bit</b><br>
  X = X & (X-1)
  
* <b>Getting lowest set bit of a number</b><br>
  X & (-X)
    




#### References:<br>
<a hef="https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/">Geeks For Geeks</a> 
<a hef="https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/">Geeks For Geeks</a> 
