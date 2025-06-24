<h2><a href="https://www.geeksforgeeks.org/problems/count-substring/1">Count Substring</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" data-cur="cursor"><p data-cur="cursor"><span style="font-size:18px" data-cur="cursor">Given string s consisting only a,b,c. return the number of substrings&nbsp;containing&nbsp;<strong data-cur="cursor">at least</strong>&nbsp;one occurrence of all these characters&nbsp;<em>a</em>,&nbsp;<em>b,</em>&nbsp;and&nbsp;<em>c</em>.</span></p>

<p data-cur="cursor"><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre data-cur="cursor"><span style="font-size:18px" data-cur="cursor"><strong data-cur="cursor">Input:</strong>
abcabc
<strong data-cur="cursor">Output:</strong>
10
<strong data-cur="cursor">Explanation:</strong>
The required substrings <em> are "</em>abc<em data-cur="cursor">", "</em>abca<em data-cur="cursor">", "</em>abcab<em data-cur="cursor">", "</em>abcabc<em data-cur="cursor">",
"</em>bca<em data-cur="cursor">", "</em>bcab<em data-cur="cursor">", "</em>bcabc<em data-cur="cursor">", "</em>cab<em>", "</em>cabc<em data-cur="cursor">" </em>and<em data-cur="cursor"> "</em>abc<em data-cur="cursor">".</em></span>

</pre>

<p data-cur="cursor"><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre data-cur="cursor"><span style="font-size:18px"><strong>Input:</strong>
</span><span style="font-size:18px" data-cur="cursor">aaacb
<strong>Output:</strong>
3</span></pre>

<p data-cur="cursor"><strong><span style="font-size:18px">Your Task:</span></strong><br>
<span style="font-size:18px" data-cur="cursor">You don't have to read input or print anything. Your task is to complete the function&nbsp;<strong>countSubstring()&nbsp;</strong>which takes the string s&nbsp;and returns the count of substring having at least a,b,c.</span></p>

<p data-cur="cursor"><span style="font-size:18px" data-cur="cursor"><strong>Expected Time Complexity: </strong>O(n)<br>
<strong data-cur="cursor">Expected Space Complexity:&nbsp;</strong>O(1)</span></p>

<p data-cur="cursor"><strong><span style="font-size:18px">Constraint:</span></strong><br>
<span style="font-size:18px" data-cur="cursor">3&lt;=s.length&lt;=5 x 10<sup data-cur="cursor">4&nbsp;&nbsp;</sup></span><br>
<span style="font-size:18px" data-cur="cursor">S only contains a,b,c.</span></p>
</div>