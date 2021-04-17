package com.titles.dao.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ReflectionUtils;
import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;


@Component
public class InjectFileDataAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        var fields = bean.getClass().getDeclaredFields();
        for (var field : fields) {
            var annotation = field.getAnnotation(InjectFileData.class);
            if (annotation != null) {
                var path = annotation.value();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, readFileToString(path));
            }
        }
        return bean;
    }

    private String readFileToString(String path) {
        var resource = new ClassPathResource(path);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
