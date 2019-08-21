/**
 *                                                                                      -- updated by elvin 2019-8-21 10:26:49
 * (1) INTRODUCE <br>
 *  A plugin witch is based on spring-boot-starter-web ,spring-session,feign-client,buukle-security <br>
 *  We can use it to single-sign-on ,url-authentication ,data-isolation . here I will tell you how to use it in START UP .<br>
 * (2) START UP <br>
 *  ① yml-configure : application-local-security.yml it's content is like : <br>
 *      ## security-plugin
 *      security:
 *        server:
 *          ### security.server.name , security server's name
 *          name: buukle-security
 *          ### security.server.appResourceURI ,security get application resources's URI
 *          appResourceURI: /api/app/getAppResource
 *        ### security.openAuth user-authentic switch : 1 mains open, default is not
 *        openAuth: 1
 *        ### security.openPerm url-permission switch : 1 mains open, default is not
 *        openPerm: 1
 *        ### security.openIsol data-isolation switch : 1 mains open, default is not
 *        openIsol: 1
 *        ### security.openRegs switch : 1 mains open, default is not
 *        openRegs: 0
 *        passport:
 *          ### security.passport.host login page and return after success
 *          host: http://tpassport.buukle.top/static/login.html?returnUrl=http://tsecurity.buukle.top/security/home
 *
 *  ② annotation-configure : you need make sure unless these annotations are configured above your application main class <br>
 *      @EnableFeignClients(basePackages = {"top.buukle.*"}) <br>
 *      @EnableRedisHttpSession <br>
 *  ③ interceptor  : you can use this way to add the Interceptor <br>
 *       @Configuration<br>
 *       public class AppConfigure implements WebMvcConfigurer {<br>
 *               @Override <br>
 *              public void addInterceptors(InterceptorRegistry registry) {<br>
 *                  registry.addInterceptor(getSecurityInterceptor())<br>
 *                          .addPathPatterns("/**")<br>
 *                          .excludePathPatterns("/static/**")<br>
 *                          .excludePathPatterns("/api/**")<br>
 *                          .excludePathPatterns("/login.html")<br>
 *                          .excludePathPatterns("/logout")<br>
 *                          // 放行錯誤請求<br>
 *                          .excludePathPatterns("/error")<br>
 *                  ;<br>
 *              }<br>
 *         }<br>
 *  ④ how to use data-isolation : <br>
 *     @DataIsolationAnnotation(tableName="user",roleFieldName = "creator_role_id",queryDimension =  DataIsolationAnnotation.DIMENSION_ROLE)<br>
 *     List<User> selectByExample(UserExample example);<br>
 *     (data-isolation require you make sure that your data record has the roleFieldName filed exist and it's not null )<br>
 *
 * @since 2019-8-2
 * @version 1.0
 */
package top.buukle.security.plugin;