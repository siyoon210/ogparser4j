package com.github.siyoon210.ogparser4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OpenGraph {
    private final Map<String, List<Content>> openGraph;

    OpenGraph(Map<String, List<Content>> openGraphMap) {
        this.openGraph = openGraphMap;
    }

    public Set<String> getAllProperties() {
        return openGraph.keySet();
    }

    public Content getContentOf(String property) {
        return getContentOf(property, 0);
    }

    public Content getContentOf(String property, int index) {
        return openGraph.get(property).get(index);
    }

    public int getContentSizeOf(String property) {
        return openGraph.get(property).size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenGraph)) return false;

        OpenGraph openGraph1 = (OpenGraph) o;

        return openGraph.equals(openGraph1.openGraph);
    }

    @Override
    public int hashCode() {
        return openGraph.hashCode();
    }

    @Override
    public String toString() {
        return "OpenGraph " +
                openGraph.keySet().stream()
                .map(p -> p + "=" + openGraph.get(p).stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("-", "{", "}")))
                .collect(Collectors.joining(", ", "{", "}"));
    }

    public static class Content {
        private final String value;
        private final Map<String, String> extraDatum;

        Content(String value) {
            this.value = value;
            extraDatum = new HashMap<>();
        }

        public String getValue() {
            return value;
        }

        public Set<String> getAllExtraDatum() {
            return extraDatum.keySet();
        }

        public String getExtraDataValueOf(String extraData) {
            return extraDatum.get(extraData);
        }

        void setExtraData(String extraData, String value) {
            extraDatum.put(extraData, value);
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

        @Override
        public String toString() {
            return "Content{" +
                    "value='" + value + '\'' +
                    ", extraDatum=" + extraDatum +
                    '}';
        }
    }
}
