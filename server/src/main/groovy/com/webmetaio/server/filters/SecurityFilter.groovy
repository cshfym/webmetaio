package com.webmetaio.server.filters

import com.webmetaio.server.config.Constants
import com.webmetaio.server.config.RequestInfoExtractor
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Component
class SecurityFilter implements Filter {

  @Autowired
  Environment environment

  @Override
  void init(FilterConfig filterConfig) throws ServletException { }

  @Override
  void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request
    HttpServletResponse res = (HttpServletResponse) response

    def token = req.getHeader(Constants.X_WMIO_SECURITY_TOKEN)

    if (token && (token == environment.getProperty("auth.token"))) {
      log.info "Authentication success: ${RequestInfoExtractor.instance.extractRequestParameters(req)}"
    } else {
      log.info "Authentication failed: ${RequestInfoExtractor.instance.extractRequestParameters(req)}"
      res.sendError(HttpStatus.FORBIDDEN.value(), "Missing or invalid security token.")
      return
    }

    chain.doFilter(request, response)
  }

  @Override
  void destroy() {

  }
}
