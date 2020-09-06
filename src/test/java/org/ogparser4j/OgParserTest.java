package org.ogparser4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class OgParserTest {
    private OgParser ogParser;

    @BeforeEach
    public void init() {
        ogParser = new OgParser(new MockOgMetaElementHtmlParser());
    }

    @Test
    public void getParseAndAllPropertiesTest() {
        final OpenGraph openGraph = ogParser.getOpenGraph("URL");
        final Set<String> allProperties = openGraph.getAllProperties();

        assertThat(allProperties.size()).isEqualTo(4); // title, type, url, image
        assertThat(allProperties.contains("title")).isTrue();
        assertThat(allProperties.contains("type")).isTrue();
        assertThat(allProperties.contains("url")).isTrue();
        assertThat(allProperties.contains("imgae")).isTrue();
    }
}