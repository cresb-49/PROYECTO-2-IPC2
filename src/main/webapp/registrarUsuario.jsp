<%-- 
    Document   : registrarUsuario
    Created on : 19/09/2020, 17:36:17
    Author     : benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>
        <div class="container">
            <br>
            <h4>Ingresa tus datos:</h4>
        </div>
        <div class="container">
            <br>
            <form id="registroUsuario" name="registroUsuario" onsubmit="return validarRegistroPaciente()" method="post">
                <section class="row">
                    <!--Primera columna del formulario-->
                    <div class="container col-md-6">
                            <div class="form-group">
                                <label for="nombrePaciente" class="">Nombre: </label>
                                <div class="">
                                    <input class="form-control" id="nombrePaciente" type="text" name="nombrePaciente" placeholder="Nombre" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="" for="fechaNacimiento">Fecha Nacimiento: </label>
                                <div class="">
                                    <input class="form-control" id="fechaNacimiento" type="date" name="fechaNacimiento" value="2000-01-01" min="1950-01-01" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="" for="telefonoPaciente">Telefono: </label>
                                <div class="">
                                    <input class="form-control" id="telefonoPaciente" type="text" name="telefonoPaciente" placeholder="Telefono" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="" for="pesoPaciente">Peso (Kg): </label>
                                <div class="">
                                    <input class="form-control" id="pesoPaciente" type="text" name="pesoPaciente" placeholder="Peso (Kg)">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="" for="passPaciente">Password: </label>
                                <div class="">
                                    <input class="form-control" id="passPaciente" type="password" name="passPaciente" placeholder="Password">
                                </div>
                            </div>
                            <div class="container" >
                                <div class="form-group">
                                    <button class="btn btn-success" type="submit" name="Registarse" value="Registrarse">Registrarse</button>
                                </div>
                            </div>
                    </div>
                    <div class="container col-md-6">
                        <div class="form-group">
                            <label class="" for="sexoPaciente">Sexo: </label><br>
                            <select class="form-control" name="sexoPaciente" id="sexoPaciente">
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="Hombre">Hombre</option>
                                    <option value="Mujer">Mujer</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="" for="DPIPaciente">DPI: </label>
                            <div class="">
                                <input class="form-control" id="DPIPaciente" type="text" name="DPIPaciente" placeholder="DPI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="correoPaciente">Correo: </label>
                            <div class="">
                                <input class="form-control" id="correoPaciente" type="email" name="correoPaciente" placeholder="Correo">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="" for="tipoSangre">Tipo Sangre: </label><br>
                                <select class="form-control" name="tipoSangre" id="tipoSangre">
                                    <option value="Seleccionar">Seleccionar</option>
                                    <option value="A">A</option>
                                    <option value="A+">A+</option>
                                    <option value="A-">A-</option>
                                    <option value="B">B</option>
                                    <option value="B+">B-</option>
                                    <option value="B-">B-</option>
                                    <option value="AB">AB</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O">O</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                </select>
                        </div>
                        <div class="form-group">
                            <label class="" for="passPacienteVer">Repetir Password: </label>
                                <div class="">
                                    <input class="form-control" id="passPacienteVer" type="password" name="passPacienteVer" placeholder="Password">
                            </div>
                        </div>
                    </div>
                </section>
            </form>
        </div>
        
        
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="js/app.js"></script>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
