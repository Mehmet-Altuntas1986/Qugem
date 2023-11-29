Feature: Company and Client name


  Scenario Outline:1- Company Name selection
    When Enter a valid email
    When Enter a valid password
    Then Click the login button after choosing english language
    Then Select "<Company>" and "<Client>"
    Examples:
      | Company                     | Client           |
      | QUICK IMMOTRANS GMBH        | Hermes           |
      | QUICK BAU & TRANSPORTE GMBH | OTLG             |
      | QUICK PLT GMBH              | TOF Koblenz      |
      | QUICKLY TRANSPORTE GMBH     | TOF Stuttgart 70 |