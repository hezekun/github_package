package com.zhisen.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PersonImpl {

//	public Map<String, Object> findGroupTreeByPersonId(int personId) {
//		Map<String,Object> result = new HashMap<String, Object>();
//		SqlSession session = ServiceUtil.getSession();
//		GroupDao groupDao= session.getMapper(GroupDao.class);
//		//查询指定的根节点
//		Group parentNode = groupDao.findGroupByPersonId(personId);
//		result  = this.coverGroupToMap(parentNode);
//		//查询所有的节点
//		List<Group> allNode  = groupDao.findAllGroup();
//		//拼接树结构
//		this.makeTree(result, allNode);
//		return result;
//	}
//
//	private void makeTree(Map<String,Object> parentNode,List<Group> allNode) {
//		if(!parentNode.containsKey("children")) {
//			parentNode.put("children", new ArrayList<Map<String,Object >>());
//		}
//		int parentId  = (int) parentNode.get("id");
//		for(Group node : allNode) {
//			if(parentId == node.getPid()) {
//				Map<String,Object> currentNode =this.coverGroupToMap(node);
//				((List<Map<String,Object>>)parentNode.get("children")).add(currentNode);
//				this.makeTree(currentNode, allNode);
//			}
//		}
//	}
//	
//	private Map<String,Object> coverGroupToMap(Group group){
//		Map<String,Object> result = new HashMap<String, Object>();
//		result.put("id", group.getId());
//		result.put("pid",group.getPid());
//		result.put("name", group.getName());
//		result.put("remark", group.getRemark());
//		result.put("modifierCode",group.getModifierCode());
//		result.put("modifierName",group.getModifierName());
//		result.put("modifyTime",group.getModifyTime());
//		result.put("createUserCode", group.getCreateUserCode());
//		result.put("createUserName", group.getCreateUserName());
//		result.put("createTime", group.getCreateTime());
//		result.put("version", group.getVersion());
//		result.put("isDel", group.getIsDel());
//		result.put("children", new ArrayList<Map<String,Object >>());
//		return result;
//	}
//	
//	
//	public Map<String, Object> findOrganizationTreeByPersonId(int personId) {
//		Map<String,Object> result = new HashMap<String, Object>();
//		SqlSession session = ServiceUtil.getSession();
//		OrganizationDao organizationDao= session.getMapper(OrganizationDao.class);
//		//查询指定的根节点
//		Organization parentNode = organizationDao.findOrganizationByPersonId(personId);
//		result  = this.coverOrganizationDaoToMap(parentNode);
//		//查询所有的节点
//		List<Organization> allNode  = organizationDao.findAllOrganization();
//		//拼接树结构
//		this.makeTree(result, allNode);
//		return result;
//	}
//
//	private void makeTree(Map<String,Object> parentNode,List<Organization> allNode) {
//		if(!parentNode.containsKey("children")) {
//			parentNode.put("children", new ArrayList<Map<String,Object >>());
//		}
//		int parentId  = (int) parentNode.get("code");
//		for(Organization node : allNode) {
//			if(parentId == node.getPid()) {
//				Map<String,Object> currentNode =this.coverOrganizationToMap(node);
//				((List<Map<String,Object>>)parentNode.get("children")).add(currentNode);
//				this.makeTree(currentNode, allNode);
//			}
//		}
//	}
//	
//	private Map<String,Object> coverOrganizationToMap(Organization organization){
//		Map<String,Object> result = new HashMap<String, Object>();
//		result.put("id", organization.getId());
//		result.put("code",organization.getCode());
//		result.put("code",organization.getPcode());
//		result.put("name", organization.getName());
//		result.put("remark", organization.getOrgLevel());
//		result.put("name", organization.get());
//		result.put("modifierCode",organization.getModifierCode());
//		result.put("modifierName",organization.getModifierName());
//		result.put("modifyTime",organization.getModifyTime());
//		result.put("createUserCode", organization.getCreateUserCode());
//		result.put("createUserName", organization.getCreateUserName());
//		result.put("createTime", organization.getCreateTime());
//		result.put("version", organization.getVersion());
//		result.put("isDel", organization.getIsDel());
//		result.put("children", new ArrayList<Map<String,Object >>());
//		return result;
//	}
}
