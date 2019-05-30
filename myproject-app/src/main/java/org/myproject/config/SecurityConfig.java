package org.myproject.config;

/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 *//**
	 * 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
	 * 例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
	 * 通过formLogin()定义当需要用户登录时候，转到的登录页面。
	 */
/*
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests()
 * .antMatchers("/home","/doc.html","/webjars/**","/swagger-resources/**",
 * "/v2/api-docs/**") .permitAll()//允许/home未授权访问
 * .anyRequest().authenticated()//其他请求都需要权限认证 .and() .formLogin()
 * .loginPage("/login").permitAll() //未授权的路径定位到/login .and()
 * .logout().permitAll(); }
 * 
 *//**
	 * 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
	 * 
	 * @param auth
	 * @throws Exception
	 *//*
		 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
		 * throws Exception { auth .inMemoryAuthentication()
		 * .withUser("user").password("password").roles("USER"); } }
		 */