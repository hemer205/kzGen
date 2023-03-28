package com.example.gen3.gen;

import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;
import static com.example.gen3.gen.Const.*;

/**
 * TODO
 *
 * @author Yi
 * @date 2023/3/25
 */
public interface PrivateFile {

    /**
     * 表名
     */
    String TABLE_NAME_STR = "base_order_sub_classes";

    /**
     * 表前缀
     */
    String TABLE_PREFIX = "base_";

    /**
     * 模块名
     */
    String MODEL_BASE = Const.MODEL_BASE;

    /**
     * 大模块
     */
    String CGILD_PHTH = "basic";

    Boolean HAVE = false;

    /**
     * 是否覆盖
     */
    Boolean FILE_OVERRIDE = Boolean.TRUE;


    /**
     * 项目路径
     */
    String PROJECT_PATH = "D:\\work\\code\\ideal-hos-server";


    String AUTHOR = "Yi";



    static void main(String[] args) {
        // 表名(仅支持一张表)
        String tableNameStr = PrivateFile.TABLE_NAME_STR;
        String[] split = tableNameStr.split(",|，");
        String name = "";
        for (String tableName : split) {
            if(HAVE){
                name = StrUtil.toCamelCase(tableName.replace(TABLE_PREFIX, ""));
            }
            //包名 示例：".workflow"
            String sonPath = StringUtils.hasLength(name) ? Const.DROP + name : "";
            //示例："workflow/"
            String fileSonPath = StringUtils.hasLength(name) ? name + Const.SLASH : "";
            CodeGenerator.codeGeneratorSib(PrivateFile.AUTHOR, tableNameStr, MODEL_SIB, PrivateFile.MODEL_BASE, sonPath, fileSonPath);
            CodeGenerator.codeGenerator(PrivateFile.AUTHOR, tableNameStr, PrivateFile.MODEL_BASE, CHILD_MODEL_CORE, sonPath, fileSonPath);
            CodeGenerator.codeGenerator(PrivateFile.AUTHOR, tableNameStr, PrivateFile.MODEL_BASE, CHILD_MODEL_CLIENT, sonPath, fileSonPath);
        }
    }

}
