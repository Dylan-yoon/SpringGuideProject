
package com.baem.webservice;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
//public record Unsplash(String id, String slug, String created_at) {
//	
//}
@JsonIgnoreProperties(ignoreUnknown = false)
public record Unsplash(
    String id,
    String slug,
    String created_at,
    String updated_at,
    String promoted_at,
    int width,
    int height,
    String color,
    String blur_hash,
    String description,
    String alt_description,
    List<String> breadcrumbs,
    int likes,
    boolean liked_by_user,
    List<Object> current_user_collections,
    Object sponsorship,
    String asset_type,
    int views,
    int downloads
) {}
