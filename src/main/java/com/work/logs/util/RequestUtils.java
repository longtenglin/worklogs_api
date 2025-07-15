package com.work.logs.util;

import java.lang.reflect.Field;
import java.util.Iterator;

import com.work.logs.exception.LtlJsonToEntityException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import static com.work.logs.constant.ResponseConst.CODE_ERROR_9001;

@Slf4j
public class RequestUtils<T> {

    public static <T> T toEntity(JSONObject obj, Class<T> tClass) throws LtlJsonToEntityException {
        try {
            T entity = tClass.getDeclaredConstructor().newInstance();

            for (Iterator<String> it = obj.keys(); it.hasNext(); ) {
                String key = it.next();
                Field field = tClass.getDeclaredField(key);
                field.setAccessible(true);
                field.set(key, obj.get(key));
            }

            return entity;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new LtlJsonToEntityException(CODE_ERROR_9001, "Json类型向数据库映射类转换时出错");
        }
    }
}
