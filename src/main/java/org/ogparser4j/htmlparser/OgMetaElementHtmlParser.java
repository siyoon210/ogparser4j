package org.ogparser4j.htmlparser;

import java.util.List;

public interface OgMetaElementHtmlParser {
    List<OgMetaElement> getOgMetaElements(String url);
}
