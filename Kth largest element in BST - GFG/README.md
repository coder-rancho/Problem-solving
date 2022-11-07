# Kth largest element in BST
## Easy
<div class="problems_problem_content__Xm_eO" style="user-select: auto;"><p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></span></p>

<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input:
&nbsp;     4</strong>
&nbsp;   /   \
<strong style="user-select: auto;">   </strong>2     9
k = 2<strong style="user-select: auto;"> 
Output: </strong>4
</span></pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></span></p>

<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input:
</strong>&nbsp; &nbsp; &nbsp; &nbsp;9
&nbsp; &nbsp; &nbsp;&nbsp;  \&nbsp;
&nbsp;  &nbsp;&nbsp;  &nbsp;  <strong style="user-select: auto;">10</strong><strong style="user-select: auto;">
</strong>K = 1<strong style="user-select: auto;">
Output: </strong>10</span>
</pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Your Task:</strong><br style="user-select: auto;">
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong style="user-select: auto;">kthLargest()</strong>&nbsp;which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Expected Time Complexity:</strong>&nbsp;O(N).<br style="user-select: auto;">
<strong style="user-select: auto;">Expected Auxiliary Space:</strong>&nbsp;O(H) where H is max recursion stack of height h at a given time.</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong><br style="user-select: auto;">
1 &lt;= N &lt;= 1000<br style="user-select: auto;">
1 &lt;= K &lt;= N</span></p>
</div>