package action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ridiculous on 2016/7/14.
 */
@Controller
public class pageAction {
    @RequestMapping("payAction")
    public ModelAndView pageAction(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        int index = Integer.parseInt(request.getParameter("index"));
        String title = null;
        String desc = null;
        switch (index) {
            case 1:
                title = "确认订购 乐游狂人包";
                desc = "乐游狂人包：订购即可获得当月推出的12款精品游戏，定期更新部分游戏，游戏使用过程中无其他信息费用。资费10元/月，次月自动续订。";
                break;
            case 2:
                title = "确认订购 超凡游戏包";
                desc = "超凡游戏包：订购即可获得当月推出的12款精品游戏，定期更新部分游戏，游戏使用过程中无其他信息费用。资费10元/月，次月自动续订。";
                break;
            case 3:
                title = "确认订购 全民游戏包";
                desc = "全民游戏包：订购即可获得当月推出的12款精品游戏，定期更新部分游戏，游戏使用过程中无其他信息费用。资费10元/月，次月自动续订。";
                break;
            case 4:
                title = "确认订购 漫漫世界动漫精品包";
                desc = "漫漫世界动漫精品包：年轻人喜好的潮流都市休闲幽默漫画，浪漫爱情、曲折情节快乐不停！资费12元/月，次月自动续订。";
                break;
            case 5:
                title = "确认订购 赏漫乐园动漫精品包";
                desc = "赏漫乐园动漫精品包：热门网络小说神印王座漫画版火爆上线，充满玄幻趣味的动漫作品让你看个过瘾！";
                break;
            default:
                return new ModelAndView("404");
        }
        view.setViewName("payment");
        System.out.println(title);
        view.addObject("title", title);
        view.addObject("desc", desc);
        return view;
    }
}
