package com.cn.xm.common.utils;

import org.springframework.ui.Model;

/**
 * 
 * @author qiuwenming
 * @function 分页功能
 * 
 * @create 2016-8-15 上午11:52:38
 */
public class PageUtils {

    public static void setPageInfo(Model model, int page, int totalCount, int pageSize, String baseurl) {
        int currentPage = page + 1;
        int remainder = totalCount % pageSize;
        int totalPage = totalCount / pageSize;

        totalPage = remainder == 0 ? totalPage : totalPage + 1;

        int interval = 3;
        int showPage = 7;
        int starPage = 1;

        if (currentPage - starPage > interval) {
            starPage = currentPage - interval;
        }
        if (totalPage - currentPage < interval) {
            starPage = totalPage - 6;
        }
        if (totalPage < showPage) {
            showPage = totalPage;
            starPage = 1;
        }

        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("showPage", showPage);
        model.addAttribute("starPage", starPage);
        boolean usepage = totalPage > 1;
        model.addAttribute("usepage", usepage);
        boolean showfirst = totalPage > showPage && currentPage - 4 > 0;
        model.addAttribute("showfirst", showfirst);
        boolean showlast = totalPage > showPage && totalPage - currentPage - 3 > 0;
        model.addAttribute("showlast", showlast);
        model.addAttribute("baseurl", baseurl);
    }

}
