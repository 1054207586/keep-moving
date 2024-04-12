package com.dpi.cdhntech.partner.service;

import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.util.EntityInfoUtil;
import com.github.mybatis.fl.util.Generator;
import com.github.mybatis.fl.util.MySqlToJavaUtil;
import com.yyc.commons.util.MD5;
import org.junit.Test;

import java.sql.SQLException;

public class MybatisGenerator {
    // 基础信息：项目名、作者、版本
    public static final String PROJECT = "cscec-third";
    public static final String AUTHOR = "huangjj";   //////////////需要修改
    public static final String VERSION = "V1.0";
    // 数据库连接信息：连接URL、用户名、秘密、数据库名
    public static final String URL = "jdbc:mysql://192.168.0.98:3306/cscec-third?useUnicode=true&useSSL=false&characterEncoding=utf8";
    public static final String NAME = "root";
    public static final String PASS = "123456";
    public static final String DATABASE = "cscec-third";
    // 类名、对象名、主键字段（一般是【类名】的首字母小些）、类说明、时间
    // 表中的主键字段(默认ID)
    public static final String PRIMARY_COLUMN = "id";
    // 表名
    public static final String TABLE = "exception_deal_record";  //////////////需要修改
    // 类名描述
    public static final String CLASSCOMMENT = "第三方对接异常处理表";
    public static final String TIME = "2021年06月04日";
    public static final String AGILE = System.currentTimeMillis() + "";
    // 路径信息，分开路径方便聚合工程项目，微服务项目
    // 实体包名
    public static final String ENTITY_URL = "com.dpi.outInterface.entity";
    // mapper类包名
    public static final String DAO_URL = "com.dpi.outInterface.service.mapper";
    // mapper xml包名
    public static final String XML_URL = "com.dpi.outInterface.service.mapper";
    // service 接口包名
    public static final String SERVICE_URL = "com.dpi.outInterface.service";
    // service 实现包名
    public static final String SERVICE_IMPL_URL = "com.dpi.outInterface.service.impl";
    // controller 实现包名
    public static final String CONTROLLER_URL = "com.dpi.outInterface.service.web";
    @Test
    public void mybatisGenerator(){
        BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL,PRIMARY_COLUMN);
        bi.setTable(TABLE);
        bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
        bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
        String primaryKey = MySqlToJavaUtil.changeToJavaFiled(PRIMARY_COLUMN);
        bi.setPrimaryKey(primaryKey);
        // 主键首字母大写(Contoller等方法中会用到)
        bi.setFuPrimaryKey(primaryKey.substring(0, 1).toUpperCase() + primaryKey.substring(1));
        bi.setEntityComment(CLASSCOMMENT);
        try {
            bi = EntityInfoUtil.getInfo(bi);

            String serviceFileUrl = "H:\\ideaProject11-25\\cscec-out-interface\\cscec-out-interface-producer\\cscec-out-interface-producer-service\\src\\main\\java\\";// 生成文件存放位置

            String apiFileUrl = "H:\\ideaProject11-25\\cscec-out-interface\\cscec-out-interface-producer\\cscec-out-interface-producer-api\\src\\main\\java\\"; //////////////需要修改

            String aa1 = Generator.createEntity(apiFileUrl, bi).toString();

            String aa2 = Generator.createDao(serviceFileUrl, bi).toString();
            String aa3 = Generator.createDaoImpl(serviceFileUrl, bi).toString();
            String aa4 = Generator.createService(apiFileUrl, bi).toString();
            String aa5 = Generator.createServiceImpl(serviceFileUrl, bi).toString();
            String aa6 = Generator.createController(serviceFileUrl, bi).toString();

            // 是否创建swagger配置文件
            // String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();

            System.out.println(aa1);
            System.out.println(aa2);
            System.out.println(aa3);
            System.out.println(aa4);
            System.out.println(aa5);
            System.out.println(aa6);

            // System.out.println(aa7);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        System.out.println(MD5.encryptToMD5("sdsdsdd"));
    }
}
