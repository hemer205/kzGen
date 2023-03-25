package com.example.gen3.gen;

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
    String TABLE_NAME_STR = "base_bill_sub_classes";

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

    /**
     *
     */
    String NAME = "";

    /**
     * 是否覆盖
     */
    Boolean FILE_OVERRIDE = Boolean.FALSE;


    /**
     * 项目路径
     */
    String PROJECT_PATH = "D:\\work\\code\\ideal-hos-server";


    String AUTHOR = "Yi";

    /**
     * 包名 示例：".workflow"
     */
    String SON_PATH = StringUtils.hasLength(NAME) ? Const.DROP + NAME : "";

    /**
     * 示例："workflow/"
     */
    String FILE_SON_PATH = StringUtils.hasLength(NAME) ? NAME + Const.SLASH : "";

    public static void main(String[] args) {
        // 表名(仅支持一张表)
        String tableNameStr = PrivateFile.TABLE_NAME_STR;
        // String tableNameStr = "base_order_group";
        CodeGenerator.codeGeneratorSib(PrivateFile.AUTHOR, tableNameStr, MODEL_SIB, PrivateFile.MODEL_BASE, PrivateFile.SON_PATH, PrivateFile.FILE_SON_PATH);
        CodeGenerator.codeGenerator(PrivateFile.AUTHOR, tableNameStr, PrivateFile.MODEL_BASE, CHILD_MODEL_CORE, PrivateFile.SON_PATH, PrivateFile.FILE_SON_PATH);
        CodeGenerator.codeGenerator(PrivateFile.AUTHOR, tableNameStr, PrivateFile.MODEL_BASE, CHILD_MODEL_CLIENT, PrivateFile.SON_PATH, PrivateFile.FILE_SON_PATH);
    }
}
