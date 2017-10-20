#### Write a program which takes a date in day/month/year format (e.g. 25/11/2015) and, if the date is valid, then it presents the date in, for example, “Wednesday, 25th November 2015” format.<br />
 
You must write and make use of at least the following functions:<br/>
numberEnding() which takes a day number returns “th”, “st”, “nd” or “rd”.<br/>
monthName() which takes a month number (1-12) and return “January”, or “February”, …<br/>
dayOfTheWeek() which takes a day, month and year and returns “Monday”, or “Tuesday”, …<br/>
The day of the week function should use the Gaussian algorithm…<br/>
w = (day + floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + floor(y/4) + floor(c/4) - 2c) mod 7<br/>
where<br/>
 Y: year-1 for January or February,<br/>
  year for the rest of the year<br/>
 y: last 2 digits of Y<br/>
 c: first 2 digits of Y<br/>
 w: day of week (0=Sunday,..6=Saturday)<br/>
  mod 7 needs to return a positive number (even if the<br/>
  passed value is negative.<br/>
NOTE:  You may incorporate functions from code provided to you within this course but must give appropriate credit.<br/>
