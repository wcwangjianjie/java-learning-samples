package com.wjj.base;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-08-14 12:51
 * @discription 类说明：
 */
public class EncodeAndDecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String keywords = "西侧紧邻兰锦路，北侧紧邻天屹路，南侧和东侧靠山";
        System.out.println(URLEncoder.encode(URLEncoder.encode(keywords, "utf-8"), "utf-8"));
    }
}
