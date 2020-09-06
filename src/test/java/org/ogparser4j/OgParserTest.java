package org.ogparser4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ogparser4j.htmlparser.OgMetaElement;
import org.ogparser4j.htmlparser.OgMetaElementHtmlParser;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OgParserTest {
    private OgParser ogParser;

    @BeforeEach
    public void init() {
        ogParser = new OgParser(getMockHtmlParser());
    }

    private OgMetaElementHtmlParser getMockHtmlParser() {
        OgMetaElementHtmlParser ogMetaElementHtmlParser = mock(OgMetaElementHtmlParser.class);
        when(ogMetaElementHtmlParser.getOgMetaElements(anyString()))
                .thenReturn(getMockOgMetaElements());
        return ogMetaElementHtmlParser;
    }

    private List<OgMetaElement> getMockOgMetaElements() {
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

    @Test
    public void test() {
        ogParser.getOpenGraph("URL");
    }
}