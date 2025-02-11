class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)  return -1;

        DisjointSet ds = new DisjointSet(n);
        int com = n;
        for(int con[]: connections) {
            int u = con[0];
            int v = con[1];
            if(ds.union(u,v)) {
                com--;
            }
        }
        return com-1;
    }
}

class DisjointSet {
    int[] rank, parent;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int findUPar(int node) {
        if (parent[node] != node) {
            parent[node] = findUPar(parent[node]); // Path compression
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu==pv)  return false;

        if(rank[pu]<rank[pv]) {
            parent[pu] = pv;
        }
        else if(rank[pu]>rank[pv]) {
            parent[pv] = pu;
        }
        else {
            parent[pv]=pu;
            rank[pu]++;
        }
        return true;
    }

}