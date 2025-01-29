class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i = 1; i < n; i++) {
            parent[i] = i;
        }
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            int p1 = findParent(u,parent);
            int p2 = findParent(v,parent);
            if(p1==p2){
                return edge;
            }
            union(p1,p2,parent,rank);
        }
        return new int[]{};
    }
    private int findParent(int x,int[] parent){
        if(x!=parent[x]){
            parent[x] = findParent(parent[x],parent);
        }
        return parent[x];
    }
    private void union(int p1,int p2,int[] parent,int[] rank){
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p2]>rank[p1]){
            parent[p1] = p2;
        }
        else{
            parent[p2] = p1;
            rank[p1]++;
        }
    }
}