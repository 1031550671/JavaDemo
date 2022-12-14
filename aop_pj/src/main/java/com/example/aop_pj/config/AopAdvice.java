package com.example.aop_pj.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aop_pj.annotation.Permissions;
import com.example.aop_pj.unit.ResultUnit;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class AopAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut() {}

    @Pointcut("@annotation(com.example.aop_pj.annotation.Permissions)")
    private void permissions(){}

//    @Pointcut("@annotation(com.example.aop_pj.annotation.PermissionsTest)")
//    private void permissionsTest(){}


    @Around("permissions()")
    public Object permissionsAs(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
//        String ss = joinPoint.getKind();
        Method signature =((MethodSignature)joinPoint.getSignature()).getMethod();

        Permissions permissions = signature.getAnnotation(Permissions.class);

        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        Object sw = joinPoint.getTarget();
        Object se = joinPoint.getThis();
        Class<?> ssw = joinPoint.getClass();

        String ids = objects[0].toString();
        Field[] fields = objects[0].getClass().getDeclaredFields();
        Object clae = objects[0];
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "??????");
        map.put("pwd", "123");
        String jsonString = JSON.toJSONString(map);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(clae);

        JSONObject jsonObject = JSONObject.parseObject(s);
        String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        if (!name.equals("?????????"))
        {
//            return JSON.parseObject("{\"message\":\" \",\"code\":403}");
            return ResultUnit.success("?????????");
        }
        return joinPoint.proceed();
    }

    @Before("logAdvicePointcut()")
    public void logAdvice(JoinPoint joinPoint){
        System.out.println("get????????????????????????");
        // ????????????
        Signature signature = joinPoint.getSignature();
        // ?????????????????????
        String declaringTypeName = signature.getDeclaringTypeName();
        // ??????????????????????????????
        String funcName = signature.getName();
        log.info("?????????????????????: {}?????????{}???", funcName, declaringTypeName);

        // ????????????????????????????????????????????????????????? URL ??? IP
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // ???????????? URL
        String url = request.getRequestURL().toString();
        // ???????????? IP
        String ip = request.getRemoteAddr();
        log.info("???????????????url??????{}???ip????????????{}", url, ip);
    }

}
