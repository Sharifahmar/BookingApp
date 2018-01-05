/**
 * 
 */
package com.acc.profiles;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author ahmar.akhtar.sharif
 *
 */

@Component
@Profile("MSD_test_Profile")
public class MSDLogCustomizer implements EmbeddedServletContainerCustomizer {

//	static{
//		System.out.println("Created the LOG URL Customizer");
//	}
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setContextPath("/spring-boot-test");
		container.setPort(8095);
	}

}