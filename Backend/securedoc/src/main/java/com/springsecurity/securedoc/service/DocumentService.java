package com.springsecurity.securedoc.service;

import com.springsecurity.securedoc.dto.Document;
import com.springsecurity.securedoc.dto.api.IDocument;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

//
 /// 4/8/24
//

public interface DocumentService {
    Page<IDocument> getDocuments(int page, int size);
    Page<IDocument> getDocuments(int page, int size, String name);
    Collection<Document> saveDocuments(String userId, List<MultipartFile> documents);
    IDocument updateDocument(String documentId, String name, String description);
    void deleteDocument(String documentId);
    IDocument getDocumentByDocumentId(String documentId);
    Resource getResource(String documentName);
}