package com.qsj.support.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 分页拦截器所有id为 ByPage的sql就执行分页操作
 * @author qsjteam   
 * @date 2018-5-5
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }),
		@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class PageInterceptor implements Interceptor {
	// private static final String SELECT_ID="selectpage";
	// 插件运行的代码，它将代替原有的方法
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// System.out.println("PageInterceptor -- intercept");
		if (invocation.getTarget() instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");
			String selectId = mappedStatement.getId();
			if (selectId.matches(".+ByPage$")) {
				BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
				// 分页参数作为参数对象parameterObject的一个属性
				String sql = boundSql.getSql();
				System.err.println("分页sql"+sql);
				// 查找page对象
				Object obj = boundSql.getParameterObject();
				// 得到page对象
				BasePage page = findPageObject(obj);
				if (page instanceof BasePage) {
					String pageSql = concatPageSql(sql, page);
					System.err.println("分页sql"+pageSql);
					// System.out.println("重写的 count sql :" + countSql);
					// System.out.println("重写的 select sql :" + pageSql);
					// 拦截到的prepare方法参数是一个Connection对象
					Connection connection = (Connection) invocation.getArgs()[0];
					// 给当前的page参数对象设置总记录数
					Object parameterObj = boundSql.getParameterObject();
					// 执行得到总数操作
					this.setTotalRecord(page, parameterObj, mappedStatement, connection);
					// 执行分页sql
					metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
				}

			}
		}
		return invocation.proceed();
	}

	/**
	 * @Title: findPageObject  
	 * @Description: TODO(得到分页的参数)  
	 * @param @param parameterObj
	 * @param @return    设定文件  
	 * @return BasePage    返回类型  
	 * @throws
	 */
	public BasePage findPageObject(Object parameterObj) {
		if (parameterObj instanceof BasePage) {
			return (BasePage) parameterObj;
		} else if (parameterObj instanceof Map) {
			for (Object val : ((Map<?, ?>) parameterObj).values()) {
				if (val instanceof BasePage) {
					return (BasePage) val;
				}
			}
		}
		return null;
	}

	/**
	 * 拦截类型StatementHandler
	 */
	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	/**
	 * 
	 * @Title: concatCountSql  
	 * @Description: TODO(组装总数sql)  
	 * @param @param sql
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	public String concatCountSql(String sql) {
		StringBuffer sb = new StringBuffer("SELECT COUNT(*) FROM  ( ");
		sql = sql.toLowerCase();
		sb.append(sql);
		sb.append(" ) as count");
		return sb.toString();
	}

	/**
	 * 
	 * @Title: concatPageSql  
	 * @Description: TODO(组装分页sql)  
	 * @param @param sql
	 * @param @param page
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	public String concatPageSql(String sql, BasePage page) {
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		sb.append(" limit ").append(page.getOffset()).append(" , ").append(page.getLimit() + page.getOffset());
		return sb.toString();
	}

	/**
	 * 
	 * @Title: setTotalRecord  
	 * @Description: TODO(执行得到总数的sql)  
	 * @param @param page
	 * @param @param parameterObject
	 * @param @param mappedStatement
	 * @param @param connection    设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	private void setTotalRecord(BasePage page, Object parameterObject, MappedStatement mappedStatement,
			Connection connection) {
		BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
		String sql = boundSql.getSql();
		String countSql = this.concatCountSql(sql);
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings,
				parameterObject);
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject,
				countBoundSql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			// 通过parameterHandler给PreparedStatement对象设置参数
			parameterHandler.setParameters(pstmt);
			// 之后就是执行获取总记录数的Sql语句和获取结果了。
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				// 给当前的参数page对象设置总记录数
				System.err.println("页数"+totalRecord);
				page.setTotal(totalRecord);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}
}