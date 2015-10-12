package com.webmetaio.matrix.filters

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse


@Slf4j
@Component
class HttpRequestLoggingFilter implements Filter {

  @Override
  void init(FilterConfig filterConfig) throws ServletException { }

  @Override
  void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    chain.doFilter(request, response)
  }

  @Override
  void destroy() { }

}
