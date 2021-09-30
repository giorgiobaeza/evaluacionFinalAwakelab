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
    <title>Listar Visita</title>
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
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/listarVisitas'>Listar Visitas</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/contacto'>Contacto</a></li>
                <li class="efecto"><a href='<c:out value="${pageContext.request.contextPath}"/>/logout'>Logout</a></li>
            </ul>
        </nav>
    </header>
    <main>
	    <table>
	   		<tr>
	   			<th>ID Visita</th>
	   			<th>Fecha</th>
	   			<th>Hora</th>
	   			<th>Lugar</th>
	   			<th>Comentario</th>
	   			<th>Rut Cliente</th>
	   		</tr>
	    	<c:forEach items="${lvisita}" var="lv">
	            <tr>
	                <td><c:out value="${lv.getIdvisita()}" /></td>
	                <td><c:out value="${lv.getVisfecha()}" /></td>
	                <td><c:out value="${lv.getVishora()}" /></td>
	                <td><c:out value="${lv.getVislugar()}" /></td>
	                <td><c:out value="${lv.getViscomentarios()}" /></td>
	 	            <td><c:out value="${lv.getCliente_rutcliente()}" /></td>
	            
	            <td>
					<form action='<c:out value="${pageContext.request.contextPath}"/>/listarDetalleChequeo/<c:out value="${lv.getIdvisita()}"/>'>
						<input id="boton" type="submit" value="Chequeos">
					</form>							
				</td>
				</tr>
			</c:forEach>
	   	</table>
	    	<div class="contenedor">
		        <form id="formulario" method="post" action="crearVisita" class="cmxform">
		            
		            <h2 id="titulo">Listar Visitas</h2>
		            <label id="label">ID Visita</label>
		            <input type="text" id="input" name="txtidvisita"/>
		            <label id="label">Fecha de pago</label>
		            <input type="date" id="" name="txtvisfecha" placeholder="Fecha de pago" />
		            <label id="label">Hora</label>
		            <input type="time" id="input" name="txtvishora"/>
		            <label id="label">Lugar</label>
		            <input type="text" id="input" name="txtvislugar"/>
		            <label id="label">Comentario</label>
		            <input type="text" id="input" name="txtviscomentarios"/>
		            <label id="label">Rut Cliente</label>
		            <select id="input" name="txtrutcliente">
		                <c:forEach items="${rutclie}" var="lc">
		                    <option value='<c:out value="${lc.getRutCliente()}" />'><c:out value="${lc.getRutCliente()}" /></option>
		                </c:forEach>
		            </select>
		            <input type="submit" id="boton" value="Crear Visita">
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
    </main>
    <script src="menu.js"></script>
</body> 

</html>