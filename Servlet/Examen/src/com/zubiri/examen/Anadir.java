package com.zubiri.examen;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Anadir
 */
public class Anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	
		int dni = Integer.parseInt(request.getParameter("dni"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		out.println("<html><head>");
		out.println("<h1>Respuesta</h1>");
		out.println("</head>");
		out.println("<body>");
		out.println("DNI: " +dni + "<br>");
		out.println("Nombre: " +nombre + "<br>");
		out.println("Apellido: " +apellido + "<br>");
		out.println("Ano de nacimiento: " +ano + "<br>");
		out.println("</body></html>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "zubiri");
			java.sql.Statement sentencia = conexion.createStatement();
			
			sentencia.execute("CREATE DATABASE IF NOT EXISTS matriculaciones;");
			sentencia.execute("USE matriculaciones;");
			
			String createTable = "CREATE TABLE IF NOT EXISTS alumnos( dni int(9), nombre varchar(30), apellido varchar(30), ano int(4));";
			sentencia.execute(createTable);
			
			String insert = "INSERT INTO alumnos (dni, nombre, apellido, ano) "
					+ "values('"+dni+"','"+nombre+"','"+apellido+"','"+ano+"')";
			sentencia.execute(insert);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
