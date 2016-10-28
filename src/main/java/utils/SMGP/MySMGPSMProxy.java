package utils.SMGP;

import com.huawei.smproxy.SMGPSMProxy ;
import com.huawei.smproxy.comm.smgp.message.SMGPDeliverMessage;
import com.huawei.smproxy.comm.smgp.message.SMGPDeliverRespMessage;
import com.huawei.smproxy.comm.smgp.message.SMGPMessage;
import com.huawei.smproxy.util.Args;

/**
 * �����·���Ϣ��Demo�ࡣ
 * ����ֱ��ʹ��SMGPSMProxy���ṩ��Send��close��getConnState����,
 * CP�н���ISMG�·��Ķ��ŵ�Ҫ���ISMG�Ͽ����ӵ�ʱ��Ҫ��
 * �õ��¼�֪ͨ��ʱ������һ���µ���̳�SMGPSMProxy������ʵ��
 * onDeliver( )��onTerminate( )��
 */

public class MySMGPSMProxy extends SMGPSMProxy
{

    public MySMGPSMProxy(Args args)
    {
        //���ø���Ĺ��캯������ɳ�ʼ���͵�¼ISMG�Ĺ��ܣ�����ʡ��
        super(args);
    }

    public SMGPMessage onDeliver(final SMGPDeliverMessage msg)
    {
        byte[] msgId = msg.getMsgId();

        //����յ�����Ϣ�����·���Ϣ�Ĵ������
        int result = 0;

        //ʵ�����Ƿ�����Ӧ��Ϣ��һ��Ҫ��
        return new SMGPDeliverRespMessage(msgId,result);
    }

    /**
     * ����InfoX�����ӱ��ж�ʱ�Ĵ���
     */
    public void OnTerminate()
    {
        System.out.println("Connection have been breaked! ");
    }
}
