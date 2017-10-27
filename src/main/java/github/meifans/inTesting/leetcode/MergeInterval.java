package github.meifans.inTesting.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class MergeInterval {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        System.out.println(System.currentTimeMillis());
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        System.out.println(System.currentTimeMillis());
        List<Interval> result = new ArrayList<>();
        int i = 0;
        for (Interval cur, pre = null; i < intervals.size(); i++) {
            cur = intervals.get(i);
            if (pre == null || pre.end < cur.start) {
                result.add(cur);
                pre = cur;
            } else if (pre.end < cur.end) {
                pre.end = cur.end;
            }
        }
        System.out.println(System.currentTimeMillis());
        return result;
    }

    // TODO: 2017/10/25 分开排序为什么可以
    public List<Interval> mergeII(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }

    public List<Interval> mergeIII(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        Interval[] vals = intervals.toArray(new Interval[1]);
        Arrays.sort(vals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        int i = 0;
        for (Interval cur, pre = null; i < vals.length; i++) {
            cur = vals[i];
            if (pre == null || pre.end < cur.start) {
                result.add(cur);
                pre = cur;
            } else if (pre.end < cur.end) {
                pre.end = cur.end;
            }
        }
        return result;
    }


    @Test
    public void test() throws InterruptedException {
        List<Interval> intervals = new ArrayList<>(1000);
        for (int i = 0; i < 10000; i++) {
            int v1 = (int) (10000 * Math.random());
            int v2 = (int) (10000 * (2 * Math.random()));
            intervals.add(new Interval(v1, v2));
        }

        List<Interval> actual = this.mergeIII(intervals);
        actual.forEach(i -> System.out.println(i.start + "-" + i.end));
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval() {
        }
    }
}

