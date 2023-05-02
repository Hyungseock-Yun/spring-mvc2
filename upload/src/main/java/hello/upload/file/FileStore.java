package hello.upload.file;

import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

  @Value("${file.dir}")
  private String fileDir;

  public String getFullPath(String filename) {
    return fileDir + filename;
  }

  public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
    List<UploadFile> storeFileResult = new ArrayList<>();
    for (MultipartFile multipartFile : multipartFiles) {
      if (!multipartFiles.isEmpty()) {
        storeFileResult.add(storeFile(multipartFile));
      }
    }

    return storeFileResult;
  }

  public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
    if (multipartFile.isEmpty()) return null;

    String originalFileName = multipartFile.getOriginalFilename();    // image.png
    String storeFileName = createStoreFileName(originalFileName);

    multipartFile.transferTo(new File(getFullPath(storeFileName)));

    return new UploadFile(originalFileName, storeFileName);
  }

  private String createStoreFileName(String originalFileName) {
    String uuid = UUID.randomUUID().toString();
    String ext = extractExt(originalFileName);

    return uuid + "." + ext;
  }

  private String extractExt(String originalFilename) {
    int pos = originalFilename.lastIndexOf(".");

    return originalFilename.substring(pos + 1);
  }


}
