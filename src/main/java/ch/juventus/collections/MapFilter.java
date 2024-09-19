package ch.juventus.collections;

import java.util.*;

public class MapFilter {

    public <K, V> Map<K, V> cleanupV1(Map<K, V> input, V value) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<K, V> output = new HashMap<>();
        for (Map.Entry<K, V> entry : input.entrySet()) {
            if (entry.getValue().equals(value)) {
                output.put(entry.getKey(), entry.getValue());
            }
        }
        return output;
    }

    public <K, V> Map<K, V> cleanupV2(Map<K, V> input, V value) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<K, V> output = new HashMap<>(input);
        Iterator<Map.Entry<K, V>> iterator = output.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            if (!entry.getValue().equals(value)) {
                iterator.remove();
            }
        }

        return output;
    }

    public <K, V> Map<K, V> cleanupV3(Map<K, V> input, V value) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<K, V> output = new HashMap<>(input);
        output.entrySet().removeIf(entry -> !entry.getValue().equals(value));
        return output;
    }

}
