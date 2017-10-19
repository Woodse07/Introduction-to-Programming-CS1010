#### Write a program which takes keeps taking in numbers from a user on the command line until the user enters "quit" or "exit".<br /> The user should be allowed to enter only one number each time and the system should compute the average and variance of all numbers entered so far each time.<br />  To do this WITHOUT storing all the numbers we must use formulas which allow to compute the average and variance based only on the previous values (of the average and variance) together with the latest number entered.<br />
AVERAGEN = AVERAGEN-1 + (NUMBERN - AVERAGEN-1) / N <br />
VARIANCEN = ((VARIANCEN-1 * (N-1)) + (NUMBERN - AVERAGEN-1) * (NUMBERN - AVERAGEN)) / N <br />
Example interaction:<br />

This program computes the average and variance of all numbers entered.<br />

Enter a number (or type 'exit'): 1<br />

So far the average is 1.0 and the variance is 0.0<br />

Enter another number (or type 'exit'): 2<br />

So far the average is 1.5 and the variance is 0.25<br />

Enter another number (or type 'exit'): 3<br />

So far the average is 2.0 and the variance is 0.6666666666666666<br />

Enter another number (or type 'exit'): 10<br />

So far the average is 4.0 and the variance is 12.5<br />

Enter another number (or type 'exit'): 5<br />

So far the average is 4.2 and the variance is 10.16<br />

Enter another number (or type 'exit'): exit<br />

Goodbye.<br />
