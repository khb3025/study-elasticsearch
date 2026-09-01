package com.example.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {
    // Custom query methods can be defined here if needed
    
}
