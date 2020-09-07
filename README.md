# ogparser4j

## Usage
### How to Get OpenGraph object from your target url. 
```
OgParser ogParser = new OgParser();
OpenGraph openGraph = ogParser.getOpenGraphOf("https://target.url");
```

### How to Get OpenGraph Value
- sample meta elements
```
<meta property="og:title" content="Open Graph protocol" />
```

- usage
```
OpenGraph.Content title = openGraph.getContentOf("title");
String titleValue = title.getValue(); // "Open Graph protocol"
```

### How to Get Extra Data
- sample meta elements
```
<meta property="og:image" content="https://ogp.me/logo.png" />
<meta property="og:image:type" content="image/png" />
```

- usage
```
OpenGraph.Content image = openGraph.getContent("image");
String imageType = image.getExtraDataValueOf("type"); // "image/png"
```

### How to Get Array Values
- sample meta elements(1)
```
<meta property="og:image" content="https://ogp.me/logo.png" />
<meta property="og:image" content="https://ogp.me/logo2.png" />
```

- usage(1)
```
OpenGraph.Content imageIndex0 = openGraph.getContent("image", 0); // you can omit index 0.
OpenGraph.Content imageIndex1 = openGraph.getContent("image", 1);

String image0 = imageIndex0.getValue(); // "https://ogp.me/logo.png"
String image1 = imageIndex1.getValue(); // "https://ogp.me/logo2.png"
```

---

- sample meta elements(2)
```
<meta property="og:image" content="https://ogp.me/logo.png" />
<meta property="og:image:width" content="300" />
<meta property="og:image" content="https://ogp.me/logo2.png" />
<meta property="og:image:width" content="200" />
```

- usage(2)
```
OpenGraph.Content imageIndex0 = openGraph.getContentOf("image", 0); // you can omit index 0.
OpenGraph.Content imageIndex1 = openGraph.getContentOf("image", 1);

String image0Width = imageIndex0.getExtraDataValueOf("width"); // "300"
String image1Wdith = imageIndex1.getExtraDataValueOf("width); // "200"
```

## OpenGraph Protocol Summary
[OpenGraph Protocol Summary](./docs/OpenGraph-Protocol-Summary.md)

## Class Diagram
![class-diagram](./docs/diagram/class-diagram.png)
