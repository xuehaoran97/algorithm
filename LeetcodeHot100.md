# Leetcode Hot 100

### 1.[221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/)

思路来源： 官方题解 

暴力法

动态规划： dp表示i,j位置的最大边长

```math
dp[i][j] = math.min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
```



```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return maxSide; 
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j ==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                    }
                }
                maxSide = Math.max(maxSide,dp[i][j]);
                

            }
        }
        return maxSide * maxSide;

    }
}
```



### 2.[85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)

解法1: 官方题解

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                if(matrix[i][j] == '1'){ //第一次写的时候落下了
                    left[i][j] = (j == 0? 0: left[i][j-1])+1;
                }
                
            }
        }

        int retArea = 0;
        for(int i = 0; i < row ;i++){
            for(int j = 0 ; j < col; j++){
                if(matrix[i][j] == '0'){  //这个地方总喜欢忘记加''
                    continue;
                }
                int width = left[i][j];
                int area = width * 1;
                for(int k = 1; i-k>=0;k++){
                    width = Math.min(width,left[i-k][j]);
                    area = Math.max(area,width*(k+1));
                }
                retArea = Math.max(area,retArea);
            }
            

        }
        return retArea;
    }
}
```





解法2 :



单调栈 从左到右， 从右到左（官方题解） 左边界是第一个比它小的，最小位-1，右边界是第一个比它大的，最大n+1

![1645254390599](C:\Users\XUEHAORAN\AppData\Roaming\Typora\typora-user-images\1645254390599.png)

java中推荐的栈的写法

#### 关联题目[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right,len); //这个容易忘，如果一直递增的话，那么右边界就是n,如果不是程序会更新
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<len;i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                right[stack.peek()] = i; 
                stack.pop();
            }
            left[i] = (stack.isEmpty()?-1:stack.peek());
            stack.push(i);
        }
        
        int res = 0;
  
        for(int i =0; i < len;i++){
            res = Math.max(res,(right[i] - left[i]-1)*heights[i]);
        }
        return res;

    }
}
```

```java
因为高度可以为0，所以不能直接用一次循环搞定，必须从左往右再从右忘左

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                if(matrix[i][j] == '1'){ //第一次写的时候落下了
                    left[i][j] = (j == 0? 0: left[i][j-1])+1;
                }
                
            }
        }

        int retArea = 0;
        for(int j = 0; j < col;j++){
            int[] l = new int[row];
            int[] r = new int[row];
            //Arrays.fill(r,row);
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < row; i++){
                while(!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]){
                    //r[i] = stack.peek();
                    stack.pop();
                }
                l[i] = (stack.isEmpty()?-1:stack.peek());
                stack.push(i);
            }
            stack.clear();

            for(int i = row-1;i>=0;i--){
                 while(!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]){
                
                    stack.pop();
                }
                r[i] = (stack.isEmpty()?row:stack.peek());
                stack.push(i);
            }

             for(int i = 0; i < row; i++){
                 retArea = Math.max(retArea,(r[i]-l[i]-1)*left[i][j]);
             }

             

        }
        return retArea;

    }
}
```

### [207. 课程表](https://leetcode-cn.com/problems/course-schedule/)

解法1 ： 深度优先遍历（官方）

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] cp:prerequisites){
            adj.get(cp[1]).add(cp[0]);
        }

        for(int i = 0;i<numCourses;i++){
            if(!dfs(adj,flag,i)){
                return false;
            }
        }
        return true;       
    }

    public boolean dfs(List<List<Integer>> adj,int[] flag, int i){
        if(flag[i] == 1){
            return false;
        }
        if(flag[i] == -1){
            return true;
        }
        flag[i] = 1;
        for(int j : adj.get(i)){
            if(!dfs(adj,flag,j)){
                return false;
            }
        }
        flag[i] = -1;
        return true;
    }
}

```



解法2 ；拓扑排序（官方）

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<numCourses;i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int cur: adj.get(pre)){
                if(--indegrees[cur] == 0){
                    queue.add(cur);
                }
            }
            
        }
        return numCourses == 0;

    }
}
```



### [139. 单词拆分](https://leetcode-cn.com/problems/word-break/)

解法1：动态规划， dp[i]表示 0- i-1的字符串是否已经满足了

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0;i<n;i++){
            // for(int j = i+1;j<n+1;j++){
            //     if(dp[i] = true && wordDict.contains(s.substring(i,j))){
            //             dp[j] = true;
            //             break;
                    
            //     }
            // }
            if (!dp[i]) {
                    continue;
                }
                for (String word : wordDict) {
                    if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
        }
        return dp[n];


    }
}
```









### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

解法1：动态规划

![1645258622219](C:\Users\XUEHAORAN\AppData\Roaming\Typora\typora-user-images\1645258622219.png)

```java
class Solution {
   public int coinChange(int[] coins, int amount) {
       int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length ; j++) {
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
                
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
   }

   

}
```



### [156. 上下翻转二叉树](https://leetcode-cn.com/problems/binary-tree-upside-down/)

解法1：dfs 遍历到左子树，直到不能遍历为止

```java
class Solution {
    TreeNode head = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root,null);
        return head;
    }

    public void dfs(TreeNode node, TreeNode father){
        if(node == null){
            return;
        }
        dfs(node.left,node);
        if(head == null){
            head = node;
        }

        if(father!=null){
            node.left = father.right;
            father.right = null;
            node.right = father;
            father.left = null;
        }
    }

}
```

### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

解法：先循环一遍，统计每个数字出现的次数，使用最小堆，求出结果

java中的堆，就是用优先队列实现的

```java
public class PriorityQueuePrac {
    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] m, int[] n) {
                        return m[1] - n[1];
                    }
                }      
        );
    }
}
```

这个默认是最小堆，若要使用最大堆 改成n[1] - m[1]即可

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurrences = new HashMap<>();
        for(int num:nums){
            occurrences.put(num,occurrences.getOrDefault(num,0)+1);

        }

         PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            int cnt = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < cnt){
                    queue.poll();
                    queue.offer(new int[]{num,cnt});
                }
            }else{
                    queue.offer(new int[]{num, cnt});
                }
        }
        int[] res = new int[k];
        for(int i = 0; i<k;i++){
            res[i] = queue.poll()[0];
        }
        return res;
    }
```

