package com.example.gen3.gen;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TODO
 *
 * @author Yi
 * @date 2023/3/25
 */
public interface PrivateFile {

    String AUTHOR = "Yi";

    /**
     * 项目路径
     */
    String PROJECT_PATH = "D:\\work\\code\\ideal-hos-server";

    // 包名
    String SON_PATH = "" ;  // 示例：".workflow"

    String FILE_SON_PATH = "" ; // 示例："workflow/"

    Boolean FILE_OVERRIDE = Boolean.FALSE;
}
