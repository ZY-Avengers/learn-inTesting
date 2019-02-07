package github.meifans.inTesting.leetcode.abilitycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }
        List<Interval> res = new ArrayList<>();
        int start = -1, end = -1;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (start == -1 && newInterval.start <= interval.end) {
                start = newInterval.start < interval.start ? newInterval.start : interval.start;
            }
            if (end == -1 && newInterval.end <= interval.end) {
                end = newInterval.end < interval.start ? newInterval.end : interval.end;
                res.add(new Interval(start, end));
            }
            if (start == -1 || (end != -1 && interval.start > end)) {
                res.add(interval);
            }
        }
        if (end == -1) {
            res.add(new Interval(start == -1 ? newInterval.start : start, newInterval.end));
        }
        return res;
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
