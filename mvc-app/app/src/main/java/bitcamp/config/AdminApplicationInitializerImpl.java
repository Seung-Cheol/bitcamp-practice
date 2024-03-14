package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class AdminApplicationInitializerImpl extends AbstractDispatcherServletInitializer {
  AnnotationConfigWebApplicationContext rootContext;
  @Override
  protected WebApplicationContext createRootApplicationContext() {
   return null;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext adminContext  =
      new AnnotationConfigWebApplicationContext();
    adminContext.setParent(rootContext);
    adminContext.register(AdminConfig.class);
    adminContext.refresh();
    return adminContext;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/admin/*"};
  }

  @Override
  protected String getServletName() {
    return "admin";
  }

}
