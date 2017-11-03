#### Chuck-A-Luck is a dice game where 3 six sided dice tumble in a spinning cage and players can place bets with a House dealer on the outcome of the 3 dice when the cage stops spinning. It originated in British Pubs many years ago and started without spinning cages. Instead, players used a horn-shaped chute made of leather or metal to "chuck" the 3 dice across a table and then take their "luck" on how they landed. Today, Chuck-A-Luck is still popular at many first-class casinos around the world [see Wikepeda page: Chuck-a-luck]. The following table shows the type of bets a player can make with the House on the outcome of the 3 dice and the payout (odds) associated with the bet if the outcome of the 3 dice satisfies the bet's condition:</br>
#### Type of Bet:   	Condition:	Payout (Odds):</br>
 	 	 
#### Triple	All 3 dice show same number (but not 1s or 6s).	30:1</br>
#### Field	Total of 3 dice < 8 or total is > 12.	1:1</br>
#### High	Total of 3 dice > 10 (but not a Triple).	1:1</br>
#### Low	Total of 3 dice < 11 (but not a Triple).	1:1</br>
Triple: All three dice must show the same number (e.g. all 3s). However, the House wins if the Triple is all 1s or all 6s. A Tripe is paid at thirty to one (30:1). </br>
Field: The total of the numbers shown on the 3 dice must sum to a number less than 8 or greater then 12. A Field is paid at one to one (1:1).</br>
High: The total of the numbers shown on the 3 dice must sum to a number greater than 10. The payoff is one to one (1:1) unless there is a high Triple, i.e., three 4s (12), three 5s (15), or three 6s (18), in which case the High bet loses. There are 108 possible combinations of the 3 dice that add up to over 10, and only 3 of them are Triples.</br>
Low: The total of the numbers shown on the 3 dice must sum to a number less than 11. The payoff is one to one (1:1) unless there is a low Triple, i.e., three 1s (3), three 2s (6), or three 3s (9), in which case the Low bet loses. There are 108 possible combinations of the 3 dice that add up to under 11, and only 3 of them are Triples.</br>
A player arrives to a Chuck-A-Luck dice game with a given sum of money in their wallet/purse and can place bets (one at a time) on the outcome of the chucking of the 3 dice. A player's bet is a choice of one of the Chuck-A-Luck types of bets and a proportion money which must be taken from their wallet/purse prior to the throwing of the 3 dice by the House's dealer. The result of a players bet is resolved immediately after the dice are thrown; if the outcome of the throw of the three dice satisfies the player's bet then the player's remaining sum of money in their wallet/purse is incremented by their winnings plus the sum of money they place on the bet. The player can keep playing until either they run of money in their wallet/purse or decided to stop playing the Chuck a Luck dice game.</br>
Write a Java program which will allow a user to repeatedly play the Chuck a Luck game until they either they run of money in their wallet or purse or decided to stop playing (while they are ahead). Your program MUST make use of the Dice and Wallet data types (Java classes) defined below.</br>
Your program requires:</br>
1. 
* mainline (parts of the mainline can be implemented in new methods that you can create) which does the following:</br>
* Asks the user for the amount of cash he/she has and creates a Wallet object and puts this cash into it.</br>
* Allows the user to play continuously placing any of the four bet types until the user either enters quit or the cash in the wallet is 0.</br>
* For each bet placed by the user, the resolveBet method is called.</br>
* Once the game is over, provides an overall summary by comparing the cash in the wallet with what the user initially started with.</br>
 
2. 
* ResolveBet method which takes the bet type (String) and the Wallet object and does not return anything:</br>
* Presents the amount of cash in the wallet and ask the user how much he/she would like to bet</br>
* Ensures the bet amount is not greater than the cash in the wallet</br>
* Checks to see if the bet is correct by creating three Dice objects and rolling them and comparing roll output with the bet type.</br>
* outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses. </br>
