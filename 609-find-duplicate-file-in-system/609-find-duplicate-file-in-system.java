class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> contentPaths=new HashMap<>();
        for(String path: paths)
        {
            String dir[]=path.split(" ");
            for(int i=1; i<dir.length; i++)
            {
                String content=dir[i].substring(dir[i].indexOf('(')-1, dir[i].indexOf(')'));
                String name=dir[i].substring(0, dir[i].indexOf('('));
                contentPaths.putIfAbsent(content, new ArrayList<>());
                List<String> paths_n=contentPaths.get(content);
                paths_n.add(dir[0]+"/"+name);
                contentPaths.put(content, paths_n);
            }
        }
        List<List<String>> res=new ArrayList<>();
        for(List<String> paths_n: contentPaths.values())
            if(paths_n.size()>1)
                res.add(paths_n);
        return res;
    }
}