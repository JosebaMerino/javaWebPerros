package com.ipartek.formacion.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerrosController;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST,
				DispatcherType.FORWARD,
				DispatcherType.INCLUDE,
				DispatcherType.ERROR
		}
					, urlPatterns = { "/private/*" })
public class SeguridadFilter implements Filter {


	private final static Logger LOG = Logger.getLogger(SeguridadFilter.class);

    /**
     * Default constructor.
     */
    public SeguridadFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		// Casteamos a HttpServlet
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		ServletContext sc = req.getServletContext();

		LOG.debug("RequestURL" + req.getRequestURL());
		LOG.debug("RequestURI" + req.getRequestURI());
		LOG.debug("HTTP Protocol" + req.getProtocol());
		LOG.debug("HTTP RemoteAddr" + req.getRemoteAddr());
		LOG.debug("HTTP RemoteHost" + req.getRemoteHost());

		HttpSession session =  req.getSession();

		Map<String, String[]> parametrosMap = req.getParameterMap();
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, String[]> entry : parametrosMap.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue()[0] + "&");
		    LOG.debug(entry.getKey() + "/" + entry.getValue()[0]);
		}

		//sb.delete(sb.length() - 1, sb.length());



		if (session.getAttribute("usuario") == null) {
			LOG.warn("Intentan entrar sin logearse, vamos a pillar sus datos por si acaso");

			int numAccesosIndebidos = (int) sc.getAttribute("numAccesosIndebidos");
			Set<String> IPs = (Set<String>) sc.getAttribute("IPs");

			IPs.add(req.getRemoteAddr());

			sc.setAttribute("numAccesosIndebidos", ++numAccesosIndebidos);
			sc.setAttribute("IPs", IPs);
		} else {
			chain.doFilter(request, response);
		}

		// pass the request along the filter chain

		//dejamos continuar
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("init");
		LOG.debug("inicializando valores de numAcesosIndebidos y IPs");
		// TODO Auto-generated method stub
		ServletContext sc =  fConfig.getServletContext();

		int numAccesosIndebidos = 0;
		Set<String> IPs = new HashSet<String>();

		sc.setAttribute("numAccesosIndebidos", numAccesosIndebidos);
		sc.setAttribute("IPs", IPs);

	}

}
