Feature: Prueba Registro
  Yo como usuario de SDETraining 
  Quiero que cuando ingrese a la pagina de registro
  Me pueda registrar

  Scenario: El usuario ingresa sus datos en los campos
    Given El usuario esta en la pagina registro
    And el usuario ingresa sus datos 
    When el usuario debe ser registrado
    
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step
