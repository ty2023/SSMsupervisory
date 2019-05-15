package com.yj.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yj.entity.Page;
import com.yj.service.IBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @User 29029
 * @Time 19:57
 */
public abstract class BaseController<T> {
    private Class<T> entityClass;

    /**
     * 实体类名并且首字母小写
     */
    private String entityName;

    /**
     * 子类上RequsetMapping中Values的值
     */
    private String mappingName;

    public BaseController(){
        // 1.返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        ParameterizedType types = (ParameterizedType) this.getClass().getGenericSuperclass();

        // 2.返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] actualTypeArguments = types.getActualTypeArguments();

        // 3.从数组中获取对对应的类型
        entityClass = (Class<T>) actualTypeArguments[0];

        // 4.把类名转小写
        entityName = entityClass.getSimpleName().toLowerCase();

        // 6.先获取@RequestMapping注解
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);
        //将值赋给namesapce
        mappingName=requestMapping.value()[0];
    }

    protected abstract IBaseService<T> getBaseService();

    @RequestMapping("/getPage")
    public String getPage(T t, Page<T> page, ModelMap map){
        PageInfo<T> pageInfo=getBaseService().getPage(page,t);
        map.put("page",pageInfo);
        map.put("url",getPageUrl(t));
        return entityName+"/"+entityName+"_Show";
    }

    public String getPageUrl(T t){
        StringBuffer buffer = new StringBuffer(mappingName+"/getPage?");
        Field[] dFields = t.getClass().getDeclaredFields();
        for(int i=0;i<dFields.length;i++){
            Field field = dFields[i];
            field.setAccessible(true);
            try {
                // 获取属性
                Object value = field.get(t);
                if(value != null){
                    buffer.append(field.getName()+"="+value+"&");
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    @RequestMapping(value = "/doDelete", produces = "text/html;charset=utf8")
    @ResponseBody
    public String doDelete(Integer id){
        Integer state = getBaseService().doDelete(id);
        return rep(state);
    }

    @RequestMapping(value = "/doUpdate",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String doUpdate(T t){
        Integer state = getBaseService().doUpdate(t);
        return rep(state);
    }

    public String rep(int flag){
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag > 0) {
            // 添加成功
            map.put("flag", true);
            map.put("msg", "操作成功");
        } else {
            // 操作失败
            map.put("flag", false);
            map.put("msg", "操作失败");
        }
        return new Gson().toJson(map);
    }
}
