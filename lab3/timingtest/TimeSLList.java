package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Double> times = new AList<>();
        int[] numbers = new int[]{1000,2000,4000,8000,16000,32000,64000,128000};
        int m = 10000;
        for(int number : numbers){
            Ns.addLast(number);
            opCounts.addLast(m);
            double usedTime = gethelper(number,m);
            times.addLast(usedTime);
        }
        printTimingTable(Ns, times, opCounts);
    }
    public static double gethelper(int n,int m){
        SLList<Integer> N1000 = new SLList<>();
        for(int i=1;i<=n;i++) {
            N1000.addFirst(i);
        }
        Stopwatch sw = new Stopwatch();
        for(int i=1;i<=m;i++) {
            N1000.getLast();
        }
        return sw.elapsedTime();
    }
}
