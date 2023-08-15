class TodoList {
    private class Task {
        String taskDescription;
        int dueDate;
        List<String> tags;
        int id;
        boolean deleted;
        public Task(String taskDescription, int dueDate, List<String> tags, int id) {
            this.taskDescription = taskDescription;
            this.dueDate = dueDate;
            this.tags = tags;
            this.id = id;
        }
    }
    
    Map<Integer, List<Task>> map;
    int id; 
    public TodoList() {
        this.map = new HashMap<>();
        this.id = 1;
    }
    
    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        if (!map.containsKey(userId)) {
            map.put(userId, new ArrayList<>());
        }
        map.get(userId).add(new Task(taskDescription, dueDate, tags, id));
        return id++;
    }
    
    public List<String> getAllTasks(int userId) {
        if (!map.containsKey(userId)) {
            return new ArrayList<>();
        }
        return map.get(userId).stream()
            .filter(task -> task.deleted == false)
            .sorted((a, b) -> a.dueDate - b.dueDate)
            .map(task -> task.taskDescription)
            .collect(Collectors.toList());
        
    }
    
    public List<String> getTasksForTag(int userId, String tag) {
        if (!map.containsKey(userId)) {
            return new ArrayList<>();
        }
        return map.get(userId).stream()
            .filter(task -> task.deleted == false && task.tags.contains(tag))
            .sorted((a, b) -> a.dueDate - b.dueDate)
            .map(task -> task.taskDescription)
            .collect(Collectors.toList());
    }
    
    public void completeTask(int userId, int taskId) {
        if (map.containsKey(userId)) {
            map.get(userId).stream()
                .filter(task -> task.id == taskId)
                .forEach(task -> task.deleted = true);
        }
    }
}

/**
 * Your TodoList object will be instantiated and called as such:
 * TodoList obj = new TodoList();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
 */