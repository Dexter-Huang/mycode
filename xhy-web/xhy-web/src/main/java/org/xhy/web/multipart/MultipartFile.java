package org.xhy.web.multipart;

import org.springframework.core.io.InputStreamSource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:45
 */
public interface MultipartFile extends InputStreamSource {

    // 获取名称
    String getName();

    // 获取文件名
    String getOriginalFilename();

    // 获取类型
    String getContentType();

    // 是否为空
    boolean isEmpty();

    // 大小
    long getSize();

    //大小
    byte[] getBytes() throws IOException;

    // 获取流
    @Override
    InputStream getInputStream() throws IOException;

    // 转换
    void transferTo(File dest) throws IOException, IllegalStateException;

    default void transferTo(Path dest) throws IOException, IllegalStateException {
        FileCopyUtils.copy(getInputStream(), Files.newOutputStream(dest));
    }

}
