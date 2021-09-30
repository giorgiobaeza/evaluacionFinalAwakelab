<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">

    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:ital,wght@0,300;0,400;0,600;1,200;1,300;1,700&family=Roboto:wght@100;300;400;500;700;900&display=swap"
        rel="stylesheet">   
    <title>Crear Usuario</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src='<c:out value="${pageContext.request.contextPath}"/>/resources/js/script.js'></script>
    <link href='<c:out value="${pageContext.request.contextPath}"/>/resources/CSS/estilos.css' rel="stylesheet">
</head>

<body>
    <header class="header-2">
        <input type="checkbox" id="btn-menu">
        <label for="btn-menu" ><i class="fas fa-bars"></i></label>
        <nav>
            <ul>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/'>Inicio</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/crearUsuario'>Crear Usuario</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/listarUsuarios'>Listar Usuarios</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/listarPagos'>Listar pagos</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/contacto'>Contacto</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/logout'>Logout</a></li>
                
            </ul>
        </nav>
    </header>
    	<main>
	    <div class="contenedor">
	        <form id="formulario" method="post" action="crearUsuarioProcesar" class="cmxform" >
	            
	            <h2 id="titulo">Crear Usuario</h2>
	            <label for="" id="label">Nombre</label>
	            <input type="text" id="input" name="usnombre"/>
	            <label for="" id="label">Apellido</label>
	            <input type="text" id="input" name="usapellido"/>
	            <label for="" id="label">Fecha de nacimiento</label>
	            <input type="date" id="input" name="usfecha"/>
	            <label for="" id="label">RUT</label>
	            <input type="text" id="input" name="usrun"/>
	            <label for="" id="label">Tipo de usuario</label>
	            <select id="input" name="tipousuario">
  	                <option value="default">Seleccionar una opción</option>
	                <option value="cliente">Cliente</option>
	                <option value="profesional">Profesional</option>
	                <option value="administrativo">Administrativo</option>
	            </select>
	
	            <input type="submit" id="boton" value="Ingresar Usuario">
	        </form>
    	</div>
    	</main>
    <footer>
        <div class="siguenos">
            <h2>Siguenos en nuestras redes sociales</h2>
        </div>
        <div class="redes-footer">
        	<img src='<c:out value="${pageContext.request.contextPath}"/>/resources/Imagenes/facebook.png' alt="">
        	<img src='<c:out value="${pageContext.request.contextPath}"/>/resources/Imagenes/instagram.png' alt="">
        	<img src='<c:out value="${pageContext.request.contextPath}"/>/resources/Imagenes/twitter.png' alt="">
        </div>
        <h2 class="titulo-final">© 2021 @grupo2 - Todos los derechos reservados</h2>
    </footer>
    <script src="menu.js"></script>
</body> 

</html>