package com.cn.xm.common.utils;

import com.alibaba.fastjson.JSON;
import com.cn.xm.pojo.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
    // 序列化对象
    public static byte[] serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    // 反序列化对象
    public static Object deSerialize(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public static void main(String args[]) {
        User user = new User();
        user.setUserName("qiuwenming");
        user.setAge(10);
        byte[] bytes = SerializeUtil.serialize(user);

        User user2 = (User) SerializeUtil.deSerialize(bytes);
        System.out.println(user2);
        // fastjson
        System.out.println(JSON.toJSONString(user));

        User user3 = JSON.parseObject(JSON.toJSONString(user), User.class);
        System.out.println(user3);
    }
}
