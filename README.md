# ogparser4j

## Open Graph Protocol Summary
1. It is located in the <meta> tags in the <head> HTML.
2. It has two attributes. `property` and `content`.
    - The value of `property`, which is referred to as `metadata`, must start with `og:`.
    ```
    <head>
    ...
    <meta property="og:title" content="The Rock" />
    ...
    </head>
    ```

3. List of Metadata
    - Basic Metadata
        - og:title
        - og:type
        - og:image
        - og:url
    - Optional Metadata
        - og:audio
        - og:description
        - og:determiner
        - og:locale
        - og:locale:alternate
        - og:site_name
        - og:video

4. Some `properties` can have extra `metadata` attached to them. These are specified in the same way as other metadata with property and content, but the property will have extra `:`.
    ```
    <meta property="og:image" content="https://example.com/ogp.jpg" />
    <meta property="og:image:secure_url" content="https://secure.example.com/ogp.jpg" />
    <meta property="og:image:type" content="image/jpeg" />
    <meta property="og:image:width" content="400" />
    <meta property="og:image:height" content="300" />
    <meta property="og:image:alt" content="A shiny red apple with a bite taken out" />
    ```

5. If the same `metadata` is declared multiple times, it is treated as an array. The first tag (from top to bottom) is given preference during conflicts.
    ```
    <meta property="og:image" content="https://example.com/rock.jpg" />
    <meta property="og:image" content="https://example.com/rock2.jpg" />
    ```
    
    ```
    <meta property="og:image" content="https://example.com/rock.jpg" />
    <meta property="og:image:width" content="300" />
    <meta property="og:image:height" content="300" />
    <meta property="og:image" content="https://example.com/rock2.jpg" />
    <meta property="og:image" content="https://example.com/rock3.jpg" />
    <meta property="og:image:height" content="1000" />
    ```
- It means there are 3 images on this page, the first image is 300x300, the middle one has unspecified dimensions, and the last one is 1000px tall.

### Reference
- https://ogp.me/

