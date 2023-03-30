package com.example.gen3.gen;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.gen3.gen.Const.*;


/**
 * 代码生成器
 *
 * @author Yi
 */
public class CodeGenerator {

    private static final String URL = "jdbc:mysql://139.155.74.96:3306/hos_dev?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zxcd!@mysql3306.1";

    public static void codeGenerator(String author, String tableNameStr, String modelName, String childModelName, String sonPath, String fileSonPath) {
        if (StringUtils.isEmpty(tableNameStr)) {
            return;
        }
        String[] tables = tableNameStr.split(",|，");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件的输出目录
        globalConfig.setOutputDir(PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName + "/src/main/java");
        //Author设置作者
        globalConfig.setAuthor(author);
        //是否覆盖文件
        globalConfig.setFileOverride(PrivateFile.FILE_OVERRIDE);
        //生成后打开文件
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        // 时间格式
        globalConfig.setDateType(DateType.TIME_PACK);
        mpg.setGlobalConfig(globalConfig);

        // 2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库类型,默认MYSQL
        dataSourceConfig.setDbType(DbType.MYSQL);
        //自定义数据类型转换
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        mpg.setDataSource(dataSourceConfig);
        // 3. 包配置
        PackageConfig pc = new PackageConfig();
        // 模块
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
//        pc.setParent(MODEL_PREFIX_DROP + modelName  + DROP +  childModelName + DROP + CGILD_PHTH);
        mpg.setPackageInfo(pc);
        /**
         * 自定义配置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                HashMap<String, Object> map = new HashMap<>();
                map.put("modelName", modelName);
                map.put("childModelName", childModelName);
                map.put("cgildPhth", PrivateFile.CGILD_PHTH);
                // client
                map.put("clientDTO", RandomUtils.nextLong());
                map.put("clientRequestDTO", RandomUtils.nextLong());
                map.put("clientRequestPageDTO", RandomUtils.nextLong());
                //core
                map.put("coreEntity", RandomUtils.nextLong());
                map.put("coreEntityBO", RandomUtils.nextLong());
                map.put("coreRequestBO", RandomUtils.nextLong());

                map.put("sonPath", sonPath);
                this.setMap(map);
            }
        };

        String coreServiceJavaTemplatePath = "/template/kzkj/core/service.java.vm";
        String coreServiceImplJavaTemplatePath = "/template/kzkj/core/serviceImpl.java.vm";
        String coreClientServiceImplJavaTemplatePath = "/template/kzkj/core/coreClientServiceImpl.java.vm";
        String coreMapperJavaTemplatePath = "/template/kzkj/core/mapper.java.vm";
        String coreXmlTemplatePath = "/template/kzkj/core/mapper.xml.vm";
        String coreModelTemplatePath = "/template/kzkj/core/entity.java.vm";
        String coreModelBoTemplatePath = "/template/kzkj/core/entityBO.java.vm";
        String coreModelRequestBoTemplatePath = "/template/kzkj/core/entityRequestBO.java.vm";
        String coreMapStructTemplatePath = "/template/kzkj/core/mapStruct/mapStruct.java.vm";

        String clientDtoTemplatePath = "/template/kzkj/client/entityDTO.java.vm";
        String clientRequestDtoTemplatePath = "/template/kzkj/client/entityRequestDTO.java.vm";
        String clientRequestPageDtoTemplatePath = "/template/kzkj/client/entityRequestPageDTO.java.vm";
        String clientServiceJavaTemplatePath = "/template/kzkj/client/service.java.vm";

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        if (CHILD_MODEL_CORE.equals(childModelName)) {
            focList.add(new FileOutConfig(coreXmlTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
                            + "/src/main/resources/mapper/"+PrivateFile.CGILD_PHTH + SLASH + fileSonPath
                            + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
//            focList.add(new FileOutConfig(coreModelTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/entity/"
//                            + fileSonPath + tableInfo.getEntityName() + "DO" + StringPool.DOT_JAVA;
//                }
//            });
            focList.add(new FileOutConfig(coreMapperJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/mapper/"
                            + fileSonPath + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
                }
            });
//            focList.add(new FileOutConfig(coreServiceJavaTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/service/"
//                            + fileSonPath + "I"+ tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
//                }
//            });
            focList.add(new FileOutConfig(coreServiceImplJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/service/"
                            + fileSonPath + "impl/"+ tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
                }
//            });
//            focList.add(new FileOutConfig(coreModelBoTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/bo/"
//                            + fileSonPath + tableInfo.getEntityName() + "BO" + StringPool.DOT_JAVA;
//                }
//            });
//            focList.add(new FileOutConfig(coreModelRequestBoTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/bo/"
//                            + fileSonPath + tableInfo.getEntityName() + "RequestBO" + StringPool.DOT_JAVA;
//                }
//            });
//            focList.add(new FileOutConfig(coreMapStructTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/convert/"
//                            + fileSonPath + tableInfo.getEntityName() + "Struct" + StringPool.DOT_JAVA;
//                }
//            });
//            focList.add(new FileOutConfig(coreClientServiceImplJavaTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName + SLASH + PrivateFile.CGILD_PHTH + SLASH + "/impl/"
//                            + fileSonPath + tableInfo.getEntityName() + "ApiServiceImpl" + StringPool.DOT_JAVA;
//                }
            });
        }
//        if (CHILD_MODEL_CLIENT.equals(childModelName)) {
//            focList.add(new FileOutConfig(clientDtoTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName +SLASH + PrivateFile.CGILD_PHTH + SLASH + "dto/"
//                            + fileSonPath + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
//                }
//            });
//            focList.add(new FileOutConfig(clientRequestDtoTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName +SLASH + PrivateFile.CGILD_PHTH + SLASH + "dto/"
//                            + fileSonPath + tableInfo.getEntityName() + "RequestDTO" + StringPool.DOT_JAVA;
//                }
//            });
//            focList.add(new FileOutConfig(clientRequestPageDtoTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName +SLASH + PrivateFile.CGILD_PHTH + SLASH + "dto/"
//                            + fileSonPath + tableInfo.getEntityName() + "PageRequestDTO" + StringPool.DOT_JAVA;
//                }
//            });
//            focList.add(new FileOutConfig(clientServiceJavaTemplatePath) {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + modelName + SLASH + MODEL_PREFIX + modelName + "-" + childModelName
//                            + "/src/main/java/com/ideal/hos/" + modelName + "/" + childModelName +SLASH + PrivateFile.CGILD_PHTH + SLASH + "service/"
//                            + fileSonPath + "I" + tableInfo.getEntityName() + "ApiService" + StringPool.DOT_JAVA;
//                }
//            });
//        }
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setMapper(null);
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        //设置命名格式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tables);
        //实体是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //设置自定义继承的Entity类全称，带包名
        //strategy.setSuperEntityClass("com.jiangfeixiang.mpdemo.BaseEntity");
        //设置自定义继承的Controller类全称，带包名
        //strategy.setSuperControllerClass("com.jiangfeixiang.mpdemo.BaseController");
        //设置自定义基础的Entity类，公共字段
//        strategy.setSuperEntityColumns("id");

        strategy.setSuperServiceClass(IService.class);
        strategy.setSuperServiceImplClass(ServiceImpl.class);
        strategy.setSuperMapperClass("BaseMapper");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setSuperEntityClass("com.ideal.hos."+modelName+".core.sys.entity.BaseEntity");
//        strategy.setSuperEntityColumns("createTime");
        //表名前缀
        strategy.setTablePrefix(PrivateFile.TABLE_PREFIX);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    public static void codeGeneratorSib(String author, String tableNameStr, String modelName, String modelNameTwo, String sonPath, String fileSonPath) {
        if (StringUtils.isEmpty(tableNameStr)) {
            return;
        }
        String[] tables = tableNameStr.split(",|，");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件的输出目录
        globalConfig.setOutputDir(PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + SLASH + MODEL_SIB + "/src/main/java");
        //Author设置作者
        globalConfig.setAuthor(author);
        //是否覆盖文件
        globalConfig.setFileOverride(PrivateFile.FILE_OVERRIDE);
        //生成后打开文件
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        // 时间格式
        globalConfig.setDateType(DateType.TIME_PACK);
        mpg.setGlobalConfig(globalConfig);

        // 2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库类型,默认MYSQL
        dataSourceConfig.setDbType(DbType.MYSQL);
        //自定义数据类型转换
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        mpg.setDataSource(dataSourceConfig);
        // 3. 包配置
        PackageConfig pc = new PackageConfig();
        // 模块
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent(MODEL_PREFIX_DROP + MODEL_SIB);
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);
        /**
         * 自定义配置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                HashMap<String, Object> map = new HashMap<>();
                map.put("modelName", modelName);
                map.put("childModelName", modelNameTwo);
                map.put("cgildPhth", PrivateFile.CGILD_PHTH);
                map.put("param", RandomUtils.nextLong());
                map.put("paramPage", RandomUtils.nextLong());
                map.put("vo", RandomUtils.nextLong());

                map.put("sonPath", sonPath);
                this.setMap(map);
            }
        };

        /**
         * 模板
         */

        // sib 服务入参模板
        String paramTemplatePath = "/template/kzkj/sib/param.java.vm";
        String paramPageTemplatePath = "/template/kzkj/sib/paramPage.java.vm";
        // sib 服务控制层
        String sibControllerJavaTemplatePath = "/template/kzkj/sib/controller.java.vm";
        String sibServiceJavaTemplatePath = "/template/kzkj/sib/sibService.java.vm";
        String sibServiceImplJavaTemplatePath = "/template/kzkj/sib/sibServiceImpl.java.vm";
        String sibVoJavaTemplatePath = "/template/kzkj/sib/entityVO.java.vm";
        String mapStructJavaTemplatePath = "/template/kzkj/sib/mapStruct/mapStruct.java.vm";


        String serviceJavaTemplatePath = "/template/kzkj/core/service.java.vm";
        String interfaceJavaTemplatePath = "/template/interface.java.vm";
        String serviceImplJavaTemplatePath = "/template/kzkj/core/serviceImpl.java.vm";
        String mapperJavaTemplatePath = "/template/kzkj/core/mapper.java.vm";
        String xmlTemplatePath = "/template/kzkj/core/mapper.xml.vm";
        String modelTemplatePath = "/template/kzkj/core/entity.java.vm";
        String dtoTemplatePath = "/template/kzkj/client/entityDTO.java.vm";
        String voTemplatePath = "/template/entityVO.java.vm";
        String listVoTemplatePath = "/template/entityListVO.java.vm";
        String boTemplatePath = "/template/entityBO.java.vm";
        String pageRequestTemplatePath = "/template/entityPageRequest.java.vm";
        String listRequestTemplatePath = "/template/entityListRequest.java.vm";
        String requestTemplatePath = "/template/entityRequest.java.vm";

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        if (modelName.equals(MODEL_SIB)) {
            focList.add(new FileOutConfig(paramTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                             + "param/" + fileSonPath + tableInfo.getEntityName() + "Param" + StringPool.DOT_JAVA;
                }
            });
            focList.add(new FileOutConfig(paramPageTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                            + "param/" + fileSonPath + tableInfo.getEntityName() + "PageParam" + StringPool.DOT_JAVA;
                }
            });
            focList.add(new FileOutConfig(mapStructJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                            + "convert/" + fileSonPath + tableInfo.getEntityName() + "Convert" + StringPool.DOT_JAVA;
                }
            });
            focList.add(new FileOutConfig(sibControllerJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                            + "controller/" + fileSonPath + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
                }
            });

            focList.add(new FileOutConfig(sibServiceJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                            + "service/" + fileSonPath + tableInfo.getEntityName() + "SibService" + StringPool.DOT_JAVA;
                }
            });

            focList.add(new FileOutConfig(sibServiceImplJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                            + "service/" + fileSonPath + "impl/" + tableInfo.getEntityName() + "SibServiceImpl" + StringPool.DOT_JAVA;
                }
            });

            focList.add(new FileOutConfig(sibVoJavaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return PrivateFile.PROJECT_PATH + SLASH + MODEL_PREFIX + MODEL_SIB + "/src/main/java/com/ideal/hos/"
                            + MODEL_SIB + SLASH + modelNameTwo + SLASH + PrivateFile.CGILD_PHTH + SLASH
                            + "vo/" + fileSonPath + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
                }
            });
        }
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setMapper(null);
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        //设置命名格式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tables);
        //实体是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //设置自定义继承的Entity类全称，带包名
        //strategy.setSuperEntityClass("com.jiangfeixiang.mpdemo.BaseEntity");
        //设置自定义继承的Controller类全称，带包名
        //strategy.setSuperControllerClass("com.jiangfeixiang.mpdemo.BaseController");
        //设置自定义基础的Entity类，公共字段
//        strategy.setSuperEntityColumns("id");

        strategy.setSuperServiceClass(IService.class);
        strategy.setSuperServiceImplClass(ServiceImpl.class);
        strategy.setSuperMapperClass("BaseMapper");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setSuperEntityClass("com.ideal.hos."+modelName+".core.entity.base.BaseEntity");
//        strategy.setSuperEntityColumns("createTime");
        //表名前缀
        strategy.setTablePrefix(PrivateFile.TABLE_PREFIX);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();

    }
}
