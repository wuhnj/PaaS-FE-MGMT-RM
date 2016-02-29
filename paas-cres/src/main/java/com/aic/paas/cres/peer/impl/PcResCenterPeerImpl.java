package com.aic.paas.cres.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.cres.bean.CPcResCenter;
import com.aic.paas.cres.bean.PcResCenter;
import com.aic.paas.cres.bean.PcResCenterInfo;
import com.aic.paas.cres.peer.PcResCenterPeer;
import com.aic.paas.cres.rest.PcResCenterSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class PcResCenterPeerImpl implements PcResCenterPeer{
	
	@Autowired
	PcResCenterSvc pcResCenterSvc;

	public Page<PcResCenter> queryPage(Integer pageNum, Integer pageSize,CPcResCenter cdt, String orders) {
		return pcResCenterSvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	public List<PcResCenter> queryList(CPcResCenter cdt, String orders) {
		return pcResCenterSvc.queryList(cdt, orders);
	}

	public PcResCenter queryById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		return pcResCenterSvc.queryById(id);
	}
	
	
	@Override
	public Page<PcResCenterInfo> queryInfoPage(Integer pageNum, Integer pageSize, CPcResCenter cdt, String orders) {
		return pcResCenterSvc.queryInfoPage(pageNum, pageSize, cdt, orders);
	}

	
	@Override
	public List<PcResCenterInfo> queryInfoList(CPcResCenter cdt, String orders) {
		return pcResCenterSvc.queryInfoList(cdt, orders);
	}

	
	
	@Override
	public PcResCenterInfo queryInfoById(Long id) {
		return pcResCenterSvc.queryInfoById(id);
	}
	

	
	public Long saveOrUpdate(PcResCenter record) {
		BinaryUtils.checkEmpty(record, "record");
		
		if(record.getId() == null) {
			BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			BinaryUtils.checkEmpty(record.getResCode(), "record.resCode");
			BinaryUtils.checkEmpty(record.getResName(), "record.resName");
			BinaryUtils.checkEmpty(record.getEnvType(), "record.envType");
		}else {
			if(record.getDataCenterId()!=null) BinaryUtils.checkEmpty(record.getDataCenterId(), "record.dataCenterId");
			if(record.getResCode()!=null) BinaryUtils.checkEmpty(record.getResCode(), "record.resCode");
			if(record.getResName()!=null) BinaryUtils.checkEmpty(record.getResName(), "record.resName");
			if(record.getEnvType()!=null) BinaryUtils.checkEmpty(record.getEnvType(), "record.envType");
		}
		
		return pcResCenterSvc.saveOrUpdate(record);
	}

	public int removeById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		return pcResCenterSvc.removeById(id);
	}

	

}
