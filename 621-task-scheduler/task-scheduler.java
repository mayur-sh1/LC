class Task{
    char t;
    int time;
    int freq;

    Task(char t,int freq,int time){
        this.t=t;
        this.freq=freq;
        this.time=time;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        Queue<Task> q = new LinkedList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);

        int count[] = new int[26];

        for(char ch:tasks){
            count[ch - 'A']++;
        }

        for(int i=0;i<26;i++){
            if(count[i]>0){
                pq.add(new Task((char)(i+'A'), count[i], 0));
            }
        }

        int time=0;

        while(!pq.isEmpty() || !q.isEmpty()){

            time++;

            // bring back cooled tasks
            while(!q.isEmpty() && q.peek().time <= time){
                pq.add(q.poll());
            }

            if(!pq.isEmpty()){
                Task taskToExecute = pq.poll();
                taskToExecute.freq--;

                // only add if still remaining
                if(taskToExecute.freq > 0){
                    taskToExecute.time = time + (n+1);
                    q.add(taskToExecute);
                }
            }
        }

        return time;
    }
}
// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         for(int i=0;i<tasks.length;i++){
//             map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
//         }

//         int max=-1;
//         int count=0;

//         for(int freq:map.values()){
//             if(freq>max){
//                 max=freq;
//                 count=1;
//             }
//             else if(freq==max){
//                 count++;
//             }
//         }

//         // formula
//         int cycles = (max - 1) * (n + 1) + count;

//         return Math.max(cycles, tasks.length);
//     }
// }