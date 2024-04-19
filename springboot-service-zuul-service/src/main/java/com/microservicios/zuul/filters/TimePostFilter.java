package com.microservicios.zuul.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TimePostFilter extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(TimePostFilter.class);

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("Entrando a filtro post"));
        Long tiempo_inicial = (Long) request.getAttribute("tiempoInicio");
        Long tiempo_final = System.currentTimeMillis();
        Long tiempo = tiempo_final - tiempo_inicial;

        log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempo.doubleValue()/1000.00));
        log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public String filterType() {
        return "post";
    }

}
