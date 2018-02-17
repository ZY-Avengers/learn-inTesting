package github.meifans.inTesting.base;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.toIntExact;
import static java.util.stream.Collectors.joining;

/**
 * Created by Meifans on 2017/9/25.
 */
public class JAVA8DateTime {


    @Test
    public void roundTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusHours(10).plusMinutes(1);

        LocalDateTime floorStart = now.truncatedTo(ChronoUnit.HOURS);
        LocalDateTime ceilingEnd = future.truncatedTo(ChronoUnit.HOURS).plusHours(1);
        if (future.truncatedTo(ChronoUnit.HOURS).equals(future)) {
            ceilingEnd = future;
        }
        int hours = (int) floorStart.until(ceilingEnd, ChronoUnit.HOURS);
        System.out.println(hours);

        String timestamp = IntStream.range(1, hours)
                .mapToObj(floorStart::plusHours)
                .map(date -> date.toEpochSecond(ZoneOffset.UTC))
                .map(second -> Integer.toString(toIntExact(second)))
                .collect(joining(","));
        System.out.println(timestamp);

        List<DataToMap> list = new ArrayList<>();


    }

    @Test
    public void test(){
        Date date = new Date(1527234076583L);

        System.out.println();
    }

    private class DataToMap {
    }
}
