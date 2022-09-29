package com.example.aop_pj.unit;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Generator {

    public static void main(String[] args) {


        generator();

    }

    public static String[] tables = {"sports_merchant","sports_basic_questionnaire_header","sports_questionnaire_module","sprots_module_question"
            ,"sprot_question_option","sports_question_risk_factor","sprot_risk_element","sports_risk_option","sport_risk_factor"};

    public static void generator()
    {
//1. 全局配置
        GlobalConfig config = new GlobalConfig();
        // 是否支持AR模式
        config.setActiveRecord(true)
                // 作者
                .setAuthor("pj")
                // 生成路径，最好使用绝对路径，window路径是不一样的
                //TODO  TODO  TODO  TODO
                .setOutputDir("D:\\项目群\\生成代码\\test")
                // 文件覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                // 设置生成的service接口的名字的首字母是否为I，默认Service是以I开头的
                .setServiceName("%sService")
                //实体类结尾名称
                .setEntityName("%sDO")
                //生成基本的resultMap
                .setBaseResultMap(true)
                //不使用AR模式
                .setActiveRecord(false)
                //生成基本的SQL片段
                .setBaseColumnList(true);
        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        // 设置数据库类型
        dsConfig.setDbType(DbType.POSTGRE_SQL)
                .setDriverName("org.postgresql.Driver")
                //TODO  TODO  TODO  TODO
                .setUrl("jdbc:postgresql://172.20.3.2:5432/sports_dev")
                .setUsername("postgres")
                .setPassword("YTyjy2018@");
        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //全局大写命名
        stConfig.setCapitalMode(true)
                // 数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //使用lombok
                .setEntityLombokModel(true)
                //使用restcontroller注解
                .setRestControllerStyle(true)
                // 生成的表, 支持多表一起生成，以数组形式填写
                //TODO  TODO  TODO  TODO 两个方式，直接写，或者使用命令行输入
                .setInclude(tables);
//                .setInclude(scanner("pl_user").split(","));
        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.example.aop_pj")
                .setMapper("mapper").setService("service").setController("controller").setEntity("model").setXml("mapper");
        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig)
                .execute();
        //6. 执行操作.execute();
        System.out.println("======= 相关代码生成完毕  ========");
    }

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
