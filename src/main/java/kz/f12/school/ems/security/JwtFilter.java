package kz.f12.school.ems.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    // фильтр вызывается при каждом запросе до rest endpoints
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // берем токен
        try {
            String token = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);
            // проверяем
            if (token != null && jwtTokenProvider.checkToken(token)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                if (authentication != null) {
                    // аутентифицируем
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (AuthenticationException e) {
            // в случае ошибки очищаем контекст
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
