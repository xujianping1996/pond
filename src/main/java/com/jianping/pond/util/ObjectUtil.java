package com.jianping.pond.util;

import com.jianping.pond.exception.SysException;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 对象序列化和反序列化工具
 */
public class ObjectUtil {

        /**
         * 判断对象是否为空
         */
        @SuppressWarnings("rawtypes")
        public static boolean isEmpty(Object o) {
            if (o == null) {
                return true;
            } else if (o instanceof String) {
                String s = (String) o;
                if ("".equals(s.trim())) {
                    return true;
                } else {
                    return false;
                }
            } else if (o instanceof Collection) {
                return ((Collection) o).isEmpty();
            } else if (o instanceof Map) {
                return ((Map) o).isEmpty();
            } else if (o.getClass().isArray()) {
                return Array.getLength(o) == 0;
            } else {
                return false;
            }
        }

        /**
         * 将对象序列化
         */
        public static byte[] serialize(Object o) throws SysException {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                oos = new ObjectOutputStream(baos);
                oos.writeObject(o);
            } catch (IOException e) {
                e.printStackTrace();
                throw new SysException(e.getMessage());
            } finally {
                closeObjectOutputStream(oos);
            }
            return baos.toByteArray();
        }

        /**
         * 将对象反序列化
         */
        public static Object unSerialize(byte[] byteArr) throws SysException {
            ObjectInputStream ois = null;
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArr);
            Object o = null;
            try {
                ois = new ObjectInputStream(bais);
                o = ois.readObject();
            } catch (Exception e) {
                throw new SysException(e.getMessage());
            } finally {
                closeObjectIutputStream(ois);
            }
            return o;
        }

        /**
         * 关闭对象输出流
         */
        private static void closeObjectOutputStream(ObjectOutputStream oos) throws SysException {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new SysException(e.getMessage());
                }
            }
            oos = null;
        }

        /**
         * 关闭对象输入流
         */
        private static void closeObjectIutputStream(ObjectInputStream ois) throws SysException {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new SysException(e.getMessage());
                }
            }
            ois = null;
        }

}
