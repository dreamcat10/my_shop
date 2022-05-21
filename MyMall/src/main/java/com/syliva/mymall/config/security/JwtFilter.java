package com.syliva.mymall.config.security;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syliva.mymall.utils.HttpContextUtil;
import com.syliva.mymall.utils.Result;
import com.syliva.mymall.utils.TokenUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;


import org.apache.shiro.web.filter.authc.AuthenticatingFilter;;
import org.springframework.stereotype.Component;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
public class JwtFilter extends AuthenticatingFilter {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();



    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求的token 先从请求头中获取，如果没有再从参数中获取
        String token = TokenUtil.getRequestToken((HttpServletRequest) request);

       return new AuthToken(token);
    }



    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //获取请求的token
        String token = TokenUtil.getRequestToken((HttpServletRequest) request);
        //判断token是否存在，如果没有直接返回
        if (StringUtils.isBlank(token)){
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            //允许客户端携带验证信息
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            //允许特定的域名访问。
            httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
            httpResponse.setCharacterEncoding("UTF-8");
            Result result = Result.fail(400, "请先登录");
            String json = MAPPER.writeValueAsString(result);
            httpResponse.getWriter().print(json);
            return false;
        }
        //执行登录
        return executeLogin(request, response);

    }

    //token失效时调用
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        httpResponse.setCharacterEncoding("UTF-8");
        try {
            //处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            Result result = Result.fail(400,throwable.getMessage());
            String json = MAPPER.writeValueAsString(result);
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
        }
        return false;

    }
}
