package com.titles.dao.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;


@Component
public class ClasspathResourceReader implements ResourceReader {

    @Override
    public String readFileToString(String path) {
        var resource = new ClassPathResource(path);
        return asString(resource);
    }

    @Override
    public String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
