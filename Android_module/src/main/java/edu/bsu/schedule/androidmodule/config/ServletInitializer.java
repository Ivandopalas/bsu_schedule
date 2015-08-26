package edu.bsu.schedule.androidmodule.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class };
    }
    /*@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);
        rootContext.register(RootConfig.class);
        rootContext.setDisplayName("root Context");

        servletContext.addListener(new ContextLoaderListener(rootContext));

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        FilterRegistration.Dynamic filter = servletContext.addFilter("openSessionInViewFilter", OpenSessionInViewFilter.class);
        // filter.setInitParameter("singleSession", "true");
        filter.addMappingForServletNames(null, true, "dispatcher");

    }*/
}
