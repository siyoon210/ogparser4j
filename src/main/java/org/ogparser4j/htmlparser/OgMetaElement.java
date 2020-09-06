package org.ogparser4j.htmlparser;

public class OgMetaElement {
    private final String property;
    private final String content;

    public OgMetaElement(String property, String content) {
        this.property = property;
        this.content = content;
    }

    public String getProperty() {
        return property;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "OgMetaElement{" +
                "property='" + property + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OgMetaElement)) return false;

        OgMetaElement that = (OgMetaElement) o;

        if (!property.equals(that.property)) return false;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        int result = property.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}
