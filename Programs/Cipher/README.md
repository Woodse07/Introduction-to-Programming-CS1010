#### Write a Java program which converts (user entered) plain text to cipher text using a substitution cipher (in which plain text letters are randomly assigned to cipher text letters).<br/>  Note that a Substitution Cipher replaces plaintext with cipher-text. The most common substitution ciphers replace single characters of plaintext with predefined single characters of cipher-text<br/> (e.g. the plain-text character `a' might be replaced by cipher text character 'q', 'b' might be replaced by 'x', 'c' by 'k' and so on).<br/>  Each plain-text character should be replaced by a different cipher-text character.<br/>
As part of your solution you must write and use at least the following functions/methods:<br/>
(i)    createCipher() which determines and returns the mapping from plain text to cipher text.  Each plain text character ('a' .. 'z', ' ') must be randomly assigned a cipher-text character;<br/>
(ii)   an encrypt() method which takes a plain text phrase (as an array of characters) & the cipher and returns an encrypted version of the phrase according to the substitution cipher;<br/>
(iii)  crypt() which takes an encrypted phrase (as an array of characters) & the cipher mapping and returns a plain text version of the phrase according to the substitution cipher<br/>
Hints:<br/>
A 27 element 1-D array (26 letters and the space character) can be used for the mapping where each element is the cipher-text character corresponding to a particular letter.<br/>
Given a String called myString you can create an array of characters as follows:<br/>
o   char[] characterArray = myString.toCharArray();<br/>
To convert back to a String:<br/>
o  String anotherString = new String( characterArray );<br/>
To convert a String to lowercase:<br/>
o   String lowercaseString = myString.toLowerCase();<br/>
