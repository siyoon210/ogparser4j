package org.ogparser4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class OpenGraphTest {
    private OpenGraph openGraph;

    @BeforeEach
    public void init() {
        openGraph = new OpenGraph();
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
        OpenGraph.Content title = openGraph.getContent("title");

        assertThat(title).isNotNull();
        assertThat(title.getValue()).isEqualTo("Open Graph protocol");
    }

    @Test
    public void getAllExtraDatumTest() {
        OpenGraph.Content image = openGraph.getContent("image");
        Set<String> extraDatum = image.getAllExtraDatum();

        assertThat(extraDatum).isNotNull();
        assertThat(extraDatum.contains("type")).isTrue();
        assertThat(extraDatum.contains("width")).isTrue();
        assertThat(extraDatum.contains("height")).isTrue();
        assertThat(extraDatum.contains("alt")).isTrue();
    }

    @Test
    public void getSpecificExtraDataValueTest() {
        String imageType = openGraph
                .getContent("image")
                .getExtraDataContent("type");

        assertThat(imageType).isEqualTo("image/png");
    }
}