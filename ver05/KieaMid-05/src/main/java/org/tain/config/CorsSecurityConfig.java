package org.tain.config;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//public class CorsSecurityConfig extends WebSecurityConfigurerAdapter {
public class CorsSecurityConfig {

	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin(CorsConfiguration.ALL);
		configuration.addAllowedMethod(CorsConfiguration.ALL);
		configuration.addAllowedHeader(CorsConfiguration.ALL);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		http.httpBasic()
			.and()
				.authorizeRequests()
				.anyRequest().permitAll()
			.and()
				.cors().configurationSource(source)
			.and()
				.csrf().disable();
	}
	*/
}
