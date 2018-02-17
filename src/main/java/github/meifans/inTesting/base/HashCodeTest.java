package github.meifans.inTesting.base;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 * @author pengfei.zhao
 */
@Log
public class HashCodeTest {


    public static final String S = "default";

    @Test
    public void test() {
        Map<Demo, String> demo = generate(1000);
        Demo flag = build(-1);
        demo.put(flag, "-1");
        System.out.println("数据准备完毕");

        long start = System.currentTimeMillis();
        String s = demo.get(flag);
        long end = System.currentTimeMillis();

        System.out.println("flag:" + s + ",mill:" + (end - start));


    }

    private Map<Demo, String> generate(int nums) {

        return IntStream.range(0, nums)
//                .parallel()
                .mapToObj(this::build)
                .collect(Collectors.toMap(Function.identity(), d -> S));

    }

    private Demo build(int i) {
        System.out.println("构建第：" + i + "个demo");
        Demo demo = new Demo();
        String iStr = String.valueOf(i);
        demo.setId(iStr);

        HashMap<String, String> map = new HashMap<>();
        IntStream.range(0, 10).forEach(j -> map.put(UUID.randomUUID().toString(), iStr));
        demo.setMap(map);
        return demo;
    }

    @Setter
    @Getter
    public static class Demo {
        String id;
        Map<String, String> map;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            if (!super.equals(o))
                return false;

            Demo demo = (Demo) o;

            if (id != null ? !id.equals(demo.id) : demo.id != null)
                return false;
            return map != null ? map.equals(demo.map) : demo.map == null;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
