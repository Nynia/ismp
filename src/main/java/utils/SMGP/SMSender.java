package utils.SMGP;

import java.util.*;
import java.sql.*;
import java.io.*;
import com.huawei.smproxy.SMGPSMProxy;
import com.huawei.smproxy.comm.smgp.*;
import com.huawei.smproxy.comm.smgp.message.*;
import com.huawei.smproxy.util.*;

/**
 * <p>Web���Ͷ���Ϣ��������࣬���帺��ҳ���ύ�Ķ���Ϣ���͵�infoX</p>
 */

public class SMSender extends SMGPSMProxy
{
    //ϵͳ������Ϣ
    private static Args arg = Env.getConfig().getArgs("SMGPConnect");

    private static SMSender instance;

    public static SMSender getInstance()
    {
        if (instance==null)
        {
            instance = new SMSender();
        }
        return instance;
    }

    protected SMSender()
    {
        super(SMSender.arg);
    }

    /**
     * ����InfoX�����ӱ��ж�ʱ�Ĵ���
     */
    public void OnTerminate()
    {
        System.out.println("Connection have been breaked! ");
    }
    /**
     * ��SMGW�����·�����Ϣ�Ĵ���������ֻ����һ���ɹ�����Ӧ��
     * @param msg �յ�����Ϣ��
     * @return ���ص���Ӧ��Ϣ��
     */
    public SMGPMessage onDeliver(final SMGPDeliverMessage msg)
    {
		if (msg.getIsReport() == 1)
		{
			System.out.println("Get a report message. " + msg.toString());
			return new SMGPDeliverRespMessage(msg.getMsgId(), 0);
		}
		else
		{
			System.out.println("Get a deliver message. "+msg.toString());
			return new SMGPDeliverRespMessage(msg.getMsgId(), 0);
		}
    }

    /**
     * ����һ����Ϣ�������������Ϣ���͡�
     * @param msg �����͵���Ϣ��
     * @return true�����ͳɹ���false������ʧ�ܡ�
     */
    public boolean send(SMGPSubmitMessage msg) {
      if ( msg == null ) {
        return false;
      }
      SMGPSubmitRespMessage reportMsg = null;
      PreparedStatement stat = null;
      try {
          reportMsg = (SMGPSubmitRespMessage)super.send(msg);
      }
      catch (IOException ex) {
        ex.printStackTrace();
        return false;
      }
      return true;
    }
}
