package com.github.siyoon210.ogparser4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class OpenGraphTest {
    private OpenGraph openGraph;

    @BeforeEach
    public void init() {
        OgParser ogParser = new OgParser(new MockOgMetaElementHtmlParser());
        openGraph = ogParser.getOpenGraphOf("URL");
    }

    @Test
    public void getAllPropertiesTest() {
        Set<String> allProperties = openGraph.getAllProperties();

        assertThat(allProperties.contains("title")).isTrue();
        assertThat(allProperties.contains("type")).isTrue();
        assertThat(allProperties.contains("url")).isTrue();
        assertThat(allProperties.contains("image")).isTrue();

        // Extra data is not added as a property.
        assertThat(allProperties.contains("image:type")).isFalse();
        assertThat(allProperties.contains("image:width")).isFalse();
        assertThat(allProperties.contains("image:height")).isFalse();
        assertThat(allProperties.contains("image:alt")).isFalse();
    }

    @Test
    public void getSpecificContentTest() {
        OpenGraph.Content title = openGraph.getContentOf("title");

        assertThat(title).isNotNull();
        assertThat(title.getValue()).isEqualTo("Open Graph protocol");
    }

    @Test
    public void getSpecificIndexContentTest() {
        //when
        OpenGraph.Content imageIndex0 = openGraph.getContentOf("image", 0);
        OpenGraph.Content imageIndex1 = openGraph.getContentOf("image", 1);

        //then
        assertThat(imageIndex0.getValue()).isEqualTo("https://ogp.me/logo.png");
        assertThat(imageIndex1.getValue()).isEqualTo("https://ogp.me/logo2.png");
    }

    @Test
    public void getSpecificContent_defaultIndexIsZero() {
        //when
        OpenGraph.Content image = openGraph.getContentOf("image");
        OpenGraph.Content imageIndex0 = openGraph.getContentOf("image", 0);

        //then
        assertThat(image).isEqualTo(imageIndex0);
    }

    @Test
    public void getContentSizeTest() {
        int imageSize = openGraph.getContentSizeOf("image");

        assertThat(imageSize).isEqualTo(2);
    }

    @Test
    public void getAllExtraDataTest() {
        OpenGraph.Content image = openGraph.getContentOf("image");
        Set<String> extraData = image.getAllExtraData();

        assertThat(extraData).isNotNull();
        assertThat(extraData.contains("type")).isTrue();
        assertThat(extraData.contains("width")).isTrue();
        assertThat(extraData.contains("height")).isTrue();
        assertThat(extraData.contains("alt")).isTrue();
    }

    @Test
    public void getSpecificExtraDataValueTest() {
        String imageType = openGraph
                .getContentOf("image")
                .getExtraDataValueOf("type");

        assertThat(imageType).isEqualTo("image/png");
    }
}