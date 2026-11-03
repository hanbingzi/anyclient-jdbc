package com.hanshan.common;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test2 {

    @Test
    public void test1() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "a");
        testMap.put("b", "b");

        Set<String> keys = testMap.keySet();
        for (String key : keys) {
            System.out.println("key:" + key + ";value:" + testMap.get(key));
        }
    }
}
