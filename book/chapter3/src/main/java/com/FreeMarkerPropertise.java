package com;

import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;

public class FreeMarkerPropertise extends AbstractTemplateViewResolverProperties {

    public static final String DEFAULT_TEMPLATE="classpath:/templates";
    public static final String DEFAULT_PREFIX="";
    public static final String DEFAULT_SUFFIX=".ftl";
}
