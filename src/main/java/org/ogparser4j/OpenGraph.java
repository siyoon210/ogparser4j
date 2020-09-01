package org.ogparser4j;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OpenGraph {
    private final Map<String, Content> openGraph = new HashMap<>();

    public OpenGraph() {
        openGraph.put("title", new Content("Open Graph protocol"));
        openGraph.put("type", new Content("website"));
        openGraph.put("url", new Content("https://ogp.me/"));
        final Content imageContent = new Content("https://ogp.me/logo.png");
        imageContent.extraDatum.put("type", "image/png");
        imageContent.extraDatum.put("width", "300");
        imageContent.extraDatum.put("height", "300");
        imageContent.extraDatum.put("alt", "The Open Graph logo");
        openGraph.put("image", imageContent);
    }

    public Set<String> getAllProperties() {
        return openGraph.keySet();
    }

    public Content getContent(String property) {
        return openGraph.get(property);
    }

    public static class Content {
        private final String value;
        private final Map<String, String> extraDatum;

        public Content(String value) {
            this.value = value;
            extraDatum = new HashMap<>();
        }

        public String getValue() {
            return value;
        }

        public Set<String> getAllExtraDatum() {
            return extraDatum.keySet();
        }
    }
}
