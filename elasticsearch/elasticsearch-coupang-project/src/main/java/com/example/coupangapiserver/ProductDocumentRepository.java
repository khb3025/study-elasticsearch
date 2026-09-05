package com.example.coupangapiserver;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, String> {
    // Custom query methods can be defined here if needed
}
