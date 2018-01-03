package tagval.u6;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("rqwe", "    " + String.valueOf(523));
        map.put("tqwe", String.valueOf(623));
        map.put("6qwe", String.valueOf(723));
        map.put("yqwe", String.valueOf(423));

        iterateOverMap(map);
        map.replaceAll(new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String integer) {
                return integer.trim();
            }
        });
        System.out.println("++++++++++++++++++++++");
        iterateOverMap(map);
    }

    private static void iterateOverMap(Map<String, String> map) {
        map.forEach((s, integer) -> System.out.println(s + " >> " + integer));
    }

}
