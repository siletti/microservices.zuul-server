package com.siletti.microservices.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        // when filter ? before: "pre" / after "post" / on "error"
        return "pre";
    }

    @Override
    public int filterOrder() {
        // order among various zuul filters, as logging, security etc
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // execute filter for every request
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {}  request URI -> {}",
                request,
                request.getRequestURI());



        return null;
    }
}
