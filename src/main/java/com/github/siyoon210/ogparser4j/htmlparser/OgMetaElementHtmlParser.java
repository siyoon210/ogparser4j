package com.github.siyoon210.ogparser4j.htmlparser;

import java.util.List;

public interface OgMetaElementHtmlParser {
    List<OgMetaElement> getOgMetaElementsFrom(String url);
}
