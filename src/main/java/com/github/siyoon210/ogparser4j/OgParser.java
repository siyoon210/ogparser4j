package com.github.siyoon210.ogparser4j;

import com.github.siyoon210.ogparser4j.htmlparser.JsoupOgMetaElementHtmlParser;
import com.github.siyoon210.ogparser4j.htmlparser.OgMetaElement;
import com.github.siyoon210.ogparser4j.htmlparser.OgMetaElementHtmlParser;

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

    public OpenGraph getOpenGraphOf(String url) {
        final List<OgMetaElement> ogMetaElements = ogMetaElementHtmlParser.getOgMetaElementsFrom(url);

        final Map<String, List<OpenGraph.Content>> openGraphMap = convertOgMetaElementsToOpenGraphMap(ogMetaElements);

        return new OpenGraph(openGraphMap);
    }

    private Map<String, List<OpenGraph.Content>> convertOgMetaElementsToOpenGraphMap(List<OgMetaElement> ogMetaElements) {
        final Map<String, List<OpenGraph.Content>> openGraphMap = new HashMap<>();

        for (OgMetaElement ogMetaElement : ogMetaElements) {
            final String property = ogMetaElement.getProperty();
            final String contentValue = ogMetaElement.getContent();

            if (openGraphMap.containsKey(property)) {
                updateContents(ogMetaElement, openGraphMap.get(property), contentValue);
                continue;
            }

            openGraphMap.put(property, getNewContents(contentValue));
        }

        return openGraphMap;
    }

    private void updateContents(OgMetaElement ogMetaElement, List<OpenGraph.Content> contents , String contentValue) {
        if (ogMetaElement.hasExtraData()) {
            setExtraDataOnLastContent(ogMetaElement, contents, contentValue);
            return;
        }
        contents.add(new OpenGraph.Content(contentValue));
    }

    private void setExtraDataOnLastContent(OgMetaElement ogMetaElement, List<OpenGraph.Content> contents, String contentValue) {
        final OpenGraph.Content lastContent = contents.get(contents.size() - 1);
        lastContent.setExtraData(ogMetaElement.getExtraData(), contentValue);
    }

    private List<OpenGraph.Content> getNewContents(String content) {
        final List<OpenGraph.Content> contents = new ArrayList<>();
        contents.add(new OpenGraph.Content(content));
        return contents;
    }
}
