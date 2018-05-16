
package com.hospitalcrud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hospitalcrud.model.Paciente;

/**
 * Servlet implementation class CreatePacienteServlet
 */
@WebServlet("/CreatePacienteServlet")
public class CreatePacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		salida.append("HOLA MUNDO");
		response.getWriter().append("Hola mundano");
		Paciente objP = new Paciente();
		objP.setIdPaciente(Integer.parseInt(request.getParameter("id")));
		objP.setName(request.getParameter("name"));
		objP.setLastName(request.getParameter("lastname"));
		response.getWriter().append("Hola mundano "+objP.getIdPaciente()+" "+objP.getName());

		Configuration cgf = new Configuration();
		cgf.configure("hibernate.cfg.xml");
		cgf.addAnnotatedClass(com.hospitalcrud.model.Paciente.class);
		
		SessionFactory factory = cgf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(objP);
		try {
			transaction.commit();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			response.getWriter().append("Sorry men ya estaba");
		}
		session.close();
		System.out.println("Guardado");
	}

}
