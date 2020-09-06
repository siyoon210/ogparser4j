package org.ogparser4j;

import org.ogparser4j.htmlparser.OgMetaElement;
import org.ogparser4j.htmlparser.OgMetaElementHtmlParser;

import java.util.Arrays;
import java.util.List;

public class MockOgMetaElementHtmlParser implements OgMetaElementHtmlParser {
    @Override
    public List<OgMetaElement> getOgMetaElements(String url) {
        return Arrays.asList(
                new OgMetaElement("title", "Open Graph protocol"),
                new OgMetaElement("type", "website"),
                new OgMetaElement("url", "https://ogp.me/"),
                new OgMetaElement("image", "https://ogp.me/logo.png"),
                new OgMetaElement("image:type", "image/png"),
                new OgMetaElement("image:width", "300"),
                new OgMetaElement("image:height", "300"),
                new OgMetaElement("image:alt", "The Open Graph logo"),
                new OgMetaElement("image", "https://ogp.me/logo2.png"),
                new OgMetaElement("image:type", "image/png"),
                new OgMetaElement("image:width", "200"),
                new OgMetaElement("image:height", "200")
        );
    }
}
