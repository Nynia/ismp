package utils.SMGP;

import java.util.*;
import java.sql.*;
import java.io.*;
import com.huawei.smproxy.SMGPSMProxy;
import com.huawei.smproxy.comm.smgp.*;
import com.huawei.smproxy.comm.smgp.message.*;
import com.huawei.smproxy.util.*;

public class SMReceiver extends SMGPSMProxy
        implements Runnable{
  //ϵͳ������Ϣ
  private static Args arg = Env.getConfig().getArgs("SMGPConnect");

  private static Thread instance;

  public static Thread getInstance() {
    if (instance == null) {
      instance = new Thread(new SMReceiver());
    }
    return instance;
  }

  protected SMReceiver() {
    super(SMReceiver.arg);
  }

  /**
   * ������ֹ�Ĵ�����APIʹ����ʵ��
   * ��������������ֹ����Ҫִ�ж����Ľӿ�
   */
  public void OnTerminate() {
    System.out.println("Connection have been breaked! ");
  }

  /**
   * ��SMGW�����·�����Ϣ�Ĵ���ӿڡ�������ֻ����һ���ɹ�����Ӧ��
   * @param msg �յ�����Ϣ��
   * @return ���ص���Ӧ��Ϣ��
   */
  public SMGPMessage onDeliver(final SMGPDeliverMessage msg) {

    if(msg.getIsReport() != 1){
      System.out.println("\n**************************Received a new message!***************************");
      System.out.println(msg.toString());
      System.out.println("The Sender is: " + msg.getSrcTermID());
      System.out.println("***************************End new message! **************************\n");
/*
      String[] rcvMobile = new String[1];
      rcvMobile[0] = msg.getSrcTermID();

      //����һ��CNGP�ظ���Ϣ
      System.out.print("Create new reply...\n");

      CNGPSubmitMessage reply = new CNGPSubmitMessage(
          "3001999995", //spid
          1, //subtype
          1, //needReport,
          3, //priority
          "+xkx", //serviceId
          "01", //FeeType
          0, //FeeUserType
          "000000", //FeeCode
          15, //msgFormat
          null,
          null, //��ʱ����ʱ��(null:��������)
          "94005", //srcTermId
          "94005", //ChargeTermId
          1, //destTermIdCount
          rcvMobile, //destTermId
          16, //msgLength
          "��ã�ллʹ�ã�", //msgmsgContent
          0 //protocolValue
          );

      if (send(reply)) {
        System.out.println("\nThe reply send OK!\n");
      }
      else {
        System.out.println("\nThe reply send Fail!\n");
      }
*/
    }else{
      System.out.println("\n++++++++++++++++++++++++++Received a new report!+++++++++++++++++++++++++");
      System.out.println(msg.toString());
      System.out.println("++++++++++++++++++++++++++End a new report!+++++++++++++++++++++++++\n");
    }
    return new SMGPDeliverRespMessage(msg.getMsgId(), 0);
  }

  /**
   * ��װ�����send()����
   * ����һ����Ϣ�������������Ϣ���͡�
   * @param msg �����͵���Ϣ��
   * @return true�����ͳɹ���false������ʧ�ܡ�
   */
  /*
  public boolean send(CNGPSubmitMessage msg) {
    if (msg == null) {
      return false;
    }
    CNGPSubmitRespMessage reportMsg = null;
    PreparedStatement stat = null;
    try {
      reportMsg = (CNGPSubmitRespMessage)super.send(msg);
      //System.out.println("����״̬:  " + reportMsg.toString());
    }
    catch (IOException ex) {
      ex.printStackTrace();
      return false;
    }catch (java.lang.NullPointerException e) {
      return false;
    }
    return true;
  }*/
  public boolean send(SMGPSubmitMessage msg) {
    if (msg == null) {
      return false;
    }
    try{
      super.send(msg);
    }catch(IOException e){
    }
    return true;
  }

  public void run(){
    while(true){
      try {
        Thread.sleep(500);
      }
      catch (Exception ex) {}
    }
  }

  //������������
  public static void main(String[] args) {
    //����100�����ն��ŵ��ֻ�����

    //������Ϣ(���Ͷ��)
    Thread receiver = SMReceiver.getInstance();
    receiver.start();
  }

}
