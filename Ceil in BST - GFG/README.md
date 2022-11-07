# Ceil in BST
## Medium
<div class="problems_problem_content__Xm_eO" style="user-select: auto;"><p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Given a&nbsp;BST and a number <strong style="user-select: auto;">X</strong>, find <strong style="user-select: auto;">Ceil of X</strong>.</span><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Note:</strong> Ceil(X) is a number that is either equal to X or is immediately greater than X.</span></p>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></span></p>

<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input:
</strong>      5
&nbsp;   /   \
&nbsp;  1     7
&nbsp;   \
&nbsp;    2 
&nbsp;     \
&nbsp;      3
X = 3
<strong style="user-select: auto;">Output: </strong>3<strong style="user-select: auto;">
Explanation: </strong>We find 3 in BST, so ceil
of 3 is 3.</span></pre>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></span></p>

<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input:
</strong>     10
&nbsp;   /  \
&nbsp;  5    11
&nbsp; / \ 
&nbsp;4   7
&nbsp;     \
&nbsp;      8
X = 6
<strong style="user-select: auto;">Output: </strong>7<strong style="user-select: auto;">
Explanation: </strong>We find 7 in BST, so ceil
of 6 is 7.</span></pre>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Your task:</strong><br style="user-select: auto;">
You don't need to read input or print anything. Just complete the function <strong style="user-select: auto;">findCeil</strong>() to implement ceil in BST which returns the ceil of&nbsp;<strong style="user-select: auto;">X&nbsp;</strong>in the given&nbsp;<strong style="user-select: auto;">BST.</strong></span></p>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Expected Time Complexity:&nbsp;</strong>O(Height of the BST)<br style="user-select: auto;">
<strong style="user-select: auto;">Expected Auxiliary Space:&nbsp;</strong>O(Height of the BST).</span></p>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong><br style="user-select: auto;">
1 &lt;= Number of nodes &lt;= 10<sup style="user-select: auto;">5</sup><br style="user-select: auto;">
1 &lt;= Value of nodes&lt;= 10<sup style="user-select: auto;">5</sup></span></p>
</div>