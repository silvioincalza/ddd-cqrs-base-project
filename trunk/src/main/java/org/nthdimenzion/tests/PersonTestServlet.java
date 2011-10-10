package org.nthdimenzion.tests;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonTestServlet extends javax.servlet.http.HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException    {
        super.doPost(req, resp);
        System.out.println("***** DO POST ******");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("**** DO GET *****");
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IPersonService personService =(IPersonService)springContext.getBean("personService");
        Person person = new Person();
        person.setId(2L);
        person.setName("Sudarshan");
        Long personId = personService.savePerson(person);
        System.out.println("person.getId--> " + personId);
    }
}