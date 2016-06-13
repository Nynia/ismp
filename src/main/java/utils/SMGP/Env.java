package utils.SMGP;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import java.lang.reflect.*;

import com.huawei.smproxy.util.*;
/**
 * �ṩϵͳ���л�����Ϣ��
 */
public class Env {

  /** ���ö�д�ࡣ*/
  static Cfg config;

 /**��Ϣ������*/
  static Cfg msgConfig;

  /** ��Դ�ļ���д�ࡣ*/
  static Resource resource;

  /**
   * ȡ�����ö�д�ࡣ
   */
  public static Cfg getConfig() {

    if (config == null) {
      try {
        config = new Cfg("config.xml");
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return config;
  }

  /**
   * ȡ����Ϣ�����ࡣ
   */
  public static Cfg getMsgConfig() {

    //���δ��ʼ������˵��ϵͳ�����ڰ�װ�����У������õĶ�ȡ
    if (msgConfig == null) {
      try {
        msgConfig = new Cfg("message.xml");
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return msgConfig;
  }

  /**
   * ȡ����Դ��ȡ�ࡣ
   */
  public static Resource getResource() {
    if (resource == null) {
      try {
        resource = new Resource("resource");
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return resource;
  }
}
