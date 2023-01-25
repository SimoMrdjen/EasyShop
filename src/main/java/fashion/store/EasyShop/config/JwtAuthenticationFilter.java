package fashion.store.EasyShop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest httpServletRequest,
            @NotNull HttpServletResponse httpServletResponse,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = httpServletRequest.getHeader("Authorization");
        final String jwt;
        final String userName;

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        jwt = authHeader.substring(7);
        userName = jwtService.extractUserName(jwt);
    }
}
