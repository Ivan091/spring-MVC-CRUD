package com.titles.dao.util;

import org.springframework.core.io.Resource;


public interface ResourceReader {

    String readFileToString(String path);

    String asString(Resource resource);
}
