package action;

import com.alibaba.fastjson.JSONObject;
import entity.ChargePoint;
import entity.CpInfo;
import entity.OrderRecord;
import entity.ProductInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.chargeService;
import service.configureService;
import service.orderRecordService;
import service.productService;
import utils.Constants;
import utils.HttpRequest;
import utils.SMGP.SMGPSMProxyMethod;
import utils.Tools;
import utils.requestInfoRecod;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Ridiculous on 2016/7/14.
 */
@Controller
public class webOrderAction {
    private HashMap<String ,requestInfoRecod> recordHashMap;
    private CpInfo cpuser;
    private ProductInfo productInfo;
    private ChargePoint chargePoint;
    @Resource
    private service.configureService configureService;

    @Resource
    private service.productService productService;

    @Resource
    private service.orderRecordService orderRecordService;

    @Resource
    private service.chargeService chargeService;

    public webOrderAction() {
        recordHashMap = new HashMap<String, requestInfoRecod>();
    }

    @RequestMapping("webOrder")
    @ResponseBody
    public ModelAndView webOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        String spid = request.getParameter("spId");
        String timestamp = request.getParameter("timestamp");
        String type = request.getParameter("orderType");
        String chargeid = request.getParameter("chargeId");
        String token = request.getParameter("accessToken");

        String orderid = null;
        String productName = null;
        String remoteip = request.getRemoteHost();
        JSONObject jsonresult = new JSONObject();
        String resultCode = "";

        String url = "http://127.0.0.1:8080/ismp/serviceOrder?action=subscribe";
        String params = String.format("spId=%s&chargeId=%s&timestamp=%s&orderType=%s&accessToken=%s",
                spid,chargeid,timestamp,type,token);
        String result = HttpRequest.sendPost(url, params);
        jsonresult = JSONObject.parseObject(result);
        if (jsonresult.containsKey("orderinfo")) {
            JSONObject jsonObject = jsonresult.getJSONObject("orderinfo");
            orderid = jsonObject.getString("orderId");
            productName = jsonObject.getString("productName");
        }
        else {
            System.out.println("error");
        }
        System.out.println(orderid);
        productName = new String(productName.getBytes(),"utf-8");
        ModelAndView view = new ModelAndView();
        view.setViewName("payment");
        view.addObject("title", productName);
        view.addObject("orderId", orderid);
        return view;
    }
}
