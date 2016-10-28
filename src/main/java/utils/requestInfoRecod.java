package utils;

/**
 * Created by Ridiculous on 2016/5/28.
 */
public class requestInfoRecod {
    private String ip;
    private String type;
    private String spid;
    private String chargeid;
    private String phonenum;
    private String vercode;
    private long vercodecreatetime;
    private long requestcreatetime;
    private String action;
    private String productname;
    private int price;
    private String providerName;
    private int reqSeq;

    public requestInfoRecod(String ip, String type, String spid,
                            String chargeid, String productname, int price, String phonenum, String vercode,
                            long vercodecreatetime, long requestcreatetime,String action, String providerName) {
        this.ip = ip;
        this.type = type;
        this.spid = spid;
        this.chargeid = chargeid;
        this.productname = productname;
        this.price = price;
        this.phonenum = phonenum;
        this.vercode = vercode;
        this.vercodecreatetime = vercodecreatetime;
        this.requestcreatetime = requestcreatetime;
        this.action = action;
        this.providerName = providerName;
        this.reqSeq = 0;
    }

    public int getReqSeq() {
        return reqSeq;
    }
    public void setReqSeq(int reqSeq) {
        this.reqSeq = reqSeq;
    }
    public void addReqSeq() {
        this.reqSeq ++;
    }
    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getRequestcreatetime() {
        return requestcreatetime;
    }

    public void setRequestcreatetime() {
        this.requestcreatetime = vercodecreatetime;
    }

    public long getVercodecreatetime() {
        return vercodecreatetime;
    }

    public void setVercodecreatetime(long vercodecreatetime) {
        this.vercodecreatetime = vercodecreatetime;
    }

    public String getId() {
        return spid;
    }

    public void setId(String spid) {
        this.spid = spid;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public void setPhonenum(String phonenum) {

        this.phonenum = phonenum;
    }

    public String getPhonenum() {

        return phonenum;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public void setRequestcreatetime(long requestcreatetime) {
        this.requestcreatetime = requestcreatetime;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChargeid() {
        return chargeid;
    }

    public void setChargeid(String chargeid) {
        this.chargeid = chargeid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
