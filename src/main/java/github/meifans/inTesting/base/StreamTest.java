package github.meifans.inTesting.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Meifans on 2017/5/9.
 */
public class StreamTest {

    @Test
    public void testCollect() {
        HashMap<Object, Object> asMap = Arrays.stream(Sex.values())
                                              .collect(HashMap::new, (map, s) -> map.put(s.getName(), s.getYear()), HashMap::putAll);

        assertEquals(Sex.MAN.getYear(), asMap.get(Sex.MAN.getName()));
        assertEquals(Sex.WOMAN.getYear(), asMap.get(Sex.WOMAN.getName()));

    }

    @Test
    public void testGroupBy() {
        List<Demo> demos = Arrays.asList(
                new Demo(1, "1"), new Demo(2, "2")
        );

        List<Demo> actuals = demos.stream().filter(demo -> demo.getYear() == 1).collect(Collectors.toList());
        assertEquals(demos.get(0),actuals.get(0));
    }

    @Test
    public void testAddAll() {
        List<Demo> demos = Arrays.asList(
                new Demo(1, "一"), new Demo(2, "二")
        );

        List<Demo> emptyList = demos.stream().filter(d -> d.getYear() == 3).collect(Collectors.toList());
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(emptyList);
        System.out.println(list.size());

    }

    public enum Sex {
        MAN("naigou", 23), WOMAN("naigoufuren", 21);

        String name;
        int year;

        Sex(String name, int year) {
            this.name = name;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }
    }

    @Setter
    @Getter
    class Demo {
        Integer year;
        String name;

        public Demo(Integer year, String name) {
            this.year = year;
            this.name = name;
        }
    }

}
