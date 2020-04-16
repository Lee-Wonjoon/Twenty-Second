package fp.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/TestFilter")
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// 필터가 사라질 때 자동으로 호출 될 녀석
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 우리가 할 게 이거
		// req을 가로채서 로직을 처리하는 코드
		System.out.println("서블릿 도착 전 필터 출력");
		String id =request.getParameter("memberId");
		System.out.println(id+"님이 로그인 시도");
		
		chain.doFilter(request, response);// 실제 서블릿 동작
		//서버가 로직처리하는 기점이 체인
		// response를 가로채서 로직을 처리하는 코드
		System.out.println("서블릿 수행 후 필터 출력");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// 필터가 생성될 때 자동으로 호출될 거
	}

}
