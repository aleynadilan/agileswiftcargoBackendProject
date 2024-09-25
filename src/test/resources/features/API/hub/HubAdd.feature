Feature: As an administrator (admin) I want to be able to create a new hub record via API connection.

  Scenario Outline: admin Send a POST request to the api/hub/add endpoint with valid authorization and the correct data
  (name, phone, address), verify that the response status code is 200 and the message in the response body is
  'Hub is added'. Then, confirm the creation of the new hub by sending a GET request to the api/hub/{id} endpoint
  using the 'New Hub ID' from the response.

    * The api user sets "api/hub/add" path parameters.
    # Api kullanicisi "api/hub/add" path parametrelerini olusturur
    * The api user prepares a POST request containing "<name>", "<phone>" and "<address>" information to send to the api hubadd endpoint.
    # Api kullanicisi api hubadd endpointine gondermek icin "<name>", "<phone>" ve "<address>" bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Hub is added".
    # Api kullanicisi response bodydeki message bilgisinin "Hub is added" oldugunu dogrular

    Examples:
      | name     | phone       | address        |
      | Test Hub | 01000000004 | Houston, Texas |


  Scenario Outline: admin Send a POST request to the api/hub/add endpoint with valid authorization and incomplete data, verify
  that the response status code is 203 and the message in the response body is 'Name, phone and adress required'

    * The api user sets "api/hub/add" path parameters.
    # Api kullanicisi "api/hub/add" path parametrelerini olusturur
    * The api user prepares a POST request containing "<phone>" and "<address>" information to send to the api hubadd endpoint.
    # Api kullanicisi api hubadd endpointine gondermek icin "<phone>" ve "<address>" bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Name, phone and adress required".
    # Api kullanicisi response bodydeki message bilgisinin "Name, phone and adress required" oldugunu dogrular

    Examples:
      | phone       | address        |
      | 01000000004 | Houston, Texas |


  Scenario: admin Send an empty POST request to the api/hub/add endpoint with valid authorization, verify that the response
  status code is 203 and the message in the response body is 'Name, phone and adress required'

    * The api user sets "api/hub/add" path parameters.
    # Api kullanicisi "api/hub/add" path parametrelerini olusturur
    * The api user prepares a POST request that contains no data.
    # Api kullanicisi data icermeyen bir post request hazırlar
    * The api user sends a POST request and saves the returned response.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Name, phone and adress required".
    # Api kullanicisi response bodydeki message bilgisinin "Name, phone and adress required" oldugunu dogrular


  Scenario Outline: Invalid Token Send a POST request to the api/hub/add endpoint with invalid authorization and correct data
  (name, phone, address), verify that the response status code is 401 and the message in the response body is
  'Unauthenticated.'

    * The api user sets "api/hub/add" path parameters.
    # Api kullanicisi "api/hub/add" path parametrelerini olusturur
    * The api user prepares a POST request containing "<name>", "<phone>" and "<address>" information to send to the api hubadd endpoint.
    # Api kullanicisi api hubadd endpointine gondermek icin "<name>", "<phone>" ve "<address>" bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 401.
    # Api kullanicisi status codeun 401 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Unauthenticated.".
    # Api kullanicisi response bodydeki message bilgisinin "Unauthenticated." oldugunu dogrular

    Examples:
      | name     | phone       | address        |
      | Test Hub | 01000000004 | Houston, Texas |

  Scenario Outline: admin The new hub record to be created from the API must be verified from the API.
  (With the “New Hub ID” returned in the response body, it can be verified that a record was created by sending a GET
  request to the api/hub/{id} endpoint.)

    * The api user sets "api/hub/<id>" path parameters.
    # Api kullanicisi "api/hub/{id}" path parametrelerini olusturur
    * The api user sends a GET request and saves the returned response.
    # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | id  |
      | 417 |
