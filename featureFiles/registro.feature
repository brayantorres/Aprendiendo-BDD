@registro
Feature: Prueba Registro
  Yo como usuario de SDETraining 
  Quiero que cuando ingrese a la pagina de registro
  Me pueda registrar

  Scenario: El usuario ingresa sus datos en los campos
    Given el usuario esta en la pagina registro
    When el usuario ingresa su primer nombre "Brayan David Torres Suárez"
    And el usuario ingresa el email "brayantorres@unac.edu.co"
    And el usuario ingresa el telefono "3256987460"
    And el usuario da click en genero Male
    And el usuario ingresa password "asd$123"
    And el usuario verifica su password "asd$123"
    And el usuario selecciona el pais "Ecuador"
    And el usuario elige suscripcion Weekly Email
    And el usuario da click en submit
    Then el usuario debe ser registrado
