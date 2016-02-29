package com.aic.paas.cres.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.cres.bean.CPcComputer;
import com.aic.paas.cres.bean.PcComputer;
import com.aic.paas.cres.bean.PcComputerTag;
import com.aic.paas.cres.peer.PcComputerPeer;
import com.aic.paas.cres.rest.PcComputerSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class PcComputerPeerImpl implements PcComputerPeer{
	
	@Autowired
	PcComputerSvc pcComputerSvc;

	public Page<PcComputer> queryPage(Integer pageNum, Integer pageSize,CPcComputer cdt, String orders) {
		return pcComputerSvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	public List<PcComputer> queryList(CPcComputer cdt, String orders) {
		return pcComputerSvc.queryList(cdt, orders);
	}

	public PcComputer queryById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		return pcComputerSvc.queryById(id);
	}

	public Long saveOrUpdate(PcComputer record) {
		return pcComputerSvc.saveOrUpdate(record);
	}

	public int removeById(Long id) {
		BinaryUtils.checkEmpty(id, "id");
		return pcComputerSvc.removeById(id);
	}

	@Override
	public List<PcComputerTag> queryComputerTagList(Long computerId,String orders) {
		return pcComputerSvc.queryComputerTagList(computerId, orders);
	}

	@Override
	public void saveComputerTags(Long computerId, List<PcComputerTag> tags) {
		pcComputerSvc.saveComputerTags(computerId, tags);
	}

	@Override
	public void removeComputerTags(Long computerId) {
		pcComputerSvc.removeComputerTags(computerId);
	}

}
