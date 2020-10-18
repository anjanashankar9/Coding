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
    
* <b>Clear all bits from LSB to ith bit</b><br>
  Mask should have LSB to ith bit as 0.
  To get the mask, left shift 1 by i+1. 
  Subtract 1 from it. This will set all bits from 0 to i-1 as 1, and the remaining as 0.
  Negate this. This will be your mask.
  And x with mask.
  
  mask = ~( ( 1 << (i+1) - 1);
  x &= mask;
  
* <b>Clear all bits from MSB to ith bit</b><br>
    Mask should have MSB to ith bit as 0.
    To get the mask, left shift 1 by i. 
    Subtract 1 from it. This will set all bits from 0 to i-1 as 1, and the remaining as 0.
    And x with mask.
    
    mask = ( 1 << (i+1) - 1;
    x &= mask;

* <b>Divide by 2</b><br>
  x >>= 1;
  
* <b>Multiply by 2</b><br>
  x <<= 1;

* <b>Upper case english alphabets to lower case</b><br>
  ch |= ' ';
  
  Logic
  ```
  A -> 01000001          a -> 01100001
  B -> 01000010          b -> 01100010
  C -> 01000011          c -> 01100011
    .                               .
    .                               .
  Z -> 01011010          z -> 01111010
  ```
  
  As seen above if we set the 5th bit we will be converting the character to lower case.
  We have to prepare a mask having 5th bit set to 1 and other 0. (0010 0000)
  This mask is bit representation of space character(' ')
  
* <b>Lower case english alphabets to upper case</b><br>
  ch &= '_'
  
  Logic
    ```
    A -> 01000001          a -> 01100001
    B -> 01000010          b -> 01100010
    C -> 01000011          c -> 01100011
      .                               .
      .                               .
    Z -> 01011010          z -> 01111010
    ```
    
    As seen above if we unset the 5th bit we will be converting the character to lower case.
    We have to prepare a mask having 5th bit set to 0 and other 1. (1101 1111)
    This mask is bit representation of underscore character('_')
    
* <b>Count set bits in an integer</b><br>
  ```
  private int countSetBits(int x) 
  {
      int count = 0; 
      while (x) 
      { 
          x &= (x-1); 
          count++; 
      } 
      return count;
  }
  ```    

* <b>Find log base 2 of 32 bit integer</b><br>
   ```
   private int logBase2(int x) 
   { 
       int res = 0; 
       while (x >>= 1) 
           res++; 
       return res; 
   } 
    ```
    Logic: We right shift x repeatedly until it becomes 0, meanwhile we keep count on the shift operation. This count value is log2(x)
    
* <b>Checking if given 32 bit integer is power of 2</b><br>
  ```
  private int isPowerOf2(int X) {
      return (x && !(x & x-1)); 
  }
   ```
   Logic:
   All powers of 2 have a single bit set. If we minus 1 from this, all the bits 
   from LSB to set bit get toggled.
    Now if we AND x with x-1, the result is 0.
    

#### References

http://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/<br>
http://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/<br>
https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
