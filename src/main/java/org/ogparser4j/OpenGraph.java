package org.ogparser4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OpenGraph {
    private final Map<String, Content> openGraph = new HashMap<>();

    public OpenGraph() {
        openGraph.put("title", new Content("Open Graph protocol"));
        openGraph.put("type", new Content("website"));
        openGraph.put("url", new Content("https://ogp.me/"));
        openGraph.put("image", new Content("https://ogp.me/logo.png"));
    }

    public Set<String> getAllProperties() {
        return openGraph.keySet();
    }

    public Content getContent(String property) {
        return openGraph.get(property);
    }

    public static class Content {
        private final String value;

        public Content(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
