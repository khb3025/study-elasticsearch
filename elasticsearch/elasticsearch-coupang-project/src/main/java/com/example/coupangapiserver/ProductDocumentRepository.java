package com.example.coupangapiserver;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.coupangapiserver.product.domain.ProductDocument;

public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, String> {
    // Custom query methods can be defined here if needed
}
