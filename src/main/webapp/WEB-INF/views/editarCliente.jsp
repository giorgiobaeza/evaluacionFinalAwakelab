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
    <title>Editar Cliente</title>
    <script src="https://kit.fontawesome.com/1d5353b7f3.js" crossorigin="anonymous"></script>

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
        <div class="wave-2" style="height: 150px; overflow: hidden;"><svg viewBox="0 0 500 150" preserveAspectRatio="none"
            style="height: 100%; width: 100%;">
            <path d="M-1.41,131.73 C169.01,195.88 329.85,35.03 518.90,148.52 L500.00,150.00 L0.00,150.00 Z"
                style="stroke: none; fill: rgb(255, 255, 255);"></path>
        </svg></div>
        
    </header>
    <div class="contenedor">
        <form id="formulario" method="post" action="<c:out value="${pageContext.request.contextPath}"/>/procesarEditarCliente" class="cmxform" id="pagForm">
            
            <h2 id="titulo">Editar Cliente</h2>
            <label for="" id="label">Rut Cliente</label>
            <input type="text" id="input" name="txtrutCliente" value='<c:out value="${usr.getRun()}"/>' readonly="readonly"/>
            <label for="" id="label">Nombres</label>
            <input type="text" id="input" name="txtcliNombres" value='<c:out value="${cli.getCliNombres()}"/>'/>
            <label for="" id="label">Apellidos</label>
            <input type="text" id="input" name="txtcliApellidos" value='<c:out value="${cli.getCliApellidos()}"/>'/>
            <label for="" id="label">Teléfono</label>
            <input type="text" id="input" name="txtcliTelefono" value='<c:out value="${cli.getCliTelefono()}"/>'/>
            <label for="" id="label">AFP</label>
            <input type="text" id="input" name="txtcliAfp" value='<c:out value="${cli.getCliAfp()}"/>'/>
            <label for="" id="label">Sistema de Salud</label>
            <input type="text" id="input" name="txtcliSistemaSalud" value='<c:out value="${cli.getCliSistemaSalud()}"/>'/>
            <label for="" id="label">Dirección</label>
            <input type="text" id="input" name="txtcliDireccion" value='<c:out value="${cli.getCliDireccion()}"/>'/>
            <label for="" id="label">Comuna</label>
            <input type="text" id="input" name="txtcliComuna" value='<c:out value="${cli.getCliComuna()}"/>'/>
            <label for="" id="label">Edad</label>
            <input type="text" id="input" name="txtcliEdad" value='<c:out value="${cli.getCliEdad()}"/>'/>
			<input style="display:none" type="text" name="txtusuariorun" value='<c:out value="${usr.getRun()}"/>' readonly="readonly"/>
            <input type="submit" id="boton" value="Editar Usuario">
        </form>
    </div>
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