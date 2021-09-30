//función para validar rut
function validaRut(campo){
    if ( campo.length == 0 ){ return false; }
    if ( campo.length < 8 ){ return false; }

    campo = campo.replace('-','')
    campo = campo.replace(/\./g,'')
    var suma = 0;
    var caracteres = "1234567890kK";
    var contador = 0;    
    for (var i=0; i < campo.length; i++){
        u = campo.substring(i, i + 1);
        if (caracteres.indexOf(u) != -1)
        contador ++;
    }
    if ( contador==0 ) { return false }
    
    var rut = campo.substring(0,campo.length-1)
    var drut = campo.substring( campo.length-1 )
    var dvr = '0';
    var mul = 2;
    
    for (i= rut.length -1 ; i >= 0; i--) {
        suma = suma + rut.charAt(i) * mul
                if (mul == 7) 	mul = 2
                else	mul++
    }
    res = suma % 11
    if (res==1)		dvr = 'k'
                else if (res==0) dvr = '0'
    else {
        dvi = 11-res
        dvr = dvi + ""
    }
    if ( dvr != drut.toLowerCase() ) { return false; }
    else { return true; }
}


//validaciones para crearCapacitacion.jsp
$(document).ready(function(){

    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")
 
    
    $('#capForm').validate({
        rules: {
           
            idcapacitacion: {
                required: true,
                digits: true,
                maxlength: 9,
                min: 1
            },                
                       
            capfecha: "required",
            
            caphora: "required",

            caplugar:  {
                required: true,
                minlength: 1,
                maxlength: 	50
            },

            capduracion:  {
                required: true,
                digits: true,
                maxlength: 3,
                min: 1
			},

            cliente_rutcliente: {
                required: true,
                digits: true,
                maxlength: 9,
                min: 1
            }, 
                                            
           
        },

        messages: {
            idcap: {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },

            capfecha: {
                required: "Este es un campo obligatorio."
            },    
            
            caphora: {
                required: "Este es un campo obligatorio."
            },    
           
            caplugar:  {
                required: "Este es un campo obligatorio.",
                minlength: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },

            capduracion:  {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },


            caprutcliente: {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },   
            

        }

    });
    
});


//validacion para formulario editarCliente.jsp
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")

    $('#cliForm').validate({
        rules: {
            txtrutCliente: {
                required: true,
                rut: true,
            },
            txtcliNombres: "required",
            txtcliApellidos: "required",
            txtcliTelefono: {
                required: true,
                maxlength: 11
            },
            
            txtcliAfp: "required",
            txtcliSistemaSalud: {
                valueNotEquals: "default"
            },
            txtcliDireccion: "required",
            txtcliComuna: "required",
            txtcliEdad: {
                required: true,
                maxlength: 2
            },
        },
        messages: {
            txtrutCliente: {
                required: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },
            txtcliNombres: "Este es un campo obligatorio.",
            txtcliApellidos: "Este es un campo obligatorio.",
            txtcliTelefono: {
                required: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },
            txtcliAfp: "Este es un campo obligatorio.",
            txtcliSistemaSalud: {
                valueNotEquals: "Seleccione una opción"
            },
            txtcliDireccion: "Este es un campo obligatorio.",
            txtcliComuna: "Este es un campo obligatorio.",
            txtcliEdad: {
                required: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },
        }
});


//validacion formulario editar profesional
$(document).ready(function(){
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")

    $('#proForm').validate({
        rules: {
            run: {
                required: true,
                rut: true,
               
            },
            nombre: "required",
            apellido: "required",
            telefono: {
                required: true,
                maxlength: 9
            },
            titulo: "required",
            proyecto: "required",
              
        },
        messages: {
            run: {
                required: "Este es un campo obligatorio.",
                rut: "El numero ingresado no corresponde a un rut real",
            },
            nombre: "Este es un campo obligatorio.",
            apellido: "Este es un campo obligatorio.",
            telefono: {
                required: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },
            titulo: "Este es un campo obligatorio.",
            proyecto: "Este es un campo obligatorio.",
        }
    });
});

//validacion formulario Contacto.jsp
$(document).ready(function(){
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")

    $('#contForm').validate({
        rules: {
            
            nombre: "required",
            email: "requiered",
            telefono: {
                required: true,
                maxlength: 9
            },
            mensage: "requiered", 
        },
        messages: {
            
            nombre: "Este es un campo obligatorio.",
            email: "Este es un campo obligatorio.",
            telefono: {
                required: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },
            mesage: "Este es un campo obligatorio.",
        }
    });
});

