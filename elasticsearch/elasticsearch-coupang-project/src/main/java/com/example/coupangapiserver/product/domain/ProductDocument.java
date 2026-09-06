package com.example.coupangapiserver.product.domain;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import jakarta.persistence.Id;

@Document (indexName = "products")
@Setting(settingPath = "/elasticsearch/product-settings.json")
public class ProductDocument {
    @Id
    private String id;

    @MultiField (
        mainField = @Field( type = FieldType.Text,
                            analyzer = "product_name_analyzer"),
        otherFields = {
            @InnerField(suffix = "auto_complete",
                        type = FieldType.Search_As_You_Type,
                        analyzer = "nori"),
        })
    private String name;

    @Field(type = FieldType.Text, analyzer = "product_description_analyzer")
    private String description;
    
    @Field(type = FieldType.Integer)
    private Integer price;

    @Field(type = FieldType.Double)
    private double rating;

    @MultiField (
        mainField = @Field( type = FieldType.Text,
                        analyzer = "product_category_analyzer"),
        otherFields = {
                    @InnerField(suffix = "keyword",
                    type = FieldType.Keyword)
        }
    )
    private String category;

    // Spring Data Elasticsearch가 검색 결과를 매핑할 때 사용하는 기본 생성자
    public ProductDocument() {
    }

    public ProductDocument(String id, String name, String description, Integer price, double rating, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
}
