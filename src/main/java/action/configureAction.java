package action;

import entity.CpInfo;
import entity.ProductInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.configureService;
import service.productService;

import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ridiculous on 2016/5/27.
 */
@Controller
@RequestMapping("/Configure")
public class configureAction {

    @Resource
    private configureService service;

    @Resource
    private productService productService;

    @RequestMapping("getAllCpUsers")
    @ResponseBody
    public List<CpInfo> getAllCpUsers() {
        List<CpInfo> cp_list = service.getAllCpUser();
        return cp_list;
    }

    @RequestMapping("addCpUser")
    @ResponseBody
    public String addCpUser(HttpServletRequest request) {
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String id = request.getParameter("id");
        String ip = request.getParameter("ip");
        if (name == null || id == null) {
            return "params error";
        } else if (level == null) {
            level = "2";
        }
//        List<CpInfo> cp_list = service.getAllCpUser();
//        for (int i = 0; i < cp_list.size(); i++) {
//            if (cp_list.get(i).getId() == Integer.parseInt(id)) {
//                return "spid exists";
//            }
//        }
        String secret = utils.Tools.genSecret(id);
        CpInfo cpInfo = new CpInfo(Integer.parseInt(id), name, new Byte(level), secret, ip);
        service.addCpUser(cpInfo);
        return name;
    }
    @RequestMapping("getProduct")
    @ResponseBody
    public String getProduct(HttpServletRequest request) {
        String id = request.getParameter("id");
        ProductInfo productInfo = productService.getProductByProductId(id);
        return productInfo.getProductName();
    }
    @RequestMapping(value = "changePrivilege", method = {RequestMethod.POST})
    @ResponseBody
    public void changePrivilege(HttpServletRequest request) {
        CpInfo cpInfo = service.getUserbyId(1912);
        if (cpInfo.getLevel() == 1) {
            service.updatePrivilegebyId(1912, (byte) 2);
        }
        else {
            service.updatePrivilegebyId(1912, (byte) 1);
        }
    }
}