//validacion formulario listarVisitas.jsp
$(document).ready(function(){
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")

    $('#visForm').validate({
        rules: {
            
            txtidvisita: "required",
            txtvisfecha: "requiered",
            txtMonto: {
                required: true,
                maxlength: 12
            },
            txtvislugar: "requiered", 
            txtviscomentarios: "requiered", 
            txtrutcliente: "requiered", 
        },
        messages: {
            
            txtidvisita: "Este es un campo obligatorio.",
            txtvisfecha: "Este es un campo obligatorio.",
            txtMonto: {
                required: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },
            txtvislugar: "Este es un campo obligatorio.", 
            txtviscomentarios: "Este es un campo obligatorio.", 
            txtrutcliente: "Este es un campo obligatorio.",
        }
    });
});

//validaciones para crearUsuario.jsp
$(document).ready(function(){

    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")
 
    
    $('#usrForm').validate({
        rules: {
           
            usnombre: {
                required: true,
                minlength: 1,
                maxlength: 	50
            },                
                       
            usapellido: {
                required: true,
                minlength: 1,
                maxlength: 	50
            },      
            
            usfecha: "required",

            usrun:  {
                required: true,
                digits: true,
                maxlength: 9,
                min: 1
            },

            tipousuario:  {
                valueNotEquals: "required",
            },                                                 
           
        },

        messages: {
            usnombre: {
                required: "Este es un campo obligatorio.",
                minlength: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },

            usapellido: {
                required: "Este es un campo obligatorio.",
                minlength: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },    
            
            usfecha: {
                required: "Este es un campo obligatorio."
            },    
           
            usrun:  {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },

            tipousuario:  {
                valueNotEquals: "Este es un campo obligatorio.",
            },
            
        }	

    });
    
});

//validacion formulario editarAdministrativo.jsp
$(document).ready(function(){
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")

    $('#admForm').validate({
        rules: {
            txtrutadministrativo: {
                required: true,
                rut: true,
               
            },
            txtadmnombres: "required",
            txtadmapellidos: "required",
            email: "required",
            Area: "required",
              
        },
        messages: {
            run: {
                required: "Este es un campo obligatorio.",
                rut: "El numero ingresado no corresponde a un rut real",
            },
            nombre: "Este es un campo obligatorio.",
            apellido: "Este es un campo obligatorio.",         
            email: "Este es un campo obligatorio.",
            Area: "Este es un campo obligatorio.",
        }
    });
});

//validacion formulario crearPagos.jsp
$(document).ready(function(){
    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")

    $('#pagForm').validate({
        rules: {
            txtfechaPago: {
                required: true,               
            },
            txtMonto: "required",
            txtMes: {
            	valueNotEquals: "default",
            },
            txtAnio: "required",
            txtCliente_rutcliente: {
            	valueNotEquals: "default",
            },
        },
        messages: {
            txtfechaPago: {
                required: "Este es un campo obligatorio.",
            },
            txtMonto: "Este es un campo obligatorio.",
            txtMes: {
            	valueNotEquals: "Este es un campo obligatorio.",
            },         
            txtAnio: "Este es un campo obligatorio.",
            txtCliente_rutcliente: {
            	valueNotEquals: "Este es un campo obligatorio.",
            },
        }
    });
});

//validaciones para crearCapacitacion.jsp
$(document).ready(function(){

    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg !== value;
       }, "Value must not equal arg.")
 
    
    $('#capForm').validate({
        rules: {
           
            idcapacitacion: {
                required: true,
                digits: true,
                maxlength: 9,
                min: 1
            },                
                       
            capfecha: "required",
            
            caphora: "required",

            caplugar:  {
                required: true,
                minlength: 1,
                maxlength: 	50
            },

            capduracion:  {
                required: true,
                digits: true,
                maxlength: 3,
                min: 1
			},

            cliente_rutcliente: {
                required: true,
                digits: true,
                maxlength: 9,
                min: 1
            }, 
                                            
           
        },

        messages: {
            idcapacitacion: {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },

            capfecha: {
                required: "Este es un campo obligatorio."
            },    
            
            caphora: {
                required: "Este es un campo obligatorio."
            },    
           
            caplugar:  {
                required: "Este es un campo obligatorio.",
                minlength: "Este es un campo obligatorio.",
                maxlength: "Excede numero máximo de caracteres."
            },

            capduracion:  {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },


            cliente_rutcliente: {
                required: "Este es un campo obligatorio.",
                digits: "Este campo solo acepta dígitos.",
                maxlength: "Excede numero máximo de dígitos."
            },   
            

        }

    });
    
});


