package org.ogparser4j;

import java.util.*;

public class OpenGraph {
    private final Map<String, List<Content>> openGraph = new HashMap<>();

    public OpenGraph() {
        openGraph.put("title", Arrays.asList(new Content("Open Graph protocol")));
        openGraph.put("type", Arrays.asList(new Content("website")));
        openGraph.put("url", Arrays.asList(new Content("https://ogp.me/")));
        final Content imageContent1 = new Content("https://ogp.me/logo.png");
        imageContent1.extraDatum.put("type", "image/png");
        imageContent1.extraDatum.put("width", "300");
        imageContent1.extraDatum.put("height", "300");
        imageContent1.extraDatum.put("alt", "The Open Graph logo");
        final Content imageContent2 = new Content("https://ogp.me/logo2.png");
        imageContent2.extraDatum.put("type", "image/gif");
        imageContent2.extraDatum.put("width", "100");
        openGraph.put("image", Arrays.asList(imageContent1, imageContent2));
    }

    public Set<String> getAllProperties() {
        return openGraph.keySet();
    }

    public Content getContent(String property) {
        return getContent(property, 0);
    }

    public Content getContent(String property, int index) {
        return openGraph.get(property).get(index);
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

        public String getExtraDataValue(String extraData) {
            return extraDatum.get(extraData);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Content)) return false;

            Content content = (Content) o;

            if (!getValue().equals(content.getValue())) return false;
            return extraDatum.equals(content.extraDatum);
        }

        @Override
        public int hashCode() {
            int result = getValue().hashCode();
            result = 31 * result + extraDatum.hashCode();
            return result;
        }
    }
}
