@login
Feature: Prueba de Login
  Yo como usuario de SDETraining 
  Quiero que cuando ingrese a la pagina de login
  Me pueda Loguear


  Scenario: El usuario se puede loguear con credenciales validas
    Given el usuario esta en la pagina de login
    When el usuario ingresa usuario "tim@testmail.com"
    And el usuario ingresa contraseña "trpass"
    When el usuario puede ver su panel de administracion


  Scenario: El usuario no se puede loguear con credeciales erroneas.
    Scenario: Credenciales erroneas
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales erroneas
    Then debe de aparecer un mensaje que le diga al usuario que son erroneas las credenciales
