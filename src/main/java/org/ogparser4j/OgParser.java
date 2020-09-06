package org.ogparser4j;

import org.ogparser4j.htmlparser.JsoupOgMetaElementHtmlParser;
import org.ogparser4j.htmlparser.OgMetaElement;
import org.ogparser4j.htmlparser.OgMetaElementHtmlParser;

import java.util.List;

public class OgParser {
    private final OgMetaElementHtmlParser ogMetaElementHtmlParser;

    public OgParser() {
        this.ogMetaElementHtmlParser = new JsoupOgMetaElementHtmlParser();
    }

    public OgParser(OgMetaElementHtmlParser ogMetaElementHtmlParser) {
        this.ogMetaElementHtmlParser = ogMetaElementHtmlParser;
    }

    public OpenGraph getOpenGraph(String url) {
        final List<OgMetaElement> ogMetaElements = ogMetaElementHtmlParser.getOgMetaElements(url);
        for (OgMetaElement ogMetaElement : ogMetaElements) {
            System.out.println("ogMetaElement.toString() = " + ogMetaElement.toString());
        }
        return null;
    }
}
