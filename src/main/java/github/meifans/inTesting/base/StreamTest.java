package github.meifans.inTesting.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Meifans on 2017/5/9.
 */
public class StreamTest {

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

    @Test
    public void testCollect() {
        HashMap<Object, Object> asMap = Arrays.stream(Sex.values())
                .collect(HashMap::new, (map, s) -> map.put(s.getName(), s.getYear()), HashMap::putAll);

        assertEquals(Sex.MAN.getYear(), asMap.get(Sex.MAN.getName()));
        assertEquals(Sex.WOMAN.getYear(), asMap.get(Sex.WOMAN.getName()));

    }

}
