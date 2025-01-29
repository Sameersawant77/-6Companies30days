class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Set<Integer>> adjList = new ArrayList<>();
        int[] res = null;
        for(int i=0;i<1001;i++){
            adjList.add(new HashSet<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            if(dfs(u,v,0,adjList)){
                res = edge;
            }
            else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return res;
    }
    private boolean dfs(int u,int v,int pre,List<Set<Integer>> adjList){
        if(u==v) return true;
        for(int w:adjList.get(u)){
            if(w==pre) continue;
            boolean ret = dfs(w,v,u,adjList);
            if(ret) return true;
        }
        return false;
    }
}