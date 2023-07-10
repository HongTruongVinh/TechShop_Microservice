package com.nhom1.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

@Configuration
public class AxonConfig {
	@Bean
	public XStream xStream() {
		XStream xStream = new XStream();
		xStream.allowTypesByWildcard(new String[] { "com.nhom1.**"});
		//xStream.allowTypes(new Class[] {com.nhom1.cp.test123.pojo.TestList.class});
		return xStream;
	}
}
