package org.ogparser4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OpenGraph {
    private Map<String, String> openGraph = new HashMap<>();

    public OpenGraph() {
        openGraph.put("title", null);
        openGraph.put("type", null);
        openGraph.put("url", null);
        openGraph.put("image", null);
    }

    public Set<String> getAllProperties() {
        return openGraph.keySet();
    }
}
