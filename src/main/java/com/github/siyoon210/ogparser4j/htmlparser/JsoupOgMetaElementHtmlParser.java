package com.github.siyoon210.ogparser4j.htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JsoupOgMetaElementHtmlParser implements OgMetaElementHtmlParser {
    @Override
    public List<OgMetaElement> getOgMetaElementsFrom(String url) {
        try {
            final Document document = Jsoup.connect(url).get();
            final Elements metaElements = document.select("meta");
            return metaElements.stream()
                    .filter(m -> m.attr("property").startsWith("og:"))
                    .map(m -> {
                        final String property = m.attr("property").substring(3).trim();
                        final String content = m.attr("content");
                        return new OgMetaElement(property, content);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
