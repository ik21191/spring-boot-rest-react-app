package com.mypack.beans;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseTypeMysqlCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String mySqlType = context.getEnvironment().getProperty("dbType");
		return mySqlType != null && mySqlType.equals("MySql");
	}
}
