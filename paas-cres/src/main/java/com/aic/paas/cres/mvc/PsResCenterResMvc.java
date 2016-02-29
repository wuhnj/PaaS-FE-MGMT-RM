package com.aic.paas.cres.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.cres.bean.CPsResCenterRes;
import com.aic.paas.cres.bean.CPsResFlow;
import com.aic.paas.cres.bean.PsResCenterRes;
import com.aic.paas.cres.bean.PsResFlow;
import com.aic.paas.cres.peer.PsResCenterResPeer;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;

@Controller
@RequestMapping("/res/rescres")
public class PsResCenterResMvc {
	
	@Autowired
	PsResCenterResPeer centerResPeer;
	
	@RequestMapping("/queryResPage")
	public void queryResPage(HttpServletRequest request, HttpServletResponse response,Integer pageNum, Integer pageSize, CPsResCenterRes cdt, String orders) {
		Page<PsResCenterRes> page = centerResPeer.queryResPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	@RequestMapping("/queryResById")
	public void queryResById(HttpServletRequest request, HttpServletResponse response,Long id) {
		PsResCenterRes p = centerResPeer.queryResById(id);
		ControllerUtils.returnJson(request, response, p);
	}
	
	@RequestMapping("/queryFlowPage")
	public void queryResPage(HttpServletRequest request, HttpServletResponse response,Integer pageNum, Integer pageSize, CPsResFlow cdt, String orders) {
		Page<PsResFlow> page = centerResPeer.queryFlowPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	@RequestMapping("/queryFlowById")
	public void queryFlowById(HttpServletRequest request, HttpServletResponse response,Long id) {
		PsResFlow p = centerResPeer.queryFlowById(id);
		ControllerUtils.returnJson(request, response, p);
	}

}
