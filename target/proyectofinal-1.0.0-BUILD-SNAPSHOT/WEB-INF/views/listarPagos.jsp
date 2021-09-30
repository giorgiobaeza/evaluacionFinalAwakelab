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
    <title>Listar Pagos</title>

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
	    <div class="contenedor-tabla">       
	        <table id="tabla">
	            <tr class="negrita">
	            	<th>Id Pagos</th>
	            	<th>Fecha</th>
	            	<th>Monto</th>
	            	<th>Mes</th>
	            	<th>Año</th>
	            	<th>Rut Cliente</th>
	            </tr>
	            <c:forEach items="${lPagos}" var="lp">
				<tr>
					<td><c:out value="${lp.getIdPagos()}" /></td>
					<td><c:out value="${lp.getFechaPago()}" /></td>
					<td><c:out value="${lp.getMonto()}" /></td>
					<td><c:out value="${lp.getMes()}" /></td>
					<td><c:out value="${lp.getAnio()}" /></td>
					<td><c:out value="${lp.getCliente_rutcliente()}" /></td>
				</tr>
				</c:forEach>
				<tr>
					<td>
						<form action='<c:out value="${pageContext.request.contextPath}"/>/crearPagos'>
							<input type="submit" value="Crear Pagos">
						</form>
					</td>
				</tr>
	        </table>
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