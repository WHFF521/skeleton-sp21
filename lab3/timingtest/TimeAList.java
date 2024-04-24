package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        // printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts)
        AList<Integer> Ns = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Double> times = new AList<>();
        int[] numbers = new int[]{1000,2000,4000,8000,16000,32000,64000,128000};
        for(int number : numbers){
            Ns.addLast(number);
            opCounts.addLast(number);
            double usedTime = addhelper(number);
            times.addLast(usedTime);
        }
        printTimingTable(Ns, times, opCounts);
    }
    public static double addhelper(int n){
        Stopwatch sw = new Stopwatch();
        AList<Integer> N1000 = new AList<>();
        for(int i=1;i<=n;i++) {
            N1000.addLast(1);
        }
        return sw.elapsedTime();
    }
}
