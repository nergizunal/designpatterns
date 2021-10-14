import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void printMaxActivities(int [] s, int [] f, int n){
        int i, j;
        System.out.print( "Following activities are selected: n ");
        i = 0;
        System.out.print(i + " "); //first activity is always selected

        for(j = 1; j<n; j++){
            if(s[j] >= f[i]){//if the activity has start time greater or equal to finish time of previously selected
                System.out.print(j + " "); //activity, then select it
                i = j;
            }
        }

    }
    static class Pair {

        int first;
        int second;

        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    static void SelectAct(int s [], int f []){
        ArrayList<Pair> ans = new ArrayList<>();
        PriorityQueue<Pair> p = new PriorityQueue<>((p1,p2) -> p1.first -p2.first); // sort activities by finishing time
        for(int i = 0; i<s.length; i++){
            p.add(new Pair(f[i], s[i]));
        }
        Pair it = p.poll();
        int start = it.first;
        int finish = it.second;
        ans.add(it);
        while(!p.isEmpty()){
            Pair itr = p.poll();
            if(itr.first >= finish){
                start = itr.first;
                finish = itr.second;
                ans.add(new Pair(start, finish));
            }
        }
        System.out.println(
                "Following Activities should be selected. \n");
        for(Pair itr : ans)
            System.out.println(
                    "Activity started at: " + itr.first
                            + " and ends at  " + itr.second);
    }
    public  static void printMaxAct(Activity arr[], int n){
        Compare obj = new Compare();
        obj.compare(arr,n);
        System.out.println(
                "Following activities are selected :");
        int i = 0;
        System.out.print("(" + arr[i].start + ", "
                + arr[i].finish + "), ");
        for(int j = 1 ; j<n; j++){
            System.out.print("(" + arr[j].start + ", "
                    + arr[j].finish + "), ");
            i = j;
        }
    }
    public static void main(String[] args)
    {
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);
    }
}

class Activity  {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}
class Compare
{
    static  void compare(Activity arr[], int n){
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.finish - o2.finish;
            }
        });
    }
}