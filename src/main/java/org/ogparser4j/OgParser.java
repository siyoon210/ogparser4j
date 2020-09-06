package org.ogparser4j;

import org.ogparser4j.htmlparser.JsoupOgMetaElementHtmlParser;
import org.ogparser4j.htmlparser.OgMetaElement;
import org.ogparser4j.htmlparser.OgMetaElementHtmlParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OgParser {
    private final OgMetaElementHtmlParser ogMetaElementHtmlParser;

    public OgParser() {
        this.ogMetaElementHtmlParser = new JsoupOgMetaElementHtmlParser();
    }

    public OgParser(OgMetaElementHtmlParser ogMetaElementHtmlParser) {
        this.ogMetaElementHtmlParser = ogMetaElementHtmlParser;
    }

    public OpenGraph getOpenGraph(String url) {
        final Map<String, List<OpenGraph.Content>> openGraphMap = new HashMap<>();
        final List<OgMetaElement> ogMetaElements = ogMetaElementHtmlParser.getOgMetaElements(url);
        for (OgMetaElement ogMetaElement : ogMetaElements) {
            String property = ogMetaElement.getProperty();
            final String content = ogMetaElement.getContent();
            String extraData = null;

            if (property.contains(":")) {
                final String[] split = property.split(":");
                property = split[0];
                extraData = split[1];
            }

            if (openGraphMap.containsKey(property)) {
                final List<OpenGraph.Content> contents = openGraphMap.get(property);
                if (extraData == null) {
                    contents.add(new OpenGraph.Content(content));
                } else {
                    final OpenGraph.Content lastContent = contents.get(contents.size() - 1);
                    lastContent.setExtraData(extraData, content);
                }
            } else {
                final List<OpenGraph.Content> contents = new ArrayList<>();
                contents.add(new OpenGraph.Content(content));
                openGraphMap.put(property, contents);
            }
        }

        return new OpenGraph(openGraphMap);
    }
}
