<%@page import="com.tacademy.sam.vo.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="com.tacademy.sam.vo.Data" scope="application"/>
m6 name: <jsp:getProperty property="name" name="data"/>