package org.ogparser4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OpenGraph {
    private final Map<String, List<Content>> openGraph;

    public OpenGraph(Map<String, List<Content>> openGraphMap) {
        this.openGraph = openGraphMap;
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

    public int getContentSize(String property) {
        return openGraph.get(property).size();
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
    }
}
