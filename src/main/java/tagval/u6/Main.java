package tagval.u6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    private static final List<String> UNWANTED_VALUE = Arrays.asList("frt", "hrt");

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("rqwe", "    " + String.valueOf(523));
        map.put("tqwe", String.valueOf(623));
        map.put("6qwe", String.valueOf(723));
        map.put("yqwe", String.valueOf(423));
        map.put("lqwe", "hrt");
        map.put("kqwe", "grt");
        map.put("jqwe", "frt");

        iterateOverMap(map);
        map.replaceAll(new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String integer) {
                return integer.trim();
            }
        });
        System.out.println("++++++++++++++++++++++");
        iterateOverMap(map);
        map.entrySet().removeIf(stringStringEntry -> stringStringEntry.getValue().equals("723"));
        map.values().removeIf(stringStringEntry -> stringStringEntry.equals("623"));
        System.out.println("++++++++++++++++++++++");
        iterateOverMap(map);
        map.values().removeAll(UNWANTED_VALUE);
        System.out.println("++++++++++++++++++++++");
        iterateOverMap(map);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("1wes", 56);
        map2.put("2wes", 456);
        map2.put("3wes", 356);
        map2.merge("1wes",1, (integer, integer2) -> integer + integer2);

        System.out.println("++++++++++++++++++++++");
        System.out.println(map2);
    }

    private static void iterateOverMap(Map<String, String> map) {
        map.forEach((s, integer) -> System.out.println(s + " >> " + integer));
    }

}
