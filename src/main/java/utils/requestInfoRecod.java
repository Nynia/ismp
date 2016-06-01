package utils;

/**
 * Created by Ridiculous on 2016/5/28.
 */
public class requestInfoRecod {
    private String ip;
    private String port;
    private String type;
    private String spid;
    private String productid;
    private String phonenum;
    private String vercode;
    private long vercodecreatetime;
    private long requestcreatetime;
    private String action;
    private String productname;
    private int price;

    public requestInfoRecod(String ip, String port, String type, String id,
                            String productid, String productname, int price, String phonenum, String vercode,
                            long vercodecreatetime, long requestcreatetime,String action) {
        this.ip = ip;
        this.port = port;
        this.type = type;
        this.spid = id;
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.phonenum = phonenum;
        this.vercode = vercode;
        this.vercodecreatetime = vercodecreatetime;
        this.requestcreatetime = requestcreatetime;
        this.action = action;
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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
