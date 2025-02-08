<h2><a href="https://www.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1">Convert array into Zig-Zag fashion</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">Given an array&nbsp;<strong>arr</strong> of <strong>distinct </strong>elements, the task is to rearrange the elements of the array in a <strong>zig-zag fashion</strong> so that the converted array should be in the below form:&nbsp;</span></p>
<blockquote>
<p><span style="font-size: 14pt;">arr[0] &lt; arr[1] &nbsp;&gt; arr[2] &lt; arr[3] &gt; arr[4] &lt; . . . . arr[n-2] &lt; arr[n-1] &gt; arr[n].&nbsp;</span></p>
</blockquote>
<p><span style="font-size: 14pt;">Note: Modify the given arr[] only,<strong> </strong>If your transformation is correct, the output will be "<strong>true"</strong> else the output will be <strong>"false"</strong>.&nbsp;</span></p>
<p><span style="font-size: 14pt;"><strong>Examples</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [4, 3, 7, 8, 6, 2, 1]
<strong>Output: </strong>true
<strong>Explanation:</strong>  After modification the array will look like 3 &lt; 7 &gt; 4 &lt; 8 &gt; 2 &lt; 6 &gt; 1, the checker in the driver code will produce 1.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [4, 7, 3, 8, 2]
<strong>Output:</strong> true
<strong>Explanation: </strong>After<strong> </strong>modification the array will look like 4 &lt; 7 &gt; 3 &lt; 8 &gt; 2 hence output will be 1.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [2, 8, 1, 7, 5, 9]
<strong>Output:</strong> true</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 &lt;= arr.size() &lt;= 10<sup>6</sup><br>0 &lt;= arr<sub>i</sub> &lt;= 10<sup>8</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Paytm</code>&nbsp;<code>Amazon</code>&nbsp;<code>Adobe</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;