package com.duthub.DutHub.bll.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String storeVideo(MultipartFile file);
    String storePreview(MultipartFile file);
    Resource loadVideoAsResource(String fileName);
    Resource loadPreviewAsResource(String fileName);
}
