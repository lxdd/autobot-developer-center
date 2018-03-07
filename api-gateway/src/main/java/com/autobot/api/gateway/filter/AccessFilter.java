package com.autobot.api.gateway.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.autobot.api.gateway.comom.util.AuthUtil;
import com.autobot.api.gateway.comom.util.ReqestUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * 它实现了在请求被路由之前检查 HttpServletReque江中是否有 accessToken 参数， 若有就进行路由， 若没有就拒绝 访问， 返回
 * 401 Unauthorized 错误。
 * 
 * @author li_xiaodong
 *
 */
public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	/*
	 * 过滤器的具体逻辑。 这里我们通过ctx.setSendZuulResponse(false) 令zuul过滤该请求， 不对其进行路由， 然后通过
	 * ctx.setResponseStatusCode (401)设置了其返回的错误码， 当然也可以进 一步优化我们的返回， 比如， 通
	 * 过ctx.setResponseBody(body)对返回的body内容进行编辑等
	 * 
	 * 过滤器的具体逻辑。 在该函数中， 我们可以实现自定义的过滤逻辑， 来确定 是否要拦截当前的请求， 不对其进行后续的路由， 或是在请求路由返回结果之后，
	 * 对处理结果做一些加工等
	 * 
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

		Map<String, String> headerInfoMap = ReqestUtil.getHeadersInfo(request);

		// 获取post携带数据流
		Object accessToken = request.getParameter("accessToken");
		// if (accessToken == null) {
		// log.warn("access token is empty");
		// ctx.setSendZuulResponse(false);
		// ctx.setResponseStatusCode(401);
		// return null;
		// }

		// TOP分配给应用的AppKey
		String appKey = headerInfoMap.get("app_key");
		// if (StringUtils.isEmpty(appKey)) {
		// log.warn("access appKey is empty");
		// ctx.setSendZuulResponse(false);
		// ctx.setResponseStatusCode(401);
		// return null;
		// }

		// 参数签名结果
		String signed = headerInfoMap.get("sign");
		// if (StringUtils.isEmpty(signed)) {
		// log.warn("access sign is empty");
		// ctx.setSendZuulResponse(false);
		// ctx.setResponseStatusCode(401);
		// return null;
		// }

		// 时间戳，格式为yyyy-MM-dd HH:mm:ss，时区为GMT+8，例如：2015-01-01
		// 12:00:00。API服务端允许客户端请求最大时间误差为10分钟。
		String timestamp = headerInfoMap.get("timestamp");
		// if (StringUtils.isEmpty(timestamp)) {
		// log.warn("access timestamp is empty");
		// ctx.setSendZuulResponse(false);
		// ctx.setResponseStatusCode(401);
		// return null;
		// }

		// API接口名称
		String method = headerInfoMap.get("method");
		// if (StringUtils.isEmpty(method)) {
		// log.warn("access method is empty");
		// ctx.setSendZuulResponse(false);
		// ctx.setResponseStatusCode(401);
		// return null;
		// }
		
		//TODO 1、根据APPKEY或APPCODE，拿到APP表信息; 2、如果method不为null则拿出改app对应的接口地址
		
		
		
		

		String sign = null;
		// 查出appSecret,根据APPKey.
		String appSecret = "111111";

		// 请求的 httpMethod
		String httpMethod = request.getMethod();

		if (HttpMethod.POST.name().equals(httpMethod)) {

			Map<String, Object> map = ReqestUtil.getBodyInfo(request);
			System.out.println(map);

			try {
				sign = AuthUtil.signTopRequest(map, appSecret);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (HttpMethod.PUT.name().equals(httpMethod)){

			String requestURI = request.getRequestURI();
			
			Map<String, Object> map = ReqestUtil.getBodyInfo(request);
			map.put("requestURI", requestURI);
			map.put("httpMethod", request.getMethod());

			try {
				sign = AuthUtil.signTopRequest(map, appSecret);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String requestURI = request.getRequestURI();

			Map<String, Object> map = new HashMap<>();
			map.put("requestURI", requestURI);
			map.put("httpMethod", request.getMethod());

			try {
				sign = AuthUtil.signTopRequest(map, appSecret);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 三：参数完整性sign验证
		if (!sign.equals(signed)) {
			// 记录日志step1
			log.warn("access signed sign is not same");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}

		log.info("access token ok");
		return null;
	}

	/*
	 * 判断该过滤器是否需要被执行。 这里我们直接返回了true, 因 此该过滤器对所有请求都会生效。 实际运用中我们可以利用该函数来指定过滤器的 有效范围
	 * 
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*
	 * 过滤器的执行顺序。 当请求在一个阶段中存在多个过滤器时， 需 要根据该方法返回的值来依次执行。
	 * 
	 * 通过 int 值来定义过滤器的执行顺序， 数值越小优先级越高
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/*
	 * 过滤器的类型， 它决定过滤器在请求的哪个生命周期中执行。 这里 定义为pre, 代表会在请求被路由之前执行。
	 * 
	 * 该函数需要返回一个字符串来代表过滤器的类型， 而这个类型就是 在HTTP请求过程中定义的各个阶段。在 Zuul 中默认定义了 4 种不同生命周期的过
	 * 滤器类型， 具体如下所示。 • pre: 可以在请求被路由之前调用。 • routing: 在路由请求时被调用。 • post: 在 routing 和
	 * error 过滤器之后被调用。 • error: 处理请求时发生错误时被调用。
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
