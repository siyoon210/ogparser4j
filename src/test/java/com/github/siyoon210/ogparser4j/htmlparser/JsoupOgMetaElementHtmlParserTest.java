package com.github.siyoon210.ogparser4j.htmlparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class JsoupOgMetaElementHtmlParserTest {
    private static final String SAMPLE_URL = "https://ogp.me/";
    private JsoupOgMetaElementHtmlParser jsoupOgMetaElementHtmlParser;

    @BeforeEach
    public void init() {
        jsoupOgMetaElementHtmlParser = new JsoupOgMetaElementHtmlParser();
    }

    @Test
    public void jsoupParserTest() {
        final List<OgMetaElement> ogMetaElements = jsoupOgMetaElementHtmlParser.getOgMetaElementsFrom(SAMPLE_URL);
        for (OgMetaElement ogMetaElement : ogMetaElements) {
            System.out.println(ogMetaElement.toString());
        }
        assertThat(ogMetaElements.contains(new OgMetaElement("title", "Open Graph protocol"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("type", "website"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("url", "https://ogp.me/"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("image", "https://ogp.me/logo.png"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("image:type", "image/png"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("image:width", "300"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("image:height", "300"))).isTrue();
        assertThat(ogMetaElements.contains(new OgMetaElement("image:alt", "The Open Graph logo"))).isTrue();
    }
}