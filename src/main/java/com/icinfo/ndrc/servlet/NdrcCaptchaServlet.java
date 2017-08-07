package com.icinfo.ndrc.servlet;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icinfo.ndrc.support.Constants;
import com.icinfo.framework.captcha.color.SingleColorFactory;
import com.icinfo.framework.captcha.filter.predefined.RippleFilterFactory;
import com.icinfo.framework.captcha.font.RandomFontFactory;
import com.icinfo.framework.captcha.service.Captcha;
import com.icinfo.framework.captcha.service.ConfigurableCaptchaService;
import com.icinfo.framework.mybatis.pagehelper.Constant;
import com.icinfo.framework.tools.utils.StringUtils;
/**
 * ndrc项目验证码
 * 
 * @author zhuyong
 */
@WebServlet(urlPatterns = {"/ndrcCaptcha"})
public class NdrcCaptchaServlet extends HttpServlet{
    private static String sessionKey = Constants.SESSION_NDRC_VALIDATE_KEY;

    /**
     * 获取SessionKey
     *
     * @return
     */
    public static String getSessionKey() {
        return sessionKey;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String customSessionKey = config.getInitParameter("sessionKey");
        if (StringUtils.isNotEmpty(customSessionKey)) {
            sessionKey = customSessionKey;
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(34, 139, 34)));
        //带曲线
        //cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        //不带曲线
        cs.setFilterFactory(new RippleFilterFactory());
        //默认宽度、高度
        cs.setWidth(100);
        cs.setHeight(40);

        //默认字体大小
        RandomFontFactory rff = new RandomFontFactory();
        rff.setMinSize(30);
        rff.setMaxSize(36);
        cs.setFontFactory(rff);

        //获取session
        HttpSession session = request.getSession();

        //输出验证码PNG格式图片
        Captcha captcha = cs.getCaptcha();
        response.setHeader("content-type", "image/png");
        ImageIO.write(captcha.getImage(), "png", response.getOutputStream());

        //保存验证码到session
        session.setAttribute(sessionKey, captcha.getChallenge());
    }
}
