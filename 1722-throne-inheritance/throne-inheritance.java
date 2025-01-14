class ThroneInheritance {

    String king;
    Map<String,List<String>> curOrder;
    Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        curOrder = new HashMap<>();
        dead = new HashSet<>();
        curOrder.put(king,new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        curOrder.computeIfAbsent(parentName,x->new ArrayList<>())
            .add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(res,king);
        return res;
    }

    public void dfs(List<String> res,String root){
        if(!dead.contains(root)){
            res.add(root);
        }
        if(curOrder.get(root)==null) return;
        for(String child:curOrder.get(root)){
            dfs(res,child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */