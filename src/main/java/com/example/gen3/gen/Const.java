package com.example.gen3.gen;

public interface Const {
    String SLASH = "/";
    String DROP = ".";

    /**
     * 模块前缀
     */
    String MODEL_PREFIX = "ideal-hos-";
    /**
     * 模块前缀
     */
    String MODEL_PREFIX_DROP = "com.ideal.hos.";
    /**
     * 模块列表 ************************************
     */
    String MODEL_BILL = "ideal-hos-bill";
    String MODEL_COMMON = "common";
    String MODEL_DTS = "dts";
    String MODEL_BASE = "patient";
    String MODEL_EMR = "emr";
    String MODEL_MATERIAL = "material";
    String MODEL_PAT = "pat";
    String MODEL_PHARMACY = "pharmacy";
    String MODEL_REPORT = "report";
    String MODEL_SIB = "sib";

    /**
     * 子模块列表 ************************************
     */
    String CHILD_MODEL_CORE = "core";
    String CHILD_MODEL_CLIENT = "client";
    /**
     * 子模块列表 ************************************
     */

    /**
     * 创建时间
     */
     String CREATE_TIME = "createTime";
    /**
     * 创建人
     */
     String CREATE_BY = "createBy";
    /**
     * 修改时间
     */
     String UPDATE_TIME = "updateTime";
    /**
     * 修改人
     */
     String UPDATE_BY = "updateBy";
    /**
     * 是否删除
     */
     String IS_DELETED = "isDeleted";
    /**
     * ID
     */
     String ID = "id";
    /**
     * 机构 ID
     */
     String ORG_ID = "orgId";
}
